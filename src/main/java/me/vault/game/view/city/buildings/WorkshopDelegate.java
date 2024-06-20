package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.ArtifactController;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.artifact.impl.DefenseArtifact;
import me.vault.game.model.artifact.impl.HealthArtifact;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * The {@code DocksDelegate} handles the control and view of the {@link me.vault.game.model.city.Workshop} city building. On the one hand it
 * initialises the view from the fxml-file and binds properties from the model to the view. On the other hand it provides methods to control the model
 * to the {@link me.vault.game.model.city.Workshop} cty building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see me.vault.game.model.city.Workshop
 * @since 11.06.2024
 */
public class WorkshopDelegate extends CityBuildingController implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(WorkshopDelegate.class.getSimpleName());

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
	private Button damageUpgradeButton;

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
	private Button defenseUpgradeButton;

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
	private Button healthUpgradeButton;

	@FXML
	private AnchorPane mainPane;



	@FXML
	private void onBackToCityView (final ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
	}


	@FXML
	private void onDamageArtifactUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(DamageArtifact.getInstance(), ArtifactController.getInstance());
	}


	@FXML
	private void onDefenseArtifactUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(DefenseArtifact.getInstance(), ArtifactController.getInstance());
	}


	@FXML
	private void onHealthArtifactUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(HealthArtifact.getInstance(), ArtifactController.getInstance());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.bindArtifactTextProperties();
		this.bindArtifactImageProperties();
		this.bindArtifactMultiplierTextProperties();
		this.bindUpgradeButtonProperties();

	}


	private void bindUpgradeButtonProperties ()
	{
		this.healthUpgradeButton.disableProperty().bind(HealthArtifact.getInstance().getIsMaxLevelProperty());
		this.defenseUpgradeButton.disableProperty().bind(DefenseArtifact.getInstance().getIsMaxLevelProperty());
		this.damageUpgradeButton.disableProperty().bind(DamageArtifact.getInstance().getIsMaxLevelProperty());
	}


	private void bindArtifactTextProperties ()
	{
		this.healthArtifactLabel.textProperty().bind(HealthArtifact.getInstance().getNameProperty());
		this.defenseArtifactLabel.textProperty().bind(DefenseArtifact.getInstance().getNameProperty());
		this.damageArtifactLabel.textProperty().bind(DamageArtifact.getInstance().getNameProperty());
	}


	private void bindArtifactImageProperties ()
	{
		this.healthArtifactImageView.imageProperty().bind(HealthArtifact.getInstance().getSpriteProperty());
		this.damageArtifactImageView.imageProperty().bind(DamageArtifact.getInstance().getSpriteProperty());
		this.defenseArtifactImageView.imageProperty().bind(DefenseArtifact.getInstance().getSpriteProperty());
	}


	private void bindArtifactMultiplierTextProperties ()
	{
		final AttributeMultiplier healthArtifactModifiers = HealthArtifact.getInstance().getAttributeMultipliers();
		this.healthArtifactDamageModifierLabel.textProperty().bind(healthArtifactModifiers.getDamageMultiplierProperty().asString());
		this.healthArtifactDefenseModifierLabel.textProperty().bind(healthArtifactModifiers.getDefenseMultiplierProperty().asString());
		this.healthArtifactHealthModifierLabel.textProperty().bind(healthArtifactModifiers.getHealthMultiplierProperty().asString());

		final AttributeMultiplier damageArtifactModifiers = DamageArtifact.getInstance().getAttributeMultipliers();
		this.damageArtifactDamageModifierLabel.textProperty().bind(damageArtifactModifiers.getDamageMultiplierProperty().asString());
		this.damageArtifactDefenseModifierLabel.textProperty().bind(damageArtifactModifiers.getDefenseMultiplierProperty().asString());
		this.damageArtifactHealthModifierLabel.textProperty().bind(damageArtifactModifiers.getHealthMultiplierProperty().asString());

		final AttributeMultiplier defenseArtifactModifiers = DefenseArtifact.getInstance().getAttributeMultipliers();
		this.defenseArtifactDamageModifierLabel.textProperty().bind(defenseArtifactModifiers.getDamageMultiplierProperty().asString());
		this.defenseArtifactDefenseModifierLabel.textProperty().bind(defenseArtifactModifiers.getDefenseMultiplierProperty().asString());
		this.defenseArtifactHealthModifierLabel.textProperty().bind(defenseArtifactModifiers.getHealthMultiplierProperty().asString());
	}

}
