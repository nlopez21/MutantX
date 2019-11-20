package com.exam.mutant.Mutant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.exam.mutant.control.SearchMutantController;
import com.exam.mutant.exp.MutantApplication;
import com.exam.mutant.model.Mutant;
import com.exam.mutant.model.Stats;

@SpringBootTest(classes = MutantApplication.class)
class MutantApplicationTests {

	@Autowired
	SearchMutantController sm; 
	
	@Test
	void contextLoads() {
		
		
		
		Mutant m = new Mutant();
		String[] dna = {"ATGCGG",
		         	   "CAGTAC",
		        	   "TTAAGT",
		        	   "AAAAGG",
		        	   "CACATA",
		        	   "ACAATG"} ;
		m.setDna(dna);
		System.out.println("TEST Mutant :"+sm.isMutant(m));
		
		
		
		
		Stats stat = new Stats();
		stat = sm.getStats();
		System.out.println("Stat TEST :"+stat.getCount_human_dna());
		System.out.println("Stat TEST :"+stat.getCount_mutant_dna());
		System.out.println("Stat TEST :"+stat.getRatio());
	}

}
