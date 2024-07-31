package me.vault.game.utility.fx;


import javafx.scene.image.ImageView;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.mission.TroopSelectionDelegate;


/**
 * The {@code SelectedTroopImageView} represents one image view in the troop selection view.
 * It extends the standard {@link ImageView} and automatically initializes the right graphic and design.
 * The {@code SelectedTroopImageView} is mainly used in the troop selection view and handles the display of the already selected troops.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see ImageView
 * @see Troop
 * @see TroopSelectionDelegate
 * @since 25.06.2024
 */
public final class SelectedTroopImageView extends ImageView
{

	/**
	 * A {@link MetaDataImage} which is displayed in this class if no troop has been selected.
	 */
	private static final MetaDataImage PLACEHOLDER_IMAGE = ResourceLoader.loadImage(GameConstants.WINDOW_ICON_PATH);

	/**
	 * The size/side length of the {@link SelectedTroopImageView}
	 */
	private static final int SIZE = 150;


	/**
	 * Constructs a new instance of this class.
	 *
	 * @precondition The constructor gets called.
	 * @postcondition A new instance of this class was created.
	 */
	public SelectedTroopImageView ()
	{
		this.setImage(PLACEHOLDER_IMAGE);
		this.setFitWidth(SIZE);
		this.setFitHeight(SIZE);
	}


	/**
	 * Returns the placeholder image from this class.
	 *
	 * @return A {@link MetaDataImage} that represents the placeholder image.
	 *
	 * @precondition The method gets called and the resource loader successfully created the class variable.
	 * @postcondition The {@link MetaDataImage} that represents the placeholder image was returned.
	 */
	static MetaDataImage getPlaceholderImage ()
	{
		return PLACEHOLDER_IMAGE;
	}

}
