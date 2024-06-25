package me.vault.game.view.city.buildings;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.constant.CharacterConstants;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.CLASS_INITIALISED;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@code MarketDelegate} handles the control and view of the {@link me.vault.game.model.city.Market} city building.
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * On the other hand, it provides methods to control the model to the {@link me.vault.game.model.city.Market} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see me.vault.game.model.city.Market
 * @since 11.06.2024
 */
public class MarketDelegate extends CityBuildingController implements Initializable
{

	// CONSTANTS -------------------------------------------------------------------------------------------------------

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MarketDelegate.class.getSimpleName());

	private static final int STEEL_PRICE = 50;

	private static final int COMPOSITE_PRICE = 50;

	private static final int SCIENCE_PRICE = 50;

	private static final int FOOD_PRICE = 50;

	private static final ObservableValue<String> STEEL_PROMPT = new SimpleStringProperty(STEEL_PRICE + "-1 Rate");

	private static final ObservableValue<String> COMPOSITE_PROMPT = new SimpleStringProperty(COMPOSITE_PRICE + "-1 Rate");

	private static final ObservableValue<String> SCIENCE_PROMPT = new SimpleStringProperty(SCIENCE_PRICE + "-1 Rate");

	private static final ObservableValue<String> FOOD_PROMPT = new SimpleStringProperty(FOOD_PRICE + "-1 Rate");


	// FXML ------------------------------------------------------------------------------------------------------------

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane mainPane;

	@FXML
	private TextField compositeInputField;

	@FXML
	private TextField compositeOutputField;

	@FXML
	private TextField foodInputField;

	@FXML
	private TextField foodOutputField;

	@FXML
	private TextField scienceInputField;

	@FXML
	private TextField scienceOutputField;

	@FXML
	private TextField steelInputField;

	@FXML
	private TextField steelOutputField;


	@FXML
	void onCompositeInputChanged (final KeyEvent ignored)
	{
		this.compositeOutputField.setText(
			this.convertInputToAmountString(this.compositeInputField, COMPOSITE_PRICE));
	}


	@FXML
	void onSteelInputChanged (final KeyEvent ignored)
	{
		this.steelOutputField.setText(
			this.convertInputToAmountString(this.steelInputField, STEEL_PRICE));
	}


	@FXML
	void onFoodInputChanged (final KeyEvent ignored)
	{
		this.foodOutputField.setText(
			this.convertInputToAmountString(this.foodInputField, FOOD_PRICE));

	}


	@FXML
	void onScienceInputChanged (final KeyEvent ignored)
	{
		this.scienceOutputField.setText(
			this.convertInputToAmountString(this.scienceInputField, SCIENCE_PRICE));

	}


	@FXML
	void onCompositeTrade (final ActionEvent ignored)
	{
		this.factorMarketTradeIntoCurrency(this.compositeInputField, Currency.COMPOSITE, COMPOSITE_PRICE);
		this.compositeInputField.setText(CharacterConstants.EMPTY_STRING);
		this.compositeOutputField.setText(CharacterConstants.EMPTY_STRING);
	}


	@FXML
	void onFoodTrade (final ActionEvent ignored)
	{
		this.factorMarketTradeIntoCurrency(this.foodInputField, Currency.FOOD_RATION, FOOD_PRICE);
		this.foodInputField.setText(CharacterConstants.EMPTY_STRING);
		this.foodOutputField.setText(CharacterConstants.EMPTY_STRING);
	}


	@FXML
	void onScienceTrade (final ActionEvent ignored)
	{
		this.factorMarketTradeIntoCurrency(this.scienceInputField, Currency.SCIENCE, SCIENCE_PRICE);
		this.scienceInputField.setText(CharacterConstants.EMPTY_STRING);
		this.scienceOutputField.setText(CharacterConstants.EMPTY_STRING);
	}


	@FXML
	void onSteelTrade (final ActionEvent ignored)
	{
		this.factorMarketTradeIntoCurrency(this.steelInputField, Currency.STEEL, STEEL_PRICE);
		this.steelInputField.setText(CharacterConstants.EMPTY_STRING);
		this.steelOutputField.setText(CharacterConstants.EMPTY_STRING);
	}


	/**
	 * Method, that gets called when the user presses the "BACK"-Button. Resets the current view to the city view.
	 *
	 * @param ignored {@link ActionEvent}-parameter, that contains information about the event-caller.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties.
	 *
	 * @param url            The {@link URL} object, which represents the fxml-file of the view.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());

		this.foodOutputField.promptTextProperty().bind(FOOD_PROMPT);
		this.steelOutputField.promptTextProperty().bind(STEEL_PROMPT);
		this.compositeOutputField.promptTextProperty().bind(COMPOSITE_PROMPT);
		this.scienceOutputField.promptTextProperty().bind(SCIENCE_PROMPT);

		// Logging the finalization of the initialization
		LOGGER.logf(DEBUG, CLASS_INITIALISED, MarketDelegate.class.getSimpleName());
	}


	private void factorMarketTradeIntoCurrency (final TextField textField, final Currency currency, final int price)
	{
		try
		{
			final String amountString = textField.getText();
			final int inputAmount = Integer.parseInt(amountString);
			CurrencyController.factorCurrencyTransaction(Currency.ENERGY_CREDIT, -inputAmount);
			CurrencyController.factorCurrencyTransaction(currency, inputAmount / price);
		}
		catch (final NumberFormatException e)
		{
			System.out.println(e.getMessage());
		}
	}


	private String convertInputToAmountString (final TextField inputField, final int price)
	{
		try
		{
			return String.valueOf(Integer.parseInt(inputField.getText()) / price);
		}
		catch (final NumberFormatException e)
		{
			return "Incorrect input";
		}
	}

}
