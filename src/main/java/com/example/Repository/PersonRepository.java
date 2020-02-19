package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
