module me.vault.vaultgame {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.logging;


	opens me.vault.vaultgame to javafx.fxml;
    exports me.vault.vaultgame;
}