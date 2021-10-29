/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.service;

import com.usa.renta.model.Admin;
import com.usa.renta.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> adminAux = adminRepository.getAdmin(admin.getIdAdmin());
            if (adminAux.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> adminAux = adminRepository.getAdmin(admin.getIdAdmin());
            if (!adminAux.isEmpty()) {
                if (admin.getName() != null) {
                    adminAux.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    adminAux.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    adminAux.get().setPassword(admin.getPassword());
                }

                return adminRepository.save(adminAux.get());
            }
        }
        return admin;
    }

    public boolean delete(int id) {
        Optional<Admin> adminAux = adminRepository.getAdmin(id);
        if (!adminAux.isEmpty()) {
            adminRepository.delete(adminAux.get());
            return true;
        }
        return false;
    }

}
