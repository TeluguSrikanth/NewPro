package com.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.student.controller.VoterController;
import com.student.entity.Voter;
import com.student.service.VoterService;

public class VoterControllerTest {

	 @InjectMocks
	    private VoterController voterController;

	    @Mock
	    private VoterService voterService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    
	    @Test
	    public void testAddVoter() {
	        Voter voter = new Voter(101, "Srikanth", "Hyderabad", 24);
	        when(voterService.addVoter(any(Voter.class))).thenReturn(voter);

	        Voter result = voterController.addVoter(voter);

	        assertNotNull(result, "The saved voter should not be null");
	        assertEquals(voter, result);
	        verify(voterService, times(1)).addVoter(any(Voter.class));
	    }

	    @Test
	    public void testGetVoter() {
	        Voter voter1 = new Voter(101, "Sylvester", "Chennai", 26);
	        Voter voter2 = new Voter(102, "Srikanth", "Hyderabad", 24);
	        List<Voter> voters = Arrays.asList(voter1, voter2);
	        when(voterService.getAllVoters()).thenReturn(voters);

	        List<Voter> result = voterController.getAllVoters();

	        assertNotNull(result, "The list of voters should not be null");
	        assertEquals(voters, result);
	        verify(voterService, times(1)).getAllVoters();
	    }
	    @Test
	    public void testGetVoterById() {
	        Voter voter = new Voter(102, "Raja", "Hyderabad", 24);
	        when(voterService.getVotersById(102)).thenReturn(Optional.of(voter));

	        Optional<Voter> result = voterController.getVotersById(102);

	        assertNotNull(result, "The voter should not be null");
	        assertEquals(Optional.of(voter), result);
	        verify(voterService, times(1)).getVotersById(10);
	    }

	
}
