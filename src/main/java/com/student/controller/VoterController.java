package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Voter;
import com.student.service.VoterService;

@RestController
//@RequestMapping("/api/voter/")
public class VoterController {

	@Autowired
	VoterService voterService;
	
	@PostMapping("/addvoter")
	public Voter addVoter(@RequestBody Voter voter) {
		return voterService.addVoter(voter);
	}
	
	@GetMapping("/getvoter")
	public List<Voter> getAllVoters() {
		return voterService.getAllVoters();
	}
	
	@GetMapping("/getvoter/{id}")
	public Optional<Voter> getVotersById(@PathVariable Integer id) {
		return voterService.getVotersById(id);
	}
	
	
}
