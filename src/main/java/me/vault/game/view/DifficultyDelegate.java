package me.vault.game.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import me.vault.game.VaultApplication;
import me.vault.game.control.GameController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public final class DifficultyDelegate implements Initializable
{
	//Buttons ----------------------------------------------------------------------------------------------------------

	@FXML
	private Button easyDifficultyButton;

	@FXML
	private Button normalDifficultyButton;

	@FXML
	private Button hardDifficultyButton;

	@FXML
	private Button backButton;

	//ImageViews ------------------------------------------------------------------------------------------------------------

	@FXML
	private ImageView backgroundImageView;

	@FXML
	private ImageView easyDifficultyButtonImageView;

	@FXML
	private ImageView normalDifficultyButtonImageView;

	@FXML
	private ImageView hardDifficultyButtonImageView;

	@FXML
	private ImageView backButtonImageView;

	//Texts ------------------------------------------------------------------------------------------------------------

	@FXML
	private Text easyDifficultyButtonText;

	@FXML
	private Text normalDifficultyButtonText;

	@FXML
	private Text hardDifficultyButtonText;

	@FXML
	private Text backButtonText;

	//Actions----------------------------------------------------------------------------------------------------------

	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton)) {
			ViewUtils.setImage(this.easyDifficultyButtonImageView,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton)) {
			ViewUtils.setImage(this.normalDifficultyButtonImageView,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton)) {
			ViewUtils.setImage(this.hardDifficultyButtonImageView,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.backButton)) {
			ViewUtils.setImage(this.backButtonImageView,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
	}

	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			ViewUtils.setImage(this.easyDifficultyButtonImageView,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton)) {
			ViewUtils.setImage(this.normalDifficultyButtonImageView,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton)) {
			ViewUtils.setImage(this.hardDifficultyButtonImageView,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.backButton)) {
			ViewUtils.setImage(this.backButtonImageView,
				ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}

	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton)) {
			ViewUtils.setButtonColor(this.easyDifficultyButtonText, javafx.scene.paint.Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton)) {
			ViewUtils.setButtonColor(this.normalDifficultyButtonText, javafx.scene.paint.Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton)) {
			ViewUtils.setButtonColor(this.hardDifficultyButtonText, javafx.scene.paint.Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.backButton)) {
			ViewUtils.setButtonColor(this.backButtonText, javafx.scene.paint.Color.valueOf(StringConstants.colorLightBlue));
		}
	}

	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton)) {
			ViewUtils.setButtonColor(this.easyDifficultyButtonText, javafx.scene.paint.Color.BLACK);
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.EASY_MODE);
			PrologueView.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton)) {
			ViewUtils.setButtonColor(this.normalDifficultyButtonText, javafx.scene.paint.Color.BLACK);
			DifficultyView.show(VaultApplication.getStage());
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.NORMAL_MODE);
			PrologueView.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton)) {
			ViewUtils.setButtonColor(this.hardDifficultyButtonText, javafx.scene.paint.Color.BLACK);
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.HARD_MODE);
			PrologueView.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.backButton)) {
			ViewUtils.setButtonColor(this.backButtonText, javafx.scene.paint.Color.BLACK);
			MainMenuView.show(VaultApplication.getStage());
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{

	}
}
