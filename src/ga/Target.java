/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga;

/**
 * Target type wrapper.
 * 
 * @author Nyks Nivero
 */
public enum Target {

    /**
     * The target is limited to the nearest ground below the caster.
     */
    Ground(GAConstants.TARGET_GROUND),

    /**
     * The target can be freely pointed to any point in range on screen.
     */
    Area(GAConstants.TARGET_AREA),

    /**
     * The target automatically locks onto units in range.
     */
    Unit(GAConstants.TARGET_UNIT),

    /**
     * The target is automatically chosen.
     */
    None(GAConstants.TARGET_NONE);

    private final String str;

    private Target(String str) {
        this.str = str;
    }

    /**
     * Returns this target type as a property string.
     *
     * @return as property string
     */
    public String propString() {
        return str;
    }

    /**
     * Returns {@code true} if {@code s} is this target
     * type's property string.
     * 
     * @param s a string
     * @return {@code true} if {@code s} is this target
     * type's property string.
     */
    public boolean equalsPropString(String s) {
        return str.equalsIgnoreCase(s);
    }

    /**
     * Returns the target associated with {@code s} as a
     * property string, or {@code null}.
     *
     * @param s a string
     * @return the target associated with {@code s} as a
     * property string, or null.
     */
    public static Target fromPropString(String s) {
        for (Target t: Target.values()) {
            if (t.equalsPropString(s)) return t;
        }
        return null;
    }
}
