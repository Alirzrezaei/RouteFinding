/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb05;

import ueb05.Spacecraft;
import ueb05.Satellite;
import ueb05.Rocket;
import org.junit.Test;
import ueb05.Rocket;
import ueb05.Rocket;
import ueb05.Satellite;
import ueb05.Satellite;
import ueb05.Spacecraft;
import ueb05.Spacecraft;
import static org.junit.Assert.*;

/**
 *
 * @author Alireza
 */
public class SpacecraftTest {

    public SpacecraftTest() {
    }

    @Test
    public void testEquals_OtherBigger() {
        Spacecraft firstSC = new Spacecraft("ABC");
        Spacecraft secondSC = new Spacecraft("ABC");
        assertTrue(firstSC.equals(secondSC));
    }

    @Test
    public void testEquals_OtherIsNull() {
        Spacecraft firstSC = new Spacecraft("ABC");
        Spacecraft secondSC = new Spacecraft();
        assertFalse(firstSC.equals(secondSC));
    }

    @Test
    public void testEquals_differentClass() {
        Spacecraft firstSC = new Rocket("ADF");
        Spacecraft secondSC = new Satellite("as");
        assertFalse(firstSC.equals(secondSC));
    }

    @Test
    public void testEquals_differentClassEqual() {
        Spacecraft firstSC = new Rocket("ADF");
        Spacecraft secondSC = new Satellite("ADF");
        assertFalse(firstSC.equals(secondSC));
    }

    @Test
    public void testEquals_sameClassEqual() {
        Spacecraft firstSC = new Rocket("ADF");
        Spacecraft secondSC = new Rocket("ADF");
        assertTrue(firstSC.equals(secondSC));
    }

    @Test
    public void testCompareByName_OtherBigger() {
        Spacecraft firstSC = new Spacecraft("ABC");
        Spacecraft secondSC = new Spacecraft("ADC");
        assertEquals(-1, firstSC.compareByName(secondSC));
    }

    @Test
    public void testCompareByName_ThisBigger() {
        Spacecraft firstSC = new Spacecraft("ADC");
        Spacecraft secondSC = new Spacecraft("ABC");
        assertEquals(1, firstSC.compareByName(secondSC));
    }

    @Test
    public void testCompareByName_ThisBigger2() {
        Spacecraft firstSC = new Spacecraft("ABCD");
        Spacecraft secondSC = new Spacecraft("ABC");
        assertEquals(1, firstSC.compareByName(secondSC));
    }

    @Test
    public void testCompareByName_OtherBigger2() {
        Spacecraft firstSC = new Spacecraft("BCFasgfd");
        Spacecraft secondSC = new Spacecraft("D");
        assertEquals(-1, firstSC.compareByName(secondSC));
    }

    @Test
    public void testCompareByName_OtherBigger3() {
        Spacecraft firstSC = new Spacecraft("ABC");
        Spacecraft secondSC = new Spacecraft("a");
        assertEquals(-1, firstSC.compareByName(secondSC));
    }

    @Test
    public void testCompareByName_equals() {
        Spacecraft firstSC = new Spacecraft("ABC");
        Spacecraft secondSC = new Spacecraft("ABC");
        assertEquals(0, firstSC.compareByName(secondSC));
    }

    @Test
    public void testCompareByName_NULL() {
        Spacecraft firstSC = new Spacecraft(null);
        Spacecraft secondSC = new Spacecraft(null);
        assertEquals(0, firstSC.compareByName(secondSC));
    }
}
