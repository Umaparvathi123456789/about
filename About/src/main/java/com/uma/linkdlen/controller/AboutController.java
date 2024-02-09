package com.uma.linkdlen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.linkdlen.model.About;
import com.uma.linkdlen.repo.AboutRepository;
@RestController
@RequestMapping("/user")
public class AboutController {
	@Autowired
	private AboutRepository aboutRepository;
	
	@PostMapping("/newabout")
	public About newUser(@RequestBody About newUser) {
		return aboutRepository.save(newUser);
	}

	@GetMapping("/about")
	public List<About> getAllUsers() {
		return aboutRepository.findAll();
	}

	@GetMapping("/about/{id}")
	
	 public Optional<About> getUserByjobTitles(@PathVariable Long id) {
		return aboutRepository.findById(id);
	}
	@PutMapping("/user/{id}")
	String updateUser(@RequestBody About newUser, @PathVariable Long id) {
		About user =aboutRepository.findById(id).get();
			user.setAbout(newUser.getAbout());
		
			user.setSkills(newUser.getSkills());
			 aboutRepository.save(user);
		return "updated..";
	}

	@DeleteMapping("/delete/about/{id}")
	String deleteUser(@PathVariable Long id) {
		aboutRepository.deleteById(id);
		return "User with id " + id + " has been deleted success.";
	}
	@GetMapping("/")
public String getPage() {
		return "Welcome...";
}
}
