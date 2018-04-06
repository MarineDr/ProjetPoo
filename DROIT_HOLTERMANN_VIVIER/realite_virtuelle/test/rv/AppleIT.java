/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rv;

import rv.Hero;
import rv.Place;
import rv.Apple;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppleIT {

    Hero h;
    Apple a;
    Place p;

    public AppleIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p = new Place("Ici", "Par la");
        h = new Hero("Tarifume", p);
        a = new Apple();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of use method, of class Apple.
     */
    @Test
    public void testUse() {
        a.use(h);
    }

}
