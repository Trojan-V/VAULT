module me.vault.game {
	requires javafx.controls;
	requires javafx.fxml;

	opens me.vault.game to javafx.fxml;
	opens me.vault.game.utility.loading to javafx.fxml;
	opens me.vault.game.artifact to javafx.fxml;
	opens me.vault.game.city to javafx.fxml;
	opens me.vault.game.city.building to javafx.fxml;

	exports me.vault.game;
	exports me.vault.game.artifact;
	exports me.vault.game.interfaces;
	exports me.vault.game.city;
	exports me.vault.game.city.building;
	exports me.vault.game.currency;
	exports me.vault.game.troop.troop;
	exports me.vault.game.utility.struct;
	exports me.vault.game.exception;
	exports me.vault.game.player;
	exports me.vault.game.troop.unit;
	exports me.vault.game.utility.constant;
	exports me.vault.game.utility.jvm;
	exports me.vault.game.utility.logging;
	exports me.vault.game.utility.loading;

	opens me.vault.game.currency to javafx.fxml;
}