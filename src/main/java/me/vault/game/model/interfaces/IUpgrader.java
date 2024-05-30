package me.vault.game.model.interfaces;


public interface IUpgrader<T extends IUpgradable<K, V>, K, V>
{
	public abstract void upgrade (T upgradable);


	public abstract boolean checkIsUpgradable (T upgradable);
}
