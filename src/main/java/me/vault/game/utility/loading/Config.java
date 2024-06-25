package me.vault.game.utility.loading;


import me.vault.game.control.ArtifactController;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.GameController;
import me.vault.game.control.TroopController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.artifact.impl.DefenseArtifact;
import me.vault.game.model.artifact.impl.HealthArtifact;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.model.city.*;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.model.troop.impl.*;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 24.06.2024
 */
public class Config
{
	// TODO: Wenn der "Exit" Button gedrueckt wird, kommt ein Dialog, dass noch nicht gespeichert wurde und es wird
	//  gefragt, ob gespeichert werden soll.
	//  Außerdem sollte ein Autosave implementiert werden, der alle 15 Minuten oaespeichert.

	// TODO: isDefault getter and setter and attribute. Set isDefault from ConfigLoader. If isDefault == true, gray
	//  out continue button in main menu.

	private static Config instance = new Config();

	// Config attributes for the whole game

	private GameDifficulty difficulty = GameDifficulty.HARD_MODE;

	// Currency related config entries

	private int steelAmount = 10000;


	private int compositeAmount = 10000;


	private int foodRationAmount = 10000;


	private int scienceAmount = 10000;


	private int energyCreditAmount = 10000;

	// Artifact related config entries


	private ArtifactLevel healthArtifactLevel = ArtifactLevel.getMinimum();


	private ArtifactLevel defenseArtifactLevel = ArtifactLevel.getMinimum();


	private ArtifactLevel damageArtifactLevel = ArtifactLevel.getMinimum();

	// CityBuilding related config entries


	private CityBuildingLevel workshopLevel = CityBuildingLevel.getMinimum();


	private CityBuildingLevel marketLevel = CityBuildingLevel.getMinimum();


	private CityBuildingLevel commandCenterLevel = CityBuildingLevel.getMinimum();


	private CityBuildingLevel laboratoryLevel = CityBuildingLevel.getMinimum();


	private CityBuildingLevel docksLevel = CityBuildingLevel.getMinimum();


	private CityBuildingLevel barracksLevel = CityBuildingLevel.getMinimum();


	private CityBuildingLevel spaceBarLevel = CityBuildingLevel.getMinimum();


	private CityBuildingLevel trainingFacilityLevel = CityBuildingLevel.getMinimum();


	// Troop related config entries
	private TroopLevel engineerLevel = TroopLevel.getMinimum();


	private TroopLevel grenadierLevel = TroopLevel.getMinimum();


	private TroopLevel guardLevel = TroopLevel.getMinimum();


	private TroopLevel infantryLevel = TroopLevel.getMinimum();


	private TroopLevel lieutenantLevel = TroopLevel.getMinimum();


	private TroopLevel medicLevel = TroopLevel.getMinimum();


	private TroopLevel officerLevel = TroopLevel.getMinimum();


	private TroopLevel precisionShooterLevel = TroopLevel.getMinimum();


	private TroopLevel rangerLevel = TroopLevel.getMinimum();


	private TroopLevel recruitLevel = TroopLevel.getMinimum();


	private TroopLevel sniperLevel = TroopLevel.getMinimum();


	private TroopLevel spaceMarineLevel = TroopLevel.getMinimum();


	private Config () {}


	public static Config getInstance ()
	{
		return instance;
	}


	public static void setInstance (final Config config)
	{
		instance = config;
	}


	private void updateCurrencyAmountsFromModels ()
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

				// TODO: keep or remove this default branch
				case null, default -> throw new IllegalStateException("Unexpected value: " + currency);
			}
		}
	}


	private void updateCurrencyAmountsFromConfig ()
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

				// TODO: keep or remove this default branch
				case null, default -> throw new IllegalStateException("Unexpected value: " + currency);
			}
		}
	}


	private void updateArtifactLevelsFromModels ()
	{
		this.healthArtifactLevel = HealthArtifact.getInstance().getLevel();
		this.damageArtifactLevel = HealthArtifact.getInstance().getLevel();
		this.defenseArtifactLevel = HealthArtifact.getInstance().getLevel();
	}


	private void updateArtifactLevelsFromConfig ()
	{
		HealthArtifact.getInstance().setLevel(this.healthArtifactLevel);
		DamageArtifact.getInstance().setLevel(this.damageArtifactLevel);
		DefenseArtifact.getInstance().setLevel(this.defenseArtifactLevel);

		ArtifactController.getInstance().updateValues(HealthArtifact.getInstance());
		ArtifactController.getInstance().updateValues(DamageArtifact.getInstance());
		ArtifactController.getInstance().updateValues(DefenseArtifact.getInstance());
	}


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


	private void updateTroopLevelsFromModels ()
	{
		this.engineerLevel = Engineer.getAllyInstance().getLevel();
		this.grenadierLevel = Grenadier.getAllyInstance().getLevel();
		this.guardLevel = Guard.getAllyInstance().getLevel();
		this.infantryLevel = Infantry.getAllyInstance().getLevel();
		this.lieutenantLevel = Lieutenant.getAllyInstance().getLevel();
		this.medicLevel = Medic.getAllyInstance().getLevel();
		this.officerLevel = Officer.getAllyInstance().getLevel();
		this.precisionShooterLevel = PrecisionShooter.getAllyInstance().getLevel();
		this.rangerLevel = Ranger.getAllyInstance().getLevel();
		this.recruitLevel = Recruit.getAllyInstance().getLevel();
		this.sniperLevel = Sniper.getAllyInstance().getLevel();
		this.spaceMarineLevel = SpaceMarine.getAllyInstance().getLevel();
	}


	private void updateTroopLevelsFromConfig ()
	{
		Engineer.getAllyInstance().setLevel(this.engineerLevel);
		Grenadier.getAllyInstance().setLevel(this.grenadierLevel);
		Guard.getAllyInstance().setLevel(this.guardLevel);
		Infantry.getAllyInstance().setLevel(this.infantryLevel);
		Lieutenant.getAllyInstance().setLevel(this.lieutenantLevel);
		Medic.getAllyInstance().setLevel(this.medicLevel);
		Officer.getAllyInstance().setLevel(this.officerLevel);
		PrecisionShooter.getAllyInstance().setLevel(this.precisionShooterLevel);
		Ranger.getAllyInstance().setLevel(this.rangerLevel);
		Recruit.getAllyInstance().setLevel(this.recruitLevel);
		Sniper.getAllyInstance().setLevel(this.sniperLevel);
		SpaceMarine.getAllyInstance().setLevel(this.spaceMarineLevel);

		TroopController.getInstance().updateValues(Engineer.getAllyInstance());
		TroopController.getInstance().updateValues(Grenadier.getAllyInstance());
		TroopController.getInstance().updateValues(Guard.getAllyInstance());
		TroopController.getInstance().updateValues(Infantry.getAllyInstance());
		TroopController.getInstance().updateValues(Lieutenant.getAllyInstance());
		TroopController.getInstance().updateValues(Medic.getAllyInstance());
		TroopController.getInstance().updateValues(Officer.getAllyInstance());
		TroopController.getInstance().updateValues(PrecisionShooter.getAllyInstance());
		TroopController.getInstance().updateValues(Ranger.getAllyInstance());
		TroopController.getInstance().updateValues(Recruit.getAllyInstance());
		TroopController.getInstance().updateValues(Sniper.getAllyInstance());
		TroopController.getInstance().updateValues(SpaceMarine.getAllyInstance());
	}


	public void updateModelsFromConfig ()
	{
		this.updateTroopLevelsFromConfig();
		this.updateCityBuildingLevelsFromConfig();
		this.updateArtifactLevelsFromConfig();
		GameController.getInstance().setDifficulty(this.difficulty);
		this.updateCurrencyAmountsFromConfig();
	}


	public void updateConfigFromModels ()
	{
		this.updateCurrencyAmountsFromModels();
		this.updateArtifactLevelsFromModels();
		this.updateCityBuildingLevelsFromModels();
		this.difficulty = GameController.getInstance().getDifficulty();
		this.updateTroopLevelsFromModels();
	}

}
