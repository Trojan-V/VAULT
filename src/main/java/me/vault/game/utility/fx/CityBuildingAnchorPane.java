package me.vault.game.utility.fx;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
	private static final Position UPGRADE_BUTTON_POSITION = new Position(0, 0);

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
		final Button interactButton = this.createInteractButton(cityBuilding);
		final Button upgradeButton = this.createUpgradeButton(cityBuilding);
		final GridPane buttonGrid = createButtonGridPane();

		buttonGrid.add(interactButton, INTERACT_BUTTON_POSITION.x(), INTERACT_BUTTON_POSITION.y());
		buttonGrid.add(upgradeButton, UPGRADE_BUTTON_POSITION.x(), UPGRADE_BUTTON_POSITION.y());
		this.getChildren().add(buttonGrid);
	}


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


	private Button createUpgradeButton (final CityBuilding cityBuilding)
	{
		final Button upgradeButton = new Button();
		upgradeButton.setText(UPGRADE_BUTTON_TEXT);
		upgradeButton.setPrefWidth(DIMENSION);
		upgradeButton.setPrefHeight(UPGRADE_BUTTON_HEIGHT);
		upgradeButton.disableProperty().bind(cityBuilding.getIsMaxLevelProperty());
		upgradeButton.setOnMouseClicked(_ -> UpgradeDialogDelegate.show(cityBuilding, CityBuildingController.getInstance()));
		return upgradeButton;
	}


	private Button createInteractButton (final CityBuilding cityBuilding)
	{
		final Button interactButton = new Button();
		interactButton.setPrefWidth(DIMENSION);
		interactButton.setPrefHeight(INTERACT_BUTTON_HEIGHT);

		final ImageView imageView = new ImageView();
		imageView.imageProperty().bind(cityBuilding.getSpriteProperty());
		interactButton.setGraphic(imageView);
		interactButton.textProperty().bind(cityBuilding.getNameProperty());
		interactButton.setOnMouseClicked(_ -> this.useCorrespondingDelegate(cityBuilding));
		return interactButton;
	}


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
