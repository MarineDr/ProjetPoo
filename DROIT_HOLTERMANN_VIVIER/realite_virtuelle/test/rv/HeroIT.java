/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rv;

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
public class HeroIT {

    Hero h;
    Place p;

    public HeroIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        h = new Hero("me", p);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEnergy method, of class Hero.
     */
    @Test
    public void testSetEnergy() {
        h.setEnergy(50);
        int current = h.getEnergy();
        assertEquals(current, Hero.MAX_ENERGY);
        h.setEnergy(-12);
        current = h.getEnergy();
        assertNotEquals(current, Hero.MAX_ENERGY);
    }

    /**
     * Test of addInventory method, of class Hero.
     */
    @Test
    public void testAddInventory() {
        h.addInventory(null);
    }

    /**
     * Test of searchInventory method, of class Hero.
     */
    @Test
    public void testSearchInventory() {
        assertNull(h.searchInventory("nothing"));
    }
}
