package me.vault.game.utility.fx;


import javafx.beans.binding.NumberExpression;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.energy.AbilityMultiplier;
import org.jetbrains.annotations.NotNull;


public final class MultiplierVBox extends VBox
{

	private static final int FONT_SIZE = 20;

	private static final int SPACING = 15;

	private static final int PREF_WIDTH = 100;

	private static final int PADDING = 15;


	public MultiplierVBox (final AbilityMultiplier abilityMultiplier)
	{
		this.setPrefWidth(PREF_WIDTH);
		this.setSpacing(SPACING);
		this.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));

		final Label dodgeMultiplierLabel = getAbilityMultiplierLabel(abilityMultiplier.getDodgeMultiplierProperty());
		final Label initiativeMultiplierLabel = getAbilityMultiplierLabel(abilityMultiplier.getInitiativeMultiplierProperty());
		final Label meleeMultiplierLabel = getAbilityMultiplierLabel(abilityMultiplier.getMeleeMultiplierProperty());

		this.getChildren().add(dodgeMultiplierLabel);
		this.getChildren().add(initiativeMultiplierLabel);
		this.getChildren().add(meleeMultiplierLabel);
	}


	public MultiplierVBox (final AttributeMultiplier abilityMultiplier)
	{
		this.setPrefWidth(PREF_WIDTH);
		this.setSpacing(SPACING);
		this.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));

		final Label dodgeMultiplierLabel = getAbilityMultiplierLabel(abilityMultiplier.getHealthMultiplierProperty());
		final Label initiativeMultiplierLabel = getAbilityMultiplierLabel(abilityMultiplier.getDamageMultiplierProperty());
		final Label meleeMultiplierLabel = getAbilityMultiplierLabel(abilityMultiplier.getDefenseMultiplierProperty());

		this.getChildren().add(dodgeMultiplierLabel);
		this.getChildren().add(initiativeMultiplierLabel);
		this.getChildren().add(meleeMultiplierLabel);
	}


	@NotNull
	private static Label getAbilityMultiplierLabel (final NumberExpression abilityMultiplier)
	{
		final Label dodgeMultiplierLabel = new Label();
		dodgeMultiplierLabel.setFont(new Font(FONT_SIZE));
		dodgeMultiplierLabel.textProperty().bind(abilityMultiplier.asString());
		return dodgeMultiplierLabel;
	}

}
