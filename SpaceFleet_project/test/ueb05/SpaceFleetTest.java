
package ueb05;

import org.junit.Test;
import ueb05.Element;
import ueb05.Planet;
import ueb05.Rocket;
import ueb05.Satellite;
import ueb05.SpaceFleet;
import ueb05.Spacecraft;
import ueb05.Spaceplane;
import static org.junit.Assert.*;

/**
 *
 * @author Alireza
 */
public class SpaceFleetTest {
    
    private static Element createList(Spacecraft[] scArr) {
        if (scArr != null && scArr.length > 0) {
            Element list = new Element(scArr[0]);
            for (int i = 1; i < scArr.length; i++) {
                list = list.insertElement(scArr[i]);
            }
            return list;
        }
        return null;
    }
    
    @Test
    public void testBuildSpacecraft() {
        SpaceFleet Ab = new SpaceFleet("Around the World ", "[ßMÄ]");
        Spacecraft dafu = new Satellite("Gbfu", Satellite.Usage.TELECOMMUNICATION, 14.5);
        Spacecraft Bahar = new Satellite("bahar", Satellite.Usage.GPS,7.3);
        Spacecraft BAhar2 = new Satellite("bahar", Satellite.Usage.GPS,2.3);
        Spacecraft azama = new Spaceplane("azama", 4, 1.5);
        Spacecraft Man = new Spaceplane(null, 4, 0.5);
        Ab.buildSpacecraft(azama, Planet.EARTH);
        Ab.buildSpacecraft(dafu, Planet.SATURN);
        Ab.buildSpacecraft(Bahar, Planet.SATURN);
        //Ab.buildSpacecraft(Man, Planet.SATURN);
        Ab.buildSpacecraft(BAhar2, Planet.SATURN);
        assertEquals(8 , Ab.getScOnSurface().length);
        assertEquals(3, Ab.getFleetStrength());
        assertEquals(Bahar, BAhar2);
    }
    
    @Test
    public void testLaunchSpacecraftToOrbitSucceed() {
        SpaceFleet Ab = new SpaceFleet("Around the World ", "[ßMÄ]");
        Spacecraft Bahar = new Spaceplane("nnazama", 6, 4.5);
        Ab.buildSpacecraft(Bahar, Planet.MARS);
        Ab.launchSpacecraftToOrbit(Bahar, Planet.MARS);
        
        assertEquals(1, Ab.getFleetStrength());
        assertEquals(null, Ab.getScInOrbit()[Planet.EARTH.ordinal()]);
        assertEquals(Bahar, Ab.getScInOrbit()[Planet.MARS.ordinal()].getElementAt(0));
        assertEquals(null, Ab.getScOnSurface()[Planet.MARS.ordinal()]);
        
    }
    
    @Test
    public void testLaunchSpacecraftToOrbitFailed() {
        SpaceFleet Ab = new SpaceFleet("Around the World ", "[ßMÄ]");
        Spacecraft Bahar = new Spaceplane("nnazama", 6, 2.5);
        Ab.buildSpacecraft(Bahar, Planet.VENUS);
        Ab.launchSpacecraftToOrbit(Bahar, Planet.VENUS);
        
        assertEquals(1, Ab.getFleetStrength());
        assertEquals(null, Ab.getScInOrbit()[Planet.EARTH.ordinal()]);
        assertEquals(null, Ab.getScInOrbit()[Planet.VENUS.ordinal()]);
        assertEquals(Bahar, Ab.getScOnSurface()[Planet.VENUS.ordinal()].getElementAt(0));
        
    }
    @Test
    public void testBuildSpacecraft1() {
        SpaceFleet Aida = new SpaceFleet("Around the World ", "[ßMÄ]");
        Spacecraft nnazama = new Spaceplane("nnazama", 6, 3.5);
        Spacecraft Gbadafu = new Satellite("Gbadafu", Satellite.Usage.TELECOMMUNICATION, 14.5);
        Spacecraft Aboni = new Satellite("Aboni", Satellite.Usage.GPS,2.3);
        Aida.buildSpacecraft(nnazama, Planet.EARTH);
        Aida.buildSpacecraft(Gbadafu, Planet.SATURN);
        Aida.buildSpacecraft(Aboni, Planet.SATURN);
        assertEquals(3,Aida.getFleetStrength());     
        assertArrayEquals(new Element [] {null, null, new Element(nnazama), null, null, (new Element(Gbadafu)).insertElement(Aboni), null, null}, Aida.getScOnSurface());
    }
    
    @Test
    public void testLaunchSpacecraftToOrbitSucceed2() {
        SpaceFleet Aida = new SpaceFleet("Around the World ", "[ßMÄ]");
        Spacecraft nnazama = new Spaceplane("nnazama", 6, 4.5);
        Aida.buildSpacecraft(nnazama, Planet.MARS);
        Aida.launchSpacecraftToOrbit(nnazama, Planet.MARS);
        assertArrayEquals(new Element [] {null, null, null, new Element(nnazama), null, null, null, null}, Aida.getScInOrbit());
    }
    
    @Test
    public void testLaunchSpacecraftToOrbitFailed2() {
        SpaceFleet Aida = new SpaceFleet("Around the World ", "[ßMÄ]");
        Spacecraft nnazama = new Spaceplane("nnazama", 6, 2.5);
        Aida.buildSpacecraft(nnazama, Planet.VENUS);
        Aida.launchSpacecraftToOrbit(nnazama, Planet.VENUS);
        assertArrayEquals(new Element [] {null, null, null, null, null, null, null, null}, Aida.getScInOrbit());
        assertArrayEquals(new Element [] {null, new Element(nnazama), null, null, null, null, null, null}, Aida.getScOnSurface());
    }
    
    @Test
    public void testLandSpacecraftToOrbitPossible() {
        Spacecraft nnazama = new Spaceplane("nnazama", 6, 2.5);
        Spacecraft Gbadafu = new Satellite("Gbadafu", Satellite.Usage.TELECOMMUNICATION, 14.5);
        Spacecraft Aboni = new Satellite("Aboni", Satellite.Usage.GPS,2.3);
        Spacecraft Rocket0 = new Rocket("pigRocket1", 5d, 3.8);
        Element[] AidaOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                nnazama, Gbadafu, Rocket0}),
            //VENUS EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null, null
        };

        Element[] AidaSurface = new Element[]{
            //MERCURY
            null,
            //VENUS
            createList(new Spacecraft[]{
                Aboni}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet Aida = SpaceFleet.createSpaceFleet(
                "Plutocratic Interstellar Government", "[ðŸ ·]", AidaOrbit, AidaSurface);
        Aida.landSpacecraft(nnazama, Planet.MERCURY);
        assertArrayEquals(new Element [] {(new Element(Gbadafu)).insertElement(Rocket0), null, null, null, null, null, null, null}, Aida.getScInOrbit());
        assertArrayEquals(new Element [] {new Element(nnazama), new Element(Aboni), null, null, null, null, null, null}, Aida.getScOnSurface());
    }
    
    @Test
    public void testLandSpacecraftToOrbitNotPossible() {
        Spacecraft nnazama = new Spaceplane("nnazama", 6, 2.5);
        Spacecraft Gbadafu = new Satellite("Gbadafu", Satellite.Usage.TELECOMMUNICATION, 14.5);
        Spacecraft Aboni = new Satellite("Aboni", Satellite.Usage.GPS,2.3);
        Spacecraft Rocket0 = new Rocket("pigRocket1", 5d, 3.8);
        Element[] AidaOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                nnazama, Gbadafu, Rocket0}),
            //VENUS EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null, null
        };

        Element[] AidaSurface = new Element[]{
            //MERCURY
            null,
            //VENUS
            createList(new Spacecraft[]{
                Aboni}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet Aida = SpaceFleet.createSpaceFleet(
                "Plutocratic Interstellar Government", "[ðŸ ·]", AidaOrbit, AidaSurface);
        Aida.landSpacecraft(Gbadafu, Planet.MERCURY);
        assertArrayEquals(new Element [] {(new Element(nnazama)).insertElement(Rocket0), null, null, null, null, null, null, null}, Aida.getScInOrbit());
        assertArrayEquals(new Element [] {null, new Element(Aboni), null, null, null, null, null, null}, Aida.getScOnSurface());
    }
    
    @Test
    public void testGetFleetStrengthSpacecraftsOnSurfaceAndInOrbit() {
        Spacecraft nnazama = new Spaceplane("nnazama", 6, 2.5);
        Spacecraft Gbadafu = new Satellite("Gbadafu", Satellite.Usage.TELECOMMUNICATION, 14.5);
        Spacecraft Aboni = new Satellite("Aboni", Satellite.Usage.GPS,2.3);
        Spacecraft Rocket0 = new Rocket("pigRocket1", 5d, 3.8);
        Element[] AidaOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                nnazama, Gbadafu, Rocket0}),
            //VENUS EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null, null
        };

        Element[] AidaSurface = new Element[]{
            //MERCURY
            null,
            //VENUS
            createList(new Spacecraft[]{
                Aboni}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet Aida = SpaceFleet.createSpaceFleet(
                "Plutocratic Interstellar Government", "[ðŸ ·]", AidaOrbit, AidaSurface);
        assertEquals(4, Aida.getFleetStrength());
    }
    
    @Test
    public void testGetFleetStrengthIsZero() {
        SpaceFleet Aida = new SpaceFleet("Plutocratic Interstellar Government", "[ðŸ ·]");
        assertEquals(0, Aida.getFleetStrength());
    }
    
    @Test
    public void testGetFleetStrengthSpacecraftsJustOnSurface() {
        Spacecraft nnazama = new Spaceplane("nnazama", 6, 2.5);
        Spacecraft Aboni = new Satellite("Aboni", Satellite.Usage.GPS,2.3);
        Element[] AidaOrbit = new Element[]{null, null, null, null, null, null, null, null
        };

        Element[] AidaSurface = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                nnazama}),
            //VENUS
            createList(new Spacecraft[]{
                Aboni}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet Aida = SpaceFleet.createSpaceFleet(
                "Plutocratic Interstellar Government", "[ðŸ ·]", AidaOrbit, AidaSurface);
        assertEquals(2, Aida.getFleetStrength());
    }
    
    @Test
    public void testGetFleetStrengthSpacecraftsJustInOrbit() {
        Spacecraft nnazama = new Spaceplane("nnazama", 6, 2.5);
        Spacecraft Aboni = new Satellite("Aboni", Satellite.Usage.GPS,2.3);
        Element[] AidaSurface = new Element[]{null, null, null, null, null, null, null, null
        };

        Element[] AidaOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                nnazama}),
            //VENUS
            createList(new Spacecraft[]{
                Aboni}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet Aida = SpaceFleet.createSpaceFleet(
                "Plutocratic Interstellar Government", "[ðŸ ·]", AidaOrbit, AidaSurface);
        assertEquals(2, Aida.getFleetStrength());
    }
    
    @Test
    public void testLaunchSpacecraftToOrbit_NotOnSurface(){
        Spacecraft sc = new Rocket("Alireza", 5d, 3.8);
        SpaceFleet sf = new SpaceFleet("SF", "#!#");
        sf.launchSpacecraftToOrbit(sc, Planet.MARS);
        assertArrayEquals(new Element []{null, null, null, null, null, null, null, null}, sf.getScInOrbit());
    }
     @Test
    public void testLaunchSpacecraftToOrbit_ExistOnSurface(){
        Spacecraft sc = new Spaceplane("Alireza", 5, 3.8);
        SpaceFleet sf = new SpaceFleet("SF", "#!#");
        sf.buildSpacecraft(sc, Planet.MARS);
        sf.launchSpacecraftToOrbit(sc, Planet.MARS);
        assertArrayEquals(new Element []{null, null, null, new Element(sc), null, null, null, null}, sf.getScInOrbit());
    }
     @Test
    public void testLaunchSpacecraftToOrbit_ExistOnSurface2(){
        Spacecraft sc = new Spaceplane("Alireza", 5, 3.8);
        Spacecraft sc2 = new Spaceplane("kobra", 5, 2);
        SpaceFleet sf = new SpaceFleet("SF", "!^!");
        sf.buildSpacecraft(sc, Planet.MARS);
        sf.buildSpacecraft(sc2, Planet.EARTH);
        assertArrayEquals(new Element []{null, null, new Element(sc2), new Element(sc), null, null, null, null}, sf.getScOnSurface());
        sf.launchSpacecraftToOrbit(sc, Planet.MARS);
        assertArrayEquals(new Element []{null, null, null, new Element(sc), null, null, null, null}, sf.getScInOrbit());
    }
     @Test
    public void testLaunchSpacecraftToOrbit_maxGravityLess(){
        Spacecraft sc = new Spaceplane("Alireza", 5, 2);
        SpaceFleet sf = new SpaceFleet("SF", "#!#");
        sf.buildSpacecraft(sc, Planet.MARS);
        sf.launchSpacecraftToOrbit(sc, Planet.MARS);
        assertArrayEquals(new Element []{null, null, null, null, null, null, null, null}, sf.getScInOrbit());
    }
    @Test
    public void testLaunchSpacecraftToOrbit_noExistOnSurface(){
        Spacecraft sc = new Spaceplane("Alireza", 5, 3.8);
        Spacecraft sc2 = new Spaceplane("kobra", 5, 3.8);
        SpaceFleet sf = new SpaceFleet("SF", "!^!");
        sf.buildSpacecraft(sc, Planet.MARS);
        sf.launchSpacecraftToOrbit(sc2, Planet.MARS);
        assertArrayEquals(new Element []{null, null, null, null, null, null, null, null}, sf.getScInOrbit());
    }
    @Test
    public void testLaunchSpacecraftToOrbit_noExistOnSurface2(){
        Spacecraft sc = new Spaceplane("Alireza", 5, 3.8);
        Spacecraft sc2 = new Spaceplane("kobra", 5, 3.8);
        SpaceFleet sf = new SpaceFleet("SF", "!^!");
        sf.buildSpacecraft(sc, Planet.MARS);
        sf.buildSpacecraft(sc2, Planet.EARTH);
        assertArrayEquals(new Element []{null, null, new Element(sc2), new Element(sc), null, null, null, null}, sf.getScOnSurface());
        sf.launchSpacecraftToOrbit(sc2, Planet.MARS);
        assertArrayEquals(new Element []{null, null, null, null, null, null, null, null}, sf.getScInOrbit());
    }
    @Test
    public void testLandOnSurface_CanLand(){
        Spacecraft sc = new Spaceplane("Alireza", 0, 4.6);
        Spacecraft sc2 = new Rocket("Kobra", 5d, 3.8);
        Spacecraft sc3 = new Rocket("Bahar", 5d, 3.8);
        Spacecraft sc4 = new Spaceplane("Mahdi", 5, 3.8);
        Spacecraft sc5 = new Spaceplane("Mohammad", 0, 4.6);
        Spacecraft sc6 = new Rocket("Jawad", 0d, 4.6);
        Spacecraft sc7 = new Rocket("Kobra", 5d, 3.8);
        Element[] scOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                sc,
                sc2,
                sc3,
                sc4}),
            //VENUS EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null, null
        };
        Element[] scSurface = new Element[]{
            //MERCURY
            null,
            //VENUS
            createList(new Spacecraft[]{
               sc6}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet sf = SpaceFleet.createSpaceFleet("SF", "$#$", scOrbit, scSurface);
        sf.landSpacecraft(sc, Planet.MERCURY);
        assertArrayEquals(new Element []{new Element(sc), new Element(sc6), null, null, null, null, null, null}, sf.getScOnSurface());
    }
     @Test
    public void testLandOnSurface_willDestroyed(){
        Spacecraft sc = new Spaceplane("Alireza", 0, 4.6);
        Spacecraft sc2 = new Rocket("Kobra", 5d, 3.8);
        Spacecraft sc3 = new Rocket("Bahar", 5d, 3.8);
        Spacecraft sc4 = new Spaceplane("Mahdi", 5, 3.8);
        Spacecraft sc5 = new Spaceplane("Mohammad", 0, 4.6);
        Spacecraft sc6 = new Rocket("Jawad", 0d, 4.6);
        Spacecraft sc7 = new Rocket("Kobra", 5d, 3.8);
        Element[] scOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                sc,
                sc2,
                sc3,
                sc4}),
            //VENUS EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null, null
        };
        Element[] scSurface = new Element[]{
            //MERCURY
            null,
            //VENUS
            createList(new Spacecraft[]{
               sc6}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet sf = SpaceFleet.createSpaceFleet("SF", "$#$", scOrbit, scSurface);
        sf.landSpacecraft(sc2, Planet.MERCURY);
        assertArrayEquals(new Element []{null, new Element(sc6), null, null, null, null, null, null}, sf.getScOnSurface());
    }
    @Test
    public void testLandOnSurface_willDestroyed2(){
        Spacecraft sc = new Spaceplane("Alireza", 0, 4.6);
        Spacecraft sc2 = new Rocket("Kobra", 5d, 3.8);
        Spacecraft sc3 = new Satellite("Bahar", Satellite.Usage.MILITARY, 3.8);
        Spacecraft sc4 = new Spaceplane("Mahdi", 5, 3.8);
        Spacecraft sc5 = new Spaceplane("Mohammad", 0, 4.6);
        Spacecraft sc6 = new Rocket("Jawad", 0d, 4.6);
        Spacecraft sc7 = new Rocket("Kobra", 5d, 3.8);
        Element[] scOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                sc,
                sc2,
                sc3,
                sc4}),
            //VENUS EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null, null
        };
        Element[] scSurface = new Element[]{
            //MERCURY
            null,
            //VENUS
            createList(new Spacecraft[]{
               sc6}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet sf = SpaceFleet.createSpaceFleet("SF", "$#$", scOrbit, scSurface);
        sf.landSpacecraft(sc3, Planet.MERCURY);
        assertArrayEquals(new Element []{null, new Element(sc6), null, null, null, null, null, null}, sf.getScOnSurface());
    }
      @Test
    public void testLandOnSurface_NotExistInOrbit(){
        Spacecraft sc = new Spaceplane("Alireza", 0, 4.6);
        Spacecraft sc2 = new Rocket("Kobra", 5d, 3.8);
        Spacecraft sc3 = new Satellite("Bahar", Satellite.Usage.MILITARY, 3.8);
        Spacecraft sc4 = new Spaceplane("Mahdi", 5, 3.8);
        Spacecraft sc5 = new Spaceplane("Mohammad", 0, 4.6);
        Spacecraft sc6 = new Rocket("Jawad", 0d, 4.6);
        Spacecraft sc7 = new Rocket("Kobra", 5d, 3.8);
        Element[] scOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                sc,
                sc2,
                sc3,
                sc4}),
            //VENUS EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null, null
        };
        Element[] scSurface = new Element[]{
            //MERCURY
            null,
            //VENUS
            createList(new Spacecraft[]{
               sc6}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };
        SpaceFleet sf = SpaceFleet.createSpaceFleet("SF", "$#$", scOrbit, scSurface);
        sf.landSpacecraft(sc5, Planet.MERCURY);
        assertArrayEquals(new Element []{null, new Element(sc6), null, null, null, null, null, null}, sf.getScOnSurface());
    }
}
