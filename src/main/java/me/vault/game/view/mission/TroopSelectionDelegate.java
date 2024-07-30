package me.vault.game.view.mission;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CurrencyDelegate;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.mission.Mission;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.impl.*;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.fx.SelectedAlliesGridPane;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.DISPLAY_FAILED_PATTERN;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * The {@link TroopSelectionDelegate} is responsible for the control (Controller) and display (View) of the troop-selection section in the GUI.
 * It provides methods to select different {@link Troop}s for an upcoming mission by providing an interactive GUI on the main {@link Stage}.
 * The delegate is also responsible for starting the correct {@link Mission} after the selection is complete.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see Mission
 * @see MissionDelegate
 * @see MissionSelectionDelegate
 * @see me.vault.game.utility.constant.MissionConstants
 * @see me.vault.game.utility.constant.LoggingConstants.MissionDelegate
 * @since 29.07.2024
 */
public final class TroopSelectionDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(TroopSelectionDelegate.class.getSimpleName());

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link TroopSelectionDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "TroopSelectionDelegate'{'fxml={0}, mission={1}'}'";

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String TROOP_SELECTION_VIEW_FXML = "troop_selection_view.fxml";

	/**
	 * The {@link AnchorPane} at the start of the scene tree. Every other control builds on top of it.
	 */
	@FXML
	private AnchorPane mainPane;

	/**
	 * The {@link AnchorPane} which contains the {@link SelectedAlliesGridPane} with all the already selected {@link Troop}s.
	 */
	@FXML
	private AnchorPane selectedTroopsPane;

	/**
	 * The {@link Accordion} which contains the {@link TitledPane}s of all the different possible {@link Faction}s.
	 */
	@FXML
	private Accordion troopAccordion;

	/**
	 * The {@link TitledPane} which contains the {@link Troop}s of the {@link Faction#MEGA_CORPORATION}.
	 */
	@FXML
	private TitledPane corporationTitledPane;

	/**
	 * The {@link TitledPane} which contains the {@link Troop}s of the {@link Faction#EXPLORER_ASSOCIATION}.
	 */
	@FXML
	private TitledPane explorerTitledPane;

	/**
	 * The {@link TitledPane} which contains the {@link Troop}s of the {@link Faction#MILITARISTIC_GOVERNMENT}.
	 */
	@FXML
	private TitledPane militaryTitledPane;

	/**
	 * The {@link TitledPane} which contains the {@link Troop}s of the {@link Faction#NEW_TERRA}.
	 */
	@FXML
	private TitledPane terraTitledPane;


	/**
	 * The {@link SelectedAlliesGridPane}, which contains the already selected {@link Troop}s.
	 */
	private SelectedAlliesGridPane selectedAlliesGridPane = null;

	/**
	 * The {@link Mission} object, which is handled by the controller, it determines which mission to start after the user has selected his troops.
	 * Gets injected into the controller, when the {@link TroopSelectionDelegate#show(Mission)} method gets called.
	 */
	private Mission mission = null;


	/**
	 * Displays the {@link Scene} of the  on the main {@link Stage} of the application.
	 *
	 * @param mission The {@link Mission} object, which is meant to be displayed on the main {@link Stage} after the
	 *                troop selection is finished.
	 *
	 * @precondition A {@link NotNull} {@link Mission} object is passed into the method.
	 * @postcondition The main {@link Stage} displays the {@link Scene} of the on the main {@link Stage}.
	 */
	public static void show (final Mission mission)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(TroopSelectionDelegate.class.getResource(TROOP_SELECTION_VIEW_FXML));
			final Parent root = fxmlLoader.load();

			final TroopSelectionDelegate troopSelectionDelegate = fxmlLoader.getController();
			troopSelectionDelegate.setMission(mission);
			troopSelectionDelegate.enableSelectedFactionPane();
			ViewUtil.show(GameApplication.getStage(), new Scene(root), TroopSelectionDelegate.class);
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, DISPLAY_FAILED_PATTERN, TroopSelectionDelegate.class.getSimpleName());
		}
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
		this.mainPane.getChildren().add(CurrencyDelegate.getCurrencyBannerScene().getRoot());
		this.selectedAlliesGridPane = new SelectedAlliesGridPane();
		this.selectedTroopsPane.getChildren().add(this.selectedAlliesGridPane);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link TroopSelectionDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link TroopSelectionDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link TroopSelectionDelegate#TO_STRING_PATTERN} is {@code != null} and {@link TroopSelectionDelegate#mission} is set.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, TROOP_SELECTION_VIEW_FXML, this.mission);
	}


	/**
	 * Gets the {@link TroopSelectionDelegate#mission} attribute of the instance of .
	 *
	 * @return The {@link TroopSelectionDelegate#mission} attribute as a {@link Mission} object.
	 *
	 * @precondition The {@link TroopSelectionDelegate#mission} attribute has already been set in the .
	 * @postcondition The method returned the {@link Mission} attribute.
	 */
	public Mission getMission ()
	{
		return this.mission;
	}


	/**
	 * Sets the {@link TroopSelectionDelegate#mission} attribute in the instance of to the passed {@link Mission} object.
	 *
	 * @param mission The new {@link Mission} object, meant to replace the current attribute in the instance.
	 *
	 * @precondition A {@link NotNull} {@link Mission} object is passed into the method.
	 * @postcondition The replaced the old {@link TroopSelectionDelegate#mission} attribute with the passed one.
	 */
	public void setMission (final Mission mission)
	{
		this.mission = mission;
	}


	/**
	 * Disables all the different {@link TitledPane}s used to show each different {@link Faction} and then only activates the {@link TitledPane}
	 * of the selected {@link Faction} of the {@link Player}.
	 *
	 * @precondition The fxml-components of the instance are != null.
	 * @postcondition The {@link TitledPane} of the selected {@link Faction} can be used, while all others are turned off.
	 */
	private void enableSelectedFactionPane ()
	{
		for (final TitledPane titledPane : this.troopAccordion.getPanes())
		{
			titledPane.setDisable(true);
		}
		switch (Player.getInstance().getSelectedFaction())
		{
			case NEW_TERRA -> this.terraTitledPane.setDisable(false);
			case EXPLORER_ASSOCIATION -> this.explorerTitledPane.setDisable(false);
			case MILITARISTIC_GOVERNMENT -> this.militaryTitledPane.setDisable(false);
			case MEGA_CORPORATION -> this.corporationTitledPane.setDisable(false);
		}
	}


	/**
	 * Adds a {@link Troop} to the {@link TroopSelectionDelegate#selectedAlliesGridPane} and to the selected troops of the {@link Player}.
	 *
	 * @param troop The {@link Troop} object, which is meant to be added to the selected troops.
	 *
	 * @precondition A {@link NotNull} {@link Troop} is passed into the method.
	 * @postcondition The {@link Troop} was added to the {@link TroopSelectionDelegate#selectedAlliesGridPane} and to the selected troops of the {@link Player}.
	 */
	private void selectTroop (final @NotNull Troop troop)
	{
		this.selectedAlliesGridPane.addTroop(troop);
		Player.getInstance().addSelectedFigures(new Figure(troop));
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Back" {@link Button} in the GUI.
	 * Resets the current {@link Scene} on the main {@link Stage} to the {@link Scene} of the {@link MissionSelectionDelegate}.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link MissionSelectionDelegate}.
	 */
	@FXML
	void onBackToMissionSelectionView (final ActionEvent ignored)
	{
		MissionSelectionDelegate.show();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Continue" {@link Button} in the GUI.
	 * Uses the {@link MissionDelegate} to set the {@link Scene} of the main {@link Stage} to the {@link Scene} of the contained
	 * {@link TroopSelectionDelegate#mission} attribute.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link TroopSelectionDelegate#mission} attribute.
	 */
	@FXML
	void onStartMission (final ActionEvent ignored)
	{
		MissionDelegate.show(this.mission);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Engineer} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Engineer} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectEngineer (final ActionEvent ignored)
	{
		this.selectTroop(Engineer.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Grenadier} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Grenadier} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectGrenadier (final ActionEvent ignored)
	{
		this.selectTroop(Grenadier.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Guard} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Guard} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectGuard (final ActionEvent ignored)
	{
		this.selectTroop(Guard.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Infantry} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Infantry} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectInfantry (final ActionEvent ignored)
	{
		this.selectTroop(Infantry.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Lieutenant} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Lieutenant} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectLieutenant (final ActionEvent ignored)
	{
		this.selectTroop(Lieutenant.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Medic} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Medic} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectMedic (final ActionEvent ignored)
	{
		this.selectTroop(Medic.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Officer} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Officer} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectOfficer (final ActionEvent ignored)
	{
		this.selectTroop(Officer.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link PrecisionShooter} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link PrecisionShooter} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectPrecisionShooter (final ActionEvent ignored)
	{
		this.selectTroop(PrecisionShooter.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Ranger} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Ranger} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectRanger (final ActionEvent ignored)
	{
		this.selectTroop(Ranger.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Recruit} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Recruit} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectRecruit (final ActionEvent ignored)
	{
		this.selectTroop(Recruit.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link Sniper} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Sniper} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectSniper (final ActionEvent ignored)
	{
		this.selectTroop(Sniper.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Engineer" {@link Button} in the GUI.
	 * Adds the {@link SpaceMarine} to the selected troops of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link SpaceMarine} is added to the selected troops of the player and is visible in the {@link TroopSelectionDelegate#selectedAlliesGridPane}.
	 */
	@FXML
	void selectSpaceMarine (final ActionEvent ignored)
	{
		this.selectTroop(SpaceMarine.getInstance());
	}

}
