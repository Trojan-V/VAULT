package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.city.TrainingFacility;
import me.vault.game.model.troop.impl.*;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.fx.TroopUpgradePane;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.TAB_PANE_STYLE;



public final class TrainingFacilityDelegate implements Initializable
{

	private static final ILogger LOGGER = new Logger(TrainingFacility.class.getSimpleName());

	private static final String TRAINING_FACILITY_VIEW_FXML = "training_facility_view.fxml";

	private static final String TO_STRING_PATTERN = "TrainingFacilityDelegate'{'fxml={0}'}'";

	@FXML
	private AnchorPane corporationPane;

	@FXML
	private AnchorPane explorerPane;

	@FXML
	private TabPane factionsTabPane;

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private AnchorPane militaristicPane;

	@FXML
	private AnchorPane terraPane;


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
		this.mainAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.militaristicPane.getChildren().add(new TroopUpgradePane(SpaceMarine.getInstance(), Officer.getAllyInstance(), Engineer.getAllyInstance()));
		this.explorerPane.getChildren().add(new TroopUpgradePane(Ranger.getInstance(), Sniper.getInstance(), Medic.getAllyInstance()));
		this.terraPane.getChildren().add(new TroopUpgradePane(Lieutenant.getInstance(), PrecisionShooter.getAllyInstance(), Infantry.getAllyInstance()));
		this.corporationPane.getChildren().add(new TroopUpgradePane(Guard.getAllyInstance(), Grenadier.getAllyInstance(), Recruit.getInstance()));
	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, TRAINING_FACILITY_VIEW_FXML);
	}

}
