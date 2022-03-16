package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Branch;
import com.example.demo.repository.BranchRepository;

@RestController
@CrossOrigin("*")
public class BranchController {

	@Autowired
	private BranchRepository br;
	
	@GetMapping("/branch")
	public List<Branch> getAllBranches()
	{
		return br.findAll();
	}
	
	@GetMapping("/branch/{bid}")
	public Branch findBranchById(@PathVariable("bid") String bid)
	{
		Optional<Branch> x = br.findById(bid);
		Branch b=null;
		if(x.isPresent())
		{
			b=x.get();
		}
		return b;
	}
	
	@PostMapping("/branch")
	public Branch addBranch(@RequestBody Branch branch)
	{
		return br.save(branch);
	}
	
	@PutMapping("/branch")
	public Branch updateBranch(@RequestBody Branch branch)
	{
		return br.save(branch);
	}
	
	@DeleteMapping("/branch/{bid}")
	public Branch deleteBranch(@PathVariable String bid)
	{
		Optional<Branch> x = br.findById(bid);
		Branch b=null;
		if(x.isPresent())
		{
			b=x.get();
			br.delete(b);
		}
		return b;
	}
}
