package me.vault.game.view;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.VaultApplication;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class ExitGameDialogueDelegate implements Initializable
{


	private static final String ICON_PATH = ASSETS_PATH + "Item_Pack/armor_icon.png";


	@FXML
	private DialogPane exitGameDialogPane;


	private static final String WINDOW_TITLE = "Exit Game?";


	private static final Stage exitGameStage = new Stage();


	private static final String GAME_EXIT_DIALOGUE_FXML = "gameExitDialog.fxml";


	private static final Scene GAME_EXIT_DIALOGUE_SCENE = ResourceLoader.loadScene(MainMenuDelegate.class, GAME_EXIT_DIALOGUE_FXML);


	public static void show ()
	{
		exitGameStage.setScene(GAME_EXIT_DIALOGUE_SCENE);
		exitGameStage.showAndWait();
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		exitGameStage.getIcons().add(ResourceLoader.loadImage(ICON_PATH));
		exitGameStage.setTitle(WINDOW_TITLE);
		exitGameStage.setResizable(false);
		exitGameStage.initModality(Modality.APPLICATION_MODAL);
		this.setButtonActions();
	}


	private void setButtonActions ()
	{
		// Closes the different stages of the program if the user presses YES
		this.exitGameDialogPane.lookupButton(ButtonType.YES).setOnMouseClicked(_ ->
		{
			exitGameStage.close();
			VaultApplication.getStage().close();
			Platform.exit();
		});

		// Closes the dialog if the user presses NO
		this.exitGameDialogPane.lookupButton(ButtonType.NO).setOnMouseClicked(_ ->
		{
			exitGameStage.close();
		});
	}
}
