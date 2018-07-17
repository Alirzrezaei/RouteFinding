/*
 * 
 */
package ueb05;

/**
 * This class is used for location of the spacecrafts. it has some attributes
 * like enum type which is the name of all planet in this project. and also
 * calculate the gravity of the planet.
 *
 * @author Alireza
 */
public enum Planet {

    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    /**
     * accuracy of comparisons *
     */
    private static final float EPSILON = 0.0001f;

    /**
     * number of planets *
     */
    static final int SIZE = Planet.values().length;

    /**
     * mass in kg *
     */
    private final double mass;

    /**
     * radius in m *
     */
    private final double radius;

    /**
     * universal gravitation konstant (m3 kg^-1 s^-2) *
     */
    public static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    /**
     * returns the mass of the planet
     *
     * @return Masse des Planeten in Kilogramm
     */
    public double mass() {
        return mass;
    }

    /**
     * returns the radius of the planet
     *
     * @return radius of the planet in meters
     */
    public double radius() {
        return radius;
    }

    /**
     * returns the gravitation on the surface of the planet
     *
     * @return gravitation in m/s^2
     */
    public double surfaceGravity() {

        return (G * mass) / (radius * radius);
    }

    /**
     * Returns -1, 0 or +1, if the gravitation of the given planet is larger,
     * equal or lesser than the gravitation of this.
     *
     * @param other the planet that is compared with
     * @return -1, 0, 1 if the gravitation is greater, equal or lesser than
     * this.surfaceGravity() is
     */
    public int comparePlanetBySurfaceGravity(Planet other) {

        if (Math.abs(this.surfaceGravity() - other.surfaceGravity()) < EPSILON) {
            return 0;
        } else if (this.surfaceGravity() < other.surfaceGravity()) {
            return -1;
        } else {
            return 1;
        }

    }
}
