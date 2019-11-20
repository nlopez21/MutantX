package com.exam.mutant.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exam.mutant.model.Mutant;
import com.exam.mutant.model.Stats;

@Component
public class SearchMutant {
	
	@Autowired
	private StatsController scontroller ;
	
	public boolean isMutant(Mutant m ) {
		
		int coincidence = 0;
		String [] dna = m.getDna();
		System.out.println("Searching. ..");
		//Validation 
		if(validation(dna)) {
		System.out.println("Validate OK");
			
		}else {
			return false;		
		}
		
		coincidence =  searchVertical(dna)+searchHorizontal(dna);

		
		System.out.println("Total coincidence :"+coincidence);
		if(coincidence > 1) {
			Stats stat = new Stats();
			stat.setCount_mutant_dna(1);
			stat.setCount_human_dna(0);
			stat.setRatio(0);
			scontroller.saveMutant(stat);
			return true;
			}else {
				Stats stat = new Stats();
				stat.setCount_mutant_dna(1);
				stat.setCount_human_dna(0);
				stat.setRatio(0);
				scontroller.saveMutant(stat);
		System.out.println("Mutant not found");
		return false;
		}
		

	}
	
	
	//Search Oblique
//	String oblique = "";
//	for(int i = 0 ; i < dna.length ;i++) {
//		oblique = dna[i].substring(i)+
//				dna[i+1].substring(i)+dna[i+2].substring(i)+dna[i+3].substring(i)+dna[i+4].substring(i)+dna[i+5].substring(i);
//		
//		oblique = oblique + dna[i+1].substring(i+1); 
//		if(searchPattern(oblique))break;
//	}
	

	
	
	private boolean searchPattern(String dna) {
		
			 if(dna.toString().contains("AAAA") || 
				dna.toString().contains("TTTT") || 
				dna.toString().contains("CCCC") || 
				dna.toString().contains("GGGG"))	
			return true;		
		
		return false;
}
	
	private boolean validation(String[] dna) {
		int flag = 0;
		for(int i = 0 ; i < dna.length ;i++ ) {
			System.out.println("To validate position "+i);
			 if(dna[i].toString().matches(".*[BDEFHIJKLMNÑOPQRSUVWXYZ].*"))flag = 1;	
		}
		if(flag == 1) {
		System.out.println("Error the validation");
		return false;
		}
		
		return true;
}
	private int searchVertical(String[] dna) {
			//Search Vertical
		int coincidence = 0;
		String vertical = "";
		int count = 0;
		int count2 = 1;
		
		for(int x = 0;x < dna.length ;x++) {
			
			for(int i = 0 ; i < dna.length ;i++) {
				vertical = vertical + dna[i].substring(count,count2);
				}
			System.out.println("Vertial value : "+vertical);
			if(searchPattern(vertical))
			coincidence = coincidence+1;
			vertical = "";
			count++;
			count2++;
			System.out.println("Search coincidence vertical : "+coincidence);	
		}
				return coincidence;
	}
	
	private int searchHorizontal(String[] dna) {
		//Search Horizontal
		int coincidence = 0;
				for(int i = 0 ; i < dna.length ;i++) {
					if(searchPattern(dna[i].toString())) 
						coincidence = coincidence+1; 
						System.out.println("Position : "+i);
						System.out.println("Search coincidence horizontal : "+coincidence);
				}
		return coincidence;
	}
}
