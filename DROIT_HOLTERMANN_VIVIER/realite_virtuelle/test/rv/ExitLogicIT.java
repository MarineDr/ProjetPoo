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
public class ExitLogicIT {

    Hero h;
    Place p;
    ExitLogic e;

    public ExitLogicIT() {
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
        e = new ExitLogic(2, p, p);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of pass method, of class ExitLogic.
     */
    @Test
    public void testPass() {
        e.pass(h);
    }

}
