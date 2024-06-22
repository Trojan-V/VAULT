package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import me.vault.game.VaultApplication;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;


public class EncounterDelegate implements Initializable
{

	private static final int NUMBER_OF_ROWS = 12;


	private static final int NUMBER_OF_COLUMNS = 12;


	private static final String ENCOUNTER_FXML = "encounter.fxml";


	private static final Scene SCENE = ResourceLoader.loadScene(MainMenuDelegate.class, ENCOUNTER_FXML);


	private static final int TILE_SIDE_LENGTH = 35;


	@FXML
	private GridPane gameBoard;


	@FXML
	private Label roundNumber;


	@FXML
	private VBox timeline;


	public static void show ()
	{
		ViewUtil.show(VaultApplication.getStage(), SCENE, EncounterDelegate.class);
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initializeGameBoard(this.gameBoard);
		this.gameBoard.setGridLinesVisible(false);

	}


	@FXML
	private void initializeGameBoard (final GridPane tileMap)
	{
		for (int i = 0; i < NUMBER_OF_ROWS; i++)
		{
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
			{
				final Button button = new Button();
				button.setTextFill(Color.TRANSPARENT);
				button.setBackground(Background.fill(Color.TRANSPARENT));
				button.setPrefSize(TILE_SIDE_LENGTH, TILE_SIDE_LENGTH);
				ViewUtil.setButtonImage(button, GameConstants.ASSETS_PATH + StringConstants.TILE_IMAGE_NAME);
				tileMap.add(button, i, j);
			}
		}
	}


	public void initializeTimeline ()
	{

	}

}
