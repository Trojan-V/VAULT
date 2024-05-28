package me.vault.vaultgame.model.Unit;

import me.vault.vaultgame.model.currency.CurrencyTransaction;

/**
 * @author Alexander Göthel
 * @version 1.0.0
 * @since 28.05.2024
 */
public class UnitProperties
{
    private String name;
    private double health;
    private double armour;
    private int energy;
    private int meleeDamage;
    private int grenade;
    private int grenadeAmount;
    private double dodge;
    private double resistance;
    private int movementRange;
    private int initiative;
    private int meleeRange;
    private int grenadeRange;
    private final CurrencyTransaction upgradeCosts;

    public UnitProperties (CurrencyTransaction upgradeCosts, double health, double armour, int energy, int meleeDamage,
                           int grenade, int grenadeAmount, double dodge, double resistance, int movementRange,
                           int initiative, int meleeRange, int grenadeRange, String name)
    {
        this.name = name;
        this.upgradeCosts = upgradeCosts;
        this.health = health;
        this.armour = armour;
        this.energy = energy;
        this.meleeDamage = meleeDamage;
        this.grenade = grenade;
        this.grenadeAmount = grenadeAmount;
        this.dodge = dodge;
        this.resistance = resistance;
        this.movementRange = movementRange;
        this.initiative = initiative;
        this.meleeRange = meleeRange;
        this.grenadeRange = grenadeRange;
    }

    public String getName ()
    {
        return name;
    }

    public double getHealth ()
    {
        return health;
    }

    public double getArmour ()
    {
        return armour;
    }

    public int getEnergy ()
    {
        return energy;
    }

    public int getMeleeDamage ()
    {
        return meleeDamage;
    }

    public int getGrenade ()
    {
        return grenade;
    }

    public int getGrenadeAmount ()
    {
        return grenadeAmount;
    }

    public double getDodge ()
    {
        return dodge;
    }

    public double getResistance ()
    {
        return resistance;
    }

    public int getMovementRange ()
    {
        return movementRange;
    }

    public int getInitiative ()
    {
        return initiative;
    }

    public int getMeleeRange ()
    {
        return meleeRange;
    }

    public int getGrenadeRange ()
    {
        return grenadeRange;
    }

    public CurrencyTransaction getUpgradeCosts ()
    {
        return upgradeCosts;
    }
}
