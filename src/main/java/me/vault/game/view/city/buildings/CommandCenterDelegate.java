package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.city.Barracks;
import me.vault.game.model.city.CommandCenter;
import me.vault.game.model.player.Player;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.mission.MissionSelectionDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class CommandCenterDelegate implements Initializable
{

	/**
	 * The {@link Scene} of the {@link CommandCenter} city building, which is extracted from the related .fxml-file
	 * with the {@link ResourceLoader}
	 * class.
	 */
	private static final Scene SCENE = ResourceLoader.loadScene(CommandCenter.class, "command_center_view.fxml");


	private static final Logger LOGGER = new Logger(CommandCenterDelegate.class.getSimpleName());

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


	public static void show ()
	{
		// Loading the FXML-File and creating a scene from the loaded components
		GameApplication.getStage().setScene(SCENE);
		GameApplication.getStage().show();

		// Logging the display of the building
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, Barracks.getInstance().getName()));
	}


	@FXML
	void onArtifactClick (final MouseEvent ignored)
	{
		WorkshopDelegate.show();
	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show(GameApplication.getStage());
	}


	@FXML
	void onFactionClick (final MouseEvent ignored)
	{
		DocksDelegate.show();
	}


	@FXML
	void onGoToMissionBoard (final ActionEvent ignored)
	{
		MissionSelectionDelegate.show(GameApplication.getStage());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.setControlsFromPlayerInventory();
	}


	@FXML
	void onMegaCorpClick (final MouseEvent ignored)
	{
		SpaceBarDelegate.show();
	}


	private void setControlsFromPlayerInventory ()
	{
		this.selectedArtifactLabel.setText(Player.getInstance().getSelectedArtifact().getName());
		this.selectedFactionLabel.setText(Player.getInstance().getSelectedFaction().name());

		this.selectedArtifactImageView.setImage(Player.getInstance().getSelectedArtifact().getSprite());
		this.selectedFactionImageView.setImage(Player.getInstance().getSelectedFaction().getSprite());
	}

}
