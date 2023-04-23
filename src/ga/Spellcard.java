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
public final class Spellcard {

    private SpellcardObj obj;

    Spellcard(SpellcardObj obj) {
        this.obj = obj;
    }

    public String getID() {
        return obj.getID();
    }

    public ColorRank getColor() {
        return obj.getColor();
    }

    public String getName() {
        return obj.getName();
    }

    public String getDesc() {
        return obj.getDesc();
    }

    public String getSpecial() {
        return obj.getSpecial();
    }

    public String[] getImages() {
        return obj.getImages();
    }

    public Element getElement() {
        return obj.getElement();
    }

    public int getPower() {
        return obj.getPower();
    }

    public int getRange() {
        return obj.getRange();
    }
    public Target getTarget() {
        return obj.getTarget();
    }

    public int getUses() {
        return obj.getUses();
    }

    public int getSellValue() {
        return obj.getSellValue();
    }

    public int getTradeValue() {
        return obj.getTradeValue();
    }

    public boolean isSellable() {
        return obj.isSellable();
    }

    public boolean isDroppable() {
        return obj.isDroppable();
    }

    public boolean isTradeable() {
        return obj.isTradeable();
    }

    public boolean isReplenishable() {
        return obj.isReplenishable();
    }

}
