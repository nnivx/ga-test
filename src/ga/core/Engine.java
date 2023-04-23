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
public class Engine {

    /**
     * Create an item.
     * 
     * @param itemID the id of the item
     * @param uses the number of uses, capped to the item's max stacks
     * @return an item
     */
    public Item createItem(String itemID, int uses) {
        return null;
    }

    /**
     * Create one item.
     * 
     * @param itemID the id of the item
     * @return
     */
    public Item createItem(String itemID) {
        return createItem(itemID, 1);
    }

}
