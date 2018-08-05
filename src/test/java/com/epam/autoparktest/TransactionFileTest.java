
package com.epam.autoparktest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.epam.autoparking.TransactionFile;

/**
 * @author Pavan_Mugathi
 *
 */
public class TransactionFileTest {
    /**
     * to store the refernce of transaction file object.
     */
    private static TransactionFile transactionFile;
    /**
     * set up the parking slots.
     */
    private static final int SLOTNUM = 4;
    /**
     * to set up the object reference before class.
     */
    @BeforeClass
    public static void setUp() {
    	try {
        transactionFile = new TransactionFile();
        transactionFile.addPath("src/test/resources/transactionfile.csv", "src/test/resources/tempfile.csv");
        transactionFile.addToFile("4");
        int slotNum = transactionFile.numOfSlots();
        assertEquals(SLOTNUM, slotNum);
        transactionFile.addToFile(1 + "," + "ap10kk1234" + "," + "12:24");
        transactionFile.addToFile(2 + "," + "ap10dd1234" + "," + "12:24");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    /**
     * to check the return data from log file.
     */
    @AfterClass
    public static void getFromFileTest() {
        String[] data = null;
		try {
			data = transactionFile.getFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
        assertEquals(data[1], 1 + "," + "ap10kk1234" + "," + "12:24");
    }
    /**
     * test to remove data from transaction file.
     */
    @Test
    public  void removeDataTest() {
        try {
			transactionFile.removeData(2 + "," + "ap10dd1234" + "," + "12:24");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
    
}
