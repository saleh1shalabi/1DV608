package model;

import view.ConsoleUI;

/** 
* S.
*/
public class Boat {

	private double length;
	private BoatType type;
	private enum BoatType {Sailboat, Motorsailer, Kayak, Other};

	/**
	* Responsible for staring the application.
	*/
	Boat(double length) {
		this.length = length;
		boatType();
	}

	/**
	* Responsible for staring the application.
	*/
	private BoatType boatType() {
	return null;
	}

	/**
	* Responsible for staring the application.
	*/
	private double getLength() {
		return length;
	}

	/**
	* Responsible for staring the application.
	*/
	private BoatType getType() {
		return type;
	}

}