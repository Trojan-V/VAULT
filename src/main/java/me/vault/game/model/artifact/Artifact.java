package me.vault.game.model.artifact;


import me.vault.game.controller.CurrencyController;
import me.vault.game.model.citybuilding.ValidatedEntriesHashMap;
import me.vault.game.model.interfaces.IUpgradable;
import me.vault.game.utility.constant.ArtifactConstants;


/**
 * @author Lasse-Leander Hillen , Vincent Wolf, Alexander Göthel
 * @version 1.0.0
 * @see IUpgradable
 * @since 25.05.2024
 */

public enum Artifact implements IUpgradable<ArtifactLevel, ArtifactProperties>
{
	/**
	 * The health-artifact with its specified properties
	 */
	HEALTH(new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactProperties(CurrencyController.createTransaction(
			-10, -10, -10, -10, -10),
			ArtifactConstants.HEALTH_BASE, ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE,
			(int) ArtifactConstants.NO_CHANGE, ArtifactConstants.HEALTH_ARTIFACT));

		this.put(ArtifactLevel.IMPROVED, new ArtifactProperties(CurrencyController.createTransaction(
			-10, -10, -10, -10, -10),
			ArtifactConstants.HEALTH_IMPROVED, ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE,
			(int) ArtifactConstants.NO_CHANGE, ArtifactConstants.IMPROVED_HEALTH_ARTIFACT));
	}}),

	/**
	 * The defense-artifact with its specified properties
	 */
	DEFENSE(new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactProperties(CurrencyController.createTransaction(
			-10, -10, -10, -10, -10),
			ArtifactConstants.NO_CHANGE, ArtifactConstants.ARMOUR_BASE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.RESISTENZ_BASE,
			(int) ArtifactConstants.NO_CHANGE, ArtifactConstants.DEFENSE_ARTIFACT));

		this.put(ArtifactLevel.IMPROVED, new ArtifactProperties(CurrencyController.createTransaction(
			-10, -10, -10, -10, -10),
			ArtifactConstants.NO_CHANGE, ArtifactConstants.ARMOUR_IMPROVED, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.RESISTENZ_IMPROVED,
			(int) ArtifactConstants.NO_CHANGE, ArtifactConstants.DEFENSE_ARTIFACT));
	}}),


	/**
	 * The damage-artifact with its specified properties
	 */
	DAMAGE(new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactProperties(CurrencyController.createTransaction(
			-10, -10, -10, -10, -10),
			ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE, ArtifactConstants.MELEE_DAMAGE_BASE,
			ArtifactConstants.GRENADE_DAMAGE_BASE, ArtifactConstants.ENERGY_DAMAGE_BASE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE, (int) ArtifactConstants.NO_CHANGE, ArtifactConstants.DAMAGE_ARTIFACT));

		this.put(ArtifactLevel.IMPROVED, new ArtifactProperties(CurrencyController.createTransaction(
			-10, -10, -10, -10, -10),
			ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE, ArtifactConstants.MELEE_DAMAGE_IMPROVED,
			ArtifactConstants.GRENADE_DAMAGE_IMPROVED, ArtifactConstants.ENERGY_DAMAGE_IMPROVED,
			ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE, (int) ArtifactConstants.NO_CHANGE,
			ArtifactConstants.IMPROVED_DAMAGE_ARTIFACT));
	}}),

	/**
	 * The mobility-artifact with its specified properties
	 */
	MOBILITY(new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactProperties(CurrencyController.createTransaction(
			-10, -10, -10, -10, -10),
			ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE, ArtifactConstants.DODGE_BASE, ArtifactConstants.NO_CHANGE,
			(int) ArtifactConstants.MOVEMENT_RANGE_BASE,
			ArtifactConstants.MOBILITY_ARTIFACT));

		this.put(ArtifactLevel.IMPROVED, new ArtifactProperties(CurrencyController.createTransaction(
			-10, -10, -10, -10, -10),
			ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE, ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE,
			ArtifactConstants.NO_CHANGE, ArtifactConstants.DODGE_IMPROVED, ArtifactConstants.NO_CHANGE,
			(int) ArtifactConstants.MOVEMENT_RANGE_IMPROVED, ArtifactConstants.IMPROVED_MOBILITY_ARTIFACT));
	}});




	private final ValidatedEntriesHashMap<ArtifactLevel, ArtifactProperties> propertyMap;


	private ArtifactLevel currentLevel;


	Artifact (final ValidatedEntriesHashMap<ArtifactLevel, ArtifactProperties> propertyMap)
	{
		// TODO: Load ArtifactLevel from config
		this.currentLevel = ArtifactLevel.BASE;
		this.propertyMap = propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidatedEntriesHashMap<ArtifactLevel, ArtifactProperties> getAllProperties ()
	{
		return this.propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArtifactProperties getCurrentProperties ()
	{
		return this.propertyMap.get(this.currentLevel);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArtifactLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final ArtifactLevel artifactLevel)
	{
		this.currentLevel = artifactLevel;
	}


	@Override
	public String toString ()
	{
		return "Artifact{" + "propertyMap=" + this.propertyMap + ", currentLevel=" + this.currentLevel + '}';
	}
}
