package me.vault.game.utility.constant;


public interface StringConstants
{

	/**
	 * This string contains the text for the story of the game.
	 */
	String prologue = "The year is 2341 and humanity has spread across the galaxy over the last few " +
	                  "centuries. During this time, many new systems have been explored and scientific" + " " +
	                  "discoveries have been made. One of the most relevant discoveries has been the " +
	                  "single-celled existence of a technologically advanced civilization, the Hitani," + " " +
	                  "who've developed, among other things, an extensive galactic teleportation " +
	                  "system. With the development of this technology, humans were able to discover " +
	                  "and explore other systems. Recently, a new solar system, Proxima Tau, was " +
	                  "discovered and a mission led by the player was dispatched to explore these new " +
	                  "worlds. When the team arrives at Proxima Tau, they discover that they are on a " +
	                  "Hitanian space station. As with many systems explored in the past, Proxima Tau " +
	                  "was already populated. But the team soon discovered a serious problem. The " +
	                  "transportation system that the team relied on for their return journey had " + "malfunctioned and needed to be repaired.";


	/**
	 * The following Strings contains the texts for the artifacts. There used in the laboratory and workshop.
	 */
	String HEALTH_ARTIFACT = "An artifact which improves the health and vitality of your troops.";

	String DAMAGE_ARTIFACT = "An artifact which improves the attacks of all your troops.";

	String DEFENCE_ARTIFACT = "An artifact which improves the defense attribute of your troops.";

	/**
	 * The following Strings describe to the Player what the mission entails.
	 */

	String STORY_MISSION_ONE = "Collect blueprints - This mission involves searching for the " +
	                           "blueprints for the broken transport system. You will need these later " +
	                           "to repair the system and find a way home. During the mission you can " + "get science and artifacts.";

	String STORY_MISSION_TWO = "Extract VIP - In this mission, a group of people must be rescued after" + " " +
	                           "the transportation system is operational again. This mission is the " +
	                           "last one in the game. After completing the mission, the game ends.";

	String REPEATABLE_MISSION_ONE =
		"Material procurement - The purpose of this mission is to give the" + " " + "player resources to unlock and upgrade buildings, recruit " +
		"mercenaries, etc. On this mission you will find all steel, " + "composites, food rations, energy credits.";

	String REPEATABLE_MISSION_TWO =
		"Raid - In the Raid mission, the player acquires the resource " + "Science. However, the opponents in this mission are stronger than" +
		" " + "normal opponents.";

	/**
	 * The following Strings contain the texts for the command center. The first is before the first story mission and the rest don't have an order
	 * for appearing.
	 */
	String COMMAND_CENTER_SLOGAN = "Fight your way back";

	String COMMAND_CENTER_NEWS_BEFORE_STORY_MISSION_ONE =
		"Breaking: The System is cut off from the " + "rest of the galaxy. Tensions are high with " + "small skirmishes occurring.";

	String COMMAND_CENTER_NEWS_AFTER_STORY_MISSION_ONE_ONE =
		"Despite rising tension in the system the" + " " + "Explorer-Association announces that it " + "members find more and more hints that " +
		"this was a major Hitani system.";

	String COMMAND_CENTER_NEWS_AFTER_STORY_MISSION_ONE_TWO =
		"The various factions in the system seems" + " " + "to employ the Mega Corporation soldiers " + "more and more.";

	String COMMAND_CENTER_NEWS_AFTER_STORY_MISSION_ONE_THREE =
		"The skirmishes escalate and now it " + "moves to capturing of outposts from " + "each other.";

	/**
	 * The following Strings contain the texts for the energy ability's of the troops.
	 */
	String MILITARISTIC_GOVERNMENT_DIG_IN =
		"The soldier digs in two be better protected. Ten percent " + "more armour and five percent more resistenz but can`t " + "move" +
		" for an energy cost of three energy.";

	String MILITARISTIC_GOVERNMENT_DOUBLE_TIME = "You motivate one soldier to be more accurate or be presented a " +
	                                             "court-martial. A cost of five energy.";

	String EXPLORER_ASSOCIATION_OVERCHARGE_WEAPON =
		"The Ranger overcharges his weapon. Deals six " + "points more damage for an energy cost of two " + "energy. ";

	String EXPLORER_ASSOCIATION_OVERCHARGE_EXOSKELETT = "The Exoskelett lets the Ranger be quickened " + "and agiler. One more movement range and " +
	                                                    "Initiative, dodge increases for five percent " +
	                                                    "for a three energy cost.";

	String MEGA_CORPORATION_ENERGYFLASH =
		"A bright flash emits of one off the thrown grenade right " + "before an enemy. A debuff for minus ten percent of dodge " + "and" +
		" a minus two to initiative for three energy.";

	String MEGA_CORPORATION_ACID_GRENADE =
		"The acid grenade weakens the armour off the poor soul that" + " " + "was hit with it. Minus ten percent off armour for two " +
		"energy.";

	String NEW_TERRA_COMBAT_OVERLAY =
		"The Combat overlay allows the soldier to aim true at a greater " + "distant. Plus one damage range for two energy.";

	String NEW_TERRA_ADVANCED_DEFENCE_SYSTEM =
		"The Advanced Defence System once deployed intercept " + "projectiles form hostile entity's. Add`s fifteen " +
		"percent of additional resistance for a cost of three" + " " + "energy.";

	/**
	 * The following Strings contain the texts for the energy ability's of the player.
	 */
	String ENERGY_DAMAGE_ABILITY =
		"This Energy beam damages one enemy unit and deals moderate damage." + " " + "16 damage for an energy cost of 3 energy.";

	String ENERGY_BUFF_DAMAGE =
		"The selected troop becomes deadlier. Deals six points more damage for" + " " + "an energy cost of two energy.";

	String ENERGY_BUFF_MOVEMENT_RANGE =
		"You motivate one of your troops to do double time. The " + "affected troop get three more movement range for an energy " +
		"cost of four energy.";

	/**
	 * The following Strings contain the texts for the tutorial,
	 */
	String tutorialIntroduction = "Hello dear player, first thank you for playing our little game. In " +
	                              "the following tabs you can read the tutorials of the integral parts" + " " +
	                              "of the game. They describe what certain things are for and how the " +
	                              "mechanics of this game work in a capacity that helps you understand" + " " + "how one can approach the game.";

	String tutorialCity = "The City is the main hub. At the top of the screen the current amount off " +
	                      "resources one has in its possession are displayed. Below that there are the" + " " +
	                      "buildings of the space station. There are the barracks for the own faction," + " " +
	                      "the docks and the space-bar for the other three factions, where one can " +
	                      "recruit troops of the different faction, unlocked through missions or are " +
	                      "unlocked from the start. The command center is where one selects the " + "mission" +
	                      " to play. The market can be used to exchange  resources with each other if " +
	                      "here are not enough to do something and one  don`t want to play a mission. " +
	                      "Lastly the training facility, workshop and the laboratory are there for " +
	                      "upgrades. In the training facility one can upgrade  unlocked troops. The " +
	                      "workshop improves the collected artifacts that one posses and the " +
	                      "laboratory can upgrade the ability of you, the player.";

	String tutorialArtifacts = "Artifacts are mysterious pieces of equipment that were left behind by " +
	                           "the Hitani and survived the tests of time. These strange pieces of " +
	                           "equipment seem to affect troops in battle positively. Artifacts are " +
	                           "selected by the player per mission and buff damage, defence or health " + "for the troops that go one that mission.";

	String tutorialFactsions = "In the system there are three faction besides to player-faction. The " +
	                           "troops of the factions can be used through different means and at " +
	                           "different points in the game. At the same time these factions also " +
	                           "pose as the enemy combatants in the game, so it dose pay off to learn " +
	                           "more about these once your in the game proper.";

	String tutorialMissions = "The missions in this game are divided in two categories. The first kind" + " " +
	                          "of missions are the story-missions. In these missions you drive the " +
	                          "story forward and get special rewards which one can`t get in the other " +
	                          "category of missions. The other category of missions are the repeatable" + " " +
	                          "missions in which one can get needed resources for upgrades. In the " +
	                          "missions you move on a map where you collect resources, troops and have" + " " + "to fight enemy's.";

	String tutorialFights = "When you encounter enemy`s on the mission-map you enter a fight. Fight in" + " " +
	                        "this game is turn-based and works on twelve times twelve grid with various" + " " +
	                        "environment based obstacles. After a troop attacks a hostile entity a " +
	                        "twenty sided dice is thrown to determine if the troop hits or if the " +
	                        "defendant hostile can dodge the attack. If an attack lands the damage " + "that" +
	                        " is done is modified by the armour or resistance of the defending troop. " +
	                        "The movement range determines how much tiles a unit can once and damage " +
	                        "and grenade range determines how great the distance there can be between " +
	                        "the attacker and the defender. If a troop is down to zero health it is " + "out" + " of combat.";

	String buttonRoundImageName = "button_round.png";

	String buttonImageName = "button.png";

	String colorLightBlue = "1584AD";

	String chooseGameFile = "Choose a gamefile to load";


	String TILE_IMAGE_NAME = "tile.png";

	String ALREADY_EXIST_EXCEPTION_MESSAGE = "The Element already exists";


	String VERTEX_DOES_NOT_EXIST = "The vertex does not exist";


	String ERROR_SERVER_SOCKET = "Error with ServerSocket";

	String ERROR_ACCEPTING = "error accepting";

	String CLIENT_CONNECTED = "client connected";
}
