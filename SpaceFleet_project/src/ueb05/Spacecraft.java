/*
 *
 */
package ueb05;

import java.lang.*;

/**
 * This class has three public attributes that it used in three specialization
 * classes the spacecraft its type of the data
 *
 * @author Kobra
 */
public class Spacecraft {

    //TODO DONE private
    private String Name;
    private double maxGravity;
    private boolean isDestroyed;

    /**
     * default constructor
     */
    Spacecraft() {

    }

    /**
     * getting the name of the spacecraft
     *
     * @return the name
     */
    public String getName() {
        return this.Name;
    }

    /**
     * set the name of the spaceccraft
     *
     * @param name
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * set the maxGravity attribute of the spacecraft
     *
     * @param maxGravity is given garvity of the spacecraft
     */
    public void setMaxGravity(double maxGravity) {
        this.maxGravity = maxGravity;
    }

    /**
     * get the maxGravity of the spacecraft
     *
     * @return the value of the garvity of spacecraft
     */
    public double getMaxGravity() {
        return this.maxGravity;
    }

    /**
     * this constructor set the name of the spacecraft TODO DONE missing comment
     *
     * @param name setting the name
     */
    Spacecraft(String name) {
        this.Name = name;
    }

    /**
     * this constructor sets the name and maxGravity of the spacecraft TODO DONE
     * missing comment
     *
     * @param name is the name of spacecraft
     * @param maxGravity is gravity of spacecraft
     */
    Spacecraft(String name, double maxGravity) {
        this.Name = name;
        this.maxGravity = maxGravity;
    }

    /**
     * The toSring method is to print the elements of the list of spacecraft.
     * TODO DONE missing comment
     *
     * @return TODO DONE only here
     */
   // private final int intFarmat = 25;

    @Override
    public String toString() {
        //return   String.format(Name + "\t" + getDescription()
        //+ "%25d max.escape gravitation " + maxGravity + "    reusable : " + getReusable() + "\n");
        String s = String.format("%-10s %30s %15f \tmax.escape gravitation \t reusable: %-20B %n", Name, getDescription(), maxGravity, getReusable());
        return s;
    }

    /**
     * define the reusability of the spacecrafts. this overridden by child
     * methods
     *
     * @return true if the spacecraft is reusable again
     */
    public boolean getReusable() {
        return this.isDestroyed;
    }

    /**
     * the description of each child class that overridden by child methods
     *
     * @return String value of details of each child
     */
    public String getDescription() {
        return " ";
    }

    /**
     * spacecraft are equals if they have the same name
     *
     * @param obj is given spacecraft
     * @return true if its equal
     */
    //TODO Done does not recognize two equal spacecrafts as equal ? look at email!
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Spacecraft) {
            Spacecraft sf = (Spacecraft) obj;
            if (this.Name == null && sf.Name == null) {
                return true;
            } else {
                return this.Name.equals(sf.Name);
            }
        } else {
            return false;
        }
    }

    /**
     * compares two spaceships lexicographically
     *
     * @param other is given spacecraft
     * @return -1 if other is greater that this , return 1 if other is less than
     * this return 0 if they are equal
     */
    //TODO DONE no return inside for loop, shorten
    public int compareByName(Spacecraft other) {
        int equality = 0;
        if (this.Name != null && other.Name != null) {
            // Check whether any of the first characters are different
            // already
            int i = 0;
            for (; i < this.Name.length() && i < other.Name.length() && equality == 0; i++) {
                if (this.Name.charAt(i) > other.Name.charAt(i)) {
                    equality = 1;
                } else if (this.Name.charAt(i) < other.Name.charAt(i)) {
                    equality = -1;
                }
            }
            
            // Any difference found?
            if (equality != 0) {
                return (equality);
            } else if (other.Name.length() > this.Name.length()) {
                return (-1);
            } else if (this.Name.length() > other.Name.length()) {
                return (1);
            } else {
                return (0);
            }
            
        } else if (other.Name == null && this.Name != null) {
            return(1);
        } else if (this.Name == null && other.Name != null) {
            return(-1);
        } else {
            return (0);
        }
    }
    
    public int compareByNumber(int lhs, int rhs) {
        if (lhs > rhs) { return 1; }
        else if (rhs > lhs) { return -1; }
        else { return 0; }
    }

}
