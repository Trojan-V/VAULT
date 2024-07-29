package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.city.Barracks;
import me.vault.game.model.city.Market;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.constant.CharacterConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.CLASS_INITIALIZED;
import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@code MarketDelegate} handles the control and view of the {@link Market} city building.
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * On the other hand, it provides methods to control the model to the {@link Market} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see Market
 * @since 11.06.2024
 */
public class MarketDelegate extends CityBuildingController implements Initializable
{
	// CONSTANTS -------------------------------------------------------------------------------------------------------

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(MarketDelegate.class.getSimpleName());


	/**
	 * The {@link Scene} of the {@link Market} city building, which is extracted from the related .fxml-file with the
	 * {@link ResourceLoader} class.
	 */
	private static final Scene SCENE = ResourceLoader.loadScene(Market.class, "market_view.fxml");

	private static final int STEEL_PRICE = 50;

	private static final int COMPOSITE_PRICE = 50;

	private static final int SCIENCE_PRICE = 50;

	private static final int FOOD_PRICE = 50;


	private static final String STEEL_PROMPT = STEEL_PRICE + "-1 Rate";


	private static final String COMPOSITE_PROMPT = COMPOSITE_PRICE + "-1 Rate";


	private static final String SCIENCE_PROMPT = SCIENCE_PRICE + "-1 Rate";


	private static final String FOOD_PROMPT = FOOD_PRICE + "-1 Rate";


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


	public static void show ()
	{
		// Loading the FXML-File and creating a scene from the loaded components
		GameApplication.getStage().setScene(SCENE);
		GameApplication.getStage().show();

		// Logging the display of the building
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, Barracks.getInstance().getName()));
	}


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
		CityDelegate.show(GameApplication.getStage());
	}


	private void factorMarketTradeIntoCurrency (final TextField textField, final Currency currency, final int price)
	{
		try
		{
			final String amountString = textField.getText();
			final int inputAmount = Integer.parseInt(amountString);
			CurrencyController.factorCurrency(Currency.ENERGY_CREDIT, -inputAmount);
			CurrencyController.factorCurrency(currency, inputAmount / price);
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
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());

		this.foodOutputField.promptTextProperty().set(FOOD_PROMPT);
		this.steelOutputField.promptTextProperty().set(STEEL_PROMPT);
		this.compositeOutputField.promptTextProperty().set(COMPOSITE_PROMPT);
		this.scienceOutputField.promptTextProperty().set(SCIENCE_PROMPT);

		// Logging the finalization of the initialization
		LOGGER.logf(DEBUG, CLASS_INITIALIZED, MarketDelegate.class.getSimpleName());
	}

}
