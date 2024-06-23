package me.vault.game.model.mission;


import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


public class TileButton extends Button
{

	private MapObject mapObject;

	private ImageView spriteImageView;


	public TileButton (final MapObject mapObject)
	{
		this.mapObject = mapObject;
		this.spriteImageView = new ImageView(mapObject.getSprite());
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
		super.setGraphic(this.spriteImageView);
	}

}
