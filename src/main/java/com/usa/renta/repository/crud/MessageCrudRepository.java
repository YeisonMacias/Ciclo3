/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.repository.crud;

import com.usa.renta.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author yeiim
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
