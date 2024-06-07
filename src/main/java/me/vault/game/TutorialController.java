package me.vault.game;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import me.vault.game.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;


public class TutorialController implements Initializable
{
	private static final int LAST_PAGE_INDEX_SHIFT = 1;


	private static final int NEXT_PAGE_INDEX_SHIFT = 1;


	@FXML
	private ImageView tutorialMenuImageView;


	@FXML
	private Button nextButton;


	@FXML
	private TabPane tutorialTabPane;


	@FXML
	void nextButtonClick (final ActionEvent ignored)
	{
		if (this.tutorialTabPane.getSelectionModel().getSelectedIndex() == this.tutorialTabPane.getTabs().size() - LAST_PAGE_INDEX_SHIFT)
		{
			CityView.show(VaultApplication.getStage());
		}
		else
		{
			this.tutorialTabPane.getSelectionModel().select(this.tutorialTabPane.getSelectionModel().getSelectedIndex() + NEXT_PAGE_INDEX_SHIFT);
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{


	}
}
