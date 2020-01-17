/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagment_common.dto;

import java.math.BigDecimal;
import java.util.List;


public class AccountDto {
    private Long id;
    
    private BigDecimal balance;
    
    private Long customerId;
    
    private List<BankTransactionDto> transactions;

    public AccountDto() {
        // JACKSON
    }

    public AccountDto(Long id, BigDecimal balance, Long customerId, List<BankTransactionDto> transactions) {
        this.id = id;
        this.balance = balance;
        this.customerId = customerId;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<BankTransactionDto> getTransactions() {
        return transactions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setTransactions(List<BankTransactionDto> transactions) {
        this.transactions = transactions;
    }
    
}
