/**
 * This class uses Element class as instance to make a list of elements. It
 * contains methods to add elements, delete elements, show elements.
 *
 */
package grp22_ueb03;

/**
 *
 * @author kobra
 */
public class MyList {

    private Element element;

    /**
     * checks if the list is empty.
     *
     * @return true if the given list is empty
     */
    public boolean isEmpty() {
        return element == null;
    }

    /**
     * appending an element with given value.
     *
     * @param value of the elements in char type
     */
    public void appendElement(char value) {
        if (isEmpty()) {
            element = new Element();
            element.setValue(value);
        } else {
            element = element.appendElement(value);
        }
    }

    /**
     * inserts an elements with given value.
     *
     * @param value for an element in char type
     */

    public void insertElement(char value) {
        if (isEmpty()) {
            element = new Element();
            element.setValue(value);
        } else {
            element = element.insertElement(value);
        }
    }

    /**
     * deletes the element with the given value.
     *
     * @param value of the elements in char type
     */
    public void deleteElement(char value) {
        if (isEmpty()) {
            this.isEmpty();
        } else {
            element = element.deleteElement(value);
        }
    }

    /**
     * checks the size of the list and return it.
     *
     * @return integer value
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return element.size();
        }
    }

    /**
     * checks if the list is sorted in ascending.
     *
     * @return true if the given list is sorted
     */
    public boolean isSorted() {
        if (isEmpty()) {
            return true;
        } else {
            return element.isSorted();
        }
    }

    /**
     * checks if an element with given value exist in our list.
     *
     * @param value of the elements
     * @return boolean (true/false)
     */

    public boolean existsElement(char value) {
        if (isEmpty()) {
            return false;
        } else {
            return element.existsElement(value);
        }
    }

    /**
     * show all values of the elements in String format
     *
     * @return String
     */
    //TODO trouble with empty list, write simply test case for it
    public String showElements() {
        if (!isEmpty()){
            return "{" + element.showElements() + "}";
        }
        else{
            return "{}";
        }
    }

    /**
     * stores all values of the list into an array
     *
     * @return char array copied from the list
     */
    public char[] getValues() {
        char[] values = new char[size()];
        if (!isEmpty()) {
            for (int i = 0; i < values.length; i++) {
                values[i] = element.getElementAt(i);
            }
        }
        return values;
    }

    /**
     * it takes the index of the element and returns the value at given index
     *
     * @param index of the element in integer format
     * @return value of the element in the position index
     */
    public char getValueAt(int index) {
        if (isEmpty()) {
            return Element.INVALID_VALUE;
        } else {
            return element.getElementAt(index);
        }
    }

    /**
     * inserts an element into the list with given value in given index
     *
     * @param value is the given value
     * @param index is the index of value
     */
    public void insertElementAt(char value, int index) {
        if (isEmpty() && index == 0) {
            appendElement(value);
        } else if (!isEmpty()) {
            element = element.insertElementAt(value, index);
        }
    }

    /**
     * inserts element at the beginning of the list
     *
     * @param value is the given value
     */
    public void insertElementAtFront(char Value) {
        if (isEmpty()) {
            appendElement(Value);
        } else {
            element = element.insertElementAtFront(Value);
        }
    }

    /**
     * inserts value into the list if there is no same value in the list and the
     * value will be inserted before first greater value than itself
     *
     * @param value of the element
     */
    public void insertSortedIfUnique(char value) {
        if (isEmpty()) {
            appendElement(value);
        } else {
            if (!existsElement(value)) {
                element = element.insertElement(value);
            }
        }
    }
}
