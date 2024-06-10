package me.vault.game.view;


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
import static me.vault.game.utility.constant.GameConstants.GENERAL_BACKGROUND_FILENAME;


public class MainMenuDelegate implements Initializable
{
	// Buttons ------------------------------------------------------------------------------------------------------------------

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

	//ImageViews ------------------------------------------------------------------------------------------------------------

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

	// Texts -------------------------------------------------------------------------------------------------------------

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


	// Actions ------------------------------------------------------------------------------------------------------------

	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton)) {
			ViewUtils.setImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.newGameButton)) {
			ViewUtils.setImage(this.newGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton)) {
			ViewUtils.setImage(this.loadGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.settingsButton)) {
			ViewUtils.setImage(this.settingsButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton)) {
			ViewUtils.setImage(this.exitGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.arenaButton)) {
			ViewUtils.setImage(this.arenaButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
	}

	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.newGameButton)) {
			ViewUtils.setImage(this.newGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton)) {
			ViewUtils.setImage(this.loadGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.settingsButton)) {
			ViewUtils.setImage(this.settingsButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton)) {
			ViewUtils.setImage(this.exitGameButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.arenaButton)) {
			ViewUtils.setImage(this.arenaButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}

	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton)) {
			ViewUtils.setButtonColor(this.continueButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.newGameButton)) {
			ViewUtils.setButtonColor(this.newGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton)) {
			ViewUtils.setButtonColor(this.loadGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.settingsButton)) {
			ViewUtils.setButtonColor(this.settingsButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton)) {
			ViewUtils.setButtonColor(this.exitGameButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.arenaButton)) {
			ViewUtils.setButtonColor(this.arenaButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
	}

	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton)) {
			ViewUtils.setButtonColor(this.continueButtonText, Color.BLACK);
		}
		else if (mouseEvent.getSource().equals(this.newGameButton)) {
			ViewUtils.setButtonColor(this.newGameButtonText, Color.BLACK);
			PrologueView.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton)) {
			ViewUtils.setButtonColor(this.loadGameButtonText, Color.BLACK);
		}
		else if (mouseEvent.getSource().equals(this.settingsButton)) {
			ViewUtils.setButtonColor(this.settingsButtonText, Color.BLACK);
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton)) {
			ViewUtils.setButtonColor(this.exitGameButtonText, Color.BLACK);
		}
		else if (mouseEvent.getSource().equals(this.arenaButton)) {
			ViewUtils.setButtonColor(this.arenaButtonText, Color.BLACK);
		}
	}

	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		ViewUtils.setImage(this.backgroundImageView, ResourceLoader.loadImage(ASSETS_PATH + GENERAL_BACKGROUND_FILENAME));
	}
}
