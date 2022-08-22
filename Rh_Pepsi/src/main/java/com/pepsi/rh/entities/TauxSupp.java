package com.pepsi.rh.entities;

public enum TauxSupp {

	Quart(0.25),Half(0.25),Full(1);
	private final double value;
	TauxSupp(double value) {
		this.value = value;
	}
	
}
