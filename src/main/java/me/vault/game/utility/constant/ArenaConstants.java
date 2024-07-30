package me.vault.game.utility.constant;


import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.troop.impl.Lieutenant;
import me.vault.game.model.troop.impl.Ranger;
import me.vault.game.model.troop.impl.Recruit;
import me.vault.game.model.troop.impl.Sniper;
import me.vault.game.utility.loading.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

import static me.vault.game.utility.constant.ConstantInterface.Constant;


@ConstantInterface
public interface ArenaConstants
{

	@Constant
	String ARENA_FXML = "arena.fxml";


	@Constant
	int MULTIPLIER = 11;


	@Constant
	int OFFSET = 10;


	@Constant
	double TIMELINE_SPACING = 5.0;

	@Constant
	String ARENA_ONE_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_1.txt";

	@Constant
	String ARENA_TWO_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_2.txt";

	@Constant
	String ARENA_THREE_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_3.txt";

	@Constant
	String ARENA_FOUR_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_4.txt";

	@Constant
	ArrayList<Figure> ARENA_ONE_ENEMIES = new ArrayList<>()
	{{
		this.add(new Figure(Sniper.getInstance()));
		this.add(new Figure(Sniper.getInstance()));
		this.add(new Figure(Sniper.getInstance()));
	}};

	@Constant
	ArrayList<Figure> ARENA_TWO_ENEMIES = new ArrayList<>()
	{{
		this.add(new Figure(Ranger.getInstance()));
		this.add(new Figure(Ranger.getInstance()));
		this.add(new Figure(Ranger.getInstance()));
	}};

	@Constant
	ArrayList<Figure> ARENA_THREE_ENEMIES = new ArrayList<>()
	{{
		this.add(new Figure(Lieutenant.getInstance()));
		this.add(new Figure(Lieutenant.getInstance()));
		this.add(new Figure(Lieutenant.getInstance()));
	}};

	@Constant
	ArrayList<Figure> ARENA_FOUR_ENEMIES = new ArrayList<>()
	{{
		this.add(new Figure(Recruit.getInstance()));
		this.add(new Figure(Recruit.getInstance()));
		this.add(new Figure(Recruit.getInstance()));
		this.add(new Figure(Recruit.getInstance()));
	}};

	@Constant
	Arena ARENA_ONE = new Arena(List.of(), ARENA_ONE_ENEMIES, new GameBoard(ResourceLoader.createTileArrayFromFile(ARENA_ONE_FILEPATH)));

	@Constant
	Arena ARENA_TWO = new Arena(List.of(), ARENA_TWO_ENEMIES, new GameBoard(ResourceLoader.createTileArrayFromFile(ARENA_TWO_FILEPATH)));

	@Constant
	Arena ARENA_THREE = new Arena(List.of(), ARENA_THREE_ENEMIES, new GameBoard(ResourceLoader.createTileArrayFromFile(ARENA_THREE_FILEPATH)));

	@Constant
	Arena ARENA_FOUR = new Arena(List.of(), ARENA_FOUR_ENEMIES, new GameBoard(ResourceLoader.createTileArrayFromFile(ARENA_FOUR_FILEPATH)));

}
