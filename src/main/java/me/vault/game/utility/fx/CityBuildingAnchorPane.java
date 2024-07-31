package me.vault.game.utility.fx;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import me.vault.game.control.CityBuildingController;
import me.vault.game.model.city.CityBuilding;
import me.vault.game.model.city.impl.*;
import me.vault.game.utility.interfaces.Placeable;
import me.vault.game.utility.math.Position;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.building.*;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;


/**
 * The {@code CityBuildingAnchorPane} represents one building pane in the city delegate view.
 * It extends the standard {@link AnchorPane} and automatically initializes the right graphic and design based
 * on the {@link CityBuilding} object which is parsed into the constructor.
 * The {@code CityBuildingAnchorPane} is mainly used in the city delegate view and allows the player to upgrade and select
 * different city buildings.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Button
 * @see CityBuilding
 * @see Placeable
 * @since 25.06.2024
 */
public final class CityBuildingAnchorPane extends AnchorPane
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link CityBuildingAnchorPane#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "CityBuildingAnchorPane'{'cityBuilding={0}'}'";

	/**
	 * The upgrade button text of each city building in the city view.
	 */
	private static final String UPGRADE_BUTTON_TEXT = "Upgrade";

	/**
	 * The x and y dimensions of each city building grid in the city view.
	 */
	private static final int DIMENSION = 270;

	/**
	 * The x offset of each city building grid in the city view.
	 */
	private static final int X_OFFSET = 30;

	/**
	 * The city building button height of the city building grid.
	 */
	private static final int INTERACT_BUTTON_HEIGHT = 150;

	/**
	 * The upgrade button height of the city building grid.
	 */
	private static final int UPGRADE_BUTTON_HEIGHT = 40;

	/**
	 * The {@link Position} of the "interact" button in the button grid.
	 */
	private static final Position INTERACT_BUTTON_POSITION = new Position(0, 0);

	/**
	 * The {@link Position} of the "upgrade" button in the button grid.
	 */
	private static final Position UPGRADE_BUTTON_POSITION = new Position(0, 1);

	/**
	 * The {@link Background} of the controls in the {@link CityBuildingAnchorPane}
	 */
	private static final Background BACKGROUND = Background.fill(Paint.valueOf("lightblue"));

	/**
	 * The {@link Border} of the controls in the {@link CityBuildingAnchorPane}
	 */
	private static final Border BORDER = Border.stroke(Paint.valueOf("grey"));

	/**
	 * The {@link CityBuilding} that is the template for the {@link CityBuildingAnchorPane}
	 */
	private final CityBuilding cityBuilding;


	/**
	 * Constructs a new instance of {@link CityBuildingAnchorPane} based on the passed city building.
	 *
	 * @param cityBuilding The {@link CityBuilding} which is the template for the new instance.
	 *
	 * @precondition The {@link CityBuilding} parameter is != null.
	 * @postcondition A new instance of {@link CityBuildingAnchorPane} was created.
	 */
	public CityBuildingAnchorPane (final CityBuilding cityBuilding)
	{
		this.cityBuilding = cityBuilding;
		final GridPane buttonGrid = createButtonGridPane();
		final Button upgradeButton = this.createUpgradeButton(cityBuilding);
		final Button interactButton = this.createInteractButton(cityBuilding);

		buttonGrid.add(interactButton, INTERACT_BUTTON_POSITION.x(), INTERACT_BUTTON_POSITION.y());
		buttonGrid.add(upgradeButton, UPGRADE_BUTTON_POSITION.x(), UPGRADE_BUTTON_POSITION.y());
		this.getChildren().add(buttonGrid);
	}


	/**
	 * Creates and designs the grid pane for the "interact" und "upgrade" buttons.
	 *
	 * @return A {@link GridPane} for the buttons.
	 *
	 * @precondition The method is called.
	 * @postcondition A GridPane with adjusted properties for the "interact" und "upgrade" buttons was returned.
	 */
	@NotNull
	private static GridPane createButtonGridPane ()
	{
		final GridPane buttonGrid = new GridPane();
		buttonGrid.getRowConstraints().add(new RowConstraints());
		buttonGrid.setAlignment(Pos.CENTER);
		buttonGrid.setPrefWidth(DIMENSION);
		buttonGrid.setPrefHeight(DIMENSION);
		buttonGrid.setLayoutX(X_OFFSET);
		buttonGrid.getRowConstraints().add(new RowConstraints());
		return buttonGrid;
	}


	/**
	 * Creates and designs the "upgrade" button of the {@link CityBuilding}.
	 *
	 * @return A {@link Button} for the {@link CityBuilding} upgrade.
	 *
	 * @precondition The method is called and a {@link CityBuilding} != null is passed.
	 * @postcondition A {@link Button} with adjusted properties for the upgrade was returned.
	 */
	private Button createUpgradeButton (final CityBuilding cityBuilding)
	{
		final Button upgradeButton = new Button();
		upgradeButton.setBorder(BORDER);
		upgradeButton.setBackground(BACKGROUND);
		upgradeButton.setText(UPGRADE_BUTTON_TEXT);
		upgradeButton.setPrefWidth(DIMENSION);
		upgradeButton.setPrefHeight(UPGRADE_BUTTON_HEIGHT);
		upgradeButton.disableProperty().bind(cityBuilding.getIsMaxLevelProperty());
		upgradeButton.setOnMouseClicked(_ -> UpgradeDialogDelegate.show(cityBuilding, CityBuildingController.getInstance()));
		return upgradeButton;
	}


	/**
	 * Creates and designs the "interact" button of the {@link CityBuilding}.
	 *
	 * @return A {@link Button} for the {@link CityBuilding} interaction.
	 *
	 * @precondition The method is called and a {@link CityBuilding} != null is passed.
	 * @postcondition A {@link Button} with adjusted properties for the interaction was returned.
	 */
	private Button createInteractButton (final CityBuilding cityBuilding)
	{
		final Button interactButton = new Button();
		interactButton.setBorder(BORDER);
		interactButton.setBackground(BACKGROUND);
		interactButton.setPrefWidth(DIMENSION);
		interactButton.setPrefHeight(INTERACT_BUTTON_HEIGHT);

		final ImageView imageView = new ImageView();
		imageView.imageProperty().bind(cityBuilding.getSpriteProperty());
		interactButton.setGraphic(imageView);
		interactButton.textProperty().bind(cityBuilding.getNameProperty());
		interactButton.setOnMouseClicked(_ -> this.useCorrespondingDelegate(cityBuilding));
		return interactButton;
	}


	/**
	 * Shows the view of the related CityBuilding delegate based on the passed CityBuilding.
	 *
	 * @param cityBuilding The CityBuilding whose view is supposed to be showed.
	 *
	 * @precondition A CityBuilding != null is passed into the method and all the delegates of the CityBuildings can be shown.
	 * @postcondition The view of the passed CityBuilding was shown on the main stage.
	 */
	private void useCorrespondingDelegate (final CityBuilding cityBuilding)
	{
		switch (cityBuilding)
		{
			case final Docks docks -> DocksDelegate.show();
			case final Market market -> MarketDelegate.show();
			case final Workshop workshop -> WorkshopDelegate.show();
			case final Barracks barracks -> BarracksDelegate.show();
			case final SpaceBar spaceBarDelegate -> SpaceBarDelegate.show();
			case final Laboratory laboratory -> LaboratoryDelegate.show();
			case final CommandCenter commandCenter -> CommandCenterDelegate.show();
			case final TrainingFacility trainingFacility -> TrainingFacilityDelegate.show();
			case null, default -> CityDelegate.show();
		}
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link CityBuildingAnchorPane#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link CityBuildingAnchorPane#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link CityBuildingAnchorPane#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.cityBuilding);
	}

}
