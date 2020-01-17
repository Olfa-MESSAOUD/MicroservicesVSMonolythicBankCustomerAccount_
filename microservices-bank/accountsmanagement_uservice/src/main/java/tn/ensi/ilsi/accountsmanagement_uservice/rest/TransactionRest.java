/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.accountsmanagement_uservice.rest;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.ensi.ilsi.accountsmanagement_uservice.service.TransactionService;
import tn.ensi.ilsi.bankaccountmanagment_common.dto.BankTransactionDto;
import static tn.ensi.ilsi.bankaccountmanagment_common.web.Web.API;


@RestController
@RequestMapping(API+"/transactions")
public class TransactionRest {
    
    private final TransactionService transactionService;

    public TransactionRest(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<BankTransactionDto> findAll() {
        return this.transactionService.findAll();
    }

    @GetMapping("/{id}")
    public BankTransactionDto findById(@PathVariable Long id) {
        return this.transactionService.findById(id);
    }

    @PostMapping
    public BankTransactionDto deposit(@RequestBody BankTransactionDto transactionDto) {
    	System.out.println("REST "+transactionDto.toString());
        return this.transactionService.create(transactionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.transactionService.delete(id);
    }
    
}
