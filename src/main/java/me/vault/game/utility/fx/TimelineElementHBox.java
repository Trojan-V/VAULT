package me.vault.game.utility.fx;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import me.vault.game.control.FigureController;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Timeline;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.utility.interfaces.Placeable;
import org.jetbrains.annotations.NotNull;


/**
 * The {@code SelectedTroopImageView} represents element of the shown timeline in the arena.
 * It extends the standard {@link HBox} and automatically initializes the right graphic and design.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see HBox
 * @see Timeline
 * @see Placeable
 * @see Arena
 * @since 25.06.2024
 */
public final class TimelineElementHBox extends HBox
{

	/**
	 * The prefix of the name label of the {@link TimelineElementHBox}.
	 */
	private static final String NAME = "Name: ";

	/**
	 * The prefix of the health label of the {@link TimelineElementHBox}.
	 */
	private static final String HEALTH = "Health: ";

	/**
	 * The prefix of the armor label of the {@link TimelineElementHBox}.
	 */
	private static final String ARMOR = "Armor: ";

	/**
	 * The vertical spacing of the statistics {@link VBox}.
	 */
	private static final int VERTICAL_SPACING = 5;

	/**
	 * The width of the statistics {@link VBox}.
	 */
	private static final int VBOX_WIDTH = 200;

	/**
	 * The height of the statistics {@link VBox} .
	 */
	private static final int VBOX_HEIGHT = 200;

	/**
	 * The size/ side length of the sprite for the figure in the {@link TimelineElementHBox}.
	 */
	private static final int SPRITE_SIZE = 70;

	/**
	 * The offset of the sprite for the figure in the {@link TimelineElementHBox}.
	 */
	private static final int IMAGE_OFFSET = 10;

	/**
	 * The spacing of the {@link TimelineElementHBox}.
	 */
	private static final int SPACING = 10;


	/**
	 * Constructs a new instance of {@link TimelineElementHBox} with the passed parameters.
	 *
	 * @param arena       The arena, that is related to the {@link TimelineElementHBox}. Used to decide the glow and other properties.
	 * @param troopFigure The figure whose sprite is supposed to be shown in the {@link TimelineElementHBox}
	 *
	 * @precondition The constructor gets called and the parameters are != null.
	 * @postcondition A new instance of {@link TimelineElementHBox} was created.
	 */
	public TimelineElementHBox (final Arena arena, final Figure troopFigure)
	{
		final VBox statistics = createStatisticsVbox(troopFigure);
		final ImageView sprite = createFigureImageView(arena, troopFigure);
		this.getChildren().add(sprite);
		this.getChildren().add(statistics);
		this.setSpacing(SPACING);
	}


	/**
	 * Creates the {@link ImageView} for the sprite of the passed figure
	 *
	 * @param arena       The arena, that is related to the {@link TimelineElementHBox}. Used to decide the glow and other properties.
	 * @param troopFigure The figure whose sprite is supposed to be shown in the {@link ImageView}
	 *
	 * @return a {@link ImageView} that was filled and designed with the sprite of the {@link Figure}.
	 *
	 * @precondition An {@link Arena} and {@link Figure} != null are passed into the method.
	 * @postcondition An {@link ImageView} that represents the figure has been returned.
	 */
	@NotNull
	private static ImageView createFigureImageView (final Arena arena, final Figure troopFigure)
	{
		final ImageView sprite = new ImageView(troopFigure.getSprite());
		sprite.setFitWidth(SPRITE_SIZE - IMAGE_OFFSET);
		sprite.setFitHeight(SPRITE_SIZE - IMAGE_OFFSET);
		FigureController.setGlow(arena, sprite, troopFigure);
		return sprite;
	}


	/**
	 * Creates the {@link VBox} for the statistics of the passed figure
	 *
	 * @param troopFigure The figure whose statistics are supposed to be shown in the {@link VBox}
	 *
	 * @return a {@link VBox} that was filled and designed with the statistics of the {@link Figure}.
	 *
	 * @precondition A {@link Figure} != null is passed into the method.
	 * @postcondition An {@link VBox} that represents the figure statistics has been returned.
	 */
	@NotNull
	private static VBox createStatisticsVbox (final Figure troopFigure)
	{
		final VBox statistics = new VBox();
		statistics.setPrefSize(VBOX_WIDTH, VBOX_HEIGHT);
		statistics.getChildren().add(new Label(NAME + troopFigure.getName()));
		statistics.getChildren().add(new Label(HEALTH + troopFigure.getStatistics().getDefensive().getHealth()));
		statistics.getChildren().add(new Label(ARMOR + troopFigure.getStatistics().getDefensive().getArmor()));
		statistics.setSpacing(VERTICAL_SPACING);
		return statistics;
	}

}
