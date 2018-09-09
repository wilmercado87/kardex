/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.web.rs;

import com.kardex.ejb.exceptions.ServicesControllerException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ADMIN
 */
public class GenericResourceTest {
    
    public GenericResourceTest() {
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

    @Test
    public void testSomeMethod() throws ServicesControllerException {
        GenericResource genericResource = new GenericResource();
        assertNotNull(genericResource.getListParameter(GenericResource.LIST_PRODUCT, false));
        assertNotNull(genericResource.getListParameter(GenericResource.LIST_ORDER, false));
    }
    
}
