package me.vault.game.model.Energy;


import me.vault.game.model.citybuilding.ValidatedEntriesHashMap;


public enum EnergyTroops
{
	BLOP(
		new ValidatedEntriesHashMap<>()
		{
			{
				this.put(EnergyLevel.BASE, new EnergyProperties("a", 1, 1, 1, 1,
					1, 1, 1, 1));
			}
		}
	);


	private final ValidatedEntriesHashMap<EnergyLevel, EnergyProperties> propertyMap;


	private EnergyLevel currentLevel;


	EnergyTroops (final ValidatedEntriesHashMap<EnergyLevel, EnergyProperties> propertyMap)
	{
		// TODO: Load Index from Config
		this.currentLevel = EnergyLevel.BASE;

		this.propertyMap = propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidatedEntriesHashMap<EnergyLevel, EnergyProperties> getAllProperties ()
	{
		return this.propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnergyProperties getCurrentProperties ()
	{
		return this.propertyMap.get(this.currentLevel);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnergyLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final EnergyLevel energyLevel)
	{
		this.currentLevel = energyLevel;
	}


	@Override
	public String toString ()
	{
		return "Energy{" + "propertyMap=" + this.propertyMap + ", currentLevel=" + this.currentLevel + '}';
	}
}
