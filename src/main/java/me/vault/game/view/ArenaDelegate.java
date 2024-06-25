package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import me.vault.game.VaultApplication;
import me.vault.game.control.TroopController;
import me.vault.game.fxcontrols.GameBoardButton;
import me.vault.game.interfaces.Placable;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Placeholder;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.UPGRADE_DIALOG_FAIL;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public class ArenaDelegate implements Initializable
{

	private static final Logger LOGGER = new Logger(ArenaDelegate.class.getSimpleName());


	private static final String ENCOUNTER_FXML = "arena.fxml";


	private static final int NUMBER_OF_ROWS = 12;


	private static final int NUMBER_OF_COLUMNS = 12;


	private static final int TILE_SIDE_LENGTH = 35;


	private static final String NAME = "Name: ";


	private static final String HEALTH = "Health: ";


	private static final String ARMOR = "Armor: ";


	private static final double TIMELINE_SPACING = 5.0;


	private static final double STATISTICS_SPACING = TIMELINE_SPACING;


	private static final int DROP_SHADOW_RADIUS = 15;


	private static final int IMAGE_OFFSET = 10;


	private static final int H_BOX_OFFSET = 10;


	private static final double DROP_SHADOW_SPREAD = 0.5;


	private Arena arena;


	private static final int SPRITE_WIDTH = 70;


	private static final float SPRITE_HEIGHT = 70;


	private static final int VBOX_WIDTH = 200;


	private static final int VBOX_HEIGHT = 72;


	private int round = 1;


	@FXML
	private GridPane gameBoardGridPane;


	@FXML
	private Label roundNumber;


	@FXML
	private VBox timelineVBox;


	private PriorityQueue<Troop> troopTimeline;


	public static void show (final Arena arena)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(ArenaDelegate.class.getResource(ENCOUNTER_FXML));
			final Parent root = fxmlLoader.load();

			final ArenaDelegate delegate = fxmlLoader.getController();
			delegate.setArena(arena);
			delegate.show(new Scene(root));
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, UPGRADE_DIALOG_FAIL, arena.toString());
		}
	}


	private void setArena (final Arena arena)
	{
		this.arena = arena;
		this.troopTimeline = arena.getTimeline().getSortedTimeline();
		this.initializeTimeline(this.timelineVBox);
		this.initializeGameBoard(this.gameBoardGridPane);
	}


	public void show (final Scene scene)
	{
		ViewUtil.show(VaultApplication.getStage(), scene, ArenaDelegate.class);
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{

	}


	@FXML
	private void initializeGameBoard (final GridPane gameBoard)
	{
		for (int i = 0; i < NUMBER_OF_ROWS; i++)
		{
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
			{
				final GameBoardButton button = new GameBoardButton(this.arena, this.arena.getGameBoard().getTile(i, j).getCurrentElement());

				final int row = i;
				final int column = j;
				button.setOnMouseClicked(_ -> {
					this.handleMapObjectInteraction(row, column, this.arena);
				});
				gameBoard.add(button, i, j);
			}
		}
	}


	private void setTroopGlow (final Arena arena, final ImageView imageView, final Placable placable)
	{
		if (placable instanceof Troop)
		{
			if (arena.getPlayerOneTroops().contains(placable))
			{
				final DropShadow playerIdentity = new DropShadow(DROP_SHADOW_RADIUS, Color.BLUE);
				playerIdentity.setSpread(DROP_SHADOW_SPREAD);
				imageView.setEffect(playerIdentity);
			}
			else if (arena.getPlayerTwoTroops().contains(placable))
			{
				final DropShadow playerIdentity = new DropShadow(DROP_SHADOW_RADIUS, Color.RED);
				playerIdentity.setSpread(DROP_SHADOW_SPREAD);
				imageView.setEffect(playerIdentity);
			}
		}
	}


	private ImageView createGameBoardButtonImageView (final MetaDataImage sprite)
	{
		final ImageView imageView = new ImageView();
		imageView.setFitHeight(TILE_SIDE_LENGTH);
		imageView.setFitWidth(TILE_SIDE_LENGTH);
		imageView.setPreserveRatio(false);
		imageView.setImage(sprite);

		return imageView;
	}


	private void handleMapObjectInteraction (final int row, final int column, final Arena arena)
	{
		final Troop attacker = arena.getSelectedTroop(); // TODO: Position für row und column anlegen
		final Placable nextTileElement = arena.getGameBoard().getTile(row, column).getCurrentElement();

		switch (nextTileElement)
		{
			case final Placeholder _ -> TroopController.getInstance().move(arena, attacker, row, column);
			case final Troop troop ->
			{
				try
				{
					final Troop defender = this.arena.getGameBoard().getTroop(row, column);
					TroopController.getInstance().attack(arena, attacker, defender);
				}
				catch (final Exception ignored)
				{
					return;
				} // TODO: KAPSELUNG!!!!!!!!!!!!!
			}
			case null, default -> {return;}
		}
		this.updateTimeline(this.timelineVBox);
		this.gameBoardGridPane.getChildren().clear();
		this.initializeGameBoard(this.gameBoardGridPane);
	}


	public void initializeTimeline (final VBox timeline)
	{
		this.arena.setSelectedTroop(this.troopTimeline.peek());
		final PriorityQueue<Troop> displayQueue = new PriorityQueue<Troop>(this.troopTimeline);
		while (!displayQueue.isEmpty())
		{
			this.timelineVBox.getChildren().add(this.createTimelineElement(Objects.requireNonNull(displayQueue.poll())));
		}
		timeline.setSpacing(TIMELINE_SPACING);
	}


	public void updateTimeline (final VBox timeline)
	{
		this.troopTimeline.poll();
		if (this.troopTimeline.isEmpty())
		{
			this.troopTimeline = new PriorityQueue<>(this.arena.getTimeline().getSortedTimeline());
			this.incrementRound();
		}
		timeline.getChildren().clear();
		this.initializeTimeline(timeline);
	}


	@FXML
	private void incrementRound ()
	{
		this.round++;
		this.roundNumber.setText(String.valueOf(this.round));
	}


	@FXML
	private HBox createTimelineElement (final Troop troop)
	{
		final HBox container = new HBox();
		final VBox statistics = new VBox();

		statistics.setPrefSize(VBOX_WIDTH, VBOX_HEIGHT);
		final ImageView sprite = new ImageView(troop.getSprite());

		sprite.setFitWidth(SPRITE_WIDTH - IMAGE_OFFSET);
		sprite.setFitHeight(SPRITE_HEIGHT - IMAGE_OFFSET);


		this.setTroopGlow(this.arena, sprite, troop);

		statistics.getChildren().add(new Label(NAME + troop.getName()));
		statistics.getChildren().add(new Label(HEALTH + troop.getStatistic().getDefensiveStatistic().getHealthPoints()));
		statistics.getChildren().add(new Label(ARMOR + troop.getStatistic().getDefensiveStatistic().getArmour()));
		statistics.setSpacing(STATISTICS_SPACING);

		container.getChildren().add(sprite);
		container.getChildren().add(statistics);

		container.setSpacing(H_BOX_OFFSET);

		return container;
	}

}
