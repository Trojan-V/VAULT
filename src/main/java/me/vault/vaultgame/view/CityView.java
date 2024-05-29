package me.vault.vaultgame.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static me.vault.vaultgame.utility.constant.GameConstants.WINDOW_TITLE;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public class CityView
{
	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the
	 * properties (color etc.) of the GUI elements.
	 */
	private static final String STYLESHEET_FILENAME = "cityview.fxml";



	public static void showCityView (final Stage stage) throws IOException
	{
		// TODO: Set scene to main stage scene
		final Parent root = FXMLLoader.load(Objects.requireNonNull(CityView.class.getResource(STYLESHEET_FILENAME)));
		final Scene scene = new Scene(root);
		stage.setTitle(WINDOW_TITLE);
		stage.setScene(scene);
		stage.show();
	}
}
