package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.model.city.impl.CommandCenter;
import me.vault.game.model.city.impl.TrainingFacility;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.impl.*;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.fx.TrainingFacilityUpgradePane;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.CurrencyDelegate;
import me.vault.game.view.mission.MissionSelectionDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.GameConstants.TAB_PANE_STYLE;


/**
 * The {@code TrainingFacilityDelegate} handles the control and view of the {@link TrainingFacility} city building.
 * <br>
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * <br>
 * On the other hand, it provides methods to control the model to the {@link TrainingFacility} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuildingController
 * @see Initializable
 * @see CommandCenter
 * @since 11.06.2024
 */
public final class TrainingFacilityDelegate implements Initializable
{

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String TRAINING_FACILITY_VIEW_FXML = "training_facility_view.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link MissionSelectionDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "TrainingFacilityDelegate'{'fxml={0}'}'";

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane mainAnchorPane;

	/**
	 * The {@link AnchorPane}, which contains the {@link TrainingFacilityUpgradePane} for the {@link Faction#MEGA_CORPORATION}
	 */
	@FXML
	private AnchorPane corporationPane;

	/**
	 * The {@link AnchorPane}, which contains the {@link TrainingFacilityUpgradePane} for the {@link Faction#MEGA_CORPORATION}
	 */
	@FXML
	private AnchorPane explorerPane;

	/**
	 * The {@link AnchorPane}, which contains the {@link TrainingFacilityUpgradePane} for the {@link Faction#MILITARISTIC_GOVERNMENT}
	 */
	@FXML
	private AnchorPane militaristicPane;

	/**
	 * The {@link AnchorPane}, which contains the {@link TrainingFacilityUpgradePane} for the {@link Faction#NEW_TERRA}
	 */
	@FXML
	private AnchorPane terraPane;

	/**
	 * The {@link TabPane}, which contains the {@link Tab}s for the different {@link Faction}s.
	 */
	@FXML
	private TabPane factionsTabPane;


	/**
	 * Calls a method to display the content stored in {@link TrainingFacilityDelegate#TRAINING_FACILITY_VIEW_FXML} and initialized
	 * by {@link TrainingFacilityDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized view is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(TrainingFacilityDelegate.class, TRAINING_FACILITY_VIEW_FXML), TrainingFacilityDelegate.class);
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
		this.factionsTabPane.getStyleClass().add(TAB_PANE_STYLE);
		this.mainAnchorPane.getChildren().add(CurrencyDelegate.getCurrencyBannerScene().getRoot());
		this.militaristicPane.getChildren().add(new TrainingFacilityUpgradePane(SpaceMarine.getInstance(), Officer.getInstance(), Engineer.getInstance()));
		this.explorerPane.getChildren().add(new TrainingFacilityUpgradePane(Ranger.getInstance(), Sniper.getInstance(), Medic.getInstance()));
		this.terraPane.getChildren().add(new TrainingFacilityUpgradePane(Lieutenant.getInstance(), PrecisionShooter.getInstance(), Infantry.getInstance()));
		this.corporationPane.getChildren().add(new TrainingFacilityUpgradePane(Guard.getInstance(), Grenadier.getInstance(), Recruit.getInstance()));
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Back" {@link Button} in the GUI.
	 * Resets the current {@link Scene} on the main {@link Stage} to the {@link Scene} of the {@link CityDelegate}.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is reset to the {@link Scene} of the {@link CityDelegate}.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link TrainingFacilityDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link TrainingFacilityDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link TrainingFacilityDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, TRAINING_FACILITY_VIEW_FXML);
	}

}
