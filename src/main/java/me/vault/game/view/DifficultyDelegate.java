package me.vault.game.view;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.GENERAL_BACKGROUND_FILENAME;


public final class DifficultyDelegate implements Initializable
{

	@FXML
	private ImageView difficultyMenuImageView;


	@FXML
	private ImageView easyDifficultyImageView;


	@FXML
	private ImageView hardDifficultyImageView;


	@FXML
	private ImageView mediumDifficultyImageView;


	@FXML
	void onEasyDifficultyClick (final Event ignored)
	{
		setDifficultyModifier(EASY_MODE_DIFFICULTY_MODIFIER);
		TutorialView.show(VaultApplication.getStage());
	}


	@FXML
	void onMediumDifficultyClick (final Event ignored)
	{
		setDifficultyModifier(MEDIUM_MODE_DIFFICULTY_MODIFIER);
		TutorialView.show(VaultApplication.getStage());
	}


	@FXML
	void onHardDifficultyClick (final Event ignored)
	{
		setDifficultyModifier(HARD_MODE_DIFFICULTY_MODIFIER);
		TutorialView.show(VaultApplication.getStage());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.difficultyMenuImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + GENERAL_BACKGROUND_FILENAME));
		this.easyDifficultyImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + "easy_difficulty_icon.png"));
		this.mediumDifficultyImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + "medium_difficulty_icon.png"));
		this.hardDifficultyImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + "hard_difficulty_icon.png"));
	}
}
