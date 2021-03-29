package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugController {
	@PostMapping("/bg")
	String createBug() {
		return "Bug Created";
	}
	@GetMapping("/bg")
	String searchBug() {
		return "Bug Retrieved";
	}
	@PutMapping("/bg/{id}")
	String updateBug(@PathVariable("id")int BugId) {
		System.out.println(BugId);
		return "Bug Updated";
	}
	@DeleteMapping("/bg/{id}")
	String deleteBug(@PathVariable("id")int BugId) {
		System.out.println(BugId);
		return "Bug Deleted";
	}
}
