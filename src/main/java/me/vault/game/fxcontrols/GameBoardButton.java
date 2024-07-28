package me.vault.game.fxcontrols;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import me.vault.game.control.FigureController;
import me.vault.game.interfaces.Displayable;
import me.vault.game.interfaces.Placable;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;


/**
 * The {@code GameBoardButton} represents one clickable button in the game board. It extends the standard {@link Button} and automatically
 * initializes the right graphic and design based on the {@link Arena} and {@link Placable} object which are parsed into the constructor.
 * The {@code GameBoardButton} is mainly used in the arena and the encounters and allows the player to click and move or click and attack the
 * different troops on the field.
 *
 * @author Lasse-Leander Hillen
 * @see Button
 * @see Arena
 * @see Placable
 * @since 25.06.2024
 */
public final class GameBoardButton extends Button
{

	private static final ILogger LOGGER = new Logger(GameBoardButton.class.getSimpleName());

	private static final int TILE_SIDE_LENGTH = 35;


	public GameBoardButton (final Arena arena, final Displayable displayable)
	{
		this.designButtonAppearance();
		this.designButtonImageViewAppearance(arena, displayable);
	}


	private void designButtonImageViewAppearance (final Arena arena, final Displayable displayable)
	{
		final ImageView imageView = new ImageView();
		imageView.setFitHeight(TILE_SIDE_LENGTH);
		imageView.setFitWidth(TILE_SIDE_LENGTH);
		imageView.setPreserveRatio(false);
		imageView.setImage(displayable.getSprite());
		if (displayable instanceof final Figure<? extends Troop> troopFigure)
		{
			FigureController.setTroopFigureGlow(arena, imageView, troopFigure);
		}
		this.setGraphic(imageView);
	}


	private void designButtonAppearance ()
	{
		this.setTextFill(Color.TRANSPARENT);
		this.setBackground(Background.fill(Color.TRANSPARENT));
		this.setPrefSize(TILE_SIDE_LENGTH, TILE_SIDE_LENGTH);
		this.setMaxSize(TILE_SIDE_LENGTH, TILE_SIDE_LENGTH);
		this.setContentDisplay(ContentDisplay.CENTER);
		this.setAlignment(Pos.CENTER);
	}

}
