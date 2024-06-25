package me.vault.game.view.city.buildings;


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
import me.vault.game.model.city.Docks;
import me.vault.game.model.city.SpaceBar;
import me.vault.game.model.city.Workshop;
import me.vault.game.model.player.Player;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.mission.MissionSelectionDelegate;

import java.net.URL;
import java.util.ResourceBundle;


public class CommandCenterController implements Initializable
{

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
		CityDelegate.show(VaultApplication.getStage());
	}


	@FXML
	void onFactionClick (final MouseEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), Docks.getInstance());
	}


	@FXML
	void onGoToMissionBoard (final ActionEvent ignored)
	{
		MissionSelectionDelegate.show(VaultApplication.getStage());
	}


	@FXML
	void onMegaCorpClick (final MouseEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), SpaceBar.getInstance());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.setControlsFromPlayerInventory();
	}


	private void setControlsFromPlayerInventory ()
	{
		this.selectedArtifactLabel.setText(Player.getInstance().getSelectedArtifact().getName());
		this.selectedFactionLabel.setText(Player.getInstance().getSelectedFaction().name());

		this.selectedArtifactImageView.setImage(Player.getInstance().getSelectedArtifact().getSprite());
		this.selectedFactionImageView.setImage(Player.getInstance().getSelectedFaction().getSprite());
	}

}
