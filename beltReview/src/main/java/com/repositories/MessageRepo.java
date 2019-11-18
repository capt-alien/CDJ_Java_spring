package com.repositories;

import org.springframework.data.repository.CrudRepository;

import com.models.Message;


public interface MessageRepo extends CrudRepository<Message, Long> {

}
