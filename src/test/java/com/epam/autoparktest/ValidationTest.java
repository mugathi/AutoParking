package com.epam.autoparktest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.epam.autoparking.VehicleValidator;

public class ValidationTest {

	 /**
     * test for validating vechicle number.
     */
    @Test
    public void vehicleValidationTest() {
        boolean validation = VehicleValidator.validateVehicleNumber("AP10RS1234");
        assertTrue(validation);
    }

}
