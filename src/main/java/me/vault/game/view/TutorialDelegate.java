package me.vault.game.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import me.vault.game.VaultApplication;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;


public final class TutorialDelegate implements Initializable
{
	//Buttons ----------------------------------------------------------------------------------------------------------

	@FXML
	private Button continueButton;

	@FXML
	private Button backButton;

	//ImageViews -----------------------------------------------------------------------------------------------------------

	@FXML
	private ImageView backgroundImageView;

	@FXML
	private ImageView continueButtonBackground;

	@FXML
	private ImageView backButtonBackground;

	//Texts -----------------------------------------------------------------------------------------------------------

	@FXML
	private Text tutorialIntroductionText;

	@FXML
	private Text tutorialCityText;

	@FXML
	private Text tutorialArtefactsText;

	@FXML
	private Text tutorialFactionsText;

	@FXML
	private Text tutorialMissionsText;

	@FXML
	private Text tutorialFightsText;

	@FXML
	private Text continueButtonText;

	@FXML
	private Text backButtonText;

	//Tabs -----------------------------------------------------------------------------------------------------------


	//Actions ----------------------------------------------------------------------------------------------------------
	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtils.changeImage(this.backButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.changeImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}

	}

	@FXML
	public void returnButtonBackgroundToNormal(final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.changeImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtils.changeImage(this.backButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}

	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtils.setButtonColor(this.backButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setButtonColor(this.continueButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
	}

	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtils.setButtonColor(this.backButtonText, Color.BLACK);
			MainMenuView.showMainMenu(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setButtonColor(this.continueButtonText, Color.BLACK);
			TutorialView.show(VaultApplication.getStage());
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
	}
}
