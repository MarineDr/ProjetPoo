/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rv;

import rv.Place;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kromeuh
 */
public class PlaceIT {

    Place p;

    public PlaceIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p = new Place("here", "here I am");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of searchStuff method, of class Place.
     */
    @Test
    public void testSearchStuff() {
        assertNull(p.searchStuff("nothing"));
    }

    /**
     * Test of searchFile method, of class Place.
     */
    @Test
    public void testSearchFile() {
        assertNull(p.searchFile("nothing"));
    }

}
