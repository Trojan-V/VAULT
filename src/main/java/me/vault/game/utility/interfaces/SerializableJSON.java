package me.vault.game.utility.interfaces;


import com.google.gson.Gson;


public interface SerializableJSON
{

	default String toJSON ()
	{
		return new Gson().toJson(this);
	}

}
