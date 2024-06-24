package me.vault.game.model.mission;


import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import me.vault.game.view.ViewUtil;


public class TileButton extends Button
{

	private static final int IMAGE_VIEW_FITHEIGTH = 35;


	private static final int IMAGE_VIEW_FIT_WIDTH = 35;


	private MapObject mapObject;

	private ImageView spriteImageView;


	public TileButton (final MapObject mapObject)
	{
		this.mapObject = mapObject;
		this.spriteImageView = new ImageView(mapObject.getSprite());
		this.spriteImageView.setPreserveRatio(false);
		this.spriteImageView.setFitWidth(IMAGE_VIEW_FIT_WIDTH);
		this.spriteImageView.setFitHeight(IMAGE_VIEW_FITHEIGTH);
		super.setGraphic(this.spriteImageView);
	}


	public MapObject getMapObject ()
	{
		return this.mapObject;
	}


	public void setMapObject (final MapObject mapObject)
	{
		this.mapObject = mapObject;
		this.spriteImageView = new ImageView(mapObject.getSprite());
		ViewUtil.setButtonImageView(this, this.spriteImageView);
	}

}
