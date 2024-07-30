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
import me.vault.game.view.city.SaveCompleteDelegate;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Set;

import static me.vault.game.utility.constant.LoggingConstants.UPGRADE_DIALOG_FAIL;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;

// TODO: Anzeigen des dialog bearbeiten -> erst anzeigen und dann "upgrade" ausgrauen

//TODO: Java doc Lasse

/**
 * The {@link UpgradeDialogDelegate} is responsible for the control (Controller) and display (view) of the dialog
 * that appears when something should be upgraded.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see DialogPane
 * @see Label
 * @see Stage
 * @see Upgrader
 * @since 30.07.2024
 */
public final class UpgradeDialogDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(UpgradeDialogDelegate.class.getSimpleName());


	/**
	 * The {@link String} that is used as the window title.
	 */
	private static final String WINDOW_TITLE = "Upgrading...";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link UpgradeDialogDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "UpgradeDialogDelegate[upgradable={0}, upgrader={1}, fxml={2}]";

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String UPGRADE_DIALOG_VIEW_FXML = "upgradeDialog.fxml";


	/**
	 * The {@link Label} that shows the Level after the upgrade is completed.
	 */
	@FXML
	private Label afterUpgradeLabel;


	/**
	 * The {@link Label} that shows the current Level.
	 */
	@FXML
	private Label beforeUpgradeLabel;


	/**
	 * The {@link Label} that shows the amount of composites needed for the upgrade.
	 */
	@FXML
	private Label compositeCostLabel;


	/**
	 * The {@link Label} that shows the number of energy credits needed for the upgrade.
	 */
	@FXML
	private Label energyCreditCostLabel;


	/**
	 * The {@link Label} that shows the number of food rations needed for the upgrade.
	 */
	@FXML
	private Label foodRationCostLabel;


	/**
	 * The {@link Label} that shows the number of science needed for the upgrade.
	 */
	@FXML
	private Label scienceCostLabel;


	/**
	 * The {@link Label} that shows the amount of steel needed for the upgrade.
	 */
	@FXML
	private Label steelCostLabel;


	/**
	 * The {@link Button} that allows the player to upgrade.
	 */
	@FXML
	private Button upgradeButton;


	/**
	 * The {@link Stage} on which the upgrade dialog is shown.
	 */
	private Stage stage = null;


	/**
	 *
	 */
	private Upgrader<Upgradable<Level>, Level> upgrader = null;


	/**
	 *
	 */
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


	/**
	 *
	 * @param ignored the {@link ActionEvent} is not used but required for the method.
	 */
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


	/**
	 * Shows the
	 * @param scene
	 */
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

	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link UpgradeDialogDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link UpgradeDialogDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link UpgradeDialogDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.upgradable, this.upgrader, UPGRADE_DIALOG_VIEW_FXML);
	}
}
