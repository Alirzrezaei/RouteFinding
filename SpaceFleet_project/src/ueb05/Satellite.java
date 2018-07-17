/*
 * 
 */
package ueb05;

/**
 * This class is exteneded from spacecraft class and gets some attributes from
 * that adn also has a enum type which has some values.
 *
 * @author Alireza
 */
public class Satellite extends Spacecraft {

    public enum Usage {
        GPS, TELECOMMUNICATION, WEATHER, MILITARY, RESEARCH;
    }

    private Usage Purpose;
    private final boolean REUSABLE = false;

    /**
     * set the name of the satellite
     *
     * @param name
     */
    Satellite(String name) {
        super.setName(name);
    }

    /**
     * this instance sets the name , usage purpose and gravity of the satellite
     *
     * @param name
     * @param purpose
     * @param maxGravity
     */
    Satellite(String name, Usage purpose, double maxGravity) {
        super.setName(name);
        this.Purpose = purpose;
        super.setMaxGravity(maxGravity);
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
     * This method represent a description of the satellite class , which
     * contains the name , purpose , maxGravity and reusablility of that. TODO
     * DONE missing comment
     *
     * @return a string that describes some infos about satellite
     */
    @Override
    public String getDescription() {
        String s = String.format("    sattelite : %26s \t", Purpose.name());
        return s;
    }

    /**
     * return a above method which print some information about the satellite
     *
     * @return a string of the descriptopn
     */
    /**
     * check if two Objects are equal
     *
     * @param obj
     * @return true if the references of the calling and given instances are
     * equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Satellite) {
            Spacecraft sf = (Spacecraft) obj;
            return super.equals(obj);
        } else {
            return false;
        }
    }

}
