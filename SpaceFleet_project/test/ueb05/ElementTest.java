/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb05;

import org.junit.Test;
import static org.junit.Assert.*;
import ueb05.Element;
import ueb05.Element;
import ueb05.Planet;
import ueb05.Rocket;
import ueb05.Satellite;
import ueb05.SpaceFleet;
import ueb05.Spacecraft;
import ueb05.Spacecraft;
import ueb05.Spaceplane;

/**
 *
 * @author Alireza
 */
public class ElementTest {

    private Element createElements(Spacecraft... value) {
        if (value.length == 0) {
            return null;
        }
        // create a new element
        Element el = new Element(value[0]);
        Element firstEl = el; // remember first element

        // create more elements
        for (int i = 1; i < value.length; i++) {
            el.setNext(new Element());
            el = el.getNext();
            el.setSpaceCraft(value[i]);
        }
        return firstEl;
    }
    @Test 
    public void testInsertElement() {
        Spacecraft sc3 = new Spaceplane("Name1", 5, 4.0);
        Spacecraft firstSC = new Rocket("Name2", 5, 4.0);
        Spacecraft secondSC = new Satellite("Name2", Satellite.Usage.GPS, 4.0);
        SpaceFleet sf = new SpaceFleet("Alireza", "#@#");
        Element elem = new Element(sc3);     
        elem.insertElement(secondSC);
        elem.insertElement(firstSC);
        sf.buildSpacecraft(sc3, Planet.MARS);
        sf.buildSpacecraft(firstSC, Planet.MARS);
        sf.buildSpacecraft(secondSC, Planet.MARS);
        
    }
  
}
