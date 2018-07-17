package ueb05;

/**
 * This class is creating new spacecrfat , insert spacecraft ,delete spacecraft
 * and also calculating the number of spacecraft. TODO DONE description of class
 *
 * @author Alireza
 */
//TODO DONE For testing purposes, add an iteratively working method getValues(): Spacecraft[].
public class Element {

    private Spacecraft spaceCraft;
    private Element next;

    /**
     * default constructor
     */
    Element() {
    }

    /**
     * set the spacecraft
     *
     * @param spaceCraft is given spacecraft
     */
    Element(Spacecraft spaceCraft) {
        this.spaceCraft = spaceCraft;
    }

    /**
     * This method gets the spacecraft TODO DONE MISSING DESCRIPTION
     *
     * @return the spacecraft
     */
    public Spacecraft getSpacecraft() {
        return spaceCraft;
    }

    /**
     * This method gets the next element TODO DONE MISSING DESCRIPTION
     *
     * @return the next element
     */
    public Element getNext() {
        return next;
    }

    /**
     * set the next element
     *
     * @param next is given parameter
     */
    public void setNext(Element next) {
        this.next = next;
    }

    /**
     * set the spacecraft
     *
     * @param spaceCraft is given spacecraft
     */
    public void setSpaceCraft(Spacecraft spaceCraft) {
        this.spaceCraft = spaceCraft;
    }

    /**
     * adds a given spacecraft to the list
     *
     * @param spacecraft
     * @return the updated element that contains the given spacecraft
     */
    public Element insertElement(Spacecraft spacecraft) {

        if (this.spaceCraft.compareByName(spacecraft) > 0) {
            Element newSpacecraft = new Element();
            newSpacecraft.setSpaceCraft(spacecraft);
            newSpacecraft.setNext(this);
            return newSpacecraft;
        } else if (spaceCraft.compareByName(spacecraft) == 0) {
            Element newSpacecraft = new Element();
            newSpacecraft.setSpaceCraft(spacecraft);
            this.setNext(newSpacecraft);
            return this;
        } else if (this.next == null) {
            Element newSpacecraft = new Element();
            newSpacecraft.setSpaceCraft(spacecraft);
            this.setNext(newSpacecraft);
            return this;

        } else {
            this.next = this.next.insertElement(spacecraft);
            return this;
        }
    }

    /**
     * This method calculate the number of spacecrafts TODO DONE MISSING
     * DESCRIPTION
     *
     * @return the size of the list
     */
    public int size() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    /**
     * deletes the element with given value
     *
     * @param value of an elements in Spacecraft type
     * @return element
     */
    public Element deleteElement(Spacecraft value) {

        if (this.getSpacecraft().equals(value)) {
            return this.next;
        } else {
            if (this.next != null) {
                this.next = this.next.deleteElement(value);
            }
            return this;
        }
    }

    /**
     * return value of the elements at specific position with given index
     *
     * @param index is the position of the value
     * @return the value of the given index
     */
    public Spacecraft getElementAt(int index) {
        if (index == 0) {
            return this.getSpacecraft();
        } else if (index > 0 && this.next != null) {
            return this.next.getElementAt(index - 1);
        } else {
            return new Spacecraft();
        }
    }

    /**
     * return string in a single line containing current spacecraft and all
     * succeeding spacecraft separated by space
     *
     * @return a string of spacecraft
     */
    //TODO DONE comment
    private String showElements() {

        if (this.next == null) {
            return "" + this.getSpacecraft().toString();
        } else {
            return this.getSpacecraft() + " " + this.next.showElements();
        }
    }

    /**
     * return true if there is an element with given value
     *
     * @param value is the given value
     * @return true if the value is exists
     */
    public boolean existsElement(Spacecraft value) {

        if (this.spaceCraft.equals(value)) {
            return true;
        } else if (this.next != null) {
            return this.next.existsElement(value);
        } else {
            return false;
        }

    }

    /**
     * this method get the values of the spacecraft and store them into an array
     *
     * @returns all elements of the set in an array
     */
    Spacecraft[] getValues() {
        Spacecraft[] values = new Spacecraft[size()];
        if (this.next != null) {
            for (int i = 0; i < values.length; i++) {
                values[i] = this.getElementAt(i);
            }
        }
        return values;
    }

    /**
     * checks if the given element is equal to this element
     *
     * @param obj
     * @return true if two elements are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Element) {
            Element elem = (Element) obj;
            if (this.next == null && elem.next == null) {
                return this.spaceCraft.equals(elem.spaceCraft);
            } else if (this.next != null && elem.next != null) {
                return this.spaceCraft.equals(elem.spaceCraft) && this.next.equals(elem.next);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * returning the showElement method TODO DONE MISSING DESCRIPTION
     *
     * @return a string
     */
    @Override
    public String toString() {

        return showElements();
    }
}
