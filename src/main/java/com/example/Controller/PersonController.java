package com.example.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Configs.PersonConsumer;
import com.example.Configs.PersonProducer;
import com.example.Entity.Person;
import com.example.Repository.PersonRepository;
 

@RestController
public class PersonController {

	@Autowired
	private PersonRepository pr;
	@Autowired
	private PersonProducer pp;
	@Autowired
	private PersonConsumer pc;
	
	@GetMapping("/all")
	public List<Person> getAll(){
		return pr.findAll();
	}
	@GetMapping("{id}")

	public  Optional<Person> getOne(@PathVariable long id){ 
		return pr.findById(id);
	}
	
	@PostMapping
	public  Person postOne(@RequestBody Person person){
		
		 person= pr.save(person);
		 pp.sendMessage(person.getLastname()+" "+person.getFirstname()+ " was added !!");
		return person;
	}

	@PutMapping("{id}")
	public  Person putOne(@PathVariable long id,@RequestBody Person person){
		 Optional<Person> old=this.getOne(id);
		 if(old.isPresent()) {
			 person.setId(id);

			 pp.sendMessage(person.getLastname()+" "+person.getFirstname()+ " with id ["+ id+ "] was updated !!");
			 return pr.save(person);
		 }
		 return null;
	}
	
	@DeleteMapping("{id}")
 
	public  void deleteOne(@PathVariable long id){

		 pp.sendMessage("person with id ["+ id+ "] was deleted !!");
		pr.deleteById(id);
	}
	
	

}