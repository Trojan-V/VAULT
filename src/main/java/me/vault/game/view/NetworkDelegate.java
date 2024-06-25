package me.vault.game.view;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.network.NetworkController;
import me.vault.game.utility.loading.ResourceLoader;


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

	@FXML
	private TabPane serverClientTabPane;

	private static final Stage STAGE = new Stage();

	private static final String WINDOW_TITLE = "Arena Connection";

	private static final String FXML_FILENAME = "network_connection_dialog.fxml";

	private static final String ICON_PATH = ASSETS_PATH + "button.png";

	private static final String TO_STRING_PATTERN = "ExitGameDialogDelegate[dialogPane={0}]";

	private String host = null;
	private int port = 0;


	@FXML
	void hostInputChanged (final KeyEvent ignored)
	{
		this.host = this.clientHost.getCharacters().toString();
	}

	@FXML
	void portInputChanged (final KeyEvent ignored)
	{
		try
		{
			this.port = Integer.parseInt(this.clientPort.getCharacters().toString());
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
		}

	}

	public static void show ()
	{

		STAGE.setScene(ResourceLoader.loadScene(MainMenuDelegate.class, FXML_FILENAME));
		STAGE.showAndWait();
	}
	@Override
	public void initialize (URL url, ResourceBundle resourceBundle)
	{
		this.serverHost.setText(NetworkController.HOST_NAME);
		this.serverPort.setText(String.valueOf(NetworkController.PORT_NUMBER));
		this.setButtonActions();
	}



	private void setButtonActions ()
	{
		this.dialogPane.lookupButton(ButtonType.YES).setOnMouseClicked(event -> {
			connect(STAGE, this.serverClientTabPane);
		});

		this.dialogPane.lookupButton(ButtonType.NO).setOnMouseClicked(event -> {
			STAGE.close();
		});
	}

	private void connect (Stage stage, TabPane tabPane)
	{
		if (tabPane.getTabs().getFirst().isSelected())
		{
			NetworkController.runServer();
			stage.close();
		}
		else if (tabPane.getTabs().getLast().isSelected())
		{
			if (this.host == null || this.port == 0)
			{
				return;
			}
			NetworkController.runClient(this.host, this.port);
			stage.close();
		}
	}

}