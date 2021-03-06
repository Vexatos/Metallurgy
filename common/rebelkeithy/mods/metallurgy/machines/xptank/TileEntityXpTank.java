package rebelkeithy.mods.metallurgy.machines.xptank;

import net.minecraft.entity.player.EntityPlayer;
import rebelkeithy.mods.metallurgy.machines.TileEntityMachineBase;
import rebelkeithy.mods.metallurgy.machines.xptank.orb.EntityXpOrbContainer;

public class TileEntityXpTank extends TileEntityMachineBase
{
	private int xpAmount;
	private int maxXp = 1000;
	
	public int addXP(int amount)
	{
		int usedXp = 0;
		if(xpAmount + amount <= maxXp)
		{
			xpAmount += amount;
			usedXp = amount;
		} 
		else 
		{
			usedXp = maxXp - xpAmount;
			xpAmount = maxXp;
		}
		int id = worldObj.getBlockId(xCoord, yCoord, zCoord);
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 0, xpAmount);
		
		return usedXp;
	}
	
	public void releaseXP()
	{
		if(!worldObj.isRemote)
		{
			EntityXpOrbContainer entity = new EntityXpOrbContainer(worldObj, xCoord + 0.5, yCoord + 1, zCoord + 0.5, xpAmount);
			worldObj.spawnEntityInWorld(entity);
		}
		xpAmount = 0;
	}

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

	public int getFuelScaled(int scale) 
	{
		return (int) (scale * (xpAmount/(float)maxXp));
	}

    @Override
	public boolean receiveClientEvent(int i, int j) 
    {
    	if(i == 0)
    	{
    		xpAmount = j;
    		return true;
    	}
    	
    	return false;
    }
}
