package me.vault.game.view.city;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.city.*;
import me.vault.game.utility.fx.CityBuildingAnchorPane;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.MainMenuDelegate;
import me.vault.game.view.TutorialDelegate;
import me.vault.game.view.ViewUtil;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public class CityDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CityDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String CITY_VIEW_FXML = "city_view.fxml";


	@FXML
	private GridPane cityGridPane;


	@FXML
	private AnchorPane cityAnchorPane;


	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(CityDelegate.class, CITY_VIEW_FXML), CityDelegate.class);
	}


	@FXML
	void onBackToMainMenu (final ActionEvent event)
	{
		MainMenuDelegate.show();
	}


	@FXML
	void onOpenHelpMenu (final ActionEvent event)
	{
		TutorialDelegate.show(GameApplication.getStage());
	}


	@FXML
	void onSaveToConfig (final ActionEvent event)
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
	@FXML
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initBuildingButtons();
		this.cityAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
	}


	private void initBuildingButtons ()
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

}
