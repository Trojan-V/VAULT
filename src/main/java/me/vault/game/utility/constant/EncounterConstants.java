package me.vault.game.utility.constant;


import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.impl.Medic;
import me.vault.game.model.troop.impl.Ranger;
import me.vault.game.model.troop.impl.Sniper;

import java.util.ArrayList;


public interface EncounterConstants
{

	public static int DICE = 20;


	public static double FIVE_PERCENT = 0.05;


	public static final ArrayList<Troop> ENCOUNTER_ENEMIES = new ArrayList<>()
	{{
		this.add(Sniper.getInstance());
		this.add(Ranger.getInstance());
		this.add(Medic.getInstance());
	}};
}
