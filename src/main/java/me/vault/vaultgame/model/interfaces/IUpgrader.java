package me.vault.vaultgame.model.interfaces;

// TODO: Bezeichner der Generics!!!!!!!!
@FunctionalInterface
public interface IUpgrader<E extends IUpgradable<F, G>, F, G>
{
	void upgrade (E upgradable);
}
