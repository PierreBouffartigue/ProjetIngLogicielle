package fr.ynov.villager.items;


import fr.ynov.villager.Main;
import net.minecraft.item.ItemFood;

public class ItemCustomFood
        extends ItemFood {

    public ItemCustomFood(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
}