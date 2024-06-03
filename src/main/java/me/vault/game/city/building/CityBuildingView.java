package me.vault.game.city.building;

import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;

/**
 * }
 */
public final class CityBuildingView
{
	private static final ILogger LOGGER = new Logger(CityBuildingView.class.getSimpleName());


	private CityBuildingView () {}


	public static void showCityBuilding (final Stage stage, CityBuilding cityBuilding)
	{
		// Loading the FXML-File and creating a scene from the loaded components
		final Scene scene = cityBuilding.getCurrentProperties().getScene();


		// New scene is set as main-scene of the passed stage
		stage.setScene(scene);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, cityBuilding.name()));
	}


	public static void showWorkshop (final Stage stage)
	{

		// Loading the FXML-File and creating a scene from the loaded components
		final Scene scene = CityBuilding.WORKSHOP.getCurrentProperties().getScene();


		// New scene is set as main-scene of the passed stage
		stage.setScene(scene);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, CityBuilding.WORKSHOP.name()));
	}

}



