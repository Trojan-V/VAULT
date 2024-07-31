package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.model.city.impl.Market;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.interfaces.constant.CharacterConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.CurrencyDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.CityBuildingConstants.Market.*;


/**
 * The {@code MarketDelegate} handles the control and view of the {@link Market} city building.
 * <br>
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * <br>
 * On the other hand, it provides methods to control the model to the {@link Market} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuildingController
 * @see Initializable
 * @see Market
 * @since 11.06.2024
 */
public final class MarketDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MarketDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String MARKET_VIEW_FXML = "market_view.fxml";

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "MarketDelegate'{'fxml={0}'}'";

	/**
	 * Prompt, which gets displayed in the {@link TextField}s if the input amount couldn't be converted.
	 */
	private static final String INVALID_INPUT_PROMPT = "Invalid input, can't factor currency";

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane mainPane;

	/**
	 * The {@link TextField} for the input of the trade for {@link Currency#COMPOSITE}.
	 */
	@FXML
	private TextField compositeInputField;

	/**
	 * The {@link TextField} for the output of the trade for {@link Currency#COMPOSITE}.
	 */
	@FXML
	private TextField compositeOutputField;

	/**
	 * The {@link TextField} for the input of the trade for {@link Currency#FOOD_RATION}.
	 */
	@FXML
	private TextField foodInputField;

	/**
	 * The {@link TextField} for the output of the trade for {@link Currency#FOOD_RATION}.
	 */
	@FXML
	private TextField foodOutputField;

	/**
	 * The {@link TextField} for the input of the trade for {@link Currency#SCIENCE}.
	 */
	@FXML
	private TextField scienceInputField;

	/**
	 * The {@link TextField} for the output of the trade for {@link Currency#SCIENCE}.
	 */
	@FXML
	private TextField scienceOutputField;

	/**
	 * The {@link TextField} for the input of the trade for {@link Currency#STEEL}.
	 */
	@FXML
	private TextField steelInputField;

	/**
	 * The {@link TextField} for the output of the trade for {@link Currency#STEEL}.
	 */
	@FXML
	private TextField steelOutputField;


	/**
	 * Calls a method to display the content stored in {@link MarketDelegate#MARKET_VIEW_FXML} and initialized
	 * by {@link MarketDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized view is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(MarketDelegate.class, MARKET_VIEW_FXML), MarketDelegate.class);
	}


	/**
	 * Factors the trade into the global currency values.
	 *
	 * @param textField The {@link TextField} for the input of the trade
	 * @param currency  The traded {@link Currency} of the trade.
	 * @param price     The price of the traded {@link Currency}.
	 *
	 * @precondition The passed {@link TextField} has been initialized and its text can be converted to an integer.
	 * @postcondition The trade was converted and factored into the global currency values.
	 */
	private void factorMarketTradeIntoCurrency (final TextField textField, final Currency currency, final int price)
	{
		try
		{
			final String amountString = textField.getText();
			final int inputAmount = Integer.parseInt(amountString);
			CurrencyDelegate.factorCurrency(Currency.ENERGY_CREDIT, -inputAmount);
			CurrencyDelegate.factorCurrency(currency, inputAmount / price);
		}
		catch (final NumberFormatException e)
		{
			LOGGER.log(ILogger.Level.WARNING, INVALID_INPUT_PROMPT);
		}
	}


	/**
	 * Calculates the output amount of a trade by dividing the text of the passed {@link TextField} by the price of the currency
	 * and checking the user credits for the available amount.
	 *
	 * @param inputField The {@link TextField} whose input is the input amount for the trade.
	 * @param price      The price of the {@link Currency} which is traded
	 *
	 * @return A String that represents the output amount of the trade.
	 *
	 * @precondition The {@link TextField} has been initialized the text of the {@link TextField} could be converted to an integer.
	 * @postcondition The calculated output amount of the input Currency has been returned.
	 */
	private String calculateOutputString (final TextField inputField, final int price)
	{
		try
		{
			final int creditCost = Integer.parseInt(inputField.getText());
			if (Currency.ENERGY_CREDIT.getAmount() >= creditCost)
			{
				return String.valueOf(creditCost / price);
			}
			return INVALID_INPUT_PROMPT;

		}
		catch (final NumberFormatException e)
		{
			return INVALID_INPUT_PROMPT;
		}
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainPane.getChildren().add(CurrencyDelegate.getCurrencyBannerScene().getRoot());
		this.foodOutputField.promptTextProperty().set(FOOD_PROMPT);
		this.steelOutputField.promptTextProperty().set(STEEL_PROMPT);
		this.compositeOutputField.promptTextProperty().set(COMPOSITE_PROMPT);
		this.scienceOutputField.promptTextProperty().set(SCIENCE_PROMPT);
	}


	/**
	 * Handles the {@code InputChanged}-{@link KeyEvent} of the "Composite Input" {@link TextField} in the GUI.
	 * Updates the output preview in the corresponding output text field and displays a message if the conversion isn't possible.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The corresponding output text field displays the correct amount for the output amount after conversion.
	 */
	@FXML
	void onCompositeInputChanged (final KeyEvent ignored)
	{
		this.compositeOutputField.setText(this.calculateOutputString(this.compositeInputField, COMPOSITE_PRICE));
	}


	/**
	 * Handles the {@code InputChanged}-{@link KeyEvent} of the "Steel Input" {@link TextField} in the GUI.
	 * Updates the output preview in the corresponding output text field and displays a message if the conversion isn't possible.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The corresponding output text field displays the correct amount for the output amount after conversion.
	 */
	@FXML
	void onSteelInputChanged (final KeyEvent ignored)
	{
		this.steelOutputField.setText(this.calculateOutputString(this.steelInputField, STEEL_PRICE));
	}


	/**
	 * Handles the {@code InputChanged}-{@link KeyEvent} of the "Food Input" {@link TextField} in the GUI.
	 * Updates the output preview in the corresponding output text field and displays a message if the conversion isn't possible.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The corresponding output text field displays the correct amount for the output amount after conversion.
	 */
	@FXML
	void onFoodInputChanged (final KeyEvent ignored)
	{
		this.foodOutputField.setText(this.calculateOutputString(this.foodInputField, FOOD_PRICE));
	}


	/**
	 * Handles the {@code InputChanged}-{@link KeyEvent} of the "Science Input" {@link TextField} in the GUI.
	 * Updates the output preview in the corresponding output text field and displays a message if the conversion isn't possible.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The corresponding output text field displays the correct amount for the output amount after conversion.
	 */
	@FXML
	void onScienceInputChanged (final KeyEvent ignored)
	{
		this.scienceOutputField.setText(this.calculateOutputString(this.scienceInputField, SCIENCE_PRICE));
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Trade Composite" {@link Button} in the GUI.
	 * Refreshes the input and output text fields and factors the trade values into the currencies of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The input and output text fields and factors are refreshed, and the trade values have been factored into the currencies of the user.
	 */
	@FXML
	void onCompositeTrade (final ActionEvent ignored)
	{
		this.factorMarketTradeIntoCurrency(this.compositeInputField, Currency.COMPOSITE, COMPOSITE_PRICE);
		this.compositeInputField.setText(CharacterConstants.EMPTY_STRING);
		this.compositeOutputField.setText(CharacterConstants.EMPTY_STRING);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Trade Food" {@link Button} in the GUI.
	 * Refreshes the input and output text fields and factors the trade values into the currencies of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The input and output text fields and factors are refreshed, and the trade values have been factored into the currencies of the user.
	 */
	@FXML
	void onFoodTrade (final ActionEvent ignored)
	{
		this.factorMarketTradeIntoCurrency(this.foodInputField, Currency.FOOD_RATION, FOOD_PRICE);
		this.foodInputField.setText(CharacterConstants.EMPTY_STRING);
		this.foodOutputField.setText(CharacterConstants.EMPTY_STRING);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Trade Science" {@link Button} in the GUI.
	 * Refreshes the input and output text fields and factors the trade values into the currencies of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The input and output text fields and factors are refreshed, and the trade values have been factored into the currencies of the user.
	 */
	@FXML
	void onScienceTrade (final ActionEvent ignored)
	{
		this.factorMarketTradeIntoCurrency(this.scienceInputField, Currency.SCIENCE, SCIENCE_PRICE);
		this.scienceInputField.setText(CharacterConstants.EMPTY_STRING);
		this.scienceOutputField.setText(CharacterConstants.EMPTY_STRING);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Trade Steel" {@link Button} in the GUI.
	 * Refreshes the input and output text fields and factors the trade values into the currencies of the user.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The input and output text fields and factors are refreshed, and the trade values have been factored into the currencies of the user.
	 */
	@FXML
	void onSteelTrade (final ActionEvent ignored)
	{
		this.factorMarketTradeIntoCurrency(this.steelInputField, Currency.STEEL, STEEL_PRICE);
		this.steelInputField.setText(CharacterConstants.EMPTY_STRING);
		this.steelOutputField.setText(CharacterConstants.EMPTY_STRING);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Back" {@link Button} in the GUI.
	 * Shows the scene of the {@link CityDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link CityDelegate}.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link MarketDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link MarketDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link MarketDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, MARKET_VIEW_FXML);
	}

}
