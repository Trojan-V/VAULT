package me.vault.game.interfaces;


public interface IUpgrader<T extends UpgradableNew<E>, E>
{
	public abstract void upgrade (T upgradable);


	public abstract boolean checkIsUpgradable (T upgradable);
}
