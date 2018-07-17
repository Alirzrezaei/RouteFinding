package ueb05;

import java.util.Arrays;

/**
 * TODO DONE comment Space Fleet is making a list of elements that store
 * spacecrafts in for each planet. The list are stored into two arrays for
 * surface of planet and orbiting around planet.
 *
 * @author Alireza
 */
public class SpaceFleet {

    //TODO DONE private
    //private Element spaceCraft; //why???
    private Element scOnSurface[] = new Element[Planet.SIZE]; // spacecrafts in the orbit of the planet
    private Element sclnOrbit[] = new Element[Planet.SIZE];// spacecrfts in the surface of the planet
    private String Name;
    private String flag;

    /**
     * default constructor
     */
    public SpaceFleet() {
    }

    /**
     * instance that gets two parameter and flag
     *
     * @param name is given name
     * @param flag is given flag
     */
    public SpaceFleet(String name, String flag) {
        this.Name = name;
        this.flag = flag;
    }

    /**
     * another instance that sets some parameter of space fleet
     *
     * @param name is the name of the space fleet
     * @param flag is the sign of the space fleet
     * @param planet is given planet
     * @param scOnSurface is the list of spacecrafts that are in the surface
     */
    public SpaceFleet(String name, String flag, Planet planet, Element scOnSurface) {

        this(name, flag);
        Spacecraft sc = new Spacecraft();
        this.scOnSurface[planet.ordinal()] = scOnSurface;
    }

    /**
     *
     * @param name is the name of the space fleet
     * @param flag is the sign of the space fleet
     * @param onSurface is an array of spacecraft that are in the surface
     * @param onOrbit is the spacecraft in the orbit
     * @return spacefleet with the given attributes
     */
    //TODO DONE should be possible to create a space fleet with no elements on the surface/in the orbit
    public static SpaceFleet createSpaceFleet(String name, String flag, Element onOrbit[], Element onSurface[]) {
        assert (name != null);
        assert (flag != null);
        assert (onOrbit != null);
        assert (onSurface != null);

        if (onSurface.length == Planet.SIZE && onOrbit.length == Planet.SIZE) {
            SpaceFleet sf = new SpaceFleet(name, flag);
            sf.scOnSurface = onSurface;
            sf.sclnOrbit = onOrbit;
            return sf;
        } else {
            return null;
        }
    }

    /**
     * creates and adds a spacecraft to the surface of the planet
     *
     * @param sc is given spacecraft
     * @param loc is given planet
     */
    //TODO DONE handle undesired values
    public void buildSpacecraft(Spacecraft sc, Planet loc) {
        assert (sc != null);
        assert (loc != null);

        if (scOnSurface[loc.ordinal()] != null) {
            if (!scOnSurface[loc.ordinal()].existsElement(sc)) {
                scOnSurface[loc.ordinal()] = scOnSurface[loc.ordinal()].insertElement(sc);
            }
        } else {
            scOnSurface[loc.ordinal()] = new Element(sc);
        }

        assert (scOnSurface[loc.ordinal()].existsElement(sc));
    }

    /**
     * remove the sc from the surface of the given planet and add it to the
     * orbit of the planet
     *
     * @param sc is the given spacecraft
     * @param loc is given planet
     */
    //TODO DONE take care of values that are not good: null, Spacecraft not on planet
    //TODO DONE write test, causes NullPointerException
    public void launchSpacecraftToOrbit(Spacecraft sc, Planet loc) {

        assert (sc != null);
        assert (loc != null);
        if (scOnSurface[loc.ordinal()] != null && scOnSurface[loc.ordinal()].existsElement(sc)) {
            if (sc.getMaxGravity() > loc.surfaceGravity()) {
                scOnSurface[loc.ordinal()] = scOnSurface[loc.ordinal()].deleteElement(sc);
                if (sclnOrbit[loc.ordinal()] != null) {
                    sclnOrbit[loc.ordinal()] = sclnOrbit[loc.ordinal()].insertElement(sc);
                } else {
                    Element tempSC = new Element(sc);
                    sclnOrbit[loc.ordinal()] = tempSC;
                }
            }
        }
    }

    /**
     * remove the sc from the orbit of the given planet and add it to the
     * surface of the planet
     *
     * @param sc is the given spacecraft
     * @param orbit is given planet
     */
    //TODO DONE not-reusable spacecrafts are destroyed upon landing
    //TODO DONE write a test, causes NullPointerException
    public void landSpacecraft(Spacecraft sc, Planet orbit) {
        assert (sc != null);
        assert (orbit != null);
        if (sclnOrbit[orbit.ordinal()] != null && sclnOrbit[orbit.ordinal()].existsElement(sc)) {

            sclnOrbit[orbit.ordinal()] = sclnOrbit[orbit.ordinal()].deleteElement(sc);

            if (sc.getReusable() && scOnSurface[orbit.ordinal()] != null) {
                scOnSurface[orbit.ordinal()] = scOnSurface[orbit.ordinal()].insertElement(sc); //TODO Done do you need to build again? 
            } else if (sc.getReusable()) {
                Element tempSC = new Element(sc);
                scOnSurface[orbit.ordinal()] = tempSC;
            }
        }
    }

    /**
     * return the total number of spacecraft of the fleet
     *
     * @return an integer number
     */
    public int getFleetStrength() {
        int surfaceNum = 0;
        int orbitNum = 0;
        for (int i = 0; i < Planet.SIZE; i++) {
            if (scOnSurface[i] != null) {
                surfaceNum += scOnSurface[i].size();
            }
            if (sclnOrbit[i] != null) {
                orbitNum += sclnOrbit[i].size();
            }
        }
        return surfaceNum + orbitNum;
    }

    /**
     * the mothod is helper for testing and is returning the scInOrbit Array.
     *
     * @return an array of all spacecraft of the fleet on orbit
     */
    public Element[] getScInOrbit() {

        return this.sclnOrbit;
    }

    /**
     * TODO DONE comment the method is helper for the testing and is returning
     * the scOnSurface array
     *
     * @return an array containing all spacecraft on the surface
     */
    public Element[] getScOnSurface() {
        return this.scOnSurface;
    }

    /**
     * the toStirng method overwritten the toStirng in Element and passing a all
     * elements to be shown in Stirng format
     *
     * @return String format of data.
     */
    @Override
    public String toString() {

        Planet planet = null;
        String s = "";
        String s2 = "";
        for (int i = 0; i < this.sclnOrbit.length; i++) {
            if (this.sclnOrbit[i] != null) {
                s = s + planet.values()[i] + " Orbit \n";
                for (int j = 0; j < this.sclnOrbit[i].size(); j++) {
                    Spacecraft temp = this.sclnOrbit[i].getElementAt(j);
                    s = s + (j + 1) + ". " + temp.toString();
                }
                s = s + "--------------\n";
            }
        }
        for (int i = 0; i < this.scOnSurface.length; i++) {
            if (this.scOnSurface[i] != null) {
                s2 = s2 + planet.values()[i] + " Surface \n";
                for (int j = 0; j < this.scOnSurface[i].size(); j++) {
                    Spacecraft temp = this.scOnSurface[i].getElementAt(j);
                    s2 = s2 + (j + 1) + ". " + temp.toString();
                }
                s2 = s2 + "--------------\n";
            }
        }

        return this.Name + "  " + this.flag + " (fleet strength: " + getFleetStrength() + ")\n--------------\n"
                + s2 + s;

    }

}
