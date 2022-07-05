package com.gtm.parking;

import java.util.Iterator;
import java.util.Vector;

public class ParkingLot {

	Vector<ParkingSpace> parkingSpaces = null;

	int parkingSpaceCount = 0;
	int parkedVic = 0;

	public ParkingLot(int parkingSpaceCount){
		this.parkingSpaces = new Vector<>();
		createParkingSpace(parkingSpaces,parkingSpaceCount);
		this.parkingSpaceCount = parkingSpaceCount;
	}



	private void createParkingSpace(Vector<ParkingSpace> vacantParkingSpaces2, int parkingSpaceCount2) {
		for (int i = 0; i < parkingSpaceCount2; i++) {
			if(i <= parkingSpaceCount2/2){
				ParkingSpace ps = new ParkingSpace(ParkingType.REGULAR,i);
				vacantParkingSpaces2.add(ps);
			}else{
				ParkingSpace ps = new ParkingSpace(ParkingType.COMPACT,i);
				vacantParkingSpaces2.add(ps);
			}
		}
	}



	ParkingSpace findNearestVacant(ParkingType type)
	{
		Iterator<ParkingSpace> itr = parkingSpaces.iterator();

		while(itr.hasNext())
		{
			ParkingSpace parkingSpace = itr.next();

			if(parkingSpace.parkingType == type)
			{
				return parkingSpace;
			}
		}
		return null;
	}

	void parkVehicle(ParkingType type, Vehicle vehicle){
		if(!isFull()){
			ParkingSpace parkingSpace = findNearestVacant(type);

			if(parkingSpace != null){
				parkingSpace.vehicle = vehicle;
				parkingSpace.isVacant = false;
				parkingSpaces.add(parkingSpace);
				parkedVic++;
				System.out.println("Vehicle No "+vehicle.num+" Parked");
			}
		}else
			System.out.println("Parking full!!");
	}

	void releaseVehicle(Vehicle vehicle){
		if(!isEmpty()){
			Iterator<ParkingSpace> itr = parkingSpaces.iterator();
			boolean isParked = false;
			while(itr.hasNext()){
				ParkingSpace parkingSpace = itr.next();

				if(parkingSpace.vehicle != null && parkingSpace.vehicle.num == vehicle.num){
					itr.remove();
					parkingSpace.isVacant = true;
					parkingSpace.vehicle = null;
					parkedVic--;
					System.out.println("Vehicle No "+vehicle.num+" released Park");
					isParked = true;
					break;
				}
			}
			if(!isParked)
				System.out.println("Vehicle No "+vehicle.num+" not Parked!!");
		}else
			System.out.println("Parking empty!!");
	}

	boolean isFull(){
		return parkedVic == parkingSpaceCount;
	}

	boolean isEmpty(){
		return parkedVic == 0;
	}

	public static void main(String[] args) {
		ParkingLot pLot = new ParkingLot(2);
		pLot.parkVehicle(ParkingType.REGULAR, new Vehicle(1213));
		pLot.parkVehicle(ParkingType.REGULAR, new Vehicle(1313));
		Vehicle v1413 = new Vehicle(1413);
		pLot.parkVehicle(ParkingType.REGULAR, v1413);
		pLot.releaseVehicle(v1413);
	}
}

class ParkingSpace 
{
	boolean isVacant;
	Vehicle vehicle;
	ParkingType parkingType;
	int distance;

	public ParkingSpace(ParkingType parkingType,int distance){
		this.isVacant = true;
		this.parkingType = parkingType;
		this.distance = distance;
	}
}

class Vehicle 
{
	int num;
	public Vehicle(int num){
		this.num = num;
	}
}

enum ParkingType
{
	REGULAR,
	HANDICAPPED,
	COMPACT,
	MAX_PARKING_TYPE,
}