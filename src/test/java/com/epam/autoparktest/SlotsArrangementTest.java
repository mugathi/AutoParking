
package com.epam.autoparktest;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.autoparking.CarAlreadyParkedException;
import com.epam.autoparking.CarNotFoundException;
import com.epam.autoparking.SlotsArrangement;

/**
 * @author Pavan_Mugathi
 *
 */
public class SlotsArrangementTest {
    /**
     * parkingSlots object.
     */
    private static SlotsArrangement parking;
    /**
     * set up the parking slots.
     */
    private static final int SLOTNUM = 5;
    /**
     * setup before class.
     */
    @BeforeClass
    public static void setUp() {
        parking = new SlotsArrangement(SLOTNUM);
        parking.map("2", "AP10CC1234", "22:47");
        parking.map("1", "AP10DD1234", "22:45");
        try {
        parking.park("AP10AA1234");
        parking.park("AP10BB1234");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    /**
     *tests the availabilty,vaildates the car
     *number,parks and unparks the vehicle.
     */
    @Test
    public void availabilityTest() {
        boolean available = parking.checkAvailability();
        assertEquals(true, available);
    }
    /**
     * Testing if we park the same vehicle again.
     */
    @Test
    public void parkingAgainTest() {
        int slotNum = 0;
		try {
			slotNum = parking.park("AP10AA1234");
		} catch (CarAlreadyParkedException e) {	
			e.printStackTrace();
		}  	
    }
    /**
     * testing for unpark.
     */
    @Test
    public void unparkTestWithWrongCarNum() {
        boolean unpark = true;
		try {
			unpark = (parking.unpark("AP10KK1234")) != null;
		} catch (CarNotFoundException e) {
			e.printStackTrace();
		}
		assertTrue(unpark);
    }
    /**
     * testing unpark with valid carnumber.
     */
    @Test
    public void unparkTestWithCorrectNum() {
    	boolean unpark = false;
    	boolean unpark2 = false;
    	try {
        unpark = (parking.unpark("AP10AA1234")) != null;
        unpark2 = (parking.unpark("AP10CC1234")) != null;
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
        assertTrue(unpark && unpark2);
    }
    /**
     * testing getdetials if exists.
     */
    @Test
    public void getDetailsTrueTest() {
    	boolean getDetails2 = (parking.getDetails("AP10BB1234")) != null;
        boolean getDetails = (parking.getDetails("AP10DD1234")) != null;
        assertTrue(getDetails && getDetails2);
    }
    /**
     * testing getdetails if does not exit.
     */
    @Test
    public void getDetailsFalseTest() {
        String getDetails = parking.getDetails("AP10GG1234") ;
        assertEquals("Car not found", getDetails);
    }
}
