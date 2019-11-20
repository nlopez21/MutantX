package com.exam.mutant.control;


import java.util.ArrayList;
import java.util.List;

import com.exam.mutant.impl.XmenRepo;
import com.exam.mutant.model.Stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class StatsController {
	
	private XmenRepo xmenRepo;
	
	@Autowired
	public StatsController(XmenRepo xmenRepo) {		
		this.xmenRepo = xmenRepo;
	}
	
	
	public List<Stats> findAll() {
	List<Stats> stats	= new ArrayList<Stats>();
	stats=xmenRepo.findAll();
	
	return stats;
	}
	
	
	public void saveMutant(Stats stat) {
		
		xmenRepo.save(stat);
	}
}
