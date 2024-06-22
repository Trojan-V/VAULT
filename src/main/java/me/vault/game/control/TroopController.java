package me.vault.game.control;


import javafx.application.Platform;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.troop.*;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;


public class TroopController implements Upgrader<Troop, TroopLevel>
{

	private static final TroopController INSTANCE = new TroopController();

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(TroopController.class.getSimpleName());


	public static TroopController getInstance ()
	{
		return INSTANCE;
	}


	private static void updateDexterityStatistic (final Troop troop)
	{
		final DexterityStatistic dexterityStatistic = troop.getStatistic().getDexterityStatistic();
		dexterityStatistic.setInitiative((int) (dexterityStatistic.getInitiative() * troop.getFaction().getDexterityLevelMultiplier()));
		dexterityStatistic.setMovementTiles((int) (dexterityStatistic.getMovementTiles() * troop.getFaction().getDexterityLevelMultiplier()));
	}


	private static void updateDefensiveStatistic (final Troop troop)
	{
		final DefensiveStatistic defensiveStatistic = troop.getStatistic().getDefensiveStatistic();
		defensiveStatistic.setDodgeRate((int) (defensiveStatistic.getDodgeRate() * troop.getFaction().getDefensiveLevelMultiplier()));
		defensiveStatistic.setHealthPoints((int) (defensiveStatistic.getHealthPoints() * troop.getFaction().getDefensiveLevelMultiplier()));
		defensiveStatistic.setEnergyDamageReduction((int) (defensiveStatistic.getEnergyDamageReduction() * troop.getFaction().getDefensiveLevelMultiplier()));
		defensiveStatistic.setMeleeDamageReduction((int) (defensiveStatistic.getMeleeDamageReduction() * troop.getFaction().getDefensiveLevelMultiplier()));
	}


	private static void updateOffensiveStatistic (final Troop troop)
	{
		final OffensiveStatistic offensiveStatistic = troop.getStatistic().getOffensiveStatistic();
		offensiveStatistic.setEnergyPoints((int) (offensiveStatistic.getEnergyPoints() * troop.getFaction().getOffensiveLevelMultiplier()));
		offensiveStatistic.setGrenadeAmount((int) (offensiveStatistic.getGrenadeAmount() * troop.getFaction().getOffensiveLevelMultiplier()));
		offensiveStatistic.setGrenadeRange((int) (offensiveStatistic.getGrenadeRange() * troop.getFaction().getOffensiveLevelMultiplier()));
		offensiveStatistic.setMeleeDamage((int) (offensiveStatistic.getMeleeDamage() * troop.getFaction().getOffensiveLevelMultiplier()));
		offensiveStatistic.setGrenadeDamage((int) (offensiveStatistic.getGrenadeDamage() * troop.getFaction().getOffensiveLevelMultiplier()));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void upgrade (final Troop troop)
	{
		Platform.runLater(new UpgradeRunnable(troop, TroopController.getInstance()));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final Troop troop)
	{
		return true;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateValues (final Troop troop)
	{
		if (troop.getLevel() == TroopLevel.getMaxLevel())
		{
			troop.setIsMaxLevel(true);
		}

		troop.setName(troop.getName(troop.getLevel()));
		troop.setSprite(troop.getSprite(troop.getLevel()));
		troop.setUpgradeCosts(troop.getUpgradeCosts(troop.getLevel()));

		updateOffensiveStatistic(troop);
		updateDexterityStatistic(troop);
		updateDefensiveStatistic(troop);

	}

}
