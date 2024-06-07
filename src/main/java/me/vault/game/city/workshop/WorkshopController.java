package me.vault.game.city.workshop;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.artifact.ArtifactController;
import me.vault.game.artifact.AttributeMultiplier;
import me.vault.game.artifact.impl.DamageArtifact;
import me.vault.game.artifact.impl.DefenseArtifact;
import me.vault.game.artifact.impl.HealthArtifact;
import me.vault.game.city.CityView;
import me.vault.game.city.building.CityBuildingController;
import me.vault.game.currency.Currency;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;


public class WorkshopController extends CityBuildingController implements Initializable
{
	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(WorkshopController.class.getSimpleName());


	@FXML
	private Label compositeAmountLabel;


	@FXML
	private ImageView compositeImageView;


	@FXML
	private Label creditAmountLabel;


	@FXML
	private ImageView creditImageView;


	@FXML
	private Label damageArtifactDamageModifierLabel;


	@FXML
	private Label damageArtifactDefenseModifierLabel;


	@FXML
	private Label damageArtifactHealthModifierLabel;


	@FXML
	private ImageView damageArtifactImageView;


	@FXML
	private Label damageArtifactLabel;


	@FXML
	private Button damageArtifactUpgradeButton;


	@FXML
	private Label defenseArtifactDamageModifierLabel;


	@FXML
	private Label defenseArtifactDefenseModifierLabel;


	@FXML
	private Label defenseArtifactHealthModifierLabel;


	@FXML
	private ImageView defenseArtifactImageView;


	@FXML
	private Label defenseArtifactLabel;


	@FXML
	private Button defenseArtifactUpgradeButton;


	@FXML
	private Label foodAmountLabel;


	@FXML
	private ImageView foodImageView;


	@FXML
	private Label healthArtifactDamageModifierLabel;


	@FXML
	private Label healthArtifactDefenseModifierLabel;


	@FXML
	private Label healthArtifactHealthModifierLabel;


	@FXML
	private ImageView healthArtifactImageView;


	@FXML
	private Label healthArtifactLabel;


	@FXML
	private Button healthArtifactUpgradeButton;


	@FXML
	private Label scienceAmountLabel;


	@FXML
	private ImageView scienceImageView;


	@FXML
	private Label steelAmountLabel;


	@FXML
	private ImageView steelImageView;


	@FXML
	private ImageView workshopBackgroundImageView;


	@FXML
	private void onBackToCityView (final ActionEvent event)
	{
		CityView.show(VaultApplication.getStage());
	}


	@FXML
	private void onDamageArtifactUpgrade (final ActionEvent event)
	{
		ArtifactController.getInstance().upgrade(DamageArtifact.getInstance());
	}


	@FXML
	private void onDefenseArtifactUpgrade (final ActionEvent event)
	{
		ArtifactController.getInstance().upgrade(DefenseArtifact.getInstance());
	}


	@FXML
	private void onHealthArtifactUpgrade (final ActionEvent event)
	{
		ArtifactController.getInstance().upgrade(HealthArtifact.getInstance());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.workshopBackgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
		this.initCurrencies();

		this.bindArtifactViews();
		this.bindArtifactNames();
		this.bindArtifactAttributeModifiers();
	}


	private void bindArtifactViews ()
	{
		this.healthArtifactImageView.imageProperty().bind(HealthArtifact.getInstance().getSpriteProperty());
		this.damageArtifactImageView.imageProperty().bind(DamageArtifact.getInstance().getSpriteProperty());
		this.defenseArtifactImageView.imageProperty().bind(DefenseArtifact.getInstance().getSpriteProperty());
	}


	private void bindArtifactNames ()
	{
		this.healthArtifactLabel.textProperty().bind(HealthArtifact.getInstance().getNameProperty());
		this.defenseArtifactLabel.textProperty().bind(DefenseArtifact.getInstance().getNameProperty());
		this.damageArtifactLabel.textProperty().bind(DamageArtifact.getInstance().getNameProperty());
	}


	private void bindArtifactAttributeModifiers ()
	{
		final AttributeMultiplier healthArtifactModifiers = HealthArtifact.getInstance().getAttributeModifiers();
		this.healthArtifactDamageModifierLabel.textProperty()
			.bind(healthArtifactModifiers.getDamageMultiplierProperty().asString());
		this.healthArtifactDefenseModifierLabel.textProperty()
			.bind(healthArtifactModifiers.getDefenseMultiplierProperty().asString());
		this.healthArtifactHealthModifierLabel.textProperty()
			.bind(healthArtifactModifiers.getHealthMultiplierProperty().asString());

		final AttributeMultiplier damageArtifactModifiers = DamageArtifact.getInstance().getAttributeModifiers();
		this.damageArtifactDamageModifierLabel.textProperty()
			.bind(damageArtifactModifiers.getDamageMultiplierProperty().asString());
		this.damageArtifactDefenseModifierLabel.textProperty()
			.bind(damageArtifactModifiers.getDefenseMultiplierProperty().asString());
		this.damageArtifactHealthModifierLabel.textProperty()
			.bind(damageArtifactModifiers.getHealthMultiplierProperty().asString());

		final AttributeMultiplier defenseArtifactModifiers = DefenseArtifact.getInstance().getAttributeModifiers();
		this.defenseArtifactDamageModifierLabel.textProperty()
			.bind(defenseArtifactModifiers.getDamageMultiplierProperty().asString());
		this.defenseArtifactDefenseModifierLabel.textProperty()
			.bind(defenseArtifactModifiers.getDefenseMultiplierProperty().asString());
		this.defenseArtifactHealthModifierLabel.textProperty()
			.bind(defenseArtifactModifiers.getHealthMultiplierProperty().asString());
	}


	private void initCurrencies ()
	{
		initCurrency(Currency.STEEL, this.steelAmountLabel, this.steelImageView);
		initCurrency(Currency.COMPOSITE, this.compositeAmountLabel, this.compositeImageView);
		initCurrency(Currency.SCIENCE, this.scienceAmountLabel, this.scienceImageView);
		initCurrency(Currency.FOOD_RATION, this.foodAmountLabel, this.foodImageView);
		initCurrency(Currency.ENERGY_CREDIT, this.creditAmountLabel, this.creditImageView);
	}
}
