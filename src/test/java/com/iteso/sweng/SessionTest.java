/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iteso.sweng;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CoCoNO
 */
public class SessionTest {
    
    public SessionTest() {
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
     * Test of logIn method, of class Session.
     */
    @Test
    public void testLogIn() {
        System.out.println("logIn");
        String _name = "CoCoNO";
        String _password = "123456";
        Session instance = new Session();
        String expResult = "CoCoNO";
        User result = instance.logIn(_name, _password);
        assertEquals(expResult, result.getName());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testLogInFail() {
        System.out.println("logIn");
        String _name = "CCoNO";
        String _password = "123456";
        Session instance = new Session();
        String expResult = "CoCoNO";
        User result = instance.logIn(_name, _password);
        assertEquals(instance.logged, false);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Session.
     */
    
    
}
