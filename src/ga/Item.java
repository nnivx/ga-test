/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga;

/**
 * Interface for item.
 * 
 * @author Nyks Nivero
 */
public interface Item extends GlobalProperties, Properties {

    /**
     * Value returned by {@link #getItemType()}
     */
    public static final int ITEM_TYPE_NORMAL = 0;
    /**
     * Value returned by {@link #getItemType()}
     */
    public static final int ITEM_TYPE_COLLECTIBLE = 1;
    /**
     * Value returned by {@link #getItemType()}
     */
    public static final int ITEM_TYPE_QUEST = 2;
    /**
     * Value returned by {@link #getItemType()}
     */
    public static final int ITEM_TYPE_DUMMY = 3;

    // IMMUTABLE PROPERTIES
    
    /**
     * Returns the item id.
     * 
     * @return the item id
     */
    public String getItemID();

    /**
     * Returns the item name.
     *
     * @return the item name
     */
    public String getItemName();

    /**
     * Returns the item group.
     * 
     * @return the item group
     */
    public String getItemGroup();
    
    /**
     * Returns the long description of this item.
     *
     * @return the long description of this item
     */
    public String getDescription();
    
    /**
     * Returns the id of this item's cooldown group.
     *
     * Items under the same cooldown group will cool
     * down at the same time. No use for items that
     * cannot be used...
     * 
     * @return the id of the cooldown group.
     */
    public int getCooldownGroup();

    /**
     * Returns the cooldown time of this item.
     *
     * The cooldown time is the set amount of time to wait
     * before the item can be used again. Use cool time to
     * set (or unset) the item into cooldown mode.
     *
     * @return the cooldown time of this item
     */
    public int getCooldown();

    /**
     * Returns the maximum number of stacks.
     *
     * Stacks is the number times this item can be "stacked"
     * above the other before occupying another inventory slot.
     *
     * @return the maximum number of stacks
     */
    public int getMaxStacks();

    /**
     * Returns the item type.
     *
     * <li>{@link #ITEM_TYPE_NORMAL} - normal items that take up inventory space
     * <li>{@link #ITEM_TYPE_COLLECTIBLE} - special items that do not take up inventory
     * space and for bragging (or unlock) purposes
     * <li>{@link #ITEM_TYPE_QUEST} - special items that are used by quests. It take up
     * inventory space
     * <li>{@link #ITEM_TYPE_DUMMY} - dummy items for debug and testing
     *
     * @return the item type
     */
    public int getItemType();

    /**
     * Returns true if this item can be equipped.
     * @return true if equippable, false otherwise
     */
    public boolean canEquip();

    /**
     * Returns true if this item can be equipped.
     * @return true if equippable, false otherwise
     */
    public boolean canUse();

    /**
     * Returns true if this item can be dropped.
     * @return true if dropped, false otherwise
     */
    public boolean canDrop();

    /**
     * Returns true if this item can be sold TO a shop.
     * @return true if sold, false otherwise
     */
    public boolean canSell();

    /**
     * Returns the price of this item when sold FROM shop.
     *
     * Note that non-sellable items can also be sold at
     * the shop, thus it is an undo-able transaction.
     * 
     * @return the price of this item
     */
    public int getPriceValue();
    
    // MUTABLE PROPERTIES

    /**
     * Returns the cool time left.
     * @return
     */
    public int getCooltime();

    /**
     * Set the cooltime.
     * @param cooltime 
     */
    public void setCooltime(int cooltime);

    /**
     * Returns true if this item is on cooldown mode.
     * @return
     */
    public boolean isCooldown();

    /**
     * Helper method to set the item's cooldown state.
     * <p>
     * Invoking {@code item.setCooldown(true)} has the same effect as
     * {@code item.setCooltime(item.getCooldown())}. Passing
     * {@code false} as an argument will set the cooldown to {@code 0}.
     * 
     * @param cooldown
     */
    public void setCooldown(boolean cooldown);
    
    /**
     * Returns the number of stacks.
     * For usable items, this is also the number of uses left.
     * @return
     */
    public int getStacks();

    /**
     * Set the number of stacks.
     * For usable items, this is also the number of uses left.
     * @param stacks
     */
    public void setStacks(int stacks);

    /**
     * Split this item, returning another item with
     * the amount specified.
     * @param amount
     * @return item split off
     */
    public Item split(int amount);

}
