package me.vault.game.utility.fx;


import javafx.scene.image.ImageView;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;


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
