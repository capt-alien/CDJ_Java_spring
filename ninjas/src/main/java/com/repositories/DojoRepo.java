package com.repositories;

import org.springframework.data.repository.CrudRepository;

import com.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long> {

}
