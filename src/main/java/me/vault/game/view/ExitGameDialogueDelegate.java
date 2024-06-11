package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.utility.loading.ResourceLoader;

import java.io.IOException;


public class ExitGameDialogueDelegate
{
	@FXML
	private DialogPane exitGameDialogPane;

	private static final String GAME_EXIT_DIALOGUE_FXML = "gameExitDialog.fxml";
	private static final Scene GAME_EXIT_DIALOGUE_SCENE = ResourceLoader.loadScene(MainMenuDelegate.class,
		GAME_EXIT_DIALOGUE_FXML);


	public static void show ()
	{
		Stage exitGameStage = new Stage();
		exitGameStage.setScene(GAME_EXIT_DIALOGUE_SCENE);
		exitGameStage.initModality(Modality.APPLICATION_MODAL);
		exitGameStage.showAndWait();
	}

	private void buttonPress ()
	{

	}
}
