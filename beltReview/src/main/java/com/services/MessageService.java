package com.services;

import org.springframework.stereotype.Service;

import com.models.Message;
import com.repositories.MessageRepo;

@Service
class MessageService {
	private final MessageRepo messageRepo;

	public MessageService(MessageRepo messageRepo) {
		super();
		this.messageRepo = messageRepo;
	}
	
	public Message createMessage(Message message) {
		return messageRepo.save(message);
		
	}
}
