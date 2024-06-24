package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.constant.ConstantInterface.Constant;


@ConstantInterface
public interface MissionConstants
{

	@ConstantInterface
	interface MissionOne
	{

		@Constant
		CurrencyTransaction MISSION_ONE_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

	}


	@ConstantInterface
	interface MissionTwo
	{

		@Constant
		CurrencyTransaction MISSION_TWO_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

	}


	@ConstantInterface
	interface MissionThree
	{

		@Constant
		CurrencyTransaction MISSION_THREE_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

	}


	@ConstantInterface
	interface MissionFour
	{

		@Constant
		CurrencyTransaction MISSION_FOUR_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

	}

}
