package myapp;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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

  	  try {

  		DefaultHttpClient httpClient = new DefaultHttpClient();
  		HttpGet getRequest = new HttpGet(
  			"http://localhost:8080/test");
  		getRequest.addHeader("accept", "application/json");

  		HttpResponse response = httpClient.execute(getRequest);

  		if (response.getStatusLine().getStatusCode() != 200) {
  			throw new RuntimeException("Failed : HTTP error code : "
  			   + response.getStatusLine().getStatusCode());
  		}

  		BufferedReader br = new BufferedReader(
                           new InputStreamReader((response.getEntity().getContent())));

    	String excepted = "{\"id\":123}";
  		
  		String output = br.readLine();
  		System.out.println("Output from Server: " + output);
  		
  		assertEquals(excepted, output);

  		httpClient.getConnectionManager().shutdown();

  	  } catch (ClientProtocolException e) {

  		e.printStackTrace();

  	  } catch (IOException e) {

  		e.printStackTrace();
  	  }

  	}
    
    @Test
    public void test2(){
    	MyController mc = new MyController();
    	String shouldbe = mc.test("");
    	assertEquals(shouldbe, "{\"id\":123}");
    	System.out.println("************ " + shouldbe + " ****************");
    }
}

