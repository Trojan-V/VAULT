package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import me.vault.game.VaultApplication;
import me.vault.game.model.encounter.Encounter;
import me.vault.game.model.mission.MapObject;
import me.vault.game.model.mission.TileButton;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.UPGRADE_DIALOG_FAIL;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public class EncounterDelegate implements Initializable
{

	private static final Logger LOGGER = new Logger(EncounterDelegate.class.getSimpleName());

	private static final String ENCOUNTER_FXML = "encounter.fxml";

	private static final int NUMBER_OF_ROWS = 12;

	private static final int NUMBER_OF_COLUMNS = 12;

	private static final int TILE_SIDE_LENGTH = 35;

	private Encounter encounter = null;

	@FXML
	private GridPane gameBoard;

	@FXML
	private Label roundNumber;

	@FXML
	private VBox timeline;


	public void show (final Scene scene)
	{
		ViewUtil.show(VaultApplication.getStage(), scene, EncounterDelegate.class);
	}


	public static void show (final Encounter encounter)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(EncounterDelegate.class.getResource(ENCOUNTER_FXML));
			final Parent root = fxmlLoader.load();

			final EncounterDelegate delegate = fxmlLoader.getController();
			delegate.setEncounter(encounter);
			delegate.show(new Scene(root));
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, UPGRADE_DIALOG_FAIL, encounter.toString());
		}
	}


	private void setEncounter (final Encounter encounter)
	{
		this.encounter = encounter;
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initializeGameBoard(this.gameBoard); // TODO: FIX
		this.gameBoard.setGridLinesVisible(false);

	}


	@FXML
	private void initializeGameBoard (final GridPane tileMap)
	{
		for (int i = 0; i < NUMBER_OF_ROWS; i++)
		{
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
			{
				final TileButton button = new TileButton(this.encounter.getMap().getMapArray()[i][j]);

				button.setTextFill(Color.TRANSPARENT);
				button.setBackground(Background.fill(Color.TRANSPARENT));
				button.setPrefSize(TILE_SIDE_LENGTH, TILE_SIDE_LENGTH);

				tileMap.add(button, i, j);
			}
		}
	}


	public void initializeTimeline ()
	{

	}

}
