package me.vault.game.view.menu;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.control.PeerController;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.interfaces.constant.NetworkConstants;
import me.vault.game.utility.loading.ResourceLoader;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 *This class acts as the controller and view for the network connection dialog.
 * <br>
 * The class provides methods to display the diaog and for the player to interact with the network dialog.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 28.07.2024
 */
public final class NetworkDelegate implements Initializable
{

	/**
	 * The {@link Stage} on which the network connection dialog is shown.
	 */
	private static final Stage STAGE = new Stage();


	/**
	 * {@link String} used as the window title
	 */
	private static final String WINDOW_TITLE = "Arena Connection";


	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String FXML_FILENAME = "network_connection_dialog_peer.fxml";


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


	/**
	 * The {@link DialogPane} that contains all the GUI elements used in the dialog.
	 */
	@FXML
	private DialogPane dialogPane;


	/**
	 * The {@link Label} that displays the Hostname of this application to the user.
	 */
	@FXML
	private Label myPeerHostLabel;

	/**
	 * The {@link Label} that displays the Portnumber of this application to the user.
	 */
	@FXML
	private Label myPeerPortLabel;


	/**
	 * The {@link Label} that displays the error message to the user.
	 */
	@FXML
	private Label errorMessage;


	/**
	 * The {@link TextField} that allows the user to input the Hostname of the other application instance.
	 */
	@FXML
	private TextField foreignPeerHostNameTextField;


	/**
	 * The {@link TextField} that allows the user to input the Portnumber of the other application instance.
	 */
	@FXML
	private TextField foreignPeerPortNumberTextField;


	/**
	 * {@link CheckBox} that allows the player to specify if he is the host of the game.
	 */
	@FXML
	private CheckBox hostSelector;


	/**
	 * The {@link String} that represents the host name of this application.
	 */
	private String foreignPeerHostNameString;


	/**
	 * The integer that represents the port of this application socket.
	 */
	private int foreignPeerPortNumberInt = 0;


	/**
	 * Displays the content stored in {@link NetworkDelegate#FXML_FILENAME} on the {@link NetworkDelegate#STAGE}. The
	 * Stage then waits until it is closed before handing control back to the main Stage.
	 *
	 * @precondition The {@link NetworkDelegate#FXML_FILENAME} has to contain valid content.
	 * @postcondition The initialized view is shown on a new stage.
	 */
	public static void show ()
	{
		STAGE.setScene(ResourceLoader.loadScene(MainMenuDelegate.class, FXML_FILENAME));
		STAGE.showAndWait();
	}

	/**
	 * Is called by FXML, when the input of the TextField changes, and sets the input of the textfield as the value
	 * of {@link NetworkDelegate#foreignPeerHostNameString}.
	 *
	 * @precondition The TextField {@link NetworkDelegate#foreignPeerHostNameTextField} has to be included in the
	 * Scene on the stage.
	 * @postcondition The input from the TextField is set as the value for
	 * {@link NetworkDelegate#foreignPeerHostNameString} and the error message label is set to null.
	 */
	@FXML
	void hostInputChanged ()
	{
		this.foreignPeerHostNameString = this.foreignPeerHostNameTextField.getCharacters().toString();
		this.errorMessage.setText(null);
	}


	/**
	 * Is called by FXML, when the input of the TextField changes, and sets the input of the textfield as the value
	 * of {@link NetworkDelegate#foreignPeerPortNumberInt}.
	 *
	 * @precondition The TextField {@link NetworkDelegate#foreignPeerPortNumberTextField} has to be included in the
	 * Scene on the stage.
	 * @postcondition The input from the TextField is converted to an integer and set as the value for
	 * {@link NetworkDelegate#foreignPeerPortNumberInt}. If there is an exception an error message is displayed in
	 * the terminal. The error message label is set to null.
	 */
	@FXML
	void portInputChanged ()
	{
		try
		{
			this.foreignPeerPortNumberInt = Integer.parseInt(this.foreignPeerPortNumberTextField.getCharacters().toString());
			this.errorMessage.setText(null);
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
		this.myPeerHostLabel.setText(PeerController.getInstance().getPeer().getMyPeerHostName());
		this.myPeerPortLabel.setText(String.valueOf(PeerController.getInstance().getPeer().getMyPeerPortNumber()));
		this.setButtonActions();
	}


	/**
	 * Set the button presses from the gui. If the "yes"-button is pressed a method to establish a new connection
	 * is called. If the "no"-button is pressed the network connection dialog is closed.
	 *
	 * @precondition The scene must contain the {@link NetworkDelegate#dialogPane}.
	 * @postcondition Sets the logic that when the yes-button is pressed a method to create a new connection is
	 * called. If the no-button is pressed the network connection dialog is closed.
	 */
	@FXML
	private void setButtonActions ()
	{
		this.dialogPane.lookupButton(ButtonType.YES).setOnMouseClicked(_ -> this.connect(STAGE));

		this.dialogPane.lookupButton(ButtonType.NO).setOnMouseClicked(_ -> STAGE.close());
	}


	/**
	 * Tries th establish a new network connection. If the connection is successful, a
	 * {@link me.vault.game.model.network.Peer} instance is started on a new thread and the network
	 * connection dialog is closed. If there is an error, it is displayed to the user and no connection is created.
	 *
	 * @param stage The network connection dialog.
	 *
	 * @precondition The stage has to contain the network connection dialog.
	 * @postcondition If a connection could be established a {@Peer} instance is started on a new thread (see
	 * {@link PeerController#runPeer()}) and the network connection dialg is closed. If there was an error, an error
	 * message is displayed via the {@link NetworkDelegate#errorMessage} and the network connection dialog remains.
	 */
	private void connect (final Stage stage)
	{
		try
		{
			PeerController.getInstance().getPeer().setIsMyPeerHost(this.hostSelector.isSelected());
			PeerController.getInstance().createConnection(this.foreignPeerHostNameString, this.foreignPeerPortNumberInt);
			errorMessage.setText(null);
		}
		catch (IOException e)
		{
			errorMessage.setText(NetworkConstants.INVALID_CONNETCTION_ATTEMPT);
			return;
		}
		PeerController.getInstance().runPeer();
		stage.close();
	}


	/**
	 * Builds a formatted {@link String} which represents the object, and it's current state using the
	 * {@link NetworkDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link NetworkDelegate#TO_STRING_PATTERN}.
	 * @precondition The {@link NetworkDelegate#TO_STRING_PATTERN} is {@code != null} and both of the instance variables are set.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.dialogPane);
	}

}
