package me.vault.game.utility.fx;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import me.vault.game.control.CityBuildingController;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.city.*;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.buildings.*;

import java.text.MessageFormat;


public final class CityBuildingAnchorPane extends AnchorPane
{

	private static final String TO_STRING_PATTERN = "CityBuildingAnchorPane'{'cityBuilding={0}'}'";

	private static final int DIMENSION = 270;

	private static final int X_OFFSET = 30;

	private static final int INTERACT_BUTTON_HEIGHT = 150;

	private static final int UPGRADE_BUTTON_HEIGHT = 40;

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
		upgradeButton.setText("UPGRADE");
		upgradeButton.setPrefWidth(DIMENSION);
		upgradeButton.setPrefHeight(UPGRADE_BUTTON_HEIGHT);
		upgradeButton.disableProperty().bind(cityBuilding.getMaxLevelProperty());
		upgradeButton.setOnMouseClicked(_ -> this.handleUpgradeEvent(cityBuilding));
		return upgradeButton;
	}


	private void handleUpgradeEvent (final CityBuilding cityBuilding)
	{
		if (CityBuildingController.getInstance().checkIsUpgradable(cityBuilding))
		{
			UpgradeDialogDelegate.show(cityBuilding, CityBuildingController.getInstance());
		}
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
		// TODO: FIX !!! mach mal switch lasse
		switch (cityBuilding)
		{
			case final Workshop workshop -> WorkshopDelegate.show();
			case final Barracks barracks -> BarracksDelegate.show();
			case null, default ->
			{
			}
		}

		if (cityBuilding == Laboratory.getInstance())
		{
			LaboratoryDelegate.show();
		}
		else if (cityBuilding == Market.getInstance())
		{
			MarketDelegate.show();
		}
		else if (cityBuilding == TrainingFacility.getInstance())
		{
			TrainingFacilityDelegate.show();
		}
		else if (cityBuilding == Docks.getInstance())
		{
			DocksDelegate.show();
		}
		else if (cityBuilding == CommandCenter.getInstance())
		{
			CommandCenterDelegate.show();
		}
		else if (cityBuilding == SpaceBar.getInstance())
		{
			SpaceBarDelegate.show();
		}
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.cityBuilding);
	}

}
