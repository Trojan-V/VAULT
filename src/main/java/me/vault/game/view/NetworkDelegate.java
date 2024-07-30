package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.model.network.NetworkController;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

// TODO: Almost complete JavaDoc needed

/**
 *
 */
public final class NetworkDelegate implements Initializable
{

	private static final Stage STAGE = new Stage();


	/**
	 * {@link String} used as the window title
	 */
	private static final String WINDOW_TITLE = "Arena Connection";


	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String FXML_FILENAME = "network_connection_dialog.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link NetworkDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "NetworkDelegate[dialogPane={0}]";


	static
	{
		STAGE.setResizable(false);
		STAGE.setTitle(WINDOW_TITLE);
		STAGE.initModality(Modality.APPLICATION_MODAL);
		STAGE.getIcons().add(ResourceLoader.loadImage(GameConstants.WINDOW_ICON_PATH));
	}



	@FXML
	private DialogPane dialogPane;


	@FXML
	private Label serverHost;


	@FXML
	private Label serverPort;


	@FXML
	private TextField clientHost;


	@FXML
	private TextField clientPort;


	@FXML
	private TabPane serverClientTabPane;


	private String host = null;


	private int port = 0;


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

	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.serverHost.setText(NetworkController.HOST_NAME);
		this.serverPort.setText(String.valueOf(NetworkController.PORT_NUMBER));
		this.setButtonActions();
	}


	private void setButtonActions ()
	{
		this.dialogPane.lookupButton(ButtonType.YES).setOnMouseClicked(event ->
		{
			this.connect(STAGE, this.serverClientTabPane);
		});

		this.dialogPane.lookupButton(ButtonType.NO).setOnMouseClicked(event ->
		{
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
			// ArenaDelegate.show(GameConstants.ARENA);
			stage.close();
		}
	}

	/**
	 * Builds a formatted {@link String} which represents the object, and it's current state using the
	 * {@link NetworkDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link NetworkDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link NetworkDelegate#TO_STRING_PATTERN} is {@code != null} and both of the instance variables are set.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.dialogPane);
	}

}
