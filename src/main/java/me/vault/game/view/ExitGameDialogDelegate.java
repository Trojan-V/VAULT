package me.vault.game.view;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.VaultApplication;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class ExitGameDialogDelegate implements Initializable
{
	private static final Stage STAGE = new Stage();

	private static final String WINDOW_TITLE = "Exit Game?";

	private static final String FXML_FILENAME = "gameExitDialog.fxml";

	private static final String ICON_PATH = ASSETS_PATH + "Item_Pack/armor_icon.png";

	private static final String TO_STRING_PATTERN = "ExitGameDialogDelegate[dialogPane={0}]";

	@FXML
	private DialogPane exitGameDialogPane;


	public static void show ()
	{
		STAGE.setScene(ResourceLoader.loadScene(MainMenuDelegate.class, FXML_FILENAME));
		STAGE.showAndWait();
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.setButtonActions();
		STAGE.setResizable(false);
		STAGE.setTitle(WINDOW_TITLE);
		STAGE.initModality(Modality.APPLICATION_MODAL);
		STAGE.getIcons().add(ResourceLoader.loadImage(ICON_PATH));
	}


	private void setButtonActions ()
	{
		// Closes the different stages of the program if the user presses YES
		this.exitGameDialogPane.lookupButton(ButtonType.YES).setOnMouseClicked(event -> {
			STAGE.close();
			VaultApplication.getStage().close();
			Platform.exit();
		});

		// Closes the dialog if the user presses NO
		this.exitGameDialogPane.lookupButton(ButtonType.NO).setOnMouseClicked(event -> {
			STAGE.close();
		});
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.exitGameDialogPane);
	}

}
