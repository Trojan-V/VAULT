package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import me.vault.game.VaultApplication;
import me.vault.game.model.encounter.Encounter;
import me.vault.game.model.mission.TileButton;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.logging.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.PriorityQueue;
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


	private static final String NAME = "Name: ";


	private static final String HEALTH = "Health: ";


	private static final String ARMOR = "Armor: ";


	private static final double TIMELINE_SPACING = 5.0;


	private static final double STATISTICS_SPACING = TIMELINE_SPACING;


	private static final int SPRITE_WIDTH = 70;


	private static final float SPRITE_HEIGHT = 70;


	private static final int VBOX_WIDTH = 200;


	private static final int VBOX_HEIGHT = 72;


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
		this.initializeGameBoard(this.gameBoard);
		this.initializeTimeline(this.timeline, this.encounter.getTimeline());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.gameBoard.setGridLinesVisible(true);

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
				button.setMaxSize(TILE_SIDE_LENGTH, TILE_SIDE_LENGTH);
				button.setContentDisplay(ContentDisplay.CENTER);
				button.setAlignment(Pos.CENTER);

				tileMap.add(button, i, j);
			}
		}
	}


	public void initializeTimeline (final VBox timline, final PriorityQueue<Troop> timelineElements)
	{
		while (!timelineElements.isEmpty())
		{
			this.timeline.getChildren().add(this.createTimelineElement(timelineElements.poll()));
		}
		this.timeline.setSpacing(TIMELINE_SPACING);
	}


	@FXML
	private HBox createTimelineElement (final Troop troop)
	{
		final HBox container = new HBox();
		final VBox statistics = new VBox();

		statistics.setPrefSize(VBOX_WIDTH, VBOX_HEIGHT);
		final ImageView sprite = new ImageView(troop.getSprite());
		sprite.setFitWidth(SPRITE_WIDTH);
		sprite.setFitHeight(SPRITE_HEIGHT);
		statistics.getChildren().add(new Label(NAME + troop.getName()));
		statistics.getChildren()
			.add(new Label(HEALTH + troop.getStatistic().getDefensiveStatistic().getHealthPoints()));
		statistics.getChildren().add(new Label(ARMOR + troop.getStatistic().getDefensiveStatistic().getArmour()));
		statistics.setSpacing(STATISTICS_SPACING);

		container.getChildren().add(sprite);
		container.getChildren().add(statistics);

		return container;
	}

}
