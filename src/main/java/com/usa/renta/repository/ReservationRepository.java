/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.repository;

import com.usa.renta.model.Client;
import com.usa.renta.model.Reservation;
import com.usa.renta.model.custom.CountClient;
import com.usa.renta.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationsByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountClient> getTopClients() {
        List<CountClient> res = new ArrayList<>();

        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {
//            Client client = (Client)report.get(i)[0];
//            Integer quantity = (Integer)report.get(i)[1];
//            CountClient countClient = new CountClient(quantity, client);
//            res.add(countClient);
            res.add(new CountClient((Long)report.get(i)[1],(Client)report.get(i)[0]));

        }

        return res;
    }
}
