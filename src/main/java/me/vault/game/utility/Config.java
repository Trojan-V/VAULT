package me.vault.game.utility;


import me.vault.game.control.*;
import me.vault.game.model.GameDifficulty;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.model.artifact.implementation.DamageArtifact;
import me.vault.game.model.artifact.implementation.DefenseArtifact;
import me.vault.game.model.artifact.implementation.HealthArtifact;
import me.vault.game.model.city.CityBuildingLevel;
import me.vault.game.model.city.implementation.*;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.energy.EnergyAbilityLevel;
import me.vault.game.model.energy.implementation.DodgeAbility;
import me.vault.game.model.energy.implementation.InitiativeAbility;
import me.vault.game.model.energy.implementation.MeleeAbility;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.model.troop.implementation.*;
import me.vault.game.utility.exception.UnexpectedValueException;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;


/**
 * This class serves as configuration and is the object that'll be used to by the {@link ConfigLoader} to load the configuration from the JSON file to this
 * object and vice versa.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see ConfigLoader
 * @since 24.06.2024
 */
public final class Config
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(Config.class.getSimpleName());


	/**
	 * The default number of currencies the player starts with if no other values were specified in the configuration file.
	 */
	private static final int DEFAULT_RESOURCE_AMOUNT = 10000;


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Artifact#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN =
		"Config'{'difficulty={0}, steelAmount={1}, compositeAmount={2}, foodRationAmount={3}, scienceAmount={4}, energyCreditAmount={5}, " +
		"healthArtifactLevel={6}, defenseArtifactLevel={7}, damageArtifactLevel={8}, dodgeEnergyAbilityLevel={9}, initiativeEnergyAbilityLevel={10}, " +
		"meleeEnergyAbilityLevel={11}, workshopLevel={12}, marketLevel={13}, commandCenterLevel={14}, laboratoryLevel={15}, docksLevel={16}, " +
		"barracksLevel={17}, spaceBarLevel={18}, trainingFacilityLevel={19}, engineerLevel={20}, grenadierLevel={21}, guardLevel={22}, infantryLevel={23}, " +
		"lieutenantLevel={24}, medicLevel={25}, officerLevel={26}, precisionShooterLevel={27}, rangerLevel={28}, recruitLevel={29}, sniperLevel={30}, " +
		"spaceMarineLevel={31}'}'";


	/**
	 * The instance of this class, which represents the current configuration in the program's memory.
	 */
	private static Config instance = new Config();


	/**
	 * The difficulty the game is currently set to.
	 * <br>
	 * The default difficulty is {@link GameDifficulty#NORMAL} if the user configured no other difficulty.
	 */
	private GameDifficulty difficulty = GameDifficulty.NORMAL;


	/**
	 * The amount of steel the player currently owns.
	 * <br>
	 * The default amount if no other value was read from the configuration file is {@link Config#DEFAULT_RESOURCE_AMOUNT}.
	 */
	private int steelAmount = DEFAULT_RESOURCE_AMOUNT;


	/**
	 * The amount of composite the player currently owns.
	 * <br>
	 * The default amount if no other value was read from the configuration file is {@link Config#DEFAULT_RESOURCE_AMOUNT}.
	 */
	private int compositeAmount = DEFAULT_RESOURCE_AMOUNT;


	/**
	 * The amount of food the player currently owns.
	 * <br>
	 * The default amount if no other value was read from the configuration file is {@link Config#DEFAULT_RESOURCE_AMOUNT}.
	 */
	private int foodRationAmount = DEFAULT_RESOURCE_AMOUNT;


	/**
	 * The amount of science the player currently owns.
	 * <br>
	 * The default amount if no other value was read from the configuration file is {@link Config#DEFAULT_RESOURCE_AMOUNT}.
	 */
	private int scienceAmount = DEFAULT_RESOURCE_AMOUNT;


	/**
	 * The amount of energy credits the player currently owns.
	 * <br>
	 * The default amount if no other value was read from the configuration file is {@link Config#DEFAULT_RESOURCE_AMOUNT}.
	 */
	private int energyCreditAmount = DEFAULT_RESOURCE_AMOUNT;


	/**
	 * The level of the health artifact.
	 */
	private ArtifactLevel healthArtifactLevel = ArtifactLevel.getMinimum();


	/**
	 * The level of the defense artifact.
	 */
	private ArtifactLevel defenseArtifactLevel = ArtifactLevel.getMinimum();


	/**
	 * The level of the damage artifact.
	 */
	private ArtifactLevel damageArtifactLevel = ArtifactLevel.getMinimum();


	/**
	 * The level of the dodge energy ability.
	 */
	private EnergyAbilityLevel dodgeEnergyAbilityLevel = EnergyAbilityLevel.getMinimum();


	/**
	 * The level of the initiative energy ability.
	 */
	private EnergyAbilityLevel initiativeEnergyAbilityLevel = EnergyAbilityLevel.getMinimum();


	/**
	 * The level of the melee energy ability.
	 */
	private EnergyAbilityLevel meleeEnergyAbilityLevel = EnergyAbilityLevel.getMinimum();


	/**
	 * The level of the workshop city building.
	 */
	private CityBuildingLevel workshopLevel = CityBuildingLevel.getMinimum();


	/**
	 * The level of the market city building.
	 */
	private CityBuildingLevel marketLevel = CityBuildingLevel.getMinimum();


	/**
	 * The level of the command center city building.
	 */
	private CityBuildingLevel commandCenterLevel = CityBuildingLevel.getMinimum();


	/**
	 * The level of the laboratory city building.
	 */
	private CityBuildingLevel laboratoryLevel = CityBuildingLevel.getMinimum();


	/**
	 * The level of the docks city building.
	 */
	private CityBuildingLevel docksLevel = CityBuildingLevel.getMinimum();


	/**
	 * The level of the barracks city building.
	 */
	private CityBuildingLevel barracksLevel = CityBuildingLevel.getMinimum();


	/**
	 * The level of the space bar city building.
	 */
	private CityBuildingLevel spaceBarLevel = CityBuildingLevel.getMinimum();


	/**
	 * The level of the training facility city building.
	 */
	private CityBuildingLevel trainingFacilityLevel = CityBuildingLevel.getMinimum();


	/**
	 * The level of the engineer troop.
	 */
	private TroopLevel engineerLevel = TroopLevel.getMinimum();


	/**
	 * The level of the grenadier troop.
	 */
	private TroopLevel grenadierLevel = TroopLevel.getMinimum();


	/**
	 * The level of the guard troop.
	 */
	private TroopLevel guardLevel = TroopLevel.getMinimum();


	/**
	 * The level of the infantry troop.
	 */
	private TroopLevel infantryLevel = TroopLevel.getMinimum();


	/**
	 * The level of the lieutenant troop.
	 */
	private TroopLevel lieutenantLevel = TroopLevel.getMinimum();


	/**
	 * The level of the medic troop.
	 */
	private TroopLevel medicLevel = TroopLevel.getMinimum();


	/**
	 * The level of the officer troop.
	 */
	private TroopLevel officerLevel = TroopLevel.getMinimum();


	/**
	 * The level of the precision shooter troop.
	 */
	private TroopLevel precisionShooterLevel = TroopLevel.getMinimum();


	/**
	 * The level of the ranger troop.
	 */
	private TroopLevel rangerLevel = TroopLevel.getMinimum();


	/**
	 * The level of the recruit troop.
	 */
	private TroopLevel recruitLevel = TroopLevel.getMinimum();


	/**
	 * The level of the sniper troop.
	 */
	private TroopLevel sniperLevel = TroopLevel.getMinimum();


	/**
	 * The level of the space marine troop.
	 */
	private TroopLevel spaceMarineLevel = TroopLevel.getMinimum();


	/**
	 * Constructs an instance of this clas.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition An instance of this class was constructed.
	 */
	private Config () {}


	/**
	 * Returns the current configuration instance.
	 *
	 * @return The current configuration instance.
	 * @precondition None.
	 * @postcondition The current configuration instance was returned.
	 */
	public static Config getInstance ()
	{
		return instance;
	}


	/**
	 * Sets the configuration instance.
	 *
	 * @param config The configuration instance that'll be set.
	 * @precondition A valid instance of this class has to be supplied as a parameter.
	 * @postcondition The configuration instance was set to the supplied value.
	 */
	public static void setInstance (final Config config)
	{
		instance = config;
	}


	/**
	 * Updates the number of available currencies in the config by reading the data from the fields throughout the program.
	 *
	 * @throws UnexpectedValueException If the currency is invalid, should usually never be thrown.
	 * @precondition None.
	 * @postcondition The number of available currencies in the config was updated by reading the data from the fields throughout the program.
	 */
	private void updateCurrencyAmountsFromModels () throws UnexpectedValueException
	{
		for (final Currency currency : Currency.values())
		{
			switch (currency)
			{
				case STEEL -> this.steelAmount = currency.getAmount();
				case COMPOSITE -> this.compositeAmount = currency.getAmount();
				case FOOD_RATION -> this.foodRationAmount = currency.getAmount();
				case SCIENCE -> this.scienceAmount = currency.getAmount();
				case ENERGY_CREDIT -> this.energyCreditAmount = currency.getAmount();
				default -> throw new UnexpectedValueException(currency.toString());
			}
		}
	}


	/**
	 * Updates the number of available currencies from the fields in the config.
	 *
	 * @throws UnexpectedValueException If the currency is invalid, should usually never be thrown.
	 * @precondition None.
	 * @postcondition The number of available currencies from the fields in the config was updated.
	 */
	private void updateCurrencyAmountsFromConfig () throws UnexpectedValueException
	{
		for (final Currency currency : Currency.values())
		{
			switch (currency)
			{
				case STEEL -> currency.setAmount(this.steelAmount);
				case COMPOSITE -> currency.setAmount(this.compositeAmount);
				case FOOD_RATION -> currency.setAmount(this.foodRationAmount);
				case SCIENCE -> currency.setAmount(this.scienceAmount);
				case ENERGY_CREDIT -> currency.setAmount(this.energyCreditAmount);
				default -> throw new UnexpectedValueException(currency.toString());
			}
		}
	}


	/**
	 * Updates the levels of the artifacts in the config by reading the data from the fields throughout the program.
	 *
	 * @precondition None.
	 * @postcondition The levels of the artifacts in the config were updated by reading the data from the fields throughout the program.
	 */
	private void updateArtifactLevelsFromModels ()
	{
		this.healthArtifactLevel = HealthArtifact.getInstance().getLevel();
		this.damageArtifactLevel = HealthArtifact.getInstance().getLevel();
		this.defenseArtifactLevel = HealthArtifact.getInstance().getLevel();
	}


	/**
	 * Updates the levels of the artifacts from the fields in the config.
	 *
	 * @precondition None.
	 * @postcondition The levels of the artifacts from the fields in the config were updated.
	 */
	private void updateArtifactLevelsFromConfig ()
	{
		HealthArtifact.getInstance().setLevel(this.healthArtifactLevel);
		DamageArtifact.getInstance().setLevel(this.damageArtifactLevel);
		DefenseArtifact.getInstance().setLevel(this.defenseArtifactLevel);

		ArtifactController.getInstance().updateValues(HealthArtifact.getInstance());
		ArtifactController.getInstance().updateValues(DamageArtifact.getInstance());
		ArtifactController.getInstance().updateValues(DefenseArtifact.getInstance());
	}


	/**
	 * Updates the levels of the energy abilities in the config by reading the data from the fields throughout the program.
	 *
	 * @precondition None.
	 * @postcondition The levels of the energy abilities in the config were updated by reading the data from the fields throughout the program.
	 */
	private void updateEnergyAbilityLevelsFromModels ()
	{
		this.dodgeEnergyAbilityLevel = DodgeAbility.getInstance().getLevel();
		this.initiativeEnergyAbilityLevel = InitiativeAbility.getInstance().getLevel();
		this.meleeEnergyAbilityLevel = MeleeAbility.getInstance().getLevel();
	}


	/**
	 * Updates the levels of the energy abilities from the fields in the config.
	 *
	 * @precondition None.
	 * @postcondition The levels of the energy abilities from the fields in the config were updated.
	 */
	private void updateEnergyLevelsFromConfig ()
	{
		DodgeAbility.getInstance().setLevel(this.dodgeEnergyAbilityLevel);
		InitiativeAbility.getInstance().setLevel(this.initiativeEnergyAbilityLevel);
		MeleeAbility.getInstance().setLevel(this.meleeEnergyAbilityLevel);

		EnergyAbilityController.getInstance().updateValues(DodgeAbility.getInstance());
		EnergyAbilityController.getInstance().updateValues(InitiativeAbility.getInstance());
		EnergyAbilityController.getInstance().updateValues(MeleeAbility.getInstance());
	}


	/**
	 * Updates the levels of the city buildings in the config by reading the data from the fields throughout the program.
	 *
	 * @precondition None.
	 * @postcondition The levels of the city buildings in the config were updated by reading the data from the fields throughout the program.
	 */
	private void updateCityBuildingLevelsFromModels ()
	{
		this.barracksLevel = Barracks.getInstance().getLevel();
		this.commandCenterLevel = CommandCenter.getInstance().getLevel();
		this.docksLevel = Docks.getInstance().getLevel();
		this.laboratoryLevel = Laboratory.getInstance().getLevel();
		this.marketLevel = Market.getInstance().getLevel();
		this.spaceBarLevel = SpaceBar.getInstance().getLevel();
		this.trainingFacilityLevel = TrainingFacility.getInstance().getLevel();
		this.workshopLevel = Workshop.getInstance().getLevel();
	}


	/**
	 * Updates the levels of the city buildings from the fields in the config.
	 *
	 * @precondition None.
	 * @postcondition The levels of the city buildings from the fields in the config were updated.
	 */
	private void updateCityBuildingLevelsFromConfig ()
	{
		Barracks.getInstance().setLevel(this.barracksLevel);
		CommandCenter.getInstance().setLevel(this.commandCenterLevel);
		Docks.getInstance().setLevel(this.docksLevel);
		Laboratory.getInstance().setLevel(this.laboratoryLevel);
		Market.getInstance().setLevel(this.marketLevel);
		SpaceBar.getInstance().setLevel(this.spaceBarLevel);
		TrainingFacility.getInstance().setLevel(this.trainingFacilityLevel);
		Workshop.getInstance().setLevel(this.workshopLevel);

		CityBuildingController.getInstance().updateValues(Barracks.getInstance());
		CityBuildingController.getInstance().updateValues(CommandCenter.getInstance());
		CityBuildingController.getInstance().updateValues(Docks.getInstance());
		CityBuildingController.getInstance().updateValues(Laboratory.getInstance());
		CityBuildingController.getInstance().updateValues(Market.getInstance());
		CityBuildingController.getInstance().updateValues(SpaceBar.getInstance());
		CityBuildingController.getInstance().updateValues(TrainingFacility.getInstance());
		CityBuildingController.getInstance().updateValues(Workshop.getInstance());
	}


	/**
	 * Updates the levels of the troops in the config by reading the data from the fields throughout the program.
	 *
	 * @precondition None.
	 * @postcondition The levels of the troops in the config were updated by reading the data from the fields throughout the program.
	 */
	private void updateTroopLevelsFromModels ()
	{
		this.engineerLevel = Engineer.getInstance().getLevel();
		this.grenadierLevel = Grenadier.getInstance().getLevel();
		this.guardLevel = Guard.getInstance().getLevel();
		this.infantryLevel = Infantry.getInstance().getLevel();
		this.lieutenantLevel = Lieutenant.getInstance().getLevel();
		this.medicLevel = Medic.getInstance().getLevel();
		this.officerLevel = Officer.getInstance().getLevel();
		this.precisionShooterLevel = PrecisionShooter.getInstance().getLevel();
		this.rangerLevel = Ranger.getInstance().getLevel();
		this.recruitLevel = Recruit.getInstance().getLevel();
		this.sniperLevel = Sniper.getInstance().getLevel();
		this.spaceMarineLevel = SpaceMarine.getInstance().getLevel();
	}


	/**
	 * Updates the levels of the troops from the fields in the config.
	 *
	 * @precondition None.
	 * @postcondition The levels of the troops from the fields in the config were updated.
	 */
	private void updateTroopLevelsFromConfig ()
	{
		Engineer.getInstance().setLevel(this.engineerLevel);
		Grenadier.getInstance().setLevel(this.grenadierLevel);
		Guard.getInstance().setLevel(this.guardLevel);
		Infantry.getInstance().setLevel(this.infantryLevel);
		Lieutenant.getInstance().setLevel(this.lieutenantLevel);
		Medic.getInstance().setLevel(this.medicLevel);
		Officer.getInstance().setLevel(this.officerLevel);
		PrecisionShooter.getInstance().setLevel(this.precisionShooterLevel);
		Ranger.getInstance().setLevel(this.rangerLevel);
		Recruit.getInstance().setLevel(this.recruitLevel);
		Sniper.getInstance().setLevel(this.sniperLevel);
		SpaceMarine.getInstance().setLevel(this.spaceMarineLevel);

		TroopController.getInstance().updateValues(Engineer.getInstance());
		TroopController.getInstance().updateValues(Grenadier.getInstance());
		TroopController.getInstance().updateValues(Guard.getInstance());
		TroopController.getInstance().updateValues(Infantry.getInstance());
		TroopController.getInstance().updateValues(Lieutenant.getInstance());
		TroopController.getInstance().updateValues(Medic.getInstance());
		TroopController.getInstance().updateValues(Officer.getInstance());
		TroopController.getInstance().updateValues(PrecisionShooter.getInstance());
		TroopController.getInstance().updateValues(Ranger.getInstance());
		TroopController.getInstance().updateValues(Recruit.getInstance());
		TroopController.getInstance().updateValues(Sniper.getInstance());
		TroopController.getInstance().updateValues(SpaceMarine.getInstance());
	}


	/**
	 * The values of the fields throughout the program are updated from the fields of the config.
	 *
	 * @precondition None.
	 * @postcondition The fields throughout the program were updated from the fields of the config.
	 */
	public void updateModelsFromConfig ()
	{

		try
		{
			this.updateTroopLevelsFromConfig();
			this.updateCityBuildingLevelsFromConfig();
			this.updateArtifactLevelsFromConfig();
			this.updateEnergyLevelsFromConfig();
			GameController.setDifficulty(this.difficulty);
			this.updateCurrencyAmountsFromConfig();
		}
		catch (final UnexpectedValueException e)
		{
			LOGGER.log(ILogger.Level.WARNING, e.getMessage());
		}
	}


	/**
	 * The values of the fields in this config file are updated from the models throughout the program.
	 *
	 * @precondition None.
	 * @postcondition The fields in this config file were updated from the models throughout the program.
	 */
	public void updateConfigFromModels ()
	{
		try
		{
			this.updateCurrencyAmountsFromModels();
			this.updateArtifactLevelsFromModels();
			this.updateCityBuildingLevelsFromModels();
			this.difficulty = GameController.getDifficulty();
			this.updateTroopLevelsFromModels();
		}
		catch (final UnexpectedValueException e)
		{
			LOGGER.log(ILogger.Level.WARNING, e.getMessage());
		}
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Config#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Config#TO_STRING_PATTERN}.
	 * @precondition The {@link Config#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.difficulty.toString(), this.steelAmount, this.compositeAmount, this.foodRationAmount,
			this.scienceAmount, this.energyCreditAmount, this.healthArtifactLevel.toString(), this.defenseArtifactLevel.toString(),
			this.damageArtifactLevel.toString(),
			this.dodgeEnergyAbilityLevel.toString(), this.initiativeEnergyAbilityLevel.toString(), this.meleeEnergyAbilityLevel.toString(),
			this.workshopLevel.toString(), this.marketLevel.toString(), this.commandCenterLevel.toString(), this.laboratoryLevel.toString(),
			this.docksLevel.toString(), this.barracksLevel.toString(), this.spaceBarLevel.toString(), this.trainingFacilityLevel.toString(),
			this.engineerLevel.toString(), this.grenadierLevel.toString(), this.guardLevel.toString(), this.infantryLevel.toString(),
			this.lieutenantLevel.toString(), this.medicLevel.toString(), this.officerLevel.toString(), this.precisionShooterLevel.toString(),
			this.rangerLevel.toString(), this.recruitLevel.toString(), this.sniperLevel.toString(), this.spaceMarineLevel.toString());
	}
}
