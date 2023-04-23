/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga;


/**
 *
 * @author Nyks Nivero
 */
class SpellcardObj {
    
    private String id;
    private ColorRank color;
    private String name;
    private String desc;
    private String special;
    private String[] images;
    private Element element;

    private int power;
    private int range;
    private Target target;
    private int uses;

    private int sellValue;
    private int tradeValue;

    private boolean sellable;
    private boolean droppable;
    private boolean tradeable;
    private boolean replenishable;
//
//    public SpellcardObj(
//        String id,
//        ColorRank color,
//        String name,
//        String desc,
//        String special,
//        String[] images,
//        Element element,
//        int power,
//        int range,
//        Target target,
//        int uses,
//        int sellValue,
//        int tradeValue,
//        boolean sellable,
//        boolean droppable,
//        boolean tradeable,
//        boolean replenishable
//    ) {
//
//    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public ColorRank getColor() {
        return color;
    }

    public void setColor(ColorRank color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    public int getSellValue() {
        return sellValue;
    }

    public void setSellValue(int sellValue) {
        this.sellValue = sellValue;
    }

    public int getTradeValue() {
        return tradeValue;
    }

    public void setTradeValue(int tradeValue) {
        this.tradeValue = tradeValue;
    }

    public boolean isSellable() {
        return sellable;
    }

    public void setSellable(boolean sellable) {
        this.sellable = sellable;
    }

    public boolean isDroppable() {
        return droppable;
    }

    public void setDroppable(boolean droppable) {
        this.droppable = droppable;
    }

    public boolean isTradeable() {
        return tradeable;
    }

    public void setTradeable(boolean tradeable) {
        this.tradeable = tradeable;
    }

    public boolean isReplenishable() {
        return replenishable;
    }

    public void setReplenishable(boolean replenishable) {
        this.replenishable = replenishable;
    }


}
