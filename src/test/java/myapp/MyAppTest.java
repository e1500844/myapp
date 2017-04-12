package myapp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyAppTest {
    public MyAppTest() {
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

    //this is a dummy test just testing that the test are run
    @Test
    public void hello() {
        assertEquals(1, 1);
    }
    
    @Test
    public void test(){
    	assertEquals(2,2);
    }
}