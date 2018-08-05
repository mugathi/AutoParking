
package com.epam.autoparktest;



import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.autoparking.LogFile;

/**
 * @author Pavan_Mugathi
 *
 */
public class LogFileTest {
    /**
     * to store logfile object reference.
     */
    private static LogFile logFile;
    /**
     * set up the log file reference before the class.
     */
    @BeforeClass
    public static void setUp() {
    	try {
        logFile = new LogFile();
        logFile.addFilePath("src/test/resources/logfile.csv");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    /**
     * to check the return data from log file.
     */
    @Test
    public void getFromFileTest() {
        try {
			logFile.addToFile(1 + "," + "ap10aa1234" + "," + "12:24");
			String[] data = logFile.getFromFile();
	        assertEquals(data[0], 1 + "," + "ap10aa1234" + "," + "12:24");
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
