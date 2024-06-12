package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.GENERAL_BACKGROUND_FILENAME;


/**
 * The {@code SpaceBarDelegate} handles the control and view of the {@link me.vault.game.model.city.SpaceBar} city building. On the one hand it
 * initialises the view from the fxml-file and binds properties from the model to the view. On the other hand it provides methods to control the model
 * to the {@link me.vault.game.model.city.SpaceBar} cty building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see me.vault.game.model.city.SpaceBar
 * @since 11.06.2024
 */
public class SpaceBarDelegate extends CityBuildingController implements Initializable
{

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane spaceBarAnchorPane;

	/**
	 * The {@link ImageView} of the scene, which works as the views background.
	 */
	@FXML
	private ImageView backgroundImageView;


	/**
	 * Method, that gets called, when th user presses the "BACK"-Button. Resets the current view to the city view.
	 *
	 * @param ignored {@link ActionEvent}-parameter, that contains information about the event-caller.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties.
	 *
	 * @param url            The {@link URL} object, which represents the fxml-file of the view.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + GENERAL_BACKGROUND_FILENAME));
		this.spaceBarAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
	}

}
