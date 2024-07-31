package me.vault.game.utility.fx;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import me.vault.game.control.TroopController;
import me.vault.game.model.city.impl.TrainingFacility;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.interfaces.Nameable;
import me.vault.game.view.UpgradeDialogDelegate;
import org.jetbrains.annotations.NotNull;

import static me.vault.game.utility.interfaces.constant.TroopStatisticConstants.*;

// TODO: Complete JavaDoc needed


public final class TroopUpgradePane extends GridPane
{

	/**
	 * Represents the spacing of the troop attributes in the attribute grid pane.
	 */
	private static final int ATTRIBUTE_SPACING = 10;

	private static final Font FONT = new Font(20);

	private static final Background BACKGROUND = Background.fill(Paint.valueOf("lightblue"));

	private static final int X_OFFSET_NAME_LABEL = 15;

	private static final int Y_OFFSET_NAME_LABEL = 25;

	private static final int X_OFFSET_IMAGE_VIEW = 50;

	private static final int X_OFFSET_BUTTON = 55;

	private static final int Y_OFFSET_BUTTON = 75;

	private static final String BUTTON_TEXT = "Upgrade troop";


	public TroopUpgradePane (final Troop... troops)
	{
		this.setBackground(BACKGROUND);
		this.createGridConstraints(troops);
		this.addTroopImageViews(troops);
		this.addNameAndUpgradeControl(troops);
		this.addAttributeGrids(troops);
	}


	/**
	 * Creates the {@link GridPane} that displays the attributes of the {@link Troop} within the
	 * {@link TrainingFacility}.
	 *
	 * @param troop The {@link Troop} for which the {@link GridPane} will be created.
	 *
	 * @return The {@link GridPane} which was created.
	 */
	private static GridPane createAttributeGridPane (final Troop troop)
	{
		final GridPane attributeGridPane = new GridPane();

		attributeGridPane.setVgap(ATTRIBUTE_SPACING);
		attributeGridPane.setHgap(ATTRIBUTE_SPACING);
		attributeGridPane.setAlignment(Pos.CENTER);

		addDexterityStatistics(troop, attributeGridPane);
		addDefensiveStatistics(troop, attributeGridPane);
		addOffensiveStatistics(troop, attributeGridPane);

		return attributeGridPane;
	}


	/**
	 * Adds the statistics found in the {@link TroopStatistics.Dexterity} instance of the {@link Troop} to the {@link GridPane}.
	 *
	 * @param troop    The {@link Troop} for which the {@link GridPane} is getting created.
	 * @param gridPane The {@link GridPane} which contains the graphically displayable information.
	 */
	private static void addDexterityStatistics (final Troop troop, final GridPane gridPane)
	{
		final TroopStatistics.Dexterity dexterity = troop.getStatistics().getDexterity();
		gridPane.add(new SingleStatisticHBox(MOVEMENT_ICON_PATH, MOVEMENT_NAME, dexterity.getMovementTileProperty()), MOVEMENT_GRID_X, MOVEMENT_GRID_Y);
		gridPane.add(new SingleStatisticHBox(INITIATIVE_ICON_PATH, INITIATIVE_NAME, dexterity.getInitiativeProperty()), INITIATIVE_GRID_X, INITIATIVE_GRID_Y);
	}


	/**
	 * Adds the statistics found in the {@link TroopStatistics.Defensive} instance of the {@link Troop} to the {@link GridPane}.
	 *
	 * @param troop    The {@link Troop} for which the {@link GridPane} is getting created.
	 * @param gridPane The {@link GridPane} which contains the graphically displayable information.
	 */
	private static void addDefensiveStatistics (final Troop troop, final GridPane gridPane)
	{
		final TroopStatistics.Defensive defensive = troop.getStatistics().getDefensive();
		gridPane.add(new SingleStatisticHBox(DODGE_ICON_PATH, DODGE_NAME, defensive.getDodgeRateProperty()), DODGE_GRID_X, DODGE_GRID_Y);
		gridPane.add(new SingleStatisticHBox(HEALTH_ICON_PATH, HEALTH_NAME, defensive.getHealthProperty()), HEALTH_GRID_X, HEALTH_GRID_Y);
		gridPane.add(new SingleStatisticHBox(ARMOR_ICON_PATH, ARMOR_NAME, defensive.getArmorProperty()), ARMOR_GRID_X, ARMOR_GRID_Y);
		gridPane.add(new SingleStatisticHBox(RESISTANCE_ICON_PATH, RESISTANCE_NAME, defensive.getResistanceProperty()), RESISTANCE_GRID_X, RESISTANCE_GRID_Y);
	}


	/**
	 * Adds the statistics found in the {@link TroopStatistics.Offensive} instance of the {@link Troop} to the {@link GridPane}.
	 *
	 * @param troop    The {@link Troop} for which the {@link GridPane} is getting created.
	 * @param gridPane The {@link GridPane} which contains the graphically displayable information.
	 */
	private static void addOffensiveStatistics (final Troop troop, final GridPane gridPane)
	{
		final TroopStatistics.Offensive offensive = troop.getStatistics().getOffensive();
		gridPane.add(new SingleStatisticHBox(MELEE_ICON_PATH, MELEE_NAME, offensive.getMeleeDamageProperty()), MELEE_GRID_X, MELEE_GRID_Y);
		gridPane.add(new SingleStatisticHBox(GRENADE_ICON_PATH, GRENADE_NAME, offensive.getGrenadeDamageProperty()), GRENADE_GRID_X, GRENADE_GRID_Y);
		gridPane.add(new SingleStatisticHBox(GRENADE_AMOUNT_ICON_PATH, GRENADE_AMOUNT_NAME, offensive.getGrenadeAmountProperty()), GRENADE_AMOUNT_GRID_X, GRENADE_AMOUNT_GRID_Y);
		gridPane.add(new SingleStatisticHBox(GRENADE_RANGE_ICON_PATH, GRENADE_RANGE_NAME, offensive.getGrenadeRangeProperty()), GRENADE_RANGE_GRID_X, GRENADE_RANGE_GRID_Y);
		gridPane.add(new SingleStatisticHBox(ENERGY_ICON_PATH, ENERGY_NAME, offensive.getEnergyPointsProperty()), ENERGY_GRID_X, ENERGY_GRID_Y);
	}


	@NotNull
	private static Button createUpgradeButton (final Troop[] troops, final int i)
	{
		final Button upgradeButton = new Button(BUTTON_TEXT);
		upgradeButton.setFont(FONT);
		upgradeButton.disableProperty().bind(troops[i].getIsMaxLevelProperty());
		upgradeButton.setLayoutX(X_OFFSET_BUTTON);
		upgradeButton.setLayoutY(Y_OFFSET_BUTTON);
		upgradeButton.setOnMouseClicked(_ -> UpgradeDialogDelegate.show(troops[i], TroopController.getInstance()));
		return upgradeButton;
	}


	@NotNull
	private static Label createTroopNameLabel (final Nameable troop)
	{
		final Label troopNameLabel = new Label(troop.getName());
		troopNameLabel.setFont(FONT);
		troopNameLabel.textProperty().bind(troop.getNameProperty());
		troopNameLabel.setLayoutX(X_OFFSET_NAME_LABEL);
		troopNameLabel.setLayoutY(Y_OFFSET_NAME_LABEL);
		return troopNameLabel;
	}


	private void addAttributeGrids (final Troop[] troops)
	{
		for (int i = 0; i < troops.length; i++)
		{
			final GridPane attributeGridPane = createAttributeGridPane(troops[i]);
			this.add(attributeGridPane, 2, i);
		}

	}


	private void addNameAndUpgradeControl (final Troop[] troops)
	{
		for (int i = 0; i < troops.length; i++)
		{
			final AnchorPane troopNameUpgradeAnchorPane = new AnchorPane();

			final Label troopNameLabel = createTroopNameLabel(troops[i]);
			troopNameUpgradeAnchorPane.getChildren().add(troopNameLabel);

			final Button upgradeButton = createUpgradeButton(troops, i);
			troopNameUpgradeAnchorPane.getChildren().add(upgradeButton);

			this.add(troopNameUpgradeAnchorPane, 1, i);
		}
	}


	private void addTroopImageViews (final Troop[] troops)
	{
		for (int i = 0; i < troops.length; i++)
		{
			final AnchorPane troopImageAnchorPane = new AnchorPane();

			final ImageView troopImageView = new ImageView(troops[i].getSprite());
			troopImageView.setLayoutX(X_OFFSET_IMAGE_VIEW);
			troopImageView.setLayoutY(Y_OFFSET_NAME_LABEL);
			troopImageAnchorPane.getChildren().add(troopImageView);
			this.add(troopImageAnchorPane, 0, i);
		}
	}


	private void createGridConstraints (final Troop[] troops)
	{
		for (int i = 0; i < troops.length; i++)
		{
			this.getRowConstraints().add(new RowConstraints(155));
		}
		this.getColumnConstraints().add(new ColumnConstraints(200));
		this.getColumnConstraints().add(new ColumnConstraints(300));
		this.getColumnConstraints().add(new ColumnConstraints(730));
		this.setGridLinesVisible(true);
	}

}
