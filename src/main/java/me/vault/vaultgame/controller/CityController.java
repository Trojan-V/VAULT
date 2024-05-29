package me.vault.vaultgame.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public final class CityController
{
	@FXML
	private Button barracksButton;


	@FXML
	private ImageView cityBackgroundImageView;


	@FXML
	private Button commandCenterButton;


	@FXML
	private ImageView compositeImageView;


	@FXML
	private Label compositeLabel;


	@FXML
	private ImageView creditImageView;


	@FXML
	private Label creditLabel;


	@FXML
	private Button docksButton;


	@FXML
	private ImageView foodImageView;


	@FXML
	private Label foodLabel;


	@FXML
	private Button laboratoryButton;


	@FXML
	private Button marketButton;


	@FXML
	private ImageView scienceImageView;


	@FXML
	private Label scienceLabel;


	@FXML
	private Button spaceBarButton;


	@FXML
	private ImageView steelImageView;


	@FXML
	private Label steelLabel;


	@FXML
	private Button trainingfacilityButton;


	@FXML
	private Button workshopButton;


	@FXML
	void onBarracksButtonClick (final ActionEvent event)
	{
		this.creditLabel.setText("Klappt");
	}


	@FXML
	void onCommandCenterButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onDocksButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onLaboratoryButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onMarketButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onSpaceBarButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onTrainingsFacilityButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onWorkshopButtonClick (final ActionEvent event)
	{

	}
}
