package me.vault.game.utility.loading;


import me.vault.game.control.GameController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.model.artifact.ArtifactLevel;
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
	// TODO: Wenn der "Exit" Button gedrückt wird, kommt ein Dialog, dass noch nicht gespeichert wurde und es wird
	//  gefragt, ob gespeichert werden soll.
	//  (Außerdem sollte ein Autosave implementiert werden, der alle 15 Minuten o.Ä. speichert).

	// TODO: isDefault getter and setter and attribute. Set isDefault from ConfigLoader. If isDefault == true, gray
	//  out continue button in main menu.

	private static Config instance = new Config();

	// Config attributes for the whole game

	private GameDifficulty difficulty = GameDifficulty.HARD_MODE;

	// Currency related config entries
	private int steelAmount = 0;


	private int compositeAmount = 0;


	private int foodRationAmount = 0;


	private int scienceAmount = 0;


	private int energyCreditAmount = 0;

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


	private void updateCurrencyAmounts ()
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


	private void updateArtifactLevels ()
	{
		this.healthArtifactLevel = HealthArtifact.getInstance().getLevel();
		this.damageArtifactLevel = HealthArtifact.getInstance().getLevel();
		this.defenseArtifactLevel = HealthArtifact.getInstance().getLevel();
	}


	private void updateCityBuildingLevels ()
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


	private void updateTroopLevels ()
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


	public void updateConfig ()
	{
		this.updateCurrencyAmounts();
		this.updateArtifactLevels();
		this.updateCityBuildingLevels();
		this.difficulty = GameController.getInstance().getDifficulty();
		this.updateTroopLevels();
	}
}
