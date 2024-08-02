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
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.interfaces.Level;
import me.vault.game.utility.interfaces.Upgradable;
import me.vault.game.utility.interfaces.Upgrader;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.UPGRADE_DIALOG_FAIL_PATTERN;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


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
	private static final String UPGRADE_DIALOG_VIEW_FXML = "upgrade_dialog.fxml";


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
	 * The {@link Label} that shows the number of composites needed for the upgrade.
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
	 * The {@link Label} that shows the number of sciences needed for the upgrade.
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
	 * The {@link Upgrader} instance passed into the object
	 */
	private Upgrader<Upgradable<Level>, Level> upgrader = null;


	/**
	 * The {@link Upgrader} instance passed into the object
	 */
	private Upgradable<Level> upgradable = null;


	/**
	 * Displays the a {@link DialogPane} based on the {@link Upgradable} instance on a new {@link Stage}.
	 *
	 * @param upgradable The {@link Upgradable} object, which describes the upgradable object.
	 * @param upgrader   The {@link Upgrader} object, which describes the upgrader of the upgradable object.
	 *
	 * @precondition A {@link Upgradable} object and the {@link Upgrader} is passed into the method.
	 * @postcondition The {@link DialogPane} is displayed on a new {@link Stage}.
	 */
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
			LOGGER.logf(WARNING, UPGRADE_DIALOG_FAIL_PATTERN, upgradable.toString());
		}
	}


	/**
	 * Initializes the stage of the dialog.
	 *
	 * @param stage The stage the dialog is supposed to be initialized on.
	 *
	 * @precondition A valid stage is passed into the method.
	 * @postcondition The passed stage was successfully modified.
	 */
	private static void initializeUpgradeDialogStage (final Stage stage)
	{
		stage.setResizable(false);
		stage.setTitle(WINDOW_TITLE);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.getIcons().add(ResourceLoader.loadImage(GameConstants.WINDOW_ICON_PATH));
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Upgrade" {@link Button} in the GUI.
	 * Starts the upgrade process for the upgradable object within the delegate.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The upgrade process was started with the upgradable object.
	 */
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
	 * Handles the {@code Click}-{@link ActionEvent} of the "Back" {@link Button} in the GUI.
	 * Closes the dialog and returns to the main stage.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The dialog was closed and the main stage is accessible.
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
	 * Displays the a {@link DialogPane} based on the {@link Scene} instance on a new {@link Stage}.
	 *
	 * @param scene The scene that is displayed on the stage.
	 *
	 * @precondition A {@link Scene} object and is passed into the method.
	 * @postcondition The {@link Scene} is displayed on a new {@link Stage}.
	 */
	public void show (final Scene scene)
	{
		this.stage.setScene(scene);
		this.stage.showAndWait();
	}


	/**
	 * Sets the upgradable attributes in the instance of to the passed {@link Upgradable} and Upgrader objects.
	 *
	 * @param upgradable The new {@link Upgradable} object, meant to replace the current attribute in the instance.
	 * @param upgrader   The new {@link Upgrader} object, meant to replace the current attribute in the instance.
	 *
	 * @precondition A {@link NotNull} {@link Upgrader} and Upgradable object is passed into the method.
	 * @postcondition The replaced the old attributes with the passed ones.
	 */
	private void setUpgradable (final Upgradable<Level> upgradable, final Upgrader<Upgradable<Level>, Level> upgrader)
	{
		this.upgradable = upgradable;
		this.upgrader = upgrader;
		this.upgradeButton.setDisable(!upgrader.checkIsUpgradable(upgradable));
		this.setLevelChangeLabels(upgradable);
		this.setUpgradeCostLabels(upgradable);
	}


	/**
	 * Sets the labels of the dialog pane to the respective values of the passed upgradable object.
	 *
	 * @param upgradable The new {@link Upgradable} object, whose values are used.
	 *
	 * @precondition A {@link Upgradable} object, whose values are used is passed into the method.
	 * @postcondition The labels are set to the values of the passed object.
	 */
	private void setUpgradeCostLabels (final Upgradable<Level> upgradable)
	{
		final CurrencyTransaction upgradeCosts = upgradable.getUpgradeCosts();
		this.steelCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.STEEL)));
		this.compositeCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.COMPOSITE)));
		this.scienceCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.SCIENCE)));
		this.foodRationCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.FOOD_RATION)));
		this.energyCreditCostLabel.setText(String.valueOf(upgradeCosts.getAbsoluteAmount(Currency.ENERGY_CREDIT)));
	}


	/**
	 * Sets the labels of the dialog pane change area to the respective values of the passed upgradable object.
	 *
	 * @param upgradable The new {@link Upgradable} object, whose values are used.
	 *
	 * @precondition A {@link Upgradable} object, whose values are used is passed into the method.
	 * @postcondition The labels are set to the values of the passed object.
	 */
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
