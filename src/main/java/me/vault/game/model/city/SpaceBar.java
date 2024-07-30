package me.vault.game.model.city;


import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.struct.MetaDataImage;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static me.vault.game.utility.constant.CityBuildingConstants.SpaceBar.*;


/**
 * This class is an implementation of {@link CityBuilding}.
 * <br>
 * The {@link SpaceBar} city building holds all information about the mercenary faction of the game, which can be selected by the player and be used in
 * missions and encounters.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 2.0.0
 * @see CityBuilding
 * @see me.vault.game.interfaces.Upgradable
 * @since 09.06.2024
 */
public class SpaceBar extends CityBuilding
{

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link SpaceBar} city building.
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final SpaceBar INSTANCE;


	/**
	 * All possible names of the {@link SpaceBar} city building are stored in this {@link Map}, with the {@link CityBuildingLevel} as key to denote which
	 * name corresponds to which {@code CityBuildingLevel}.
	 */
	private static final Map<CityBuildingLevel, String> NAMES = new ValidatedEntriesHashMap<>();

	/**
	 * All possible sprites of the {@link SpaceBar} city building are stored in this {@link Map}, with the {@link CityBuildingLevel} as key to denote which
	 * sprite corresponds to which {@code CityBuildingLevel}.
	 */
	private static final Map<CityBuildingLevel, MetaDataImage> SPRITES = new ValidatedEntriesHashMap<>();

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the {@link SpaceBar} city building are stored in this {@link Map}, with the
	 * {@link CityBuildingLevel} as key to denote which set of upgrade costs corresponds to which {@code CityBuildingLevel}.
	 */
	private static final Map<CityBuildingLevel, CurrencyTransaction> UPGRADE_COSTS = new ValidatedEntriesHashMap<>();


	static
	{
		NAMES.put(CityBuildingLevel.OLD, OLD_NAME);
		NAMES.put(CityBuildingLevel.NORMAL, NORMAL_NAME);
		NAMES.put(CityBuildingLevel.SUPER, SUPER_NAME);

		SPRITES.put(CityBuildingLevel.OLD, OLD_SPRITE);
		SPRITES.put(CityBuildingLevel.NORMAL, NORMAL_SPRITE);
		SPRITES.put(CityBuildingLevel.SUPER, SUPER_SPRITE);

		UPGRADE_COSTS.put(CityBuildingLevel.OLD, OLD_UPGRADE_COSTS);
		UPGRADE_COSTS.put(CityBuildingLevel.NORMAL, NORMAL_UPGRADE_COSTS);
		UPGRADE_COSTS.put(CityBuildingLevel.SUPER, CurrencyTransaction.EMPTY);

		// Create the singleton instance at last, so all maps are filled with values as the data in these maps is required to create an instance of this class.
		INSTANCE = new SpaceBar();
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static SpaceBar getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}

}
