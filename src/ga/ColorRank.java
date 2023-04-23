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
public enum ColorRank {
    Platinum(GAConstants.CARD_COLOR_PLATINUM),
    Gold(GAConstants.CARD_COLOR_GOLD),
    Silver(GAConstants.CARD_COLOR_SILVER),
    Bronze(GAConstants.CARD_COLOR_BRONZE);

    private final String str;

    private ColorRank(String s) {
        this.str = s;
    }

    public boolean equalsPropString(String s) {
        return str.equalsIgnoreCase(s);
    }

    public String propString() {
        return str;
    }

    public static ColorRank fromPropString(String s) {
        for (ColorRank e: ColorRank.values()) {
            if (e.equalsPropString(s)) return e;
        }
        return null;
    }
    
}
