package me.vault.game.view.mission;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.fxcontrols.SelectedAlliesGridPane;
import me.vault.game.model.mission.Mission;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.impl.*;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public class TroopSelectionDialogDelegate implements Initializable
{

	private static final Stage STAGE = GameApplication.getStage();

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(TroopSelectionDialogDelegate.class.getSimpleName());

	private static final String FXML_FILENAME = "troop_selection_view.fxml";


	@FXML
	private TitledPane corporationTitledPane;

	@FXML
	private TitledPane explorerTitledPane;

	@FXML
	private AnchorPane mainPane;

	@FXML
	private TitledPane militaryTitledPane;

	@FXML
	private AnchorPane selectorPane;

	@FXML
	private TitledPane terraTitledPane;

	@FXML
	private Accordion troopAccordion;

	private SelectedAlliesGridPane selectedAlliesGridPane;

	private Mission mission = null;


	public static void show (final Mission mission)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(TroopSelectionDialogDelegate.class.getResource(FXML_FILENAME));
			final Parent root = fxmlLoader.load();

			final TroopSelectionDialogDelegate controller = fxmlLoader.getController();
			controller.setMission(mission);
			controller.enableSelectedFactionPane();
			controller.show(new Scene(root));
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, "Display of TroopSelectionDialogDelegate failed!");
		}
	}


	public void show (final Scene scene)
	{
		STAGE.setScene(scene);
		STAGE.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, TroopSelectionDialogDelegate.class.getSimpleName()));
	}


	private void enableSelectedFactionPane ()
	{
		for (final TitledPane titledPane : this.troopAccordion.getPanes())
		{
			titledPane.setDisable(true);
		}
		switch (Player.getInstance().getSelectedFaction())
		{
			case Faction.NEW_TERRA -> this.terraTitledPane.setDisable(false);
			case Faction.EXPLORER_ASSOCIATION -> this.explorerTitledPane.setDisable(false);
			case Faction.MILITARISTIC_GOVERNMENT -> this.militaryTitledPane.setDisable(false);
			case Faction.MEGA_CORPORATION -> this.corporationTitledPane.setDisable(false);
		}
	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		MissionSelectionDelegate.show(GameApplication.getStage());
	}


	@FXML
	void onStartMission (final ActionEvent ignored)
	{

	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.selectedAlliesGridPane = new SelectedAlliesGridPane();
		this.selectorPane.getChildren().add(this.selectedAlliesGridPane);
	}


	@FXML
	void selectEngineer (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Engineer.getAllyInstance());
	}


	@FXML
	void selectGrenadier (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Grenadier.getAllyInstance());
	}


	@FXML
	void selectGuard (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Guard.getAllyInstance());
	}


	@FXML
	void selectInfantry (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Infantry.getAllyInstance());
	}


	@FXML
	void selectLieutenant (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Lieutenant.getAllyInstance());
	}


	@FXML
	void selectMedic (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Medic.getAllyInstance());
	}


	@FXML
	void selectOfficer (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Officer.getAllyInstance());
	}


	@FXML
	void selectPrecisionShooter (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(PrecisionShooter.getAllyInstance());
	}


	@FXML
	void selectRanger (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Ranger.getAllyInstance());
	}


	@FXML
	void selectRecruit (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Recruit.getAllyInstance());
	}


	@FXML
	void selectSniper (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(Sniper.getAllyInstance());
	}


	@FXML
	void selectSpaceMarine (final ActionEvent ignored)
	{
		this.selectedAlliesGridPane.addTroop(SpaceMarine.getAllyInstance());
	}


	public Mission getMission ()
	{
		return this.mission;
	}


	public void setMission (final Mission mission)
	{
		this.mission = mission;
	}

}
