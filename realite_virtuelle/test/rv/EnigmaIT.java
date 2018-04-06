/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rv;

import rv.Hero;
import rv.Enigma;
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
public class EnigmaIT {

    public EnigmaIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of open method, of class Enigma.
     */
    @Test
    public void testOpen() {
        Hero h = null;
        Enigma instance = new Enigma("esdrfgh", 1, "dfghj", "sdfgyhuji");
        instance.open(h);
    }

}
