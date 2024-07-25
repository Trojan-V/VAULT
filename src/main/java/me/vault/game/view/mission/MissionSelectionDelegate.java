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
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.constant.MissionConstants.MissionFour.MISSION_FOUR;
import static me.vault.game.utility.constant.MissionConstants.MissionFour.MISSION_FOUR_REWARDS;
import static me.vault.game.utility.constant.MissionConstants.MissionOne.MISSION_ONE;
import static me.vault.game.utility.constant.MissionConstants.MissionOne.MISSION_ONE_REWARDS;
import static me.vault.game.utility.constant.MissionConstants.MissionThree.MISSION_THREE;
import static me.vault.game.utility.constant.MissionConstants.MissionThree.MISSION_THREE_REWARDS;
import static me.vault.game.utility.constant.MissionConstants.MissionTwo.MISSION_TWO;
import static me.vault.game.utility.constant.MissionConstants.MissionTwo.MISSION_TWO_REWARDS;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class MissionSelectionDelegate implements Initializable
{

	private static final Scene SCENE = ResourceLoader.loadScene(MissionSelectionDelegate.class, "mission_view.fxml");

	private static final Logger LOGGER = new Logger(MissionSelectionDelegate.class.getSimpleName());

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


	public static void show (final Stage stage)
	{
		stage.setScene(SCENE);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, MissionSelectionDelegate.class.getSimpleName()));
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


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());

		this.addRewardGridsToMissionPanes();
	}


	private void addRewardGridsToMissionPanes ()
	{
		this.missionOneRewardPane.getChildren().add(new RewardGridPane(MISSION_ONE_REWARDS));
		this.missionTwoRewardPane.getChildren().add(new RewardGridPane(MISSION_TWO_REWARDS));
		this.missionThreeRewardPane.getChildren().add(new RewardGridPane(MISSION_THREE_REWARDS));
		this.missionFourRewardPane.getChildren().add(new RewardGridPane(MISSION_FOUR_REWARDS));

	}

}
