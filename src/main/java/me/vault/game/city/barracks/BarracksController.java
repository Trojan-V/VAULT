package me.vault.game.city.barracks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.city.CityView;
import me.vault.game.currency.CurrencyController;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;

public class BarracksController implements Initializable
{

	@FXML
	private ImageView backgroundImageView;

	@FXML
	private AnchorPane barracksAnchorPane;


	@FXML
	void onBackToCityView (ActionEvent event)
	{
		CityView.show(VaultApplication.getStage());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
		this.barracksAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
	}

}
