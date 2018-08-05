package com.epam.autoparking;

/**
 * class to allocate the parking slots to the vehicles.
 */

public class SlotsArrangement {

    /**
     * array of slots to save the details.
     */

    private Slot[] slots;
    /**
     * to store slot object.
     */
    private Slot slot;
    /**
     * numofSlots entered by the user.
     */
    private int numofSlots;
    /**
     * variable to show the empty slot.
     */

    private int index;

    /**
     * constructor to fix no of slots.
     * @param number ...
     */
    public SlotsArrangement(final int number) {
        this.numofSlots = number;
        slots = new Slot[number];
        index = number;
    }

    /**
     * Checks the availablity of slots and return boolean value.
     * @return boolean
     */
    public boolean checkAvailability() {
        return index != 0;
    }

    /**
     * returns the hash value of the object.
     * @param slot object.
     * @return hashvalue as slot number.
     */
    private int hash(final Slot slot) {
        return Math.abs(slot.getVehicleNum().hashCode()) % numofSlots;
    }

    /**
     * gets the carnumber as input and allocates slot to it.
     * @param carNumber takes carnumber as input
     * @return index location number
     * @throws Exception 
     */
    public int park(final String carNumber) throws CarAlreadyParkedException {
        slot = new Slot();
        slot.addVehicle(carNumber);
        int i = hash(slot);
        for(; slots[i] != null; i = (i + 1) % numofSlots) {
            if (slots[i].getVehicleNum().equals(carNumber)) {
                throw new CarAlreadyParkedException("your car is already parked");
            }  
        }
            slots[i] = slot;
            index--;
            return i + 1;
    }

    /**
     * gets the carnumber as input unparks the car , keeps slot empty.
     * @param carNumber takes carnumber as input
     * @return boolean value
     */

    public String unpark(final String carNumber) throws CarNotFoundException{
        slot = new Slot();
        slot.addVehicle(carNumber);
        int i = hash(slot);
        int j = i;
        String data = null;
        boolean flag = true;
        if (slots[i] != null && slots[i].getVehicleNum().equals(carNumber)) {
            data = (i + 1) + "," + carNumber + "," + slots[i].getTime();
            slots[i] = null;
            index++;
            flag = false;
        }
        for (i = (i + 1) % numofSlots; (slots[i] != null && j != i&&flag);
                i = (i + 1) % numofSlots) {
            if (slots[i].getVehicleNum().equals(carNumber)) {
                data = (i + 1) + "," + carNumber + "," + slots[i].getTime();
                index++;
                slots[i] = null;
                flag = false;
                break;
            }
        }
        if (flag ) {
            throw new CarNotFoundException("your car has not been found");
        }
        return data;
    }

    /**
     * method that prints the time and slot number.
     * @param carNumber takes carnumber
     * @return true or false
     */
    public String getDetails(final String carNumber) {
        String data = "Car not found";
        slot = new Slot();
        slot.addVehicle(carNumber);
        int i = hash(slot);
        int j = i;
        if (slots[i] != null && slots[i].getVehicleNum().equals(carNumber)) {
            data = "Your vehicle has been parked at "
        + slots[i].getTime() + " In the slot number " + (i + 1);
            j = (i + 1) % numofSlots;
        }
        for (i = (i + 1) % numofSlots;
                (slots[i] != null && j != i); i = (i + 1) % numofSlots) {
            if (slots[i].getVehicleNum().equals(carNumber)) {
                       data = "Your vehicle has been parked at "
                + slots[i].getTime() + " In the slot number " + (i + 1);
            }
        }
        return data;
    }

    /**
     * maps the data to slots.
     * @param slotNum assigns the slot number.
     * @param carNum  assigns the carnumber.
     * @param time    assigns the time.
     */
    public void map(final String slotNum,
            final String carNum, final String time) {
        slot = new Slot();
        slot.setTime(time);
        slot.addVehicle(carNum);
        slots[Integer.parseInt(slotNum) - 1] = slot;
        System.out.println(slotNum+""+carNum);
        index--;
    }
}
