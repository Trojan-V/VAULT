package me.vault.game.fxcontrols;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import me.vault.game.control.FigureController;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;


/**
 *
 */
public final class TimelineElementHBox extends HBox
{

	private static final ILogger LOGGER = new Logger(TimelineElementHBox.class.getSimpleName());

	private static final String NAME = "Name: ";

	private static final String HEALTH = "Health: ";

	private static final String ARMOR = "Armor: ";

	private static final int VERTICAL_SPACING = 5;

	private static final int VBOX_WIDTH = 200;

	private static final int VBOX_HEIGHT = 200;

	private static final int SPRITE_WIDTH = 70;

	private static final int SPRITE_HEIGHT = 70;

	private static final int IMAGE_OFFSET = 10;

	private static final int H_BOX_OFFSET = 10;


	public TimelineElementHBox (final Arena arena, final Figure<? extends Troop> troopFigure)
	{
		final VBox statistics = new VBox();
		statistics.setPrefSize(VBOX_WIDTH, VBOX_HEIGHT);
		statistics.getChildren().add(new Label(NAME + troopFigure.getName()));
		statistics.getChildren().add(new Label(HEALTH + troopFigure.getStatistics().getDefensive().getHealth()));
		statistics.getChildren().add(new Label(ARMOR + troopFigure.getStatistics().getDefensive().getArmor()));
		statistics.setSpacing(VERTICAL_SPACING);

		final ImageView sprite = new ImageView(troopFigure.getSprite());
		sprite.setFitWidth(SPRITE_WIDTH - IMAGE_OFFSET);
		sprite.setFitHeight(SPRITE_HEIGHT - IMAGE_OFFSET);
		FigureController.setTroopFigureGlow(arena, sprite, troopFigure);

		this.getChildren().add(sprite);
		this.getChildren().add(statistics);
		this.setSpacing(H_BOX_OFFSET);
	}
}
