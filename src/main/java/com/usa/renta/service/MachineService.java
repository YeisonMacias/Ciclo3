/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.service;

import com.usa.renta.model.Machine;
import com.usa.renta.repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id) {
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine machine) {
        if (machine.getId() == null) {
            return machineRepository.save(machine);
        } else {
            Optional<Machine> machineAux = machineRepository.getMachine(machine.getId());
            if (machineAux.isEmpty()) {
                return machineRepository.save(machine);
            } else {
                return machine;
            }
        }
    }

    public Machine update(Machine machine) {
        if (machine.getId() != null) {
            Optional<Machine> machineAux = machineRepository.getMachine(machine.getId());
            if (!machineAux.isEmpty()) {
                if (machine.getBrand() != null) {
                    machineAux.get().setBrand(machine.getBrand());
                }
                if (machine.getYear() != null) {
                    machineAux.get().setYear(machine.getYear());
                }
                if (machine.getName() != null) {
                    machineAux.get().setName(machine.getName());
                }
                if (machine.getDescription() != null) {
                    machineAux.get().setDescription(machine.getDescription());
                }
                return machineRepository.save(machineAux.get());
            }
        }
        return machine;
    }

    public boolean delete(int id) {
        Optional<Machine> machineAux = machineRepository.getMachine(id);
        if (!machineAux.isEmpty()) {
            machineRepository.delete(machineAux.get());
            return true;
        }
        return false;
    }
}
