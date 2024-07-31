package me.vault.game.utility.fx;


import javafx.scene.image.ImageView;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;

// TODO: Complete JavaDoc needed


public class SelectedTroopImageView extends ImageView
{

	private static final MetaDataImage PLACEHOLDER_IMAGE = ResourceLoader.loadImage(GameConstants.WINDOW_ICON_PATH);


	public SelectedTroopImageView ()
	{
		this.setImage(PLACEHOLDER_IMAGE);
		this.setFitWidth(150);
		this.setFitHeight(150);
	}


	public static MetaDataImage getPlaceholderImage ()
	{
		return PLACEHOLDER_IMAGE;
	}

}
