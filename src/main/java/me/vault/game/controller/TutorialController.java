package me.vault.game.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import me.vault.game.views.PrologueView;
import me.vault.game.VaultApplication;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;


public final class TutorialController implements Initializable
{
	/**
	 * The logger object for this class used for writing formatted outputs into the console.
	 *
	 * @see Logger
	 */
	private static final Logger LOGGER = new Logger(TutorialController.class.getSimpleName());


	private static final int LAST_PAGE_INDEX_SHIFT = 1;


	private static final int NEXT_PAGE_INDEX_SHIFT = 1;


	@FXML
	private ImageView tutorialMenuImageView;


	@FXML
	private TabPane tutorialTabPane;


	@FXML
	void nextButtonClick (final ActionEvent ignored)
	{
		if (this.tutorialTabPane.getSelectionModel().getSelectedIndex() == this.tutorialTabPane.getTabs().size() - LAST_PAGE_INDEX_SHIFT)
		{
			PrologueView.show(VaultApplication.getStage());
		}
		else
		{
			this.tutorialTabPane.getSelectionModel().select(this.tutorialTabPane.getSelectionModel().getSelectedIndex() + NEXT_PAGE_INDEX_SHIFT);
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.tutorialMenuImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
	}
}
