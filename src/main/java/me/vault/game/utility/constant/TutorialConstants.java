package me.vault.game.utility.constant;


import me.vault.game.view.TutorialDelegate;


/**
 * This interface provides {@link String}s that contain the texts used in the tutorial.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 *
 * @see TutorialDelegate
 * @since 30.07.2024
 */
public interface TutorialConstants
{

	/**
	 * The {@link String} that contains the introduction text for the tutorial.
	 */
	String TUTORIAL_INTRODUCTION = """
		Hello dear player, first thank you for playing our little game. In the following tabs you can read the tutorials of the integral parts \
		of the game. They describe what certain things are for and how the mechanics of this game work in a capacity that helps you understand \
		how one can approach the game.""";


	/**
	 * The {@link String} that contains the tutorial text for the city.
	 */
	String TUTORIAL_CITY = """
		The City is the main hub. At the top of the screen, the current amount of resources one has in its possession is displayed. Below that there are the \
		buildings of the space station. There are the barracks for the own faction, the docks and the space-bar for the other three factions, where one can \
		recruit troops of the different faction, unlocked through missions or are unlocked from the start. The command center is where one selects the mission\
		 to play. The market can be used to exchange resources with each other if there isn't enough to do something, and one doesn't want to play a mission. \
		Lastly, the training facility, workshop and the laboratory are there for upgrades. In the training facility, one can upgrade unlocked troops. The \
		workshop improves the collected artifacts that one possesses and the laboratory can upgrade the ability of you, the player.""";


	/**
	 * The {@link String} that contains the tutorial text for the artefacts.
	 */
	String TUTORIAL_ARTIFACTS = """
		Artifacts are mysterious pieces of equipment that were left behind by the Hitani and survived the tests of time. These strange pieces of \
		equipment seem to affect troops in battle positively. Artifacts are selected by the player per mission and buff damage, defense or health \
		for the troops that go one that mission.""";


	/**
	 * The {@link String} that contains the tutorial text for the factions.
	 */
	String TUTORIAL_FACTIONS = """
		In the system, there are three factions besides to player-faction. The troops of the factions can be used through different means and at \
		different points in the game. At the same time, these factions also pose as the enemy combatants in the game, so it does pay off to learn \
		more about these once your in the game proper.""";


	/**
	 * The {@link String} that contains the tutorial text for the missions.
	 */
	String TUTORIAL_MISSIONS = """
		The missions in this game are divided in two categories. The first kind of missions are the story-missions. In these missions, you drive the \
		story forward and get special rewards which one can't get in the other category of missions. The other category of missions is the repeatable \
		missions in which one can get the necessary resources for upgrades. In the missions you move on a map where you collect resources, troops and have \
		to fight an enemy.""";


	/**
	 * The {@link String} that contains the tutorial text for the fights.
	 */
	String TUTORIAL_FIGHTS = """
		When you encounter enemies on the mission-map, you enter a fight. Fights in this game is turn-based and works on twelve times twelve grid with various \
		environment-based obstacles. After a troop attacks a hostile entity, a twenty-sided dice is thrown to determine if the troop hits or if the \
		defendant hostile can dodge the attack. If an attack lands, the damage that is done is modified by the armor or resistance of the defending troop. \
		The movement range determines how many tiles a unit can once and damage, and the grenade range determines how great the distance there can be between \
		the attacker and the defender. If a troop is down to zero health, it's out of combat.""";

}
