/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.customermanagement_uservice.rest;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import tn.ensi.ilsi.bankaccountmanagment_common.dto.CustomerDto;
import static tn.ensi.ilsi.bankaccountmanagment_common.web.Web.API;
import tn.ensi.ilsi.customermanagement_uservice.service.CustomerService;


@RestController
@RequestMapping(API+"/customers")
public class CustomerRest {
    private final CustomerService customerService;

    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }
    @HystrixCommand
    @GetMapping
    public List<CustomerDto> findAll() {
        return this.customerService.findAll();
    }
    @HystrixCommand
    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Long id) {
        return this.customerService.findById(id);
    }

    @PostMapping
    public CustomerDto create(@RequestBody CustomerDto customerDto) {
        return this.customerService.create(customerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.customerService.delete(id);
    }
}
