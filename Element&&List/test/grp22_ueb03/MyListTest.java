/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp22_ueb03;

import org.junit.Test;
import static org.junit.Assert.*;
//import org.junit.FixMethodOrder;
//import org.junit.runners.MethodSorters;


/**
 * Tests of the methods that have been presented in the lecture.
 *
 * @author klk
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class MyListTest {

    /**
     * Creates a list with the given values.
     *
     * @param value value, that should be inserted into the list
     * @return Liste mit den Werten.
     */
    private MyList createList(char... value) {
        MyList list = new MyList();
        for (char i : value) {
            list.appendElement(i);
        }
        return list;
    }

//<editor-fold defaultstate="collapsed" desc="Method tests for methods from the lecture">
    //-----------------------------------------------
    @Test
    public void testIsEmpty() {
        MyList list = new MyList();
        assertTrue(list.isEmpty());
        list = createList('a');
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAppendElement() {
        MyList list = new MyList();
        assertEquals(0, list.size());
        list.appendElement('a');
        assertEquals(1, list.size());
    }

    //-----------------------------------------------
    //<editor-fold defaultstate="collapsed" desc="testInsertElement">
    @Test
    public void testInsertElement_InEmptyList() {
        MyList list = createList();
        list.insertElement('a');
        assertEquals(1, list.size());
    }

    @Test
    public void testInsertElement_AtFront() {
        MyList list = createList('b', 'c', 'd');
        list.insertElement('a');
        assertEquals(4, list.size());
        assertArrayEquals(new char[]{'a', 'b', 'c', 'd'}, list.getValues());
    }

    @Test
    public void testInsertElement_InMiddle() {
        MyList list = createList('a', 'c', 'd');
        list.insertElement('b');
        assertEquals(4, list.size());
        assertArrayEquals(new char[]{'a', 'b', 'c', 'd'}, list.getValues());
    }

    @Test
    public void testInsertElement_AtEnd() {
        MyList list = createList('a', 'b', 'c');
        list.insertElement('d');
        assertEquals(4, list.size());
        assertArrayEquals(new char[]{'a', 'b', 'c', 'd'}, list.getValues());
    }
//</editor-fold>

    //-----------------------------------------------
    //<editor-fold defaultstate="collapsed" desc="testDeleteElement">
    @Test
    public void testDeleteElement_AtFront() {
        MyList list = createList('a', 'b', 'c');
        list.deleteElement('a');
        assertEquals(2, list.size());
        assertArrayEquals(new char[]{'b', 'c'}, list.getValues());
    }

    @Test
    public void testDeleteElement_InMiddle() {
        MyList list = createList('a', 'b', 'c');
        list.deleteElement('b');
        assertEquals(2, list.size());
        assertArrayEquals(new char[]{'a', 'c'}, list.getValues());
    }

    @Test
    public void testDeleteElement_AtEnd() {
        MyList list = createList('a', 'b', 'c');
        list.deleteElement('c');
        assertEquals(2, list.size());
        assertArrayEquals(new char[]{'a', 'b'}, list.getValues());
    }

    @Test
    public void testDeleteElement_NotExisting() {
        MyList list = createList('a', 'b', 'c');
        list.deleteElement('d');
        assertEquals(3, list.size());
        assertArrayEquals(new char[]{'a', 'b', 'c'}, list.getValues());
    }

    @Test
    public void testDeleteElement_EmptyList() {
        MyList list = createList();
        list.deleteElement('d');
        assertEquals(0, list.size());
        assertArrayEquals(new char[]{}, list.getValues());
    }
//</editor-fold>

//</editor-fold>
    //-----------------------------------------------
//<editor-fold defaultstate="collapsed" desc="required situation tests">
    /*TODO Test ListOfThree with list     {'a', 'c', 'e'}      */
 /*TODO Test ListWithDoubleValues with {'a', 'b', 'b', 'c'} */
 /*TODO Test ListUnsortedAtBegin  with {'b', 'a', 'c'}      */
 /*TODO Test ListEmpty            with {}           */
 /*
    for each test
    - is empty
    - is sorted
    - list length
    - exists the value [..] (check all existing values and at least one non-existant value)
    - getValueAt for each available value and at least one wrong index
    
    use
    - assertTrue(), assertFalse(), assertEquals(), as needed assertArrayEquals()
     */
//</editor-fold>
    ///////////////////////////////////////////////
    @Test
    public void testListOfThree() {
        MyList list = createList('a', 'c', 'e');
        assertFalse(list.isEmpty());
        assertTrue(list.isSorted());
        assertEquals(3, list.size());
        assertTrue(list.existsElement('a'));
        assertTrue(list.existsElement('c'));
        assertTrue(list.existsElement('e'));
        assertFalse(list.existsElement('b'));
        assertEquals('a', list.getValueAt(0));
        assertEquals('c', list.getValueAt(1));
        assertEquals('e', list.getValueAt(2));
        assertEquals(0, list.getValueAt(6));
        assertEquals(0, list.getValueAt(-1));
    }

    @Test
    public void testListWithDoubleValue() {
        MyList list = createList('a', 'b', 'b', 'c');
        assertFalse(list.isEmpty());
        assertTrue(list.isSorted());
        assertEquals(4, list.size());
        assertTrue(list.existsElement('a'));
        assertTrue(list.existsElement('b'));
        assertTrue(list.existsElement('c'));
        assertFalse(list.existsElement('e'));
        assertEquals('a', list.getValueAt(0));
        assertEquals('b', list.getValueAt(1));
        assertEquals('b', list.getValueAt(2));
        assertEquals('c', list.getValueAt(3));
        assertEquals(0, list.getValueAt(-1));
        assertEquals(0, list.getValueAt(6));
    }

    @Test
    public void testListEmpty() {
        MyList list = createList();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        list.insertElementAt('e', 4);
        assertEquals(0, list.size());
        list.insertElementAt('e', -1);
        assertEquals(0, list.size());
        list.insertElementAt('e', 0);
        assertEquals(1, list.size());
        list.deleteElement('e');
        list.insertElementAtFront('e');
        assertEquals(1, list.size());
    }

    @Test
    public void testListUnsortedAtBegin() {
        MyList list = createList('b', 'a', 'c');
        assertFalse(list.isEmpty());
        assertFalse(list.isSorted());
        assertEquals(3, list.size());
        assertTrue(list.existsElement('b'));
        assertTrue(list.existsElement('a'));
        assertTrue(list.existsElement('c'));
        assertFalse(list.existsElement('e'));
        assertEquals('b', list.getValueAt(0));
        assertEquals('a', list.getValueAt(1));
        assertEquals('c', list.getValueAt(2));
        assertEquals(0, list.getValueAt(-1));
        assertEquals(0, list.getValueAt(3));
    }

    @Test
    public void testInsertSortedIfUnique() {
        MyList list = createList('b', 'a', 'c');
        assertFalse(list.existsElement('e'));
        list.insertSortedIfUnique('A');
        assertEquals(4, list.size());
        list.insertSortedIfUnique('b');
        assertEquals(4, list.size());
    }

    @Test
    public void ownTestInsertElementAtList() {
        MyList list = createList('b', 'a', 'c');
        list.insertElementAt('A', 0);
        assertEquals(4, list.size());
        assertEquals('A', list.getValueAt(0));
        assertEquals('c', list.getValueAt(3));
    }

    @Test
    public void ownTestInsertElementAtFront() {
        MyList list = createList('b', 'a', 'c');
        list.insertElementAtFront('e');
        assertEquals(4, list.size());
        assertEquals('e', list.getValueAt(0));
        assertEquals('c', list.getValueAt(3));
    }

    @Test
    public void ownTestInsertElementAtEmptyList() {
        MyList list = createList();
        list.insertElementAt('e', 1);
        assertEquals(0, list.size());
        list.insertElementAt('e', 0);
        assertEquals(1, list.size());
        assertEquals('e', list.getValueAt(0));
    }

    @Test
    public void ownTestInsertElementAtFront_EmptyList() {
        MyList list = createList();
        list.insertElementAtFront('e');
        assertEquals(1, list.size());
        assertEquals('e', list.getValueAt(0));
    }

    @Test
    public void ownTestInsertElementAt_EmptyList() {
        MyList list = createList();
        assertEquals(0, list.size());
        list.insertElementAt('e', 1);
        assertEquals(0, list.size());
        list.insertElementAt('e', 0);
        assertEquals(1, list.size());

    }
    @Test
    public void ownTestshowElements_isEmpty(){
        MyList list = createList();
        assertEquals("{}", list.showElements());  
    }

     @Test
    public void ownTestshowElements(){
        MyList list = createList('b', 'a', 'c');
        assertEquals("{b a c}", list.showElements());  
    }
}





































