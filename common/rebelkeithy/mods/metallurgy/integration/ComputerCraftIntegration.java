package rebelkeithy.mods.metallurgy.integration;

import net.minecraft.item.Item;
import rebelkeithy.mods.metallurgy.core.metalsets.OreInfo;
import rebelkeithy.mods.metallurgy.metals.MetallurgyMetals;

public class ComputerCraftIntegration 
{
	public static void init()
	{
		try
		{
			Class a = Class.forName("dan200.turtle.api.TurtleAPI");
			
			System.out.println("Metallurgy: Adding ComputerCraft Turtles");
			addTurtles();
		} 
		catch(Exception e) 
		{
			System.out.println("Metlalurgy: Skipping ComputerCraft Turtles");
		}
	}
	
	public static void addTurtles()
	{
		OreInfo info;
		
		info = MetallurgyMetals.fantasySet.getOreInfo("Orichalcum");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(101, "Orichalcum Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(111, "Orichalcum Melee", info.sword);

		info = MetallurgyMetals.fantasySet.getOreInfo("Adamantine");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(102, "Adamantine Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(112, "Adamantine Melee", info.sword);

		info = MetallurgyMetals.fantasySet.getOreInfo("Celenegil");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(103, "Celenegil Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(113, "Celenegil Melee", info.sword);

		info = MetallurgyMetals.fantasySet.getOreInfo("Atlarus");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(104, "Atlarus Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(114, "Atlarus Melee", info.sword);

		info = MetallurgyMetals.fantasySet.getOreInfo("Tartarite");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(105, "Tartarite Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(115, "Tartarite Melee", info.sword);
		


		info = MetallurgyMetals.netherSet.getOreInfo("Inolashite");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(106, "Inolashite Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(116, "Inolashite Melee", info.sword);

		info = MetallurgyMetals.netherSet.getOreInfo("Kalendrite");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(107, "Kalendrite Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(117, "Kalendrite Melee", info.sword);

		info = MetallurgyMetals.netherSet.getOreInfo("Amordrine");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(108, "Amordrine Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(118, "Amordrine Melee", info.sword);

		info = MetallurgyMetals.netherSet.getOreInfo("Vulcanite");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(109, "Vulcanite Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(119, "Vulcanite Melee", info.sword);

		info = MetallurgyMetals.netherSet.getOreInfo("Sanguinite");
		if(info.isEnabled() && info.pickaxe != null)
			createTurtle(110, "Sanguinite Mining", info.pickaxe);
		if(info.isEnabled() && info.sword != null)
			createTurtle(120, "Sanguinite Melee", info.sword);
	}
	
	public static void createTurtle(int id, String name, Item tool)
	{
		System.out.println("Metallurgy: Creating " + name + " Turtle");
		dan200.turtle.shared.TurtleTool toolTurtle = new dan200.turtle.shared.TurtleTool(id, name, tool, false);
		dan200.turtle.api.TurtleAPI.registerUpgrade(toolTurtle);
		System.out.println("Metallurgy: Registered " + toolTurtle);
	}
}
