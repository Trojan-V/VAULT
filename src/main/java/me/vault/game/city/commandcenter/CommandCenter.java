package me.vault.game.city.commandcenter;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import me.vault.game.city.building.AbsCityBuilding;
import me.vault.game.city.building.CityBuildingLevel;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


/**
 * This class is an implementation of {@link AbsCityBuilding}.
 * <br>
 * The {@link CommandCenter} city building is used by the player to select and start missions,
 * where he can collect currencies and artifacts.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen
 * @version 2.0.0
 * @see me.vault.game.city.building.CityBuilding
 * @since 09.06.2024
 */
public class CommandCenter extends AbsCityBuilding
{

	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(CommandCenter.class.getSimpleName());


	/**
	 * Singleton instance, as there's never a reason to have more than one {@link CommandCenter} city building.
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final CommandCenter INSTANCE;


	/**
	 * The {@link Scene} of the {@link CommandCenter} city building, which is extracted from the related .fxml-file with the
	 * {@link ResourceLoader} class.
	 */
	private static final Scene FXML_SCENE = ResourceLoader.loadScene(CommandCenter.class, "command_center_view.fxml");


	/**
	 * All possible names of the {@link CommandCenter} city building are stored in this map, with the {@link CityBuildingLevel} as key to
	 * denote which name corresponds to which {@link CityBuildingLevel}.
	 *
	 * @see Map
	 * @see CityBuildingLevel
	 */
	private static final Map<CityBuildingLevel, String> NAMES = new HashMap<>();


	/**
	 * All possible sprites of the {@link CommandCenter} city building are stored in this map, with the {@link CityBuildingLevel} as key to
	 * denote which sprite corresponds to which {@link CityBuildingLevel}.
	 *
	 * @see Map
	 * @see CityBuildingLevel
	 * @see Image
	 */
	private static final Map<CityBuildingLevel, MetaDataImage> SPRITES = new HashMap<>();


	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the {@link CommandCenter} city building are stored in this map, with the
	 * {@link CityBuildingLevel} as key to denote which set of upgrade costs corresponds to which {@link CityBuildingLevel}.
	 *
	 * @see Map
	 * @see CityBuildingLevel
	 * @see CurrencyTransaction
	 */
	private static final Map<CityBuildingLevel, CurrencyTransaction> UPGRADE_COSTS = new HashMap<>();

	static
	{
		NAMES.put(CityBuildingLevel.OLD, "Old Command Center");
		NAMES.put(CityBuildingLevel.NORMAL, "Command Center");
		NAMES.put(CityBuildingLevel.SUPER, "Super Command Center");

		SPRITES.put(CityBuildingLevel.OLD, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png"));
		SPRITES.put(CityBuildingLevel.NORMAL, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png"));
		SPRITES.put(CityBuildingLevel.SUPER, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png"));

		UPGRADE_COSTS.put(CityBuildingLevel.OLD, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.NORMAL, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.SUPER, CurrencyTransaction.EMPTY);

		INSTANCE = new CommandCenter();
	}

	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static CommandCenter getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<CityBuildingLevel, CurrencyTransaction> getUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<CityBuildingLevel, String> getNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<CityBuildingLevel, MetaDataImage> getSprites ()
	{
		return SPRITES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Scene getScene ()
	{
		return FXML_SCENE;
	}
}
