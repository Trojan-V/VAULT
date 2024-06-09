package me.vault.game;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import me.vault.game.city.CityView;
import me.vault.game.utility.constant.StringConstants;
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
	private Text storyText;

	@FXML
	private ImageView continueButtonBackground;

	@FXML
	private ImageView backButtonBackground;

	@FXML
	private Button buttonPrologueWeiter;

	@FXML
	private Button buttonPrologueBack;

	@FXML
	private Text buttonBack;

	@FXML
	private Text buttonContinue;



	@FXML
	void continueButtonClick (final MouseEvent ignored)
	{
		ControllerActions.setButtonColor(buttonContinue, Color.BLACK);
		CityView.show(VaultApplication.getStage());
	}

	@FXML
	void backButtonClick (final MouseEvent ignored)
	{
		ControllerActions.setButtonColor(buttonBack, Color.BLACK);
		MainMenuView.showMainMenu(VaultApplication.getStage());
	}

	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(buttonPrologueBack)) {
			ControllerActions.setButtonColor(this.buttonBack, Color.valueOf(StringConstants.colorLightBlue));
		}
		if (mouseEvent.getSource().equals(buttonPrologueWeiter)) {
			ControllerActions.setButtonColor(this.buttonContinue, Color.valueOf(StringConstants.colorLightBlue));
		}
	}

	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(buttonPrologueBack)) {
			ControllerActions.changeImage(this.backButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		if (mouseEvent.getSource().equals(buttonPrologueWeiter)) {
			ControllerActions.changeImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}

	}

	@FXML
	public void returnButtonBackgroundToNormal(final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(buttonPrologueWeiter))
		{
			ControllerActions.changeImage(this.continueButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		if (mouseEvent.getSource().equals(buttonPrologueBack)) {
			ControllerActions.changeImage(this.backButtonBackground,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}

	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.prologueImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
		ControllerActions.setText(this.storyText, StringConstants.prologue);
	}
}
