package me.vault.game.utility.fx;


import javafx.scene.control.Button;
// TODO: Complete JavaDoc needed


public final class TroopUnselectButton extends Button
{

	private static final int WIDTH = 190;

	private static final int HEIGHT = 40;

	private static final String TEXT = "Unselect unit...";


	public TroopUnselectButton ()
	{
		this.setText(TEXT);
		this.setDisable(true);
		this.setMinSize(WIDTH, HEIGHT);
	}

}
