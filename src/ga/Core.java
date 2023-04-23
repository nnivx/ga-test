/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ga;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
//import org.lwjgl.input.Keyboard;

/**
 * The core should be able to save itself.
 * 
 * @author Nyks Nivero
 */
public class Core {

    // Rhis is made like this (rather than a static class)
    // so that the list can be reloaded
    public static final class Resources {
        public final String GA_LOGO;
        public final String ENMA;
        public final String MAIN_BACKGROUND;
        public final String MAIN_DOCK;
        public final String MAIN_MEA;
        public final String MAIN_RIBBON;
        public final String MAIN_HIGHLIGHT;
        public final String SELECTOR;
        public final String SELECT_SFX;
        public final String MENU_ITEM_SFX;
        public final String SELECT_FAIL_SFX;

        private ArrayList<String> list;

        public Resources() {
            // TODO: load strings from pkg list
            GA_LOGO = "ga/data/greengates-logo.png";
            ENMA = "ga/data/enmartworks.png";
            MAIN_BACKGROUND = "ga/data/main-bg.png";
            MAIN_DOCK = "ga/data/main-dock.png";
            MAIN_MEA = "ga/data/main-mea.png";
            MAIN_RIBBON = "ga/data/main-ribbon.png";
            MAIN_HIGHLIGHT = "ga/data/main-selected.png";
            SELECTOR = "ga/data/selector-anim.png";
            SELECT_SFX = "ga/data/sound/menu-small-select.ogg";
            MENU_ITEM_SFX = "ga/data/sound/menu-item.ogg";
            SELECT_FAIL_SFX = "ga/data/sound/item.wav";

            // Use reflection to fill the list
            Field[] fields = Core.Resources.class.getFields();
            list = new ArrayList<>(fields.length);
            try {
                for (Field field: fields) {
                    if (Modifier.isPublic(field.getModifiers())
                        && Modifier.isFinal(field.getModifiers())
                        && field.getType().equals(String.class)) {
                        list.add((String)field.get(this));
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
            }
            list.trimToSize();
        }

        public java.util.List<String> list() {
            return java.util.Collections.unmodifiableList(list);
        }
    }
    
    public static Resources res = new Resources();
    
}
