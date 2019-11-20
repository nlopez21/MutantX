package com.exam.mutant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mutant {
	@JsonProperty("dna")
	private String [] dna;
	
	public Mutant() {
		this.dna = null;
	}
	
	public Mutant(String[] dna) {

		this.dna = dna;
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
	
	
	
	
	
}
