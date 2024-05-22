package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Voter;
import com.student.repository.VoterRepository;

@Service
public class VoterService {

	@Autowired
	VoterRepository voterRepository;
	
	
	public Voter addVoter(Voter voter) {
		return voterRepository.save(voter);
	}

	public List<Voter> getAllVoters() {
		return voterRepository.findAll();
	}

	public Optional<Voter> getVotersById(Integer id) {
		return voterRepository.findById(id);
	}

}
