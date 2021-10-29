/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.renta.repository;


import com.usa.renta.model.Admin;
import com.usa.renta.repository.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    
    @Autowired
    private AdminCrudRepository adminCrudReposotiry;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudReposotiry.findAll();
    }

    public Optional<Admin> getAdmin (int id) {
        return adminCrudReposotiry.findById(id);
    }

    public Admin save(Admin admin){
        return adminCrudReposotiry.save(admin);
    }

    public void delete(Admin admin){
        adminCrudReposotiry.delete(admin);
    }    
}
