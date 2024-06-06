package me.vault.game;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import me.vault.game.city.CityView;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;


public class DifficultyMenuController implements Initializable
{
	@FXML
	private ImageView backgroundImageView;


	@FXML
	private ImageView easyDifficultyImageView;


	@FXML
	private ImageView hardDifficultyImageView;


	@FXML
	private ImageView mediumDifficultyImageView;


	@FXML
	void onEasyDifficultyClick (final MouseEvent event)
	{
		CityView.show(VaultApplication.getStage());
	}


	@FXML
	void onHardDifficultyClick (final MouseEvent event)
	{
		CityView.show(VaultApplication.getStage());
	}


	@FXML
	void onMediumDifficultyClick (final MouseEvent event)
	{
		CityView.show(VaultApplication.getStage());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
		this.bindDifficultyImageViews();
	}


	private void bindDifficultyImageViews ()
	{
		this.easyDifficultyImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + "easy_difficulty_icon.png"));
		this.mediumDifficultyImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + "medium_difficulty_icon.png"));
		this.hardDifficultyImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + "hard_difficulty_icon.png"));
	}
}
