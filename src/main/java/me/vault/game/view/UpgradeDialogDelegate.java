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
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.UPGRADE_DIALOG_FAIL;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;

// TODO: Anzeigen des dialog bearbeiten -> erst anzeigen und dann "upgrade" ausgrauen


public final class UpgradeDialogDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(UpgradeDialogDelegate.class.getSimpleName());

	private static final String WINDOW_TITLE = "Upgrading...";

	private static final String TO_STRING_PATTERN = "UpgradeDialogDelegate[upgradable={0}, upgrader={1}, fxml={2}]";

	private static final String UPGRADE_DIALOG_VIEW_FXML = "upgradeDialog.fxml";


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

	private Stage stage = null;

	private Upgrader<Upgradable<Level>, Level> upgrader = null;

	private Upgradable<Level> upgradable = null;


	private static void initializeUpgradeDialogStage (final Stage stage)
	{
		stage.setResizable(false);
		stage.setTitle(WINDOW_TITLE);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.getIcons().add(ResourceLoader.loadImage(GameConstants.WINDOW_ICON_PATH));
	}


	public static void show (final Upgradable upgradable, final Upgrader upgrader)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(UpgradeDialogDelegate.class.getResource(UPGRADE_DIALOG_VIEW_FXML));
			final Parent root = fxmlLoader.load();

			final UpgradeDialogDelegate controller = fxmlLoader.getController();
			controller.setUpgradable(upgradable, upgrader);
			controller.show(new Scene(root));
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, UPGRADE_DIALOG_FAIL, upgradable.toString());
		}
	}


	@FXML
	void onUpgradeButtonAction (final ActionEvent ignored)
	{
		if (this.upgrader.checkIsUpgradable(this.upgradable))
		{
			this.upgrader.upgrade(this.upgradable);
		}
		this.stage.close();
	}


	@FXML
	void onCancelButtonAction (final ActionEvent ignored)
	{
		this.stage.close();
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.stage = new Stage();
		initializeUpgradeDialogStage(this.stage);
	}


	public void show (final Scene scene)
	{
		this.stage.setScene(scene);
		this.stage.showAndWait();
	}


	private void setUpgradable (final Upgradable<Level> upgradable, final Upgrader<Upgradable<Level>, Level> upgrader)
	{
		this.upgradable = upgradable;
		this.upgrader = upgrader;
		this.upgradeButton.setDisable(!upgrader.checkIsUpgradable(upgradable));
		this.setLevelChangeLabels(upgradable);
		this.setUpgradeCostLabels(upgradable);
	}


	private void setUpgradeCostLabels (final Upgradable<Level> upgradable)
	{
		final CurrencyTransaction upgradeCosts = upgradable.getUpgradeCosts();
		this.steelCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.STEEL)));
		this.compositeCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.COMPOSITE)));
		this.scienceCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.SCIENCE)));
		this.foodRationCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.FOOD_RATION)));
		this.energyCreditCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.ENERGY_CREDIT)));
	}


	private void setLevelChangeLabels (final Upgradable<Level> upgradable)
	{
		this.beforeUpgradeLabel.setText(upgradable.getLevel().toString());
		this.afterUpgradeLabel.setText(upgradable.getLevel().getNextHigherLevel().toString());
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.upgradable, this.upgrader, UPGRADE_DIALOG_VIEW_FXML);
	}

}
