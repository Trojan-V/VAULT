package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.city.CommandCenter;
import me.vault.game.model.player.Player;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.mission.MissionSelectionDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * The {@code CommandCenterDelegate} handles the control and view of the {@link CommandCenter} city building.
 * <br>
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * <br>
 * On the other hand, it provides methods to control the model to the {@link CommandCenter} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see CommandCenter
 * @since 11.06.2024
 */
public final class CommandCenterDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(CommandCenterDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String COMMAND_CENTER_VIEW_FXML = "command_center_view.fxml";

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "CommandCenterDelegate'{'fxml={0}'}'";


	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private Label currentNewsLabel;

	@FXML
	private ImageView selectedArtifactImageView;

	@FXML
	private Label selectedArtifactLabel;

	@FXML
	private ImageView selectedFactionImageView;

	@FXML
	private Label selectedFactionLabel;


	/**
	 * Calls a method to display the content stored in {@link CommandCenterDelegate#COMMAND_CENTER_VIEW_FXML} and initialized
	 * by {@link CommandCenterDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized view is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(CommandCenterDelegate.class, COMMAND_CENTER_VIEW_FXML), CommandCenterDelegate.class);
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.setControlsFromPlayerInventory();
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, COMMAND_CENTER_VIEW_FXML);
	}


	private void setControlsFromPlayerInventory ()
	{
		this.selectedArtifactLabel.setText(Player.getInstance().getSelectedArtifact().getName());
		this.selectedFactionLabel.setText(Player.getInstance().getSelectedFaction().name());
		// TODO: Random news generieren
		this.selectedArtifactImageView.setImage(Player.getInstance().getSelectedArtifact().getSprite());
		this.selectedFactionImageView.setImage(Player.getInstance().getSelectedFaction().getSprite());
	}


	@FXML
	void onArtifactClick (final MouseEvent ignored)
	{
		WorkshopDelegate.show();
	}


	@FXML
	void onMegaCorpClick (final MouseEvent ignored)
	{
		SpaceBarDelegate.show();
	}


	@FXML
	void onFactionClick (final MouseEvent ignored)
	{
		DocksDelegate.show();
	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	@FXML
	void onGoToMissionBoard (final ActionEvent ignored)
	{
		MissionSelectionDelegate.show();
	}

}
