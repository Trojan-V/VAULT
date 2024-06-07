package me.vault.game;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import me.vault.game.city.CityView;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;


public class PrologueController implements Initializable
{
	@FXML
	private ImageView prologueImageView;


	@FXML
	void continueButtonClick (final ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.prologueImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
	}
}
