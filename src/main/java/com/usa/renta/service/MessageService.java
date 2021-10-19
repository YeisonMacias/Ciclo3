/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.service;

import com.usa.renta.model.Message;
import com.usa.renta.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll() {
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> messageAux = messageRepository.getMessage(message.getIdMessage());
            if (messageAux.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }
        
}
