package me.vault.game.view.city.buildings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;

public class BarracksDelegate implements Initializable
{

	@FXML
	private ImageView backgroundImageView;

	@FXML
	private AnchorPane barracksAnchorPane;


	@FXML
	void onBackToCityView (final ActionEvent event)
	{
		CityView.show(VaultApplication.getStage());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + GameConstants.GENERAL_BACKGROUND_FILENAME));
		this.barracksAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
	}

}
