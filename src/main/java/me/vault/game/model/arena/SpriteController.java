package me.vault.game.model.arena;


import me.vault.game.interfaces.Placable;

import java.awt.*;
import java.util.HashMap;


public class SpriteController
{
	private final SpriteController instance = null;


	private final HashMap<Placable, Image> sprites = new HashMap<>();


	private SpriteController ()
	{

	}


	public SpriteController getInstance ()
	{
		if (this.instance == null)
		{
			return new SpriteController();
		}
		return this.instance;
	}


	private void initialize ()
	{
	}

}
