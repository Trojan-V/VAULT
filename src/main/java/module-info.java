/**
 * Exports all required modules to the JavaFX framework, so JavaFX is able to use these classes.
 */
module me.vault.game {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jetbrains.annotations;
	requires java.desktop;
	requires jdk.compiler;
	requires java.sql;
	requires com.google.gson;

	exports me.vault.game;
	exports me.vault.game.control;
	exports me.vault.game.model;
	exports me.vault.game.view;
	exports me.vault.game.utility;

	exports me.vault.game.model.arena;
	exports me.vault.game.model.artifact;
	exports me.vault.game.model.city;
	exports me.vault.game.model.currency;
	exports me.vault.game.model.energy;
	exports me.vault.game.model.gameboard;
	exports me.vault.game.model.network;
	exports me.vault.game.model.troop;

	exports me.vault.game.model.artifact.impl;
	exports me.vault.game.model.city.impl;
	exports me.vault.game.model.energy.impl;
	exports me.vault.game.model.gameboard.tile;
	exports me.vault.game.model.gameboard.tile.impl;
	exports me.vault.game.model.troop.impl;

	exports me.vault.game.utility.comparators;
	exports me.vault.game.utility.concurrency;
	exports me.vault.game.utility.datatypes;
	exports me.vault.game.utility.exception;
	exports me.vault.game.utility.fx;
	exports me.vault.game.utility.interfaces;
	exports me.vault.game.utility.jvm;
	exports me.vault.game.utility.logging;
	exports me.vault.game.utility.loading;
	exports me.vault.game.utility.math;

	exports me.vault.game.utility.interfaces.constant;

	exports me.vault.game.view.arena;
	exports me.vault.game.view.city;
	exports me.vault.game.view.menu;
	exports me.vault.game.view.mission;
	exports me.vault.game.view.newgame;

	exports me.vault.game.view.city.building;





	opens me.vault.game to javafx.fxml;
	opens me.vault.game.utility.loading to javafx.fxml, com.google.gson;
	opens me.vault.game.model.artifact to javafx.fxml;
	opens me.vault.game.model.currency to javafx.fxml;
	opens me.vault.game.model.artifact.impl to javafx.fxml;
	opens me.vault.game.view to javafx.fxml;
	opens me.vault.game.control to javafx.fxml;
	opens me.vault.game.model.city to javafx.fxml;
	opens me.vault.game.view.city to javafx.fxml;
	opens me.vault.game.view.city.building to javafx.fxml;
	opens me.vault.game.view.mission to javafx.fxml;
	opens me.vault.game.model.arena to javafx.fxml;
	opens me.vault.game.model.energy to javafx.fxml;
	opens me.vault.game.utility.fx to javafx.fxml;
	opens me.vault.game.model.gameboard to javafx.fxml;
	opens me.vault.game.model.gameboard.tile to javafx.fxml;
	opens me.vault.game.model.gameboard.tile.impl to javafx.fxml;
	opens me.vault.game.model.city.impl to javafx.fxml;
	opens me.vault.game.model to javafx.fxml;
	opens me.vault.game.utility to com.google.gson, javafx.fxml;
	opens me.vault.game.utility.math to com.google.gson, javafx.fxml;
	opens me.vault.game.view.arena to javafx.fxml;
	opens me.vault.game.view.menu to javafx.fxml;
	opens me.vault.game.view.newgame to javafx.fxml;
}