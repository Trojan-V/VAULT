package me.vault.game.utility.fx;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import me.vault.game.control.CityBuildingController;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.model.city.*;
import me.vault.game.view.ArenaFinishedDialogDelegate;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.building.*;

import java.text.MessageFormat;


public final class CityBuildingAnchorPane extends AnchorPane
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link ArenaFinishedDialogDelegate#toString()} is called.
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
	 * The {@link CityBuilding} that is the template for the {@link CityBuildingAnchorPane}
	 */
	private final CityBuilding cityBuilding;


	public CityBuildingAnchorPane (final CityBuilding cityBuilding)
	{
		this.cityBuilding = cityBuilding;
		final GridPane buttonGrid = new GridPane();
		final Button interactButton = this.createInteractButton(cityBuilding);
		final Button upgradeButton = this.createUpgradeButton(cityBuilding);
		buttonGrid.getRowConstraints().add(new RowConstraints());
		buttonGrid.setAlignment(Pos.CENTER);
		buttonGrid.setPrefWidth(DIMENSION);
		buttonGrid.setPrefHeight(DIMENSION);
		buttonGrid.setLayoutX(X_OFFSET);
		buttonGrid.getRowConstraints().add(new RowConstraints());
		buttonGrid.add(interactButton, 0, 0);
		buttonGrid.add(upgradeButton, 0, 1);
		this.getChildren().add(buttonGrid);
	}


	private Button createUpgradeButton (final CityBuilding cityBuilding)
	{
		final Button upgradeButton = new Button();
		upgradeButton.setText(UPGRADE_BUTTON_TEXT);
		upgradeButton.setPrefWidth(DIMENSION);
		upgradeButton.setPrefHeight(UPGRADE_BUTTON_HEIGHT);
		upgradeButton.disableProperty().bind(cityBuilding.getIsMaxLevelProperty());
		upgradeButton.setOnMouseClicked(_ -> this.handleUpgradeEvent(cityBuilding));
		return upgradeButton;
	}


	private void handleUpgradeEvent (final Upgradable<CityBuildingLevel> cityBuilding)
	{
		UpgradeDialogDelegate.show(cityBuilding, CityBuildingController.getInstance());
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
