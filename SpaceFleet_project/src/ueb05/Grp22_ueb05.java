package ueb05;

/**
 * In this class multiple fleets are created, which manage their spacecraft and
 * output them on stdout. 
 *
 * @author lvo
 */

//TODO DONE formatting for all classes!!!
//TODO DONE output should number proper
public class Grp22_ueb05 {
      /**
     * Create a sorted list of spacecrafts, which are in the array {@code scArr} 
     *
     * @param scArr spacecrafts, that should be added to the list
     * @return sorted list with the spacecrafts from {@code scArr}; null,
     * if the array {@code scArr} is null or its length is 0
     */
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

    /**
     * Create as an example a few fleets and outputs these on stdout. 
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Element batFleet = createList(new Spacecraft[]{
            new Rocket("batRocket1", 5d, 3.8),
            new Rocket("batRocket2", 5d, 3.8),
            new Satellite("batSat1", Satellite.Usage.MILITARY, 20.9)});

        Element[] pigOrbit = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                new Spaceplane("pigPlane2", 0, 4.6),
                new Rocket("pigRocket1", 5d, 3.8),
                new Rocket("pigRocket2", 5d, 3.8),
                new Spaceplane("pigPlane1", 5, 3.8)}),
            //VENUS EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null, null
        };

        Element[] pigSurface = new Element[]{
            //MERCURY
            createList(new Spacecraft[]{
                new Spaceplane("pigRocket0", 0, 4.6),}),
            //VENUS
            createList(new Spacecraft[]{
                new Rocket("pigRocket0", 0d, 4.6),
                new Satellite("pigSat1", Satellite.Usage.MILITARY, 20.9)}),
            //EARTH MARS JUPITER SATURN URANUS NEPTUNE
            null, null, null, null, null, null
        };

        SpaceFleet cat = new SpaceFleet("Collective of "
                + "Aeronautic Territories", "[ðŸ±]");
        SpaceFleet bat = new SpaceFleet("British Agency of "
                + "Terraforming ", "[ðŸ¦‡]", Planet.EARTH, batFleet);
        SpaceFleet pig = SpaceFleet.createSpaceFleet(
                "Plutocratic Interstellar Government", "[ðŸ·]", pigOrbit, pigSurface);

        cat.buildSpacecraft(new Satellite("catSat1", Satellite.Usage.GPS,
                11.9), Planet.SATURN);
        cat.buildSpacecraft(new Satellite("catSat2", Satellite.Usage.RESEARCH,
                2.3), Planet.SATURN);
        cat.buildSpacecraft(new Spaceplane("catPlane1", 4, 10.5), Planet.EARTH);

        System.out.println("------------------------------");
        System.out.print(cat.toString() + "\n");
        System.out.println("------------------------------");
        System.out.print(bat.toString() + "\n");
        System.out.println("------------------------------");
        if (pig != null) {
            System.out.print(pig.toString() + "\n");
        } else {
            System.err.println("Error: SpaceAdministration PIG could not be created");
        }

    }
    /*
An output could look like this:

------------------------------
Collective of Aeronautic Territories [ðŸ±] (fleet strength: 3)
-------------- 
earth surface 
 1. catPlane1  Spaceplane: 4  crew members   , max. escape gravitation:  10,50 , reuseable: true 
-------------- 
saturn surface 
 1. catSat1    Satellite:              GPS   , max. escape gravitation:  11,90 , reuseable: false 
 2. catSat2    Satellite:         RESEARCH   , max. escape gravitation:   2,30 , reuseable: false 


------------------------------
British Agency of Terraforming  [ðŸ¦‡] (fleet strength: 3)
-------------- 
earth surface 
 1. batRocket1 Rocket: 5,000000  cargo load  , max. escape gravitation:   3,80 , reuseable: false 
 2. batRocket2 Rocket: 5,000000  cargo load  , max. escape gravitation:   3,80 , reuseable: false 
 3. batSat1    Satellite:         MILITARY   , max. escape gravitation:  20,90 , reuseable: false 


------------------------------
Plutocratic Interstellar Government [ðŸ·] (fleet strength: 7)
-------------- 
mercury surface 
 1. pigRocket0 Spaceplane: 0  crew members   , max. escape gravitation:   4,60 , reuseable: true 
-------------- 
venus surface 
 1. pigRocket0 Rocket: 0,000000  cargo load  , max. escape gravitation:   4,60 , reuseable: false 
 2. pigSat1    Satellite:         MILITARY   , max. escape gravitation:  20,90 , reuseable: false 
-------------- 
mercury orbit 
 1. pigPlane1  Spaceplane: 5  crew members   , max. escape gravitation:   3,80 , reuseable: true 
 2. pigPlane2  Spaceplane: 0  crew members   , max. escape gravitation:   4,60 , reuseable: true 
 3. pigRocket1 Rocket: 5,000000  cargo load  , max. escape gravitation:   3,80 , reuseable: false 
 4. pigRocket2 Rocket: 5,000000  cargo load  , max. escape gravitation:   3,80 , reuseable: false
 */
}
