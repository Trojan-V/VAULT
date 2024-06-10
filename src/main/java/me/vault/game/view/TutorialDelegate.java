package me.vault.game.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import me.vault.game.VaultApplication;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.*;


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

	//TabPane ----------------------------------------------------------------------------------------------------------

	@FXML
	private TabPane tutorialTabPane;


	//Actions ----------------------------------------------------------------------------------------------------------
	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtils.setImage(this.backButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}

	}

	@FXML
	public void returnButtonBackgroundToNormal(final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtils.setImage(this.backButtonBackground,
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
			PrologueView.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtils.setButtonColor(this.continueButtonText, Color.BLACK);
			// TutorialView.show(VaultApplication.getStage());
			CityView.show(VaultApplication.getStage());
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		ViewUtils.setImage(this.backgroundImageView, ResourceLoader.loadImage(ASSETS_PATH + GENERAL_BACKGROUND_FILENAME));
		ViewUtils.setText(this.tutorialIntroductionText, StringConstants.tutorialIntroduction);
		ViewUtils.setText(this.tutorialCityText, StringConstants.tutorialCity);
		ViewUtils.setText(this.tutorialArtefactsText, StringConstants.tutorialArtefacts);
		ViewUtils.setText(this.tutorialFactionsText, StringConstants.tutorialFactsions);
		ViewUtils.setText(this.tutorialMissionsText, StringConstants.tutorialMissions);
		ViewUtils.setText(this.tutorialFightsText, StringConstants.tutorialFights);
		ViewUtils.setTabPaneStyle(tutorialTabPane,TAB_PANE_STYLE);

	}
}
