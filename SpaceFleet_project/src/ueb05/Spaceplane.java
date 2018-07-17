/*
 * 
 */
package ueb05;

/**
 * This class is exteneded from spacecraft class and gets some attributes from
 * that and also has an additional attribute like number of crew. TODO DONE
 * missing comment
 *
 * @author Alireza
 */
public class Spaceplane extends Spacecraft {

    int numberOfCrew;
    private final boolean REUSABLE = true;

    /**
     * override the reusable method of parent and return the constant reusable.
     *
     * @return true if the spacecraft is reusable
     */
    @Override
    public boolean getReusable() {
        return this.REUSABLE;
    }

    /**
     * this constructor setting the name , number of crew and max gravity of the
     * spaceplane
     *
     * @param name is given name
     * @param numberOfCrew is the given crew number
     * @param maxGravity is the given gravity
     */
    Spaceplane(String name, int numberOfCrew, double maxGravity) {
        super.setName(name);
        this.numberOfCrew = numberOfCrew;
        super.setMaxGravity(maxGravity);
    }

    /**
     * check if two Objects are equal
     *
     * @param obj
     * @return true if the references of the calling and given instances are
     * equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Spaceplane) {
            return super.equals(obj);
        } else {
            return false;
        }
    }

    /**
     * This method represent a description of the spaceplane class , which
     * contains the name , number of crew , maxGravity and reusablility of that.
     * TODO DONE missing comment
     *
     * @return a description of the spaceplane with the given attributes
     */
    @Override
    public String getDescription() {

        return String.format("    Spaceplane: %15d crew members \t", numberOfCrew);
    }

}
