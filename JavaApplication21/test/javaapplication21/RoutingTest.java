/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

import RouteFinding.Routing;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alireza
 */
public class RoutingTest {
    
    public RoutingTest() {
    }

    @Test
    public void routes() {
        Routing rt = new Routing();
        assertEquals("kbl, ham, mun, wein, par", rt.findRoute(new String [][]{
            {"ham", "mun"}, {"kbl", "ham"}, {"mun", "wein"}, {"wein", "par"}}));

        assertEquals("a, b, c, d, e, f", rt.findRoute(new String [][]{
            {"d", "e"}, {"b", "c"}, {"a", "b"}, {"c", "d"}, {"e", "f"}})); 
    }
    
}
