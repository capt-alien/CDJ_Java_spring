package com.repositories;

import org.springframework.data.repository.CrudRepository;

import com.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {

}
