package com.exam.mutant.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exam.mutant.control.SearchMutant;
import com.exam.mutant.model.Mutant;

@RestController
@RequestMapping("/mutant")
public class MutantExp {
	@Autowired
	private SearchMutant sm ;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus
	public ResponseEntity  isMutant(@RequestBody Mutant dna) {
		
		if(sm.isMutant(dna)) {
		return new ResponseEntity(HttpStatus.OK);
		}else
		return new ResponseEntity(HttpStatus.FORBIDDEN);	
	}
}
