package me.vault.game.fxcontrols;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import me.vault.game.interfaces.Placable;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.troop.Troop;


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

	private static final int TILE_SIDE_LENGTH = 35;

	private static final int DROP_SHADOW_RADIUS = 15;

	private static final double DROP_SHADOW_SPREAD = 0.5;


	public GameBoardButton (final Arena arena, final Placable placable)
	{
		this.designButtonAppearance();

		this.designButtonImageViewAppearance(arena, placable);
	}


	private void designButtonImageViewAppearance (final Arena arena, final Placable placable)
	{
		final ImageView imageView = new ImageView();
		imageView.setFitHeight(TILE_SIDE_LENGTH);
		imageView.setFitWidth(TILE_SIDE_LENGTH);
		imageView.setPreserveRatio(false);
		imageView.setImage(placable.getSprite());
		this.setTroopGlow(arena, imageView, placable);
		this.setGraphic(imageView);
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
