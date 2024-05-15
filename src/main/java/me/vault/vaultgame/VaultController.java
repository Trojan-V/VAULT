package me.vault.vaultgame;


import javafx.fxml.FXML;
import javafx.scene.control.Label;


/**
 * The controller class is responsible for reacting to events which are automatically dispatched by the JavaFX
 * framework. The controller can respond to these events by using callback methods for different events, for instance
 * {@link VaultController#onHelloButtonClick()}.
 * <br>
 * The registration of the controller automatically happens within the {@code main.fxml} file. The
 * {@link VaultApplication} loads this {@code .fxml} file and therefore the link between the application adn the
 * corresponding controller is created.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see javafx.fxml.FXMLLoader
 * @see VaultApplication
 * @since 24.04.2024
 */
public class VaultController
{
	@FXML
	private Label welcomeText;


	/**
	 * Callback method which is invoked as soon as the "hello button" gets clicked.
	 */
	@FXML
	protected void onHelloButtonClick ()
	{
		welcomeText.setText("Hello, I am sending this from the 'onHelloButtonClick' method!");
	}
}