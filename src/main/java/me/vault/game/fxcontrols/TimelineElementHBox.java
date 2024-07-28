package me.vault.game.fxcontrols;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import me.vault.game.control.FigureController;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.troop.Troop;

import static me.vault.game.utility.constant.ArenaConstants.*;


public final class TimelineElementHBox extends HBox
{

	public TimelineElementHBox (final Arena arena, final Figure<? extends Troop> troopFigure)
	{
		final VBox statistics = new VBox();
		statistics.setPrefSize(VBOX_WIDTH, VBOX_HEIGHT);
		statistics.getChildren().add(new Label(NAME + troopFigure.getName()));
		statistics.getChildren().add(new Label(HEALTH + troopFigure.getStatistics().getDefensiveStatistic().getHealthPoints()));
		statistics.getChildren().add(new Label(ARMOR + troopFigure.getStatistics().getDefensiveStatistic().getArmor()));
		statistics.setSpacing(TIMELINE_SPACING);

		final ImageView sprite = new ImageView(troopFigure.getSprite());
		sprite.setFitWidth(SPRITE_WIDTH - IMAGE_OFFSET);
		sprite.setFitHeight(SPRITE_HEIGHT - IMAGE_OFFSET);
		FigureController.setTroopFigureGlow(arena, sprite, troopFigure);

		this.getChildren().add(sprite);
		this.getChildren().add(statistics);
		this.setSpacing(H_BOX_OFFSET);
	}

}
