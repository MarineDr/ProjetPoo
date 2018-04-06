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
public class CommandIT {

    Place p;
    Hero h;
    Command c;
    Stuff s1, s2;

    public CommandIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        c = Command.none;
        p = new Place("here", "its here");
        h = new Hero("me", p);
        s1 = new Paper("paper", "azerty");
        s2 = new Apple();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of utiliser method, of class Command.
     */
    @Test
    public void testUtiliser_Stuff_Stuff() {
        c.utiliser(s1, s2);
    }

}
