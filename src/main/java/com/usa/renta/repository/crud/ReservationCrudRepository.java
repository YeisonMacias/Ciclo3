/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.repository.crud;

import com.usa.renta.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author yeiim
 */
public interface ReservationCrudRepository  extends CrudRepository<Reservation, Integer>{
        
}
