
package com.epam.autoparktest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.autoparking.Slot;

/**
 * @author Pavan_Mugathi
 *
 */
public class SlotTest {
    /**
     * To store Slot object reference.
     */
    private static Slot slot;
    /**
     * set up the slot reference before the class.
     */
    @BeforeClass
    public static void setUp() {
        slot = new Slot();
    }
    /**
     *allocating slot to vehicle and checking vehicle id.
     */
    @Test
    public void vehicleIdTest() {
        slot.addVehicle("AP10RS1234");
        String vehicleId = slot.getVehicleNum();
        assertEquals("AP10RS1234", vehicleId);
    }
}
