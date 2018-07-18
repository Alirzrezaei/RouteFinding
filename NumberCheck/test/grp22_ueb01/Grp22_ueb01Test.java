/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp22_ueb01;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alireza
 */
public class Grp22_ueb01Test {
    
    public Grp22_ueb01Test() {
    }

    @Test
    public void testIsBeast() {
        assertTrue(Grp22_ueb01.isBeast(-1666));
        assertTrue(Grp22_ueb01.isBeast(666));
        assertFalse(Grp22_ueb01.isBeast(16566));
        assertFalse(Grp22_ueb01.isBeast(616));
        assertFalse(Grp22_ueb01.isBeast(0));
    }
    @Test
    public void testIsNarcisstic(){
        assertTrue(Grp22_ueb01.isNarcissisticNumber(5));
        assertTrue(Grp22_ueb01.isNarcissisticNumber(153));
        assertTrue(Grp22_ueb01.isNarcissisticNumber(407));
        assertTrue(Grp22_ueb01.isNarcissisticNumber(1634));
        assertFalse(Grp22_ueb01.isNarcissisticNumber(55));
        assertFalse(Grp22_ueb01.isNarcissisticNumber(-407));   
        assertFalse(Grp22_ueb01.isNarcissisticNumber(0)); 
    }
    @Test
    public void testIsCatalan(){
        assertTrue(Grp22_ueb01.isCatalanNumber(2));
        assertTrue(Grp22_ueb01.isCatalanNumber(14));
        assertTrue(Grp22_ueb01.isCatalanNumber(132));
        assertTrue(Grp22_ueb01.isCatalanNumber(429));
        assertTrue(Grp22_ueb01.isCatalanNumber(16796));
        assertFalse(Grp22_ueb01.isCatalanNumber(-429));
        assertFalse(Grp22_ueb01.isCatalanNumber(1431));
        assertFalse(Grp22_ueb01.isCatalanNumber(0));
    }
    @Test
    public void testIsSmith(){
        assertTrue(Grp22_ueb01.isSmithNumber(22));
        assertTrue(Grp22_ueb01.isSmithNumber(85));
        assertTrue(Grp22_ueb01.isSmithNumber(166));
        assertTrue(Grp22_ueb01.isSmithNumber(666));
        assertTrue(Grp22_ueb01.isSmithNumber(958));
        assertFalse(Grp22_ueb01.isSmithNumber(-166));
        assertFalse(Grp22_ueb01.isSmithNumber(734));
        assertFalse(Grp22_ueb01.isSmithNumber(0));
    }
}
