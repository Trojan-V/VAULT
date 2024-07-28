package me.vault.game.utility.constant;


import static me.vault.game.utility.constant.ConstantInterface.Constant;


@ConstantInterface
public interface ArenaConstants
{

	@Constant
	String ARENA = "arena";

	@Constant
	String NAME = "Name: ";

	@Constant
	String HEALTH = "Health: ";

	@Constant
	String ARMOR = "Armor: ";

	@Constant
	String ENCOUNTER_FXML = "arena.fxml";

	@Constant
	String ARENA_FXML = "arena.fxml";

	@Constant
	int MULTIPLIER = 11;

	@Constant
	int OFFSET = 10;

	@Constant
	double TIMELINE_SPACING = 5.0;

	@Constant
	double STATISTICS_SPACING = TIMELINE_SPACING;

	@Constant
	int DROP_SHADOW_RADIUS = 15;

	@Constant
	int IMAGE_OFFSET = 10;

	@Constant
	int H_BOX_OFFSET = 10;

	@Constant
	double DROP_SHADOW_SPREAD = 0.5;

	@Constant
	int SPRITE_WIDTH = 70;

	@Constant
	float SPRITE_HEIGHT = 70;

	@Constant
	int VBOX_WIDTH = 200;

	@Constant
	int VBOX_HEIGHT = 72;

	@Constant
	int ARENA_ROW_COUNT = 12;

	@Constant
	int ARENA_COLUMN_COUNT = 12;

}
