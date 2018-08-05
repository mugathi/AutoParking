package com.epam.autoparking;

public class VehicleCar implements Vehicle{
	private String vehicleId;
	public VehicleCar(String carNum) {
		vehicleId = carNum;
	}
	public String getVehicleNum() {
		return vehicleId;
	}
}
