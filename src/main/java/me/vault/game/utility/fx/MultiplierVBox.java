package me.vault.game.utility.fx;


import javafx.beans.binding.NumberExpression;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.energy.AbilityMultiplier;
import org.jetbrains.annotations.NotNull;


/**
 * The {@code MultiplierVBox} is used to display the values of various Multipliers throughout the game.
 * It extends the standard {@link VBox} and automatically initializes the right graphic and design based on the multiplier object, which is parsed
 * into the constructor.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see VBox
 * @see AttributeMultiplier
 * @see AbilityMultiplier
 * @since 25.06.2024
 */
public final class MultiplierVBox extends VBox
{

	/**
	 * The font size of the labels withing the {@link MultiplierVBox}
	 */
	private static final int FONT_SIZE = 20;

	/**
	 * The spacing of the {@link MultiplierVBox}
	 */
	private static final int SPACING = 15;

	/**
	 * The preferred width of the {@link MultiplierVBox}
	 */
	private static final int PREF_WIDTH = 100;

	/**
	 * The padding of the {@link MultiplierVBox}
	 */
	private static final int PADDING = 15;


	/**
	 * Constructs a new instance of this class with the passed parameters.
	 *
	 * @param abilityMultiplier The {@link AbilityMultiplier} object, whose values are added to the vbox.
	 *
	 * @precondition The constructor gets called and the parameter is != null.
	 * @postcondition A new instance of this class was created.
	 */
	public MultiplierVBox (final AbilityMultiplier abilityMultiplier)
	{
		this.setPrefWidth(PREF_WIDTH);
		this.setSpacing(SPACING);
		this.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));

		final Label dodgeMultiplierLabel = createMultiplierLabel(abilityMultiplier.getDodgeMultiplierProperty());
		final Label initiativeMultiplierLabel = createMultiplierLabel(abilityMultiplier.getInitiativeMultiplierProperty());
		final Label meleeMultiplierLabel = createMultiplierLabel(abilityMultiplier.getMeleeMultiplierProperty());

		this.getChildren().add(dodgeMultiplierLabel);
		this.getChildren().add(initiativeMultiplierLabel);
		this.getChildren().add(meleeMultiplierLabel);
	}


	/**
	 * Constructs a new instance of this class with the passed parameters.
	 *
	 * @param attributeMultiplier The {@link AttributeMultiplier} object, whose values are added to this vbox.
	 *
	 * @precondition The constructor gets called and the parameter is != null.
	 * @postcondition A new instance of this class was created.
	 */
	public MultiplierVBox (final AttributeMultiplier attributeMultiplier)
	{
		this.setPrefWidth(PREF_WIDTH);
		this.setSpacing(SPACING);
		this.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));

		final Label dodgeMultiplierLabel = createMultiplierLabel(attributeMultiplier.getHealthMultiplierProperty());
		final Label initiativeMultiplierLabel = createMultiplierLabel(attributeMultiplier.getDamageMultiplierProperty());
		final Label meleeMultiplierLabel = createMultiplierLabel(attributeMultiplier.getDefenseMultiplierProperty());

		this.getChildren().add(dodgeMultiplierLabel);
		this.getChildren().add(initiativeMultiplierLabel);
		this.getChildren().add(meleeMultiplierLabel);
	}


	/**
	 * Creates a {@link Label} that is bound to the value of a passed {@link NumberExpression}.
	 *
	 * @param abilityMultiplier The {@link NumberExpression} whose value will be bound to the {@link Label}.
	 *
	 * @return A {@link Label}, which has its text property bound to the value of the {@link NumberExpression}.
	 *
	 * @precondition A valid NumberExpression != null is passed into the method.
	 * @postcondition A {@link Label} with a bound text property was returned.
	 */
	@NotNull
	private static Label createMultiplierLabel (final NumberExpression abilityMultiplier)
	{
		final Label dodgeMultiplierLabel = new Label();
		dodgeMultiplierLabel.setFont(new Font(FONT_SIZE));
		dodgeMultiplierLabel.textProperty().bind(abilityMultiplier.asString());
		return dodgeMultiplierLabel;
	}

}
