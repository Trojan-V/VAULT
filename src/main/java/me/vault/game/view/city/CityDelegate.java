package me.vault.game.view.city;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyDelegate;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.city.*;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.fx.CityBuildingAnchorPane;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.MainMenuDelegate;
import me.vault.game.view.TutorialDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * The {@code CityDelegate} handles the control and view of the city with its buildings.
 * <br>
 * It provides the user the possibility to choose and upgrade buildings and thereby is the starting
 * point of many game aspects.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see CityBuilding
 * @since 11.06.2024
 */
public class CityDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CityDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String CITY_VIEW_FXML = "city_view.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link CityDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "CityDelegate'{'fxml={0}'}'";


	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane cityAnchorPane;

	/**
	 * The {@link GridPane} which contains the different {@link CityBuildingAnchorPane}s.
	 */
	@FXML
	private GridPane cityGridPane;


	/**
	 * Calls a method to display the content stored in {@link CityDelegate#CITY_VIEW_FXML} and initialized
	 * by {@link CityDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized view is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(CityDelegate.class, CITY_VIEW_FXML), CityDelegate.class);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Back" {@link Button} in the GUI.
	 * Shows the scene of the {@link MainMenuDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link MainMenuDelegate}.
	 */
	@FXML
	void onBackToMainMenu (final ActionEvent ignored)
	{
		MainMenuDelegate.show();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Help" {@link Button} in the GUI.
	 * Shows the scene of the {@link TutorialDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link TutorialDelegate}.
	 */
	@FXML
	void onOpenHelpMenu (final ActionEvent ignored)
	{
		TutorialDelegate.show();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "save game to config" {@link Button} in the GUI.
	 * Save the current configuration of the game, so the player can load this configuration after restarting the program.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current configuration of the program gets saved and can be accessed later again.
	 */
	@FXML
	void onSaveToConfig (final ActionEvent ignored)
	{
		ConfigLoader.getInstance().save();
		SaveCompleteDelegate.show();
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
		this.cityAnchorPane.getChildren().add(CurrencyDelegate.getCurrencyBannerScene().getRoot());
		this.initCityBuildingAnchorPane();
	}


	/**
	 * Initializes the different {@link CityBuildingAnchorPane}s for each city building and adds them to the grid of the {@link CityDelegate}.
	 *
	 * @precondition {@link CityDelegate#cityGridPane} has at least two rows and four columns.
	 * @postcondition All the different {@link CityBuildingAnchorPane}s have been initialized and were added to the grid.
	 */
	private void initCityBuildingAnchorPane ()
	{
		this.cityGridPane.add(new CityBuildingAnchorPane(Workshop.getInstance()), 0, 0);
		this.cityGridPane.add(new CityBuildingAnchorPane(Barracks.getInstance()), 1, 0);
		this.cityGridPane.add(new CityBuildingAnchorPane(CommandCenter.getInstance()), 2, 0);
		this.cityGridPane.add(new CityBuildingAnchorPane(TrainingFacility.getInstance()), 3, 0);
		this.cityGridPane.add(new CityBuildingAnchorPane(Docks.getInstance()), 0, 1);
		this.cityGridPane.add(new CityBuildingAnchorPane(SpaceBar.getInstance()), 1, 1);
		this.cityGridPane.add(new CityBuildingAnchorPane(Laboratory.getInstance()), 2, 1);
		this.cityGridPane.add(new CityBuildingAnchorPane(Market.getInstance()), 3, 1);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link CityDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link CityDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link CityDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, CITY_VIEW_FXML);
	}

}
