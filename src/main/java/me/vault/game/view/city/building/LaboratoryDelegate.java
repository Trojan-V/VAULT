package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import me.vault.game.GameApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.control.EnergyAbilityController;
import me.vault.game.model.energy.impl.DodgeAbility;
import me.vault.game.model.energy.impl.InitiativeAbility;
import me.vault.game.model.energy.impl.MeleeAbility;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.fx.MultiplierVBox;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.util.ResourceBundle;


public final class LaboratoryDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(LaboratoryDelegate.class.getSimpleName());

	private static final String LABORATORY_VIEW_FXML = "laboratory_view.fxml";

	@FXML
	private AnchorPane mainPane;

	@FXML
	private HBox meleeHBox;

	@FXML
	private HBox dodgeHBox;

	@FXML
	private HBox initiativeHBox;

	@FXML
	private ImageView dodgeImageView;

	@FXML
	private Label dodgeLabel;

	@FXML
	private Button dodgeUpgradeButton;

	@FXML
	private ImageView initiativeImageView;

	@FXML
	private Label initiativeLabel;

	@FXML
	private Button initiativeUpgradeButton;

	@FXML
	private ImageView meleeImageView;

	@FXML
	private Label meleeLabel;

	@FXML
	private Button meleeUpgradeButton;


	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(LaboratoryDelegate.class, LABORATORY_VIEW_FXML), LaboratoryDelegate.class);
	}


	@FXML
	private void onDodgeAbilityUpgrade (final ActionEvent ignored)
	{
		if (EnergyAbilityController.getInstance().checkIsUpgradable(DodgeAbility.getInstance()))
		{
			UpgradeDialogDelegate.show(DodgeAbility.getInstance(), EnergyAbilityController.getInstance());
		}
	}


	@FXML
	private void onInitiativeAbilityUpgrade (final ActionEvent ignored)
	{
		if (EnergyAbilityController.getInstance().checkIsUpgradable(InitiativeAbility.getInstance()))
		{
			UpgradeDialogDelegate.show(InitiativeAbility.getInstance(), EnergyAbilityController.getInstance());
		}
	}


	@FXML
	private void onMeleeAbilityUpgrade (final ActionEvent ignored)
	{
		if (EnergyAbilityController.getInstance().checkIsUpgradable(MeleeAbility.getInstance()))
		{
			UpgradeDialogDelegate.show(MeleeAbility.getInstance(), EnergyAbilityController.getInstance());
		}
	}


	/**
	 * Initialises the fxml-view and sets program-specific bindings and properties.
	 *
	 * @param url            The {@link URL} object, which represents the fxml-file of the view.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 */

	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.bindEnergyTextProperties();
		this.bindEnergyImageProperties();
		this.addMultiplierBoxes();
		this.bindUpgradeButtonProperties();

	}


	private void bindUpgradeButtonProperties ()
	{
		this.dodgeUpgradeButton.disableProperty().bind(DodgeAbility.getInstance().getIsMaxLevelProperty());
		this.initiativeUpgradeButton.disableProperty().bind(InitiativeAbility.getInstance().getIsMaxLevelProperty());
		this.meleeUpgradeButton.disableProperty().bind(MeleeAbility.getInstance().getIsMaxLevelProperty());
	}


	private void bindEnergyTextProperties ()
	{
		this.dodgeLabel.textProperty().bind(DodgeAbility.getInstance().getNameProperty());
		this.initiativeLabel.textProperty().bind(InitiativeAbility.getInstance().getNameProperty());
		this.meleeLabel.textProperty().bind(MeleeAbility.getInstance().getNameProperty());
	}


	private void bindEnergyImageProperties ()
	{
		this.dodgeImageView.imageProperty().bind(DodgeAbility.getInstance().getSpriteProperty());
		this.initiativeImageView.imageProperty().bind(InitiativeAbility.getInstance().getSpriteProperty());
		this.meleeImageView.imageProperty().bind(MeleeAbility.getInstance().getSpriteProperty());
	}


	private void addMultiplierBoxes ()
	{
		this.dodgeHBox.getChildren().add(new MultiplierVBox(DodgeAbility.getInstance().getAbilityMultiplier()));
		this.initiativeHBox.getChildren().add(new MultiplierVBox(InitiativeAbility.getInstance().getAbilityMultiplier()));
		this.meleeHBox.getChildren().add(new MultiplierVBox(MeleeAbility.getInstance().getAbilityMultiplier()));
	}


	@FXML
	private void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}

}