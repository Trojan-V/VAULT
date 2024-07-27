package me.vault.game.utility.constant;


import me.vault.game.model.arena.Figure;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.impl.*;

import java.util.ArrayList;


public interface EncounterConstants
{

	public static int DICE = 20;


	public static double FIVE_PERCENT = 0.05;

	String ENCOUNTER_TWO_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_2.txt";

	public static final ArrayList<Figure<Troop>> ALLIES = new ArrayList<>()
	{{
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
	}};

	public static final ArrayList<Figure<Troop>> ENCOUNTER_ONE_ENEMIES = new ArrayList<>()
	{{
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
	}};

	public static final ArrayList<Figure<Troop>> ENCOUNTER_TWO_ENEMIES = new ArrayList<>()
	{{
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
	}};

	public static final ArrayList<Figure<Troop>> ENCOUNTER_THREE_ENEMIES = new ArrayList<>()
	{{
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
	}};

	public static final ArrayList<Figure<Troop>> ENCOUNTER_FOUR_ENEMIES = new ArrayList<>()
	{{
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
		this.add(new Figure<Troop>(SpaceMarine.getAllyInstance()));
	}};

}
