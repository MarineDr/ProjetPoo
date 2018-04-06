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
import rv.Code;
import rv.Hero;
import static org.junit.Assert.*;

/**
 *
 * @author kromeuh
 */
public class CodeIT {

    Place p;
    Hero h;
    Code c;

    public CodeIT() {
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
        c = new Code("1234", "1234");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of use method, of class Code.
     */
    @Test
    public void testUse() {
        c.use(h);
    }

    /**
     * Test of decrypt method, of class Code.
     */
    @Test
    public void testDecrypt() {
        c.decrypt();
    }

}
