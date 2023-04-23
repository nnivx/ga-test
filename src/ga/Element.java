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
public enum Element {

    Fire(GAConstants.ELEMENT_FIRE),
    Ice(GAConstants.ELEMENT_ICE),
    Lightning(GAConstants.ELEMENT_LIGHTNING),
    Light(GAConstants.ELEMENT_LIGHT),
    Dark(GAConstants.ELEMENT_DARK),
    None(GAConstants.ELEMENT_NONE);

    private final String str;

    private Element(String s) {
        this.str = s;
    }

    public boolean equalsPropString(String s) {
        return str.equalsIgnoreCase(s);
    }

    public String propString() {
        return str;
    }

    public static Element fromPropString(String s) {
        for (Element e: Element.values()) {
            if (e.equalsPropString(s)) return e;
        }
        return null;
    }

}
