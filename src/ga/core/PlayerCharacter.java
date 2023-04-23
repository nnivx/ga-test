/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga.core;

import ga.Item;

/**
 *
 * @author Nyks Nivero
 */
public class PlayerCharacter {

    private class Bag {
        String bagName;

        Bag(String bagName) {
            this.bagName = bagName;
        }

        void addItem(Item item) {

        }

        void getItemAt(Item item) {

        }
    }

    public class Inventory {

        private final Bag[] bags;

        private Inventory() {
            bags = new Bag[]{
                new Bag("Equip"),
                new Bag("Clothes"),
                new Bag("Foot"),
                new Bag("Accesories"),
                new Bag("Accesories"),
                new Bag("Others")
            };
        }

        public void addItem(Item item) {

        }

        public void getItemAt(Item item) {
            
        }

        public int getAvailableSlots() {
            return 0;
        }

        public int getMaxSlots() {
            return 0;
        }

    }

    public final Inventory inventory = new Inventory();

    /**
     * Headgears.
     * <p>
     * Item groups: "Headgear", "Hat", "Ribbon", "Headband", "Ears", "Mask"
     */
    public static final int EQUIP_SLOT_HEADGEAR = 0;
    /**
     * Neckgear.
     * <p>
     * Item groups: "Choker", "Scarf"
     */
    public static final int EQUIP_SLOT_NECKGEAR = 1;
    /**
     * Accessory slot 0. (necklaces have exclusion)
     * <p>
     * Item groups: "Necklace", "Ring", "Earring"
     */
    public static final int EQUIP_SLOT_ACCESORY0 = 2;
    /**
     * Accessory slot 1. (necklaces have exclusion)
     * <p>
     * Item groups: "Necklace", "Ring", "Earring"
     */
    public static final int EQUIP_SLOT_ACCESORY1 = 3;
    /**
     * Upper Garment.
     * <p>
     * Item groups: "Shirt", "Uniform"
     */
    public static final int EQUIP_SLOT_UPPER_GERMENT = 4;
    /**
     * Lower Garment.
     * <p>
     * Item groups: "Skirt", "Short", "Pants"
     */
    public static final int EQUIP_SLOT_LOWER_GERMENT = 5;
    /**
     * Hands.
     * <p>
     * Item groups: "Bracer", "Gloves", "Gauntlet"
     */
    public static final int EQUIP_SLOT_HAND = 6;
    /**
     * Feet.
     * <p>
     * Item groups: "Flipflop", "Boots", "Shoes"
     */
    public static final int EQUIP_SLOT_FEET = 7;

    public Item getEquippedItem(int slot) {
        return null;
    }

}
