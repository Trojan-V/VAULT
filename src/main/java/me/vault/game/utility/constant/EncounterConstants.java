package me.vault.game.utility.constant;


import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.impl.*;

import java.util.ArrayList;


public interface EncounterConstants
{

	public static int DICE = 20;


	public static double FIVE_PERCENT = 0.05;

	String ENCOUNTER_TWO_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_2.txt";

	public static final ArrayList<Troop> ALLIES = new ArrayList<>()
	{{
		this.add(Recruit.getAllyInstance());
		this.add(Guard.getAllyInstance());
		this.add(Lieutenant.getAllyInstance());
		this.add(Officer.getAllyInstance());
	}};

	public static final ArrayList<Troop> ENCOUNTER_ONE_ENEMIES = new ArrayList<>()
	{{
		this.add(SpaceMarine.getEnemyInstance());
		this.add(Ranger.getEnemyInstance());
		this.add(Medic.getEnemyInstance());
		this.add(Grenadier.getEnemyInstance());
	}};

	public static final ArrayList<Troop> ENCOUNTER_TWO_ENEMIES = new ArrayList<>()
	{{
		this.add(SpaceMarine.getEnemyInstance());
		this.add(Ranger.getEnemyInstance());
		this.add(Medic.getEnemyInstance());
		this.add(Grenadier.getEnemyInstance());
	}};

	public static final ArrayList<Troop> ENCOUNTER_THREE_ENEMIES = new ArrayList<>()
	{{
		this.add(SpaceMarine.getEnemyInstance());
		this.add(Ranger.getEnemyInstance());
		this.add(Medic.getEnemyInstance());
		this.add(Grenadier.getEnemyInstance());
	}};

	public static final ArrayList<Troop> ENCOUNTER_FOUR_ENEMIES = new ArrayList<>()
	{{
		this.add(SpaceMarine.getEnemyInstance());
		this.add(Ranger.getEnemyInstance());
		this.add(Medic.getEnemyInstance());
		this.add(Grenadier.getEnemyInstance());
	}};

}
