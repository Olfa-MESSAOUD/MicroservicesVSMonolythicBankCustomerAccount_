/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.customermanagement_uservice.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.Email;
import tn.ensi.ilsi.bankaccountmanagment_common.dto.AccountDto;


@Entity
public class Customer extends AbstractEntity{
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "cin")
    private String cin;
    
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    public Customer() {
        super();
        //JPA, efficient solution No?
    }

    public Customer(String name, String cin, String email, String telephone) {
        this.name = name;
        this.cin = cin;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getCin() {
        return cin;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.cin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", cin=" + cin + ", email=" + email 
                + ", telephone=" + telephone + '}';
    }
    
}
