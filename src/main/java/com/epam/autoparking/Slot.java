package com.epam.autoparking;

import java.util.Calendar;
/**
 * @author Pavan_Mugathi
 *
 */
/**
 * Slot class which stores the vehicle,
 *  allocated time for that vechicle in the slot.
 */
public class Slot {

    /**
     * used to store vehicleid IN slot.
     */
    private Vehicle vehicle;
    /**
     * calender class used to get the time.
     */
    private Calendar cal = Calendar.getInstance();
    /**
     * used to store time of allotment.
     */
    private String time = cal.get(Calendar.HOUR_OF_DAY)
     + ":" + cal.get(Calendar.MINUTE);
    /**
     * used to add vehicle and time to the slot.
     * @param vechilenum  vehicle number to store.
     */

//    public void addVehicle(final String vechilenum) {
//        vehicle = new VehicleCar(vechilenum);
//        this.time = cal.get(Calendar.HOUR_OF_DAY)
//                + ":" + cal.get(Calendar.MINUTE);
//    }
    /**
     * set the time of entry.
     * @param giventime input
     */
    protected void setTime(final String giventime) {
        this.time = giventime;
    }
    /**
     * sets the vehicleid.
     * @param vehicleNum as input
     */
    public void addVehicle(final String vehicleNum) {
     this.vehicle = new VehicleCar(vehicleNum);
    }
    /**
     * @return time String
     */

    protected  String getTime() {
        return time;
    }
    /**
     * @return vehiclenumber
     */

    public String getVehicleNum() {
        return vehicle.getVehicleNum();
    }
}
