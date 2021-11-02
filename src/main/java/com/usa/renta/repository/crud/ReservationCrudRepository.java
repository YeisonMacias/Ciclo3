/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.repository.crud;

import com.usa.renta.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author yeiim
 */
public interface ReservationCrudRepository  extends CrudRepository<Reservation, Integer>{
   
    //JPQL  (JAVA PERSISTENSE QUERY LANGUAGE)
    @Query("SELECT r.client, COUNT(r.client) FROM Reservation AS r GROUP BY r.client ORDER BY COUNT(r.client)desc")
    public List<Object[]> countTotalReservationByClient();
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date detaOne, Date dateTwo);
    
    public List<Reservation> findAllByStatus(String status);
}
