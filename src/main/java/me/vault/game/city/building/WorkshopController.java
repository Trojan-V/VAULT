package me.vault.game.city.building;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.artifact.Artifact;
import me.vault.game.artifact.ArtifactController;
import me.vault.game.city.CityView;
import me.vault.game.currency.Currency;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;

public class WorkshopController implements Initializable
{
	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(WorkshopController.class.getSimpleName());

	@FXML
	private Button backToCityViewButton;

	@FXML
	private Label compositeAmountLabel;

	@FXML
	private ImageView compositeImageView;

	@FXML
	private Label creditAmountLabel;

	@FXML
	private ImageView creditImageView;

	@FXML
	private ImageView damageArtifactImageView;

	@FXML
	private Button damageArtifactUpgradeButton;

	@FXML
	private ImageView defenseArtifactImageView;

	@FXML
	private Button defenseArtifactUpgradeButton;

	@FXML
	private Label foodAmountLabel;

	@FXML
	private ImageView foodImageView;

	@FXML
	private ImageView healthArtifactImageView;

	@FXML
	private Button healthArtifactUpgradeButton;

	@FXML
	private Label scienceAmountLabel;

	@FXML
	private ImageView scienceImageView;

	@FXML
	private Label steelAmountLabel;

	@FXML
	private ImageView steelImageView;

	@FXML
	private ImageView workshopBackgroundImageView;


	@FXML
	private void onBackToCityView (final ActionEvent event)
	{
		CityView.show(VaultApplication.getStage());
	}


	@FXML
	private void onDamageArtifactUpgrade (final ActionEvent event)
	{
		ArtifactController.getInstance().upgrade(Artifact.DAMAGE);
	}


	@FXML
	private void onDefenseArtifactUpgrade (final ActionEvent event)
	{
		ArtifactController.getInstance().upgrade(Artifact.DEFENSE);
	}


	@FXML
	private void onHealthArtifactUpgrade (final ActionEvent event)
	{
		ArtifactController.getInstance().upgrade(Artifact.HEALTH);
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.workshopBackgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
		this.initCurrencies();
		this.bindArtifactViews();
	}


	private void bindArtifactViews ()
	{
		this.healthArtifactImageView.imageProperty().bind(Artifact.HEALTH.getCurrentProperties().getSprite());
		this.damageArtifactImageView.imageProperty().bind(Artifact.DAMAGE.getCurrentProperties().getSprite());
		this.defenseArtifactImageView.imageProperty().bind(Artifact.DEFENSE.getCurrentProperties().getSprite());
	}


	private void initCurrencies ()
	{
		CityBuildingController.initCurrency(Currency.STEEL, this.steelAmountLabel, this.steelImageView);
		CityBuildingController.initCurrency(Currency.COMPOSITE, this.compositeAmountLabel, this.compositeImageView);
		CityBuildingController.initCurrency(Currency.SCIENCE, this.scienceAmountLabel, this.scienceImageView);
		CityBuildingController.initCurrency(Currency.FOOD_RATION, this.foodAmountLabel, this.foodImageView);
		CityBuildingController.initCurrency(Currency.ENERGY_CREDIT, this.creditAmountLabel, this.creditImageView);
	}

}
