package me.vault.game.utility.fx;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import me.vault.game.control.FigureController;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.utility.interfaces.Placeable;
import org.jetbrains.annotations.Nullable;


/**
 * The {@code GameBoardButton} represents one clickable button in the game board. It extends the standard {@link Button} and automatically
 * initializes the right graphic and design based on the {@link Arena} and {@link Placeable} object which are parsed
 * into the constructor.
 * The {@code GameBoardButton} is mainly used in the arena and the encounters and allows the player to click and move or click and attack the
 * different troops on the field.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Button
 * @see Arena
 * @see Placeable
 * @since 25.06.2024
 */
public final class GameBoardButton extends Button
{

	/**
	 * The side length of each game board button.
	 */
	private static final int BUTTON_LENGTH = 35;


	/**
	 * Constructs a new instance of this class with the passed parameters.
	 *
	 * @param arena     The arena object this button is related to.
	 * @param placeable The Placeable that fills the button on the grid.
	 *
	 * @precondition The constructor gets called and both parameters are != null.
	 * @postcondition A new instance of this class was created.
	 */
	public GameBoardButton (final Arena arena, final Placeable placeable)
	{
		this.designAppearance();
		this.designImageView(arena, placeable);
	}


	/**
	 * Constructs a new instance of this class with the passed parameters.
	 *
	 * @param placeable The Placeable that fills the button on the grid.
	 *
	 * @precondition The constructor gets called and the parameter is != null.
	 * @postcondition A new instance of this class was created.
	 */
	public GameBoardButton (final Placeable placeable)
	{
		this.designAppearance();
		this.designImageView(null, placeable);
	}


	/**
	 * Designs the appearance of this class by setting its properties.
	 *
	 * @precondition The instance of this class is != null and inherits from {@link Button}.
	 * @postcondition The appearance of the instance of this class was designed.
	 */
	private void designAppearance ()
	{
		this.setTextFill(Color.TRANSPARENT);
		this.setBackground(Background.fill(Color.TRANSPARENT));
		this.setPrefSize(BUTTON_LENGTH, BUTTON_LENGTH);
		this.setMaxSize(BUTTON_LENGTH, BUTTON_LENGTH);
		this.setContentDisplay(ContentDisplay.CENTER);
		this.setAlignment(Pos.CENTER);
	}


	/**
	 * Designs an {@link ImageView} that contains the sprite of the Placeable passed into the method.
	 * Sets the glow of the button if an Arena object was passed != null.
	 *
	 * @param arena     An arena object, used to decide what glow to apply to the placeable.
	 * @param placeable The placeable object whose sprite will be displayed.
	 *
	 * @precondition A Placeable object is passed and != null. The instance of this class is != null.
	 * @postcondition The image view of this class was designed, and a glow was applied if an arena object was passed.
	 */
	private void designImageView (@Nullable final Arena arena, final Placeable placeable)
	{
		final ImageView imageView = new ImageView();
		imageView.setFitHeight(BUTTON_LENGTH);
		imageView.setFitWidth(BUTTON_LENGTH);
		imageView.setPreserveRatio(false);
		imageView.setImage(placeable.getSprite());

		// the glow of the placeable is set if the related arena has been passed into the method.
		if (arena != null && placeable instanceof final Figure figure)
		{
			FigureController.setGlow(arena, imageView, figure);
		}
		this.setGraphic(imageView);
	}

}
