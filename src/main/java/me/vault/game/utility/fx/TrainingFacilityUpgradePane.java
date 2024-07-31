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


public final class TrainingFacilityUpgradePane extends GridPane
{

	/**
	 * The {@link Background} of the controls in the {@link TrainingFacilityUpgradePane}
	 */
	private static final Background BACKGROUND = Background.fill(Paint.valueOf("lightblue"));

	/**
	 * Represents the spacing of the troop attributes in the attribute grid pane.
	 */
	private static final int ATTRIBUTE_SPACING = 10;

	/**
	 * The font of the Labels in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final Font FONT = new Font(20);

	/**
	 * The x offset of the Name Labels in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int X_OFFSET_NAME_LABEL = 15;

	/**
	 * The y offset of the Name Labels in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int Y_OFFSET_NAME_LABEL = 25;

	/**
	 * The x offset of the image view in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int X_OFFSET_IMAGE_VIEW = 50;

	/**
	 * The x offset of the button in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int X_OFFSET_BUTTON = 55;

	/**
	 * The y offset of the button in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int Y_OFFSET_BUTTON = 75;

	/**
	 * The text of the button in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final String BUTTON_TEXT = "Upgrade troop";

	/**
	 * The row index of the attribute grids in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int ROW_INDEX_ATTRIBUTES = 2;

	/**
	 * The row index of the upgrade buttons in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int ROW_INDEX_UPGRADE = 1;

	/**
	 * The row index of the image views in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int ROW_INDEX_IMAGE_VIEWS = 0;

	/**
	 * Height of the rows in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int ROW_HEIGHT = 155;

	/**
	 * Width of the first column in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int COLUMN_ONE_WIDTH = 200;

	/**
	 * Width of the second column in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int COLUMN_TWO_WIDTH = 300;

	/**
	 * Width of the third column in the {@link TrainingFacilityUpgradePane}.
	 */
	private static final int COLUMN_THREE_WIDTH = 730;


	/**
	 * Constructs a new instance of {@link TrainingFacilityUpgradePane} with the passed parameters.
	 *
	 * @param troops A list of troops that is contained in the {@link TrainingFacilityUpgradePane}.
	 *
	 * @precondition The constructor gets called and the parameters are != null.
	 * @postcondition A new instance of {@link TrainingFacilityUpgradePane} was created.
	 */
	public TrainingFacilityUpgradePane (final Troop... troops)
	{
		this.setBackground(BACKGROUND);
		this.setGridConstraints(troops);
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
	 *
	 * @precondition A troop from the troop list != null is passed into the method.
	 * @postcondition The attribute grid pane for the attributes of the passed troop was returned.
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
	 *
	 * @precondition The passed {@link GridPane} and {@link Troop} are both != null and the grid pane has the required number of rows and columns.
	 * @postcondition The statistics found in the {@link TroopStatistics.Dexterity} instance of the {@link Troop} were added to the grid pane.
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
	 *
	 * @precondition The passed {@link GridPane} and {@link Troop} are both != null and the grid pane has the required number of rows and columns.
	 * @postcondition The statistics found in the {@link TroopStatistics.Defensive} instance of the {@link Troop} were added to the grid pane.
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
	 *
	 * @precondition The passed {@link GridPane} and {@link Troop} are both != null and the grid pane has the required number of rows and columns.
	 * @postcondition The statistics found in the {@link TroopStatistics.Offensive} instance of the {@link Troop} were added to the grid pane.
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


	/**
	 * Creates a {@link Button} that is able to upgrade the passed troop link at index.
	 *
	 * @param troops The list of troops that's been passed into the instance in the constructor.
	 * @param index  The index of the troop that the button is created for.
	 *
	 * @return A {@link Button} that is able to upgrade the passed troop link at index i.
	 *
	 * @precondition The list of troops from the constructor and an index in that list is passed into the method.
	 * @postcondition A {@link Button} that is able to upgrade that troop was returned.
	 */
	@NotNull
	private static Button createUpgradeButton (final Troop[] troops, final int index)
	{
		final Button upgradeButton = new Button(BUTTON_TEXT);
		upgradeButton.setFont(FONT);
		upgradeButton.disableProperty().bind(troops[index].getIsMaxLevelProperty());
		upgradeButton.setLayoutX(X_OFFSET_BUTTON);
		upgradeButton.setLayoutY(Y_OFFSET_BUTTON);
		upgradeButton.setOnMouseClicked(_ -> UpgradeDialogDelegate.show(troops[index], TroopController.getInstance()));
		return upgradeButton;
	}


	/**
	 * Creates a {@link Label} whose text property is bound to the name property of the passed troop.
	 *
	 * @param troop The troop whose name is supposed to be bound to the Label.
	 *
	 * @return A {@link Label} whose text property is bound to the name property of the passed troop.
	 *
	 * @precondition The method is called and a Nameable object != null is passed inside.
	 * @postcondition A {@link Label} whose text property is bound to the name property of the passed troop was returned.
	 */
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


	/**
	 * Adds the attribute grids of the troops to the {@link TrainingFacilityUpgradePane}.
	 *
	 * @param troops The list of troops that's been passed into the constructor.
	 *
	 * @precondition The list of troops isn't empty and != null.
	 * @postcondition The attribute grids of the troops have been added to the {@link TrainingFacilityUpgradePane}.
	 */
	private void addAttributeGrids (final Troop[] troops)
	{
		for (int i = ROW_INDEX_IMAGE_VIEWS; i < troops.length; i++)
		{
			final GridPane attributeGridPane = createAttributeGridPane(troops[i]);
			this.add(attributeGridPane, ROW_INDEX_ATTRIBUTES, i);
		}

	}


	/**
	 * Adds the name labels and upgrade buttons of the troops to the {@link TrainingFacilityUpgradePane}.
	 *
	 * @param troops The list of troops that's been passed into the constructor.
	 *
	 * @precondition The list of troops isn't empty and != null.
	 * @postcondition The name labels and upgrade buttons of the troops have been added to the {@link TrainingFacilityUpgradePane}.
	 */
	private void addNameAndUpgradeControl (final Troop[] troops)
	{
		for (int i = ROW_INDEX_IMAGE_VIEWS; i < troops.length; i++)
		{
			final AnchorPane troopNameUpgradeAnchorPane = new AnchorPane();
			final Label troopNameLabel = createTroopNameLabel(troops[i]);
			final Button upgradeButton = createUpgradeButton(troops, i);

			troopNameUpgradeAnchorPane.getChildren().add(troopNameLabel);
			troopNameUpgradeAnchorPane.getChildren().add(upgradeButton);
			this.add(troopNameUpgradeAnchorPane, ROW_INDEX_UPGRADE, i);
		}
	}


	/**
	 * Adds the name image views of the troops to the {@link TrainingFacilityUpgradePane}.
	 *
	 * @param troops The list of troops that's been passed into the constructor.
	 *
	 * @precondition The list of troops isn't empty and != null.
	 * @postcondition The image views of the troops have been added to the {@link TrainingFacilityUpgradePane}.
	 */
	private void addTroopImageViews (final Troop[] troops)
	{
		for (int i = ROW_INDEX_IMAGE_VIEWS; i < troops.length; i++)
		{
			final AnchorPane troopImageAnchorPane = new AnchorPane();
			final ImageView troopImageView = new ImageView(troops[i].getSprite());

			troopImageView.setLayoutX(X_OFFSET_IMAGE_VIEW);
			troopImageView.setLayoutY(Y_OFFSET_NAME_LABEL);
			troopImageAnchorPane.getChildren().add(troopImageView);
			this.add(troopImageAnchorPane, ROW_INDEX_IMAGE_VIEWS, i);
		}
	}


	/**
	 * Sets the grid constraints for the {@link TrainingFacilityUpgradePane}.
	 *
	 * @param troops The list of troops that's been passed into the constructor.
	 *
	 * @precondition The list of troops isn't empty and != null.
	 * @postcondition The grid constraints have been set for the {@link TrainingFacilityUpgradePane}.
	 */
	private void setGridConstraints (final Troop[] troops)
	{
		for (int i = ROW_INDEX_IMAGE_VIEWS; i < troops.length; i++)
		{
			this.getRowConstraints().add(new RowConstraints(ROW_HEIGHT));
		}
		this.getColumnConstraints().add(new ColumnConstraints(COLUMN_ONE_WIDTH));
		this.getColumnConstraints().add(new ColumnConstraints(COLUMN_TWO_WIDTH));
		this.getColumnConstraints().add(new ColumnConstraints(COLUMN_THREE_WIDTH));
		this.setGridLinesVisible(true);
	}

}
