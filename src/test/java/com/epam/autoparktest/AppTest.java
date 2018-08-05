
package com.epam.autoparktest;



import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.autoparking.App;

/**
 * @author Pavan_Mugathi
 *
 */
public class AppTest {
/**
 * to test the main application.
 */
	@Test
    public  void appTest() {
        String input = "admin\nadmin\n1\n1\nAP10HH1234\n1\n6\n3\nap10aa1234\nAP10HH1234\n2\nAP10HH1234\n1\nAP10AA1234\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); 
        App.main(null);
        input = "admin\nadmin\n4\n";
         in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); 
        App.main(null);
    }
	
    
}
