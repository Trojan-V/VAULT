package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import me.vault.game.VaultApplication;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;


public class MainMenuDelegate implements Initializable
{
	//------------------------- Buttons ------------------------------------------------
	@FXML
	private Button continueButton;

	@FXML
	private Button newGameButton;

	@FXML
	private Button loadGameButton;

	@FXML
	private Button settingsButton;

	@FXML
	private Button exitGameButton;

	@FXML
	private Button arenaButton;

	//------------------------- ImageViews ------------------------------------------------

	@FXML
	private ImageView backgroundImageView;

	@FXML
	private ImageView continueButtonBackground;

	@FXML
	private ImageView newGameButtonBackground;

	@FXML
	private ImageView loadGameButtonBackground;

	@FXML
	private ImageView settingsButtonBackground;

	@FXML
	private ImageView exitGameButtonBackground;

	@FXML
	private ImageView arenaButtonBackground;

	//------------------------- Texts ------------------------------------------------

	@FXML
	private Text continueButtonText;

	@FXML
	private Text newGameButtonText;

	@FXML
	private Text loadGameButtonText;

	@FXML
	private Text settingsButtonText;

	@FXML
	private Text exitGameButtonText;

	@FXML
	private Text arenaButtonText;


	//------------------------- Actions ------------------------------------------------

	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(continueButton)) {
			ViewUtils.changeImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(newGameButton)) {
			ViewUtils.changeImage(this.newGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		if (mouseEvent.getSource().equals(loadGameButton)) {
			ViewUtils.changeImage(this.loadGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(settingsButton)) {
			ViewUtils.changeImage(this.settingsButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		if (mouseEvent.getSource().equals(exitGameButton)) {
			ViewUtils.changeImage(this.exitGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(arenaButton)) {
			ViewUtils.changeImage(this.arenaButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
	}

	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(continueButton))
		{
			ViewUtils.changeImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(newGameButton)) {
			ViewUtils.changeImage(this.newGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(loadGameButton)) {
			ViewUtils.changeImage(this.loadGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(settingsButton)) {
			ViewUtils.changeImage(this.settingsButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(exitGameButton)) {
			ViewUtils.changeImage(this.exitGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(arenaButton)) {
			ViewUtils.changeImage(this.arenaButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}

	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(continueButton)) {
			ViewUtils.setButtonColor(this.continueButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		if (mouseEvent.getSource().equals(newGameButton)) {
			ViewUtils.setButtonColor(this.newGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		if (mouseEvent.getSource().equals(loadGameButton)) {
			ViewUtils.setButtonColor(this.loadGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		if (mouseEvent.getSource().equals(settingsButton)) {
			ViewUtils.setButtonColor(this.settingsButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		if (mouseEvent.getSource().equals(exitGameButton)) {
			ViewUtils.setButtonColor(this.exitGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		if (mouseEvent.getSource().equals(arenaButton)) {
			ViewUtils.setButtonColor(this.arenaButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
	}

	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(continueButton)) {
			ViewUtils.setButtonColor(this.continueButtonText, Color.BLACK);
		}
		if (mouseEvent.getSource().equals(newGameButton)) {
			ViewUtils.setButtonColor(this.newGameButtonText, Color.BLACK);
		}
		if (mouseEvent.getSource().equals(loadGameButton)) {
			ViewUtils.setButtonColor(this.loadGameButtonText, Color.BLACK);
		}
		if (mouseEvent.getSource().equals(settingsButton)) {
			ViewUtils.setButtonColor(this.settingsButtonText, Color.BLACK);
		}
		if (mouseEvent.getSource().equals(exitGameButton)) {
			ViewUtils.setButtonColor(this.exitGameButtonText, Color.BLACK);
		}
		if (mouseEvent.getSource().equals(arenaButton)) {
			ViewUtils.setButtonColor(this.arenaButtonText, Color.BLACK);
		}
	}

	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		ViewUtils.changeImage(backgroundImageView, ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
	}
}
