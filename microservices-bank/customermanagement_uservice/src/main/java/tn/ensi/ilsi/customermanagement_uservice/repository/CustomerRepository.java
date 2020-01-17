/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.customermanagement_uservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.ensi.ilsi.customermanagement_uservice.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
