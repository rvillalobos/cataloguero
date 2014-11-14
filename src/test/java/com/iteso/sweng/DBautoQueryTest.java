/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteso.sweng;

import java.sql.ResultSet;
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
public class DBautoQueryTest {
    
    public DBautoQueryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("connecting");
        DBautoQuery.getInstance().connect();
    }
    
    @After
    public void tearDown() {
        System.out.println("close");
        DBautoQuery.getInstance().close();
    }

    
    /**
     * Test of doQuery method, of class DBautoQuery.
     */
    @org.junit.Test
    public void testDoQuery() {
        System.out.println("doQuery");
        String qry = "SELECT * FROM `USERS` WHERE ID=1";
        String expResult = "CoCoNO";
        
        ResultSet result = DBautoQuery.getInstance().doQuery(qry);
        String resultName="";
        
        try {
            while (result.next())
            {
                resultName=result.getString("name");
                System.out.println("Test data:"+resultName);
            }
        } catch (Exception e) {
        }
        
        assertEquals(expResult, resultName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class DBautoQuery.
     */

}
