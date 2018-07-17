/*
 * 
 */
package ueb05;

/**
 * this class is extened from spacecraft class and gets some attributes form
 * that
 *
 * @author Alireza
 */
public class Rocket extends Spacecraft {

    private final boolean REUSABLE = false;
    private double payLoad;

    /**
     * constructor to build a rocket with name.
     *
     * @param name
     */
    Rocket(String name) {
        super.setName(name);
    }

    /**
     * override the reusable method of parent
     *
     * @return true if the spacecraft is reusable
     */
    @Override
    public boolean getReusable() {
        return this.REUSABLE;
    }

    /**
     * set the name , payload and gravity of the given rocket
     *
     * @param name
     * @param payLoad
     * @param maxGravity
     */
    Rocket(String name, double payLoad, double maxGravity) {
        super.setName(name);
        super.setMaxGravity(maxGravity);
        this.payLoad = payLoad;

    }

    /**
     * This method represent a description of the Rocket class , which contains
     * the name , payload ,maxGravity and reusablility of that. TODO DONE
     *
     * @return a string that describes some information about the rocket
     */
    @Override
    public String getDescription() {

        return String.format("    Rocket : %25f cargo load", payLoad);
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
        if (obj instanceof Rocket) {
            return super.equals(obj);
        } else {
            return false;
        }
    }

}
