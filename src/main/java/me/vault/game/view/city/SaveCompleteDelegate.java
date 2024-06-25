package me.vault.game.view.city;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class SaveCompleteDelegate implements Initializable
{

	private static final Stage STAGE = new Stage();


	private static final String WINDOW_TITLE = "Save game complete!";


	private static final String FXML_FILENAME = "save_complete_dialog.fxml";


	private static final String ICON_PATH = ASSETS_PATH + "button.png";


	private static final String TO_STRING_PATTERN = "SaveCompleteDelegate[dialogPane={0}]";


	static
	{
		STAGE.setResizable(false);
		STAGE.setTitle(WINDOW_TITLE);
		STAGE.initModality(Modality.APPLICATION_MODAL);
		STAGE.getIcons().add(ResourceLoader.loadImage(ICON_PATH));
	}


	@FXML
	private DialogPane saveGameDialogPane;


	public static void show ()
	{
		STAGE.setScene(ResourceLoader.loadScene(SaveCompleteDelegate.class, FXML_FILENAME));
		STAGE.showAndWait();
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.setButtonActions();
	}


	private void setButtonActions ()
	{
		// Closes the different stages of the program if the user presses OK
		this.saveGameDialogPane.lookupButton(ButtonType.OK).setOnMouseClicked(_ -> {
			STAGE.close();
		});
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.saveGameDialogPane);
	}

}

