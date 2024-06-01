package me.vault.game.view;


import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.model.citybuilding.CityBuilding;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.constant.LoggingConstants.CityBuildingView.SHOWING_BUILDING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 *
 */
public final class CityBuildingView
{
	private static final ILogger LOGGER = new Logger(CityBuildingView.class.getSimpleName());


	private CityBuildingView () {}


	public static void showWorkshopView (final Stage stage)
	{
		// Loading the FXML-File and creating a scene from the loaded components
		final Scene scene = CityBuilding.WORKSHOP.getCurrentProperties().getScene();

		// New scene is set as main-scene of the passed stage
		stage.setScene(scene);
		stage.show();
		LOGGER.log(DEBUG, SHOWING_BUILDING_VIEW_MSG);
	}
}



