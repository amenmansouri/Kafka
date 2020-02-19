package com.example.Configs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.Entity.Person;
import com.example.Repository.PersonRepository;
 
@Component
public class Config implements ApplicationRunner {
	@Autowired
	private PersonRepository pr;

	@Override
	public void run(ApplicationArguments args) throws Exception {
	List<Person> persons=	Stream.of(new Person("amen allah", "mansouri"),
				new Person("sofien", "trablesi") ).collect(Collectors.toList());
		pr.saveAll(persons);
	}

}