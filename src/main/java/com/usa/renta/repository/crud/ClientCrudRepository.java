/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.repository.crud;

import com.usa.renta.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer>{
    
}
