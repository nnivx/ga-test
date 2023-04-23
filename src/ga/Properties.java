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
public interface Properties {

    public java.util.Map<String, Object> getProperties();

    public void setProperty(String prop, Object value);

    public Object getProperty(String prop);
    
}
