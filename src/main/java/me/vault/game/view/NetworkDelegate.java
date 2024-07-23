package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.network.NetworkController;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.EncounterConstants.ALLIES;
import static me.vault.game.utility.constant.EncounterConstants.ENCOUNTER_ONE_ENEMIES;
import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class NetworkDelegate implements Initializable
{

	private static final Stage STAGE = new Stage();

	private static final String WINDOW_TITLE = "Arena Connection";

	private static final String FXML_FILENAME = "network_connection_dialog.fxml";

	private static final String ICON_PATH = ASSETS_PATH + "button.png";

	private static final String TO_STRING_PATTERN = "ExitGameDialogDelegate[dialogPane={0}]";

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

	private String host = null;

	private int port = 0;

	static
	{
		STAGE.setResizable(false);
		STAGE.setTitle(WINDOW_TITLE);
		STAGE.initModality(Modality.APPLICATION_MODAL);
		STAGE.getIcons().add(ResourceLoader.loadImage(ICON_PATH));
	}

	public static void show ()
	{

		STAGE.setScene(ResourceLoader.loadScene(MainMenuDelegate.class, FXML_FILENAME));
		STAGE.showAndWait();
	}


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
		catch (final NumberFormatException e)
		{
			System.out.println(e);
		}

	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.serverHost.setText(NetworkController.HOST_NAME);
		this.serverPort.setText(String.valueOf(NetworkController.PORT_NUMBER));
		this.setButtonActions();
	}


	private void setButtonActions ()
	{
		this.dialogPane.lookupButton(ButtonType.YES).setOnMouseClicked(event -> {
			this.connect(STAGE, this.serverClientTabPane);
		});

		this.dialogPane.lookupButton(ButtonType.NO).setOnMouseClicked(event -> {
			STAGE.close();
		});
	}


	private void connect (final Stage stage, final TabPane tabPane)
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
			ArenaDelegate.show(GameConstants.ARENA);
			stage.close();
		}
	}

}
