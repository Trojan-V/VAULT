/**
 * Exports all required modules to the JavaFX framework, so JavaFX is able to use these classes.
 */
module me.vault.game {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jetbrains.annotations;
	requires java.desktop;
	requires jdk.compiler;

	exports me.vault.game;
	exports me.vault.game.model.artifact;
	exports me.vault.game.interfaces;
	exports me.vault.game.model.currency;
	exports me.vault.game.utility.struct;
	exports me.vault.game.exception;
	exports me.vault.game.model.player;
	exports me.vault.game.model.troop.unit;
	exports me.vault.game.utility.constant;
	exports me.vault.game.utility.jvm;
	exports me.vault.game.utility.logging;
	exports me.vault.game.utility.loading;
	exports me.vault.game.model.artifact.impl;
	exports me.vault.game.view;
	exports me.vault.game.control;
	exports me.vault.game.model.building;
	exports me.vault.game.view.city.buildings;
	exports me.vault.game.view.city;
	exports me.vault.game.model.city;
	exports me.vault.game.model.mission;
	exports me.vault.game.model.encounter;

	opens me.vault.game to javafx.fxml;
	opens me.vault.game.utility.loading to javafx.fxml;
	opens me.vault.game.model.artifact to javafx.fxml;
	opens me.vault.game.model.currency to javafx.fxml;
	opens me.vault.game.model.artifact.impl to javafx.fxml;
	opens me.vault.game.view to javafx.fxml;
	opens me.vault.game.control to javafx.fxml;
	opens me.vault.game.model.building to javafx.fxml;
	opens me.vault.game.model.city to javafx.fxml;
	opens me.vault.game.view.city to javafx.fxml;
	opens me.vault.game.view.city.buildings to javafx.fxml;
	opens me.vault.game.model.mission to javafx.fxml;
	exports me.vault.game.model.troop;

}