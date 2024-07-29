package me.vault.game.view.mission;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.fxcontrols.RewardGridPane;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.ViewUtil;
import me.vault.game.view.city.CityDelegate;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.MissionConstants.MissionFour.MISSION_FOUR;
import static me.vault.game.utility.constant.MissionConstants.MissionFour.MISSION_FOUR_REWARDS;
import static me.vault.game.utility.constant.MissionConstants.MissionOne.MISSION_ONE;
import static me.vault.game.utility.constant.MissionConstants.MissionOne.MISSION_ONE_REWARDS;
import static me.vault.game.utility.constant.MissionConstants.MissionThree.MISSION_THREE;
import static me.vault.game.utility.constant.MissionConstants.MissionThree.MISSION_THREE_REWARDS;
import static me.vault.game.utility.constant.MissionConstants.MissionTwo.MISSION_TWO;
import static me.vault.game.utility.constant.MissionConstants.MissionTwo.MISSION_TWO_REWARDS;


public class MissionSelectionDelegate implements Initializable
{

	@NotNull
	private static final Scene SCENE = Objects.requireNonNull(ResourceLoader.loadScene(MissionSelectionDelegate.class, "mission_view.fxml"));

	private static final Logger LOGGER = new Logger(MissionSelectionDelegate.class.getSimpleName());

	private static final String TO_STRING_PATTERN = "MissionSelectionDelegate'{'mainPane={0}, missionFourRewardPane={1}, missionOneRewardPane={2}, " +
	                                                "missionThreeRewardPane={3}, missionTwoRewardPane={4}, selectMissionFourButton={5}, " +
	                                                "selectMissionOneButton={6}, selectMissionThreeButton={7}, selectMissionTwoButton={8}'}'";

	@FXML
	private AnchorPane mainPane;

	@FXML
	private AnchorPane missionFourRewardPane;

	@FXML
	private AnchorPane missionOneRewardPane;

	@FXML
	private AnchorPane missionThreeRewardPane;

	@FXML
	private AnchorPane missionTwoRewardPane;

	@FXML
	private Button selectMissionFourButton;

	@FXML
	private Button selectMissionOneButton;

	@FXML
	private Button selectMissionThreeButton;

	@FXML
	private Button selectMissionTwoButton;


	/**
	 * Displays the {@link Scene} of the fxml-view of the current delegate on the main {@link Stage} of the application.
	 *
	 * @precondition The {@link MissionSelectionDelegate#SCENE} is != null and the method is called.
	 * @postcondition The main {@link Stage} displays the content of the current delegate.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), SCENE, MissionSelectionDelegate.class);
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
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.missionOneRewardPane.getChildren().add(new RewardGridPane(MISSION_ONE_REWARDS));
		this.missionTwoRewardPane.getChildren().add(new RewardGridPane(MISSION_TWO_REWARDS));
		this.missionThreeRewardPane.getChildren().add(new RewardGridPane(MISSION_THREE_REWARDS));
		this.missionFourRewardPane.getChildren().add(new RewardGridPane(MISSION_FOUR_REWARDS));
	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show(GameApplication.getStage());
	}


	@FXML
	void onSelectMissionOne (final ActionEvent ignored)
	{
		TroopSelectionDialogDelegate.show(MISSION_ONE);
	}


	@FXML
	void onSelectMissionTwo (final ActionEvent ignored)
	{
		TroopSelectionDialogDelegate.show(MISSION_TWO);
	}


	@FXML
	void onSelectMissionThree (final ActionEvent ignored)
	{
		TroopSelectionDialogDelegate.show(MISSION_THREE);
	}


	@FXML
	void onSelectMissionFour (final ActionEvent ignored)
	{
		TroopSelectionDialogDelegate.show(MISSION_FOUR);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link MissionSelectionDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link MissionSelectionDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link MissionSelectionDelegate#TO_STRING_PATTERN} is {@code != null} and both of the instance variables are set.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.mainPane, this.missionFourRewardPane, this.missionOneRewardPane,
			this.missionThreeRewardPane, this.missionTwoRewardPane, this.selectMissionFourButton, this.selectMissionOneButton,
			this.selectMissionThreeButton, this.selectMissionTwoButton);
	}

}
