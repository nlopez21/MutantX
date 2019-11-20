package com.exam.mutant.model;

import java.io.Serializable;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stats")
public class Stats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count_mutant_dna;
	private int count_human_dna;

	private String ratio;
	
	public Stats() {
		this.count_mutant_dna = 0;
		this.count_human_dna = 0;
		
		this.ratio = "";
	}
	
	public Stats(int count_mutant_dna, int count_human_dna, String ratio) {
		this.count_mutant_dna = count_mutant_dna;
		this.count_human_dna = count_human_dna;
		this.ratio = ratio;
	}
	public int getCount_mutant_dna() {
		return count_mutant_dna;
	}
	public void setCount_mutant_dna(int count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}
	public int getCount_human_dna() {
		return count_human_dna;
	}
	public void setCount_human_dna(int count_human_dna) {
		this.count_human_dna = count_human_dna;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	
	
}
