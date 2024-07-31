package me.vault.game.view.mission;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.model.Mission;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.fx.RewardGridPane;
import me.vault.game.utility.interfaces.constant.LoggingConstants;
import me.vault.game.utility.interfaces.constant.MissionConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.CurrencyDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.CLASS_INITIALIZED_PATTERN;
import static me.vault.game.utility.interfaces.constant.MissionConstants.MissionFour.MISSION_FOUR;
import static me.vault.game.utility.interfaces.constant.MissionConstants.MissionFour.MISSION_FOUR_REWARDS;
import static me.vault.game.utility.interfaces.constant.MissionConstants.MissionOne.MISSION_ONE;
import static me.vault.game.utility.interfaces.constant.MissionConstants.MissionOne.MISSION_ONE_REWARDS;
import static me.vault.game.utility.interfaces.constant.MissionConstants.MissionThree.MISSION_THREE;
import static me.vault.game.utility.interfaces.constant.MissionConstants.MissionThree.MISSION_THREE_REWARDS;
import static me.vault.game.utility.interfaces.constant.MissionConstants.MissionTwo.MISSION_TWO;
import static me.vault.game.utility.interfaces.constant.MissionConstants.MissionTwo.MISSION_TWO_REWARDS;


/**
 * The {@link MissionSelectionDelegate} is responsible for the control (Controller) and display (View) of the mission-selection section in the GUI.
 * It provides methods to select different {@link Mission}s and start them by providing a GUI for the user to interact with.
 * The delegate is also responsible to display the different rewards each {@link Mission} has.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see Mission
 * @see MissionDelegate
 * @see MissionConstants
 * @see LoggingConstants.MissionDelegate
 * @since 25.07.2024
 */
public final class MissionSelectionDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MissionSelectionDelegate.class.getSimpleName());


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link MissionSelectionDelegate#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "MissionSelectionDelegate'{'fxml={0}'}'";

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String MISSION_SELECTION_VIEW_FXML = "mission_view.fxml";


	/**
	 * The {@link AnchorPane} at the start of the scene tree. Every other control builds on top of it.
	 */
	@FXML
	private AnchorPane mainPane;

	/**
	 * The {@link AnchorPane} which contains the {@link RewardGridPane} for the first {@link Mission}.
	 */
	@FXML
	private AnchorPane missionOneRewardPane;

	/**
	 * The {@link AnchorPane} which contains the {@link RewardGridPane} for the second {@link Mission}.
	 */
	@FXML
	private AnchorPane missionTwoRewardPane;

	/**
	 * The {@link AnchorPane} which contains the {@link RewardGridPane} for the third {@link Mission}.
	 */
	@FXML
	private AnchorPane missionThreeRewardPane;

	/**
	 * The {@link AnchorPane} which contains the {@link RewardGridPane} for the fourth {@link Mission}.
	 */
	@FXML
	private AnchorPane missionFourRewardPane;

	/**
	 * The {@link Button} which starts the {@link TroopSelectionDelegate} for the first {@link Mission}.
	 */
	@FXML
	private Button selectMissionOneButton;

	/**
	 * The {@link Button} which starts the {@link TroopSelectionDelegate} for the second {@link Mission}.
	 */
	@FXML
	private Button selectMissionTwoButton;

	/**
	 * The {@link Button} which starts the {@link TroopSelectionDelegate} for the third {@link Mission}.
	 */
	@FXML
	private Button selectMissionThreeButton;

	/**
	 * The {@link Button} which starts the {@link TroopSelectionDelegate} for the fourth {@link Mission}.
	 */
	@FXML
	private Button selectMissionFourButton;


	/**
	 * Displays the {@link Scene} of the fxml-view of the current delegate on the main {@link Stage} of the application.
	 *
	 * @precondition The {@link MissionSelectionDelegate#MISSION_SELECTION_VIEW_FXML} is != null and the method is called.
	 * @postcondition The main {@link Stage} displays the content of the current delegate.
	 */
	public static void show ()
	{
		final Scene scene = Objects.requireNonNull(ResourceLoader.loadScene(MissionSelectionDelegate.class, MISSION_SELECTION_VIEW_FXML));
		ViewUtil.show(GameApplication.getStage(), scene, MissionSelectionDelegate.class);
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

		this.selectMissionOneButton.disableProperty().bind(MISSION_ONE.getIsCompletedProperty());
		this.selectMissionTwoButton.disableProperty().bind(MISSION_TWO.getIsCompletedProperty());
		this.selectMissionThreeButton.disableProperty().bind(MISSION_THREE.getIsCompletedProperty());
		this.selectMissionFourButton.disableProperty().bind(MISSION_FOUR.getIsCompletedProperty());

		this.missionOneRewardPane.getChildren().add(new RewardGridPane(MISSION_ONE_REWARDS));
		this.missionTwoRewardPane.getChildren().add(new RewardGridPane(MISSION_TWO_REWARDS));
		this.missionThreeRewardPane.getChildren().add(new RewardGridPane(MISSION_THREE_REWARDS));
		this.missionFourRewardPane.getChildren().add(new RewardGridPane(MISSION_FOUR_REWARDS));

		LOGGER.logf(ILogger.Level.DEBUG, CLASS_INITIALIZED_PATTERN, MissionSelectionDelegate.class.getSimpleName());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Back" {@link Button} in the GUI.
	 * Resets the current {@link Scene} on the main {@link Stage} to the {@link Scene} of the {@link CityDelegate}.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is reset to the {@link Scene} of the {@link CityDelegate}.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Mission One" {@link Button} in the GUI.
	 * Shows the scene of the {@link TroopSelectionDelegate} for the first mission on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link TroopSelectionDelegate}.
	 */
	@FXML
	void onSelectMissionOne (final ActionEvent ignored)
	{
		TroopSelectionDelegate.show(MISSION_ONE);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Mission Two" {@link Button} in the GUI.
	 * Shows the scene of the {@link TroopSelectionDelegate} for the second mission on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link TroopSelectionDelegate}.
	 */
	@FXML
	void onSelectMissionTwo (final ActionEvent ignored)
	{
		TroopSelectionDelegate.show(MISSION_TWO);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Mission Three" {@link Button} in the GUI.
	 * Shows the scene of the {@link TroopSelectionDelegate} for the third mission on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link TroopSelectionDelegate}.
	 */
	@FXML
	void onSelectMissionThree (final ActionEvent ignored)
	{
		TroopSelectionDelegate.show(MISSION_THREE);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Select Mission Four" {@link Button} in the GUI.
	 * Shows the scene of the {@link TroopSelectionDelegate} for the fourth mission on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link TroopSelectionDelegate}.
	 */
	@FXML
	void onSelectMissionFour (final ActionEvent ignored)
	{
		TroopSelectionDelegate.show(MISSION_FOUR);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link MissionSelectionDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link MissionSelectionDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link MissionSelectionDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, MISSION_SELECTION_VIEW_FXML);
	}

}
