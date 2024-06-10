package me.vault.game.model.city;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.city.CityView;
import me.vault.game.view.city.buildings.CityBuildingView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class CommandCenterController implements Initializable
{

	@FXML
	private ImageView backgroundImageView;


	@FXML
	private AnchorPane mainAnchorPane;


	@FXML
	private Label currentNewsLabel;


	@FXML
	private Button goToMissionBoardButton;


	@FXML
	private ImageView selectedArtifactImageView;


	@FXML
	private Label selectedArtifactLabel;


	@FXML
	private ImageView selectedFactionImageView;


	@FXML
	private Label selectedFactionLabel;


	@FXML
	void onArtifactClick (final MouseEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), Workshop.getInstance());
	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
	}


	@FXML
	void onFactionClick (final MouseEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), Docks.getInstance());
	}


	@FXML
	void onGoToMissionBoard (final ActionEvent ignored)
	{

	}


	@FXML
	void onMegaCorpClick (final MouseEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), SpaceBar.getInstance());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + GameConstants.GENERAL_BACKGROUND_FILENAME));
		this.mainAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.bindPlayerSelections();
	}


	private void bindPlayerSelections ()
	{

	}

}
