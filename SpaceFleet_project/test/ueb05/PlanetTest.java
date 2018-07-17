/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb05;

import ueb05.Planet;
import org.junit.Test;
import ueb05.Planet;
import static org.junit.Assert.*;

/**
 *
 * @author Alireza
 */
public class PlanetTest {

    public PlanetTest() {
    }

    @Test
    public void testcomparePalnetBySurfaceGravity_thisBigger() {
        Planet first = Planet.EARTH;
        Planet second = Planet.VENUS;
        assertEquals(1, first.comparePlanetBySurfaceGravity(second));
    }

    @Test
    public void testcomparePalnetBySurfaceGravity_OtherBigger() {
        Planet first = Planet.MERCURY;
        Planet second = Planet.MARS;
        assertEquals(-1, first.comparePlanetBySurfaceGravity(second));
    }

    @Test
    public void testcomparePalnetBySurfaceGravity_equal() {
        Planet first = Planet.MERCURY;
        Planet second = Planet.MERCURY;
        assertEquals(0, first.comparePlanetBySurfaceGravity(second));
    }

    @Test
    public void testcomparePalnetBySurfaceGravity_equal2() {
        Planet first = Planet.JUPITER;
        Planet second = Planet.SATURN;
        assertEquals(1, first.comparePlanetBySurfaceGravity(second));
    }

}
