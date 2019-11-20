package com.exam.mutant.control;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exam.mutant.model.Mutant;
import com.exam.mutant.model.Stats;

@Component
public class SearchMutantController {
	
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
		
		coincidence =  searchObliqueDownRL(dna)+searchObliqueDownLR(dna)+
				searchVertical(dna)+searchHorizontal(dna)+searchObliqueLR(dna)+searchObliqueRL(dna);

		
		System.out.println("Total coincidence :"+coincidence);
		if(coincidence > 1) {
			Stats stat = new Stats();
			stat.setCount_mutant_dna(1);
			stat.setCount_human_dna(0);
			stat.setRatio("0");
			scontroller.saveMutant(stat);
			System.out.println("Gen X found");
			return true;
			}else {
				Stats stat = new Stats();
				stat.setCount_mutant_dna(0);
				stat.setCount_human_dna(1);
				stat.setRatio("0");
				scontroller.saveMutant(stat);
		System.out.println("Mutant not found");
		return false;
		}
		

	}
	

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
			 if(dna[i].toString().matches(".*[BDEFHIJKLMNÑOPQRSUVWXYZ0123456789].*"))flag = 1;	
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
	private int searchObliqueLR(String[] dna) {
		int coincidence = 0;
		String oblique = "";
		String chain ="";
		//Contador Largo del Array
		int count1 = dna.length;
		//Contador de posicion del string
		int count2 = 1;
		//Contador de que solo calcula como minimo una secuencia de 4 caractares
		int count3 = dna[0].length();
		//Contador de las posiciones del Array
		int count4 = 0;
		for (int x = 0 ; x < count1 ; x++) {
			if(count2 > 1)
			count2= count2 - count3;
			if(count1 < 4)
			count3 = 0; 
			for (int i = 0 ; i < count3 ; i++) {
				
				if(count3 > 3) {	
				chain = dna[i].substring(count4,count2);
				oblique = oblique + chain.charAt(chain.length() -1);
				count2++;
				count4++;}
				
			}
			System.out.println("Oblique value Left to rigth : "+oblique);
			if(searchPattern(oblique))
				coincidence = coincidence+1;
				count1--;
				count3--;
				count4=0;
				oblique = "";
				System.out.println("Search coincidence oblique : "+coincidence);
		}
			
		return coincidence;
	}
	private int searchObliqueRL(String[] dna) {
		int coincidence = 0;
		String oblique = "";
		String chain ="";
		//Contador Largo del Array
		int count1 = dna.length;
		//Contador de posicion del string
		int count2 = dna[0].length();;
		//Contador de que solo calcula como minimo una secuencia de 4 caractares
		int count3 = dna[0].length();
		for (int x = 0 ; x < count1 ; x++) {
			if(count2 == 0)
			count2= count3 - count2;
			if(count1 < 4)
			count3 = 0; 
			for (int i = 0 ; i < count3 ; i++) {
				
				if(count3 > 3) {	
				chain = dna[i].substring(0,count2);
				oblique = oblique + chain.charAt(chain.length() -1);
				count2--;
				//count4++;
				}
				
			}
			System.out.println("Oblique value Left to rigth : "+oblique);
			if(searchPattern(oblique))
				coincidence = coincidence+1;
				count1--;
				count3--;
				oblique = "";
				System.out.println("Search coincidence oblique : "+coincidence);
		}
			
		return coincidence;
		
	}
	private int searchObliqueDownLR(String[] dna) {
	int coincidence = 0;
	String oblique = "";
	String chain ="";
	//Contador Largo del Array
	int count1 = dna.length;
	//Contador de posicion del string
	int count2 = dna[0].length();
	//Contador de que solo calcula como minimo una secuencia de 4 caractares
	int count3 = dna[0].length();
	//Contador de las posiciones del Array
	int count4 = 0;
	for (int x = 0 ; x < count1 ; x++) {
		count4 = x+1;
		if((dna.length-count4) < 4)
		count3 = 0; 
		if(count2 > 0) 
		count2= dna[count4].length();
		for (int i = 0 ; i < count3 ; i++) {
			
			if( count4 < dna.length) {
				
			chain = dna[count4].substring(0,count2);
			oblique = oblique + chain.charAt(chain.length() -1);
			count2--;
			count4++;
			
			}
			
		}
		System.out.println("Oblique value down rigth to left : "+oblique);
		if(searchPattern(oblique))
			coincidence = coincidence+1;
			count1--;
			count3--;
			oblique = "";
			System.out.println("Search coincidence oblique : "+coincidence);
	}
		
	return coincidence;
	}	
	private int searchObliqueDownRL(String[] dna) {
		int coincidence = 0;
		String oblique = "";
		String chain ="";
		//Contador Largo del Array
		int count1 = dna.length;
		//Contador de posicion del string
		int count2 = 1;
		//Contador de que solo calcula como minimo una secuencia de 4 caractares
		int count3 = dna[0].length();
		//Contador de las posiciones del Array
		int count4 = 0;
		for (int x = 0 ; x < count1 ; x++) {
			count4 = x+1;
			if((dna.length-count4) < 4)
			count3 = 0; 
			if(count2 > 0) 
			count2 = 1;
			for (int i = 0 ; i < count3 ; i++) {
				
				if( count4 < dna.length) {
					
				chain = dna[count4].substring(0,count2);
				oblique = oblique + chain.charAt(chain.length() -1);
				count2++;
				count4++;
				
				}
				
			}
			System.out.println("Oblique value down left to rigth : "+oblique);
			if(searchPattern(oblique))
				coincidence = coincidence+1;
				count1--;
				count3--;
				oblique = "";
				System.out.println("Search coincidence oblique : "+coincidence);
		}
			
		return coincidence;
		}
	
	
	public Stats getStats () {
		
		List<Stats> stats = new ArrayList<Stats>();
		stats = scontroller.findAll();
		Stats stat = new Stats(); 
		for(int i = 0 ; i <stats.size();i++) {
			stat.setCount_mutant_dna(stat.getCount_mutant_dna()+stats.get(i).getCount_mutant_dna());
			stat.setCount_human_dna(stat.getCount_human_dna()+stats.get(i).getCount_human_dna());			
		}
		
		if(stat.getCount_human_dna() > 0 & stat.getCount_mutant_dna() >0) {
			DecimalFormat format = new DecimalFormat("#.#");
			float div = (float)stat.getCount_mutant_dna()/stat.getCount_human_dna();
			System.out.println("Ratio is :"+format.format(div).toString().replace(",", "."));
			stat.setRatio(format.format(div).toString().replace(",", "."));
		}else if(stat.getCount_human_dna() == 0) {
			stat.setRatio("0");
		}else if(stat.getCount_mutant_dna() ==0) {
			stat.setRatio("1");
		}
		
		return stat;
	}
	
}
