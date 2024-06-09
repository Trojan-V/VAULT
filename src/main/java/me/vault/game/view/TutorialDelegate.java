package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;


public final class TutorialDelegate implements Initializable
{
	/**
	 * The logger object for this class used for writing formatted outputs into the console.
	 *
	 * @see Logger
	 */
	private static final Logger LOGGER = new Logger(TutorialDelegate.class.getSimpleName());



	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.tutorialMenuImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
	}
}
