package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.interfaces.UpgradableNew;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;


public class UpgradeDialogDelegate implements Initializable
{

	private static final Scene UPGRADE_DIALOGUE_SCENE = ResourceLoader.loadScene(UpgradeDialogDelegate.class, "upgradeDialog.fxml");

	private static final String WINDOW_TITLE = "Upgrading...";

	private Stage stage;

	@FXML
	private Label afterUpgradeLabel;

	@FXML
	private Label beforeUpgradeLabel;

	@FXML
	private Label compositeCostLabel;

	@FXML
	private Label energyCreditCostLabel;

	@FXML
	private Label foodRationCostLabel;

	@FXML
	private Label scienceCostLabel;

	@FXML
	private Label steelCostLabel;

	@FXML
	private Button upgradeButton;

	@FXML
	private DialogPane upgradeDialogPane;


	private static void initializeUpgradeDialogStage (final Stage stage)
	{
		stage.setTitle(WINDOW_TITLE);
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		// UPGRADE_DIALOG_STAGE.getIcons().add(ResourceLoader.loadImage(ICON_PATH));
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.stage = new Stage();
		initializeUpgradeDialogStage(this.stage);
	}


	public void setUpgradable (final UpgradableNew upgradable)
	{
		this.setLevelChangeLabels(upgradable);
		this.setUpgradeCostLabels(upgradable);
	}


	private void setUpgradeCostLabels (final UpgradableNew upgradable)
	{
		final CurrencyTransaction upgradeCosts = upgradable.getCurrentUpgradeCosts();
		this.steelCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.STEEL)));
		this.compositeCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.COMPOSITE)));
		this.scienceCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.SCIENCE)));
		this.foodRationCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.FOOD_RATION)));
		this.energyCreditCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.ENERGY_CREDIT)));
	}


	private void setLevelChangeLabels (final UpgradableNew upgradable)
	{
		this.beforeUpgradeLabel.setText(upgradable.getLevel().toString());
		this.afterUpgradeLabel.setText(upgradable.getLevel().toString());
	}


	@FXML
	void onUpgradeButtonAction (final ActionEvent event)
	{

	}


	@FXML
	void onCancelButtonAction (final ActionEvent event)
	{

	}


	public void show (final Scene scene)
	{
		this.stage.setScene(scene);
		this.stage.showAndWait();
	}

}
