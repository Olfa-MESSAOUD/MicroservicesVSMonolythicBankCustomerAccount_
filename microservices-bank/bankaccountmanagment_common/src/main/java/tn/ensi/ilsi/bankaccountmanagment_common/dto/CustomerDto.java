/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagment_common.dto;


public class CustomerDto {
    
    private Long id;
    
    private String name;
    
    private String email;
    
    private String telephone;
    
    private String cin;

    public CustomerDto() {
        
    }

    public CustomerDto(Long id, String name, String email, String telephone, String cin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.cin = cin;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCin() {
        return cin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
      
}
