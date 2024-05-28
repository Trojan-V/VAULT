package me.vault.vaultgame.model.artifact;


import me.vault.vaultgame.controller.CurrencyController;
import me.vault.vaultgame.model.citybuilding.ValidatedEntriesHashMap;
import me.vault.vaultgame.model.interfaces.IUpgradable;


public enum Artifact implements IUpgradable<ArtifactLevel, ArtifactProperties>
{
	// TODO: Sind Literale in Enum-Eintraegen okay?
	/**
	 * The damage-artifact with its specified properties
	 */
	DAMAGE(
		new ValidatedEntriesHashMap<>()
		{{
			this.put(ArtifactLevel.BASE, new ArtifactProperties(
				CurrencyController.createTransaction(-10, -10, -10, -10, -10),
				1, 1, 1, 1, 1, 1, "Damage Artifact"));

			this.put(ArtifactLevel.SUPER, new ArtifactProperties(
				CurrencyController.createTransaction(-10, -10, -10, -10, -10),
				1, 1, 1, 1, 1, 1, "Super Damage Artifact"));
		}}),


	/**
	 * The defense-artifact with its specified properties
	 */
	DEFENSE(
		new ValidatedEntriesHashMap<>()
		{{
			this.put(ArtifactLevel.BASE, new ArtifactProperties(
				CurrencyController.createTransaction(-10, -10, -10, -10, -10),
				1, 1, 1, 1, 1, 1, "DEFENSE Artifact"));

			this.put(ArtifactLevel.SUPER, new ArtifactProperties(
				CurrencyController.createTransaction(-10, -10, -10, -10, -10),
				1, 1, 1, 1, 1, 1, "Super DEFENSE Artifact"));
		}}),


	/**
	 * The health-artifact with its specified properties
	 */
	HEALTH(
		new ValidatedEntriesHashMap<>()
		{{
			this.put(ArtifactLevel.BASE, new ArtifactProperties(
				CurrencyController.createTransaction(-10, -10, -10, -10, -10),
				1, 1, 1, 1, 1, 1, "HEALTH Artifact"));

			this.put(ArtifactLevel.SUPER, new ArtifactProperties(
				CurrencyController.createTransaction(-10, -10, -10, -10, -10),
				1, 1, 1, 1, 1, 1, "Super HEALTH Artifact"));
		}});


	private final ValidatedEntriesHashMap<ArtifactLevel, ArtifactProperties> propertyMap;


	private ArtifactLevel currentLevel;


	Artifact (final ValidatedEntriesHashMap<ArtifactLevel, ArtifactProperties> propertyMap)
	{
		// TODO: Load Index from Config
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
		return "Artifact{" +
		       "propertyMap=" + this.propertyMap +
		       ", currentLevel=" + this.currentLevel +
		       '}';
	}
}
