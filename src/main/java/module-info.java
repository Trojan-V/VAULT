module me.vault.vaultgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.vault.vaultgame to javafx.fxml;
    exports me.vault.vaultgame;
}