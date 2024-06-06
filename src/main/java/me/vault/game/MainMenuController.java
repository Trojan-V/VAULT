package me.vault.game;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;


public class MainMenuController implements Initializable
{
	@FXML
	private Button arenaModeButton;


	@FXML
	private Button continueButton;


	@FXML
	private Button exitGameButton;


	@FXML
	private Button loadGameButton;


	@FXML
	private Button newGameButton;


	@FXML
	private ImageView backgroundImageView;


	@FXML
	void onArenaModeClick (ActionEvent event)
	{

	}


	@FXML
	void onContinueClick (ActionEvent event)
	{

	}


	@FXML
	void onExitGameClick (ActionEvent event)
	{

	}


	@FXML
	void onLoadGameClick (ActionEvent event)
	{

	}


	@FXML
	void onNewGameClick (ActionEvent event)
	{
		DifficultyMenuView.show(VaultApplication.getStage());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
	}
}
