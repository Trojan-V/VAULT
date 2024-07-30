package me.vault.game.utility.fx;


import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import me.vault.game.model.energy.AbilityMultiplier;


public final class ModifierVBox extends VBox
{

	public ModifierVBox (final AbilityMultiplier abilityMultiplier)
	{
		final Label dodgeMultiplierLabel = new Label();
		dodgeMultiplierLabel.textProperty().bind(abilityMultiplier.getDodgeMultiplierProperty().asString());

		final Label initiativeMultiplierLabel = new Label();
		initiativeMultiplierLabel.textProperty().bind(abilityMultiplier.getInitiativeMultiplierProperty().asString());

		final Label meleeMultiplierLabel = new Label();
		meleeMultiplierLabel.textProperty().bind(abilityMultiplier.getMeleeMultiplierProperty().asString());

		this.getChildren().add(dodgeMultiplierLabel);
		this.getChildren().add(initiativeMultiplierLabel);
		this.getChildren().add(meleeMultiplierLabel);
	}

}
