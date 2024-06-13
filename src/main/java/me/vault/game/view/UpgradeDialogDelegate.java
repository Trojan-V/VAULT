package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.interfaces.Level;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.NewLoggingConstants.UPGRADE_DIALOG_FAIL;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public class UpgradeDialogDelegate implements Initializable
{
	private static final ILogger LOGGER = new Logger(UpgradeDialogDelegate.class.getSimpleName());

	private static final String WINDOW_TITLE = "Upgrading...";

	private static final String ICON_PATH = ASSETS_PATH + "Item_Pack/armor_icon.png";

	private static final String TO_STRING_PATTERN =
			"UpgradeDialogDelegate[stage={0}, afterUpgradeLabel={1}, beforeUpgradeLabel={2}, compositeCostLabel={3}, energyCreditCostLabel={4}, " +
			"foodRationCostLabel={5}, scienceCostLabel={6}, steelCostLabel={7}, upgradeButton={8}, upgradeDialogPane={9}]";

	private static final String UPGRADE_DIALOG_FXML = "upgradeDialog.fxml";

	private Stage stage = null;

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
		stage.setResizable(false);
		stage.setTitle(WINDOW_TITLE);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.getIcons().add(ResourceLoader.loadImage(ICON_PATH));
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.stage = new Stage();
		initializeUpgradeDialogStage(this.stage);
	}


	public void setUpgradable (final Upgradable upgradable)
	{
		this.setLevelChangeLabels(upgradable);
		this.setUpgradeCostLabels(upgradable);
	}


	private void setUpgradeCostLabels (final Upgradable upgradable)
	{
		final CurrencyTransaction upgradeCosts = upgradable.getCurrentUpgradeCosts();
		this.steelCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.STEEL)));
		this.compositeCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.COMPOSITE)));
		this.scienceCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.SCIENCE)));
		this.foodRationCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.FOOD_RATION)));
		this.energyCreditCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.ENERGY_CREDIT)));
	}


	private void setLevelChangeLabels (final Upgradable upgradable)
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


	public static void showUpgradeDialog (final Upgradable<? extends Level> upgradable)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(UpgradeDialogDelegate.class.getResource(UPGRADE_DIALOG_FXML));
			final Parent root = fxmlLoader.load();
			final UpgradeDialogDelegate controller = fxmlLoader.getController();
			controller.setUpgradable(upgradable);
			controller.show(new Scene(root));
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, UPGRADE_DIALOG_FAIL, upgradable.toString());
		}
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.stage, this.afterUpgradeLabel, this.beforeUpgradeLabel, this.compositeCostLabel,
				this.energyCreditCostLabel, this.foodRationCostLabel, this.scienceCostLabel, this.steelCostLabel, this.upgradeButton,
				this.upgradeDialogPane);
	}

}
