module me.vault.vaultgame {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.logging;


	opens me.vault.vaultgame to javafx.fxml;
	opens me.vault.vaultgame.view to javafx.fxml;
	opens me.vault.vaultgame.controller to javafx.fxml;

    exports me.vault.vaultgame;
	exports me.vault.vaultgame.view;
	exports me.vault.vaultgame.controller;
}