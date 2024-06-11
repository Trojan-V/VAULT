package me.vault.game.view.city.buildings;

import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.model.building.AbsCityBuilding;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;

public final class CityBuildingView
{
	private static final ILogger LOGGER = new Logger(CityBuildingView.class.getSimpleName());


	private CityBuildingView ()
	{}


	public static void showCityBuilding (final Stage stage, final AbsCityBuilding cityBuilding)
	{
		// Loading the FXML-File and creating a scene from the loaded components
		final Scene scene = cityBuilding.getScene();
		stage.setScene(scene);
		stage.show();

		// Logging th display of the building
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, cityBuilding.getName()));
	}

}



