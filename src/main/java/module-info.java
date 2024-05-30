module me.vault.game {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.logging;


	opens me.vault.game to javafx.fxml;
	opens me.vault.game.view to javafx.fxml;
	opens me.vault.game.controller to javafx.fxml;

	exports me.vault.game;
	exports me.vault.game.view;
	exports me.vault.game.model.interfaces;
	exports me.vault.game.model.artifact;
	exports me.vault.game.controller;
}