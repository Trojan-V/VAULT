package me.vault.game.view;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.vault.game.GameApplication;


import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class NetworkDelegate implements Initializable
{
	@FXML
	private Label serverHost;

	@FXML
	private Label serverPort;

	@FXML
	private TextField clientHost;

	@FXML
	private TextField clientPort;

	@FXML
	private DialogPane dialogPane;

	private static final Stage STAGE = new Stage();

	private static final String WINDOW_TITLE = "Arena Connection";

	private static final String FXML_FILENAME = "network_connection_dialog.fxml";

	private static final String ICON_PATH = ASSETS_PATH + "button.png";

	private static final String TO_STRING_PATTERN = "ExitGameDialogDelegate[dialogPane={0}]";
	@Override
	public void initialize (URL url, ResourceBundle resourceBundle)
	{
		this.setButtonActions();
	}

	private void setButtonActions ()
	{
		// Closes the different stages of the program if the user presses YES
		this.dialogPane.lookupButton(ButtonType.YES).setOnMouseClicked(event -> {
			STAGE.close();
			GameApplication.getStage().close();
			Platform.exit();
		});

		// Closes the dialog if the user presses NO
		this.dialogPane.lookupButton(ButtonType.NO).setOnMouseClicked(event -> {
			STAGE.close();
		});
	}

}
