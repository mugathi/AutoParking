package com.epam.autoparking;
import java.util.regex.Pattern;
public class VehicleValidator {
    /**
     * validate vehicle number.
     * @param id get the vehicle number
     * @return true if matches
     */
	private VehicleValidator() {
		//does nothing.
	}
    public static boolean validateVehicleNumber(final String id) {
        Pattern pattern = Pattern.compile("(AP|TS)\\d\\d\\w{1,2}\\d\\d\\d\\d");
        return pattern.matcher(id).matches();
    }
}
