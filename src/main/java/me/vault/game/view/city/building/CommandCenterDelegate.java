package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.model.Player;
import me.vault.game.model.city.implementation.CommandCenter;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.CurrencyDelegate;
import me.vault.game.view.mission.MissionSelectionDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Random;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.CityBuildingConstants.CommandCenter.RANDOM_NEWS_LIST;


/**
 * The {@code CommandCenterDelegate} handles the control and view of the {@link CommandCenter} city building.
 * <br>
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * <br>
 * On the other hand, it provides methods to control the model to the {@link CommandCenter} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuildingController
 * @see Initializable
 * @see CommandCenter
 * @since 11.06.2024
 */
public final class CommandCenterDelegate implements Initializable
{

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

	/**
	 * The {@link ImageView} on the GUI, that displays the sprite of the currently selected artifact.
	 */
	@FXML
	private ImageView selectedArtifactImageView;

	/**
	 * The {@link ImageView} on the GUI, that displays the sprite of the currently selected faction.
	 */
	@FXML
	private ImageView selectedFactionImageView;

	/**
	 * The {@link Label} on the GUI, that randomly displays news messages.
	 */
	@FXML
	private Label currentNewsLabel;

	/**
	 * The {@link Label} on the GUI, that displays the name of the currently selected artifact.
	 */
	@FXML
	private Label selectedArtifactLabel;

	/**
	 * The {@link Label} on the GUI, that displays the name of the currently selected faction.
	 */
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
		this.mainAnchorPane.getChildren().add(CurrencyDelegate.getCurrencyBannerScene().getRoot());
		this.currentNewsLabel.setText(RANDOM_NEWS_LIST.get(new Random().nextInt(RANDOM_NEWS_LIST.size())));
		this.selectedArtifactLabel.setText(Player.getInstance().getSelectedArtifact().getName());
		this.selectedFactionLabel.setText(Player.getInstance().getSelectedFaction().name());
		this.selectedArtifactImageView.setImage(Player.getInstance().getSelectedArtifact().getSprite());
		this.selectedFactionImageView.setImage(Player.getInstance().getSelectedFaction().getSprite());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the artifact image view in the GUI.
	 * Shows the scene of the {@link WorkshopDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link ImageView} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link WorkshopDelegate}.
	 */
	@FXML
	void onArtifactClick (final MouseEvent ignored)
	{
		WorkshopDelegate.show();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the mega corporation image view in the GUI.
	 * Shows the scene of the {@link SpaceBarDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link ImageView} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link SpaceBarDelegate}.
	 */
	@FXML
	void onMegaCorpClick (final MouseEvent ignored)
	{
		SpaceBarDelegate.show();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the faction image view in the GUI.
	 * Shows the scene of the {@link DocksDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link ImageView} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link DocksDelegate}.
	 */
	@FXML
	void onFactionClick (final MouseEvent ignored)
	{
		DocksDelegate.show();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Back" {@link Button} in the GUI.
	 * Shows the scene of the {@link CityDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link CityDelegate}.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Continue" {@link Button} in the GUI.
	 * Shows the scene of the {@link MissionSelectionDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link MissionSelectionDelegate}.
	 */
	@FXML
	void onGoToMissionBoard (final ActionEvent ignored)
	{
		MissionSelectionDelegate.show();
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link CommandCenterDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link CommandCenterDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link CommandCenterDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, COMMAND_CENTER_VIEW_FXML);
	}

}
