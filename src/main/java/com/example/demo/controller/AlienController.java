package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	/* 
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "index.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showResult.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}

	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien) {
		repo.save(alien);
		return "index.jsp";
		
		
	}
	
	@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int aid) {
		repo.deleteById(aid);
		return "index.jsp";
		
		
	}
	
	@RequestMapping("/getAllAlien")
	public ModelAndView getAllAlien() {
		List <Alien> alien =  (List<Alien>) repo.findAll();
		ModelAndView mv = new ModelAndView("showAll.jsp");
		System.out.println("alien object "+alien.toString());
		mv.addObject("alien", alien.toString());
		return mv;
	} */
	
	/*
	 * Below is using the Rest call and above are using the modelAndView
	 * If we are using the JpaRespository we will send like List and object otherwise it will accept only String
	 */
	
	/*
	 * to restrict only xml or json we use path and producer in the RequestMapping 
	 * 	If we use the RestController in top of the class we dont need to use @ResponseBody 
	 * 
	 * @consume - data from the client side
	 * @produce - for view for the rest call response
	 */
	
	@GetMapping(path="/aliens")
	public List<Alien> findAllAlien() {
		List<Alien> allAliens = repo.findAll();
		return allAliens;
	}
	/*
	 * We need to specify the @REquestBidy to get the raw json data from the client side
	 */
	@PostMapping(path="/alien", consumes = {"application/json"})
	public Alien updateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
		
		
	}
	
	@RequestMapping("/alien/{aid}")
	public Optional<Alien> findByAlienId(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien alien = repo.getOne(aid);
		System.out.println("delete obj"+alien);
		repo.delete(alien);
		return "deleted";
	}
	
}
