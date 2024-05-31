package me.vault.game.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.utility.logging.Logger;

import java.io.IOException;
import java.util.Objects;


/**
 *
 */
public final class CityBuildingView
{
	private static final Logger LOGGER = new Logger(CityBuildingView.class.getSimpleName());


	private CityBuildingView () {}


	static final String STYLESHEET_URL = "workshop_view.fxml";


	public static void showWorkshopView (final Stage stage) throws IOException
	{
		// Loading the FXML-File and creating a scene from the loaded components
		final Parent root = FXMLLoader.load(Objects.requireNonNull(CityView.class.getResource(STYLESHEET_URL)));
		final Scene scene = new Scene(root);

		// New scene is set as main-scene of the passed stage
		stage.setScene(scene);
		stage.show();
	}
}



