package me.vault.vaultgame.model.interfaces;

// TODO: Bezeichner der Generics!!!!!!!!
public interface IUpgrader<E extends IUpgradable<F, G>, F, G>
{
	public abstract void upgrade (E upgradable);


	public abstract boolean checkIsUpgradable (E upgradable);
}
