/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.bankaccountmanagment_common.dto;

import java.math.BigDecimal;
import tn.ensi.ilsi.bankaccountmanagment_common.enumeration.TransactionType;

public class BankTransactionDto {
    
    private long id;
    
    private BigDecimal amount;
    
    private TransactionType transactionType;
    
    private Long accountID;

    public BankTransactionDto() {
        // JACKSON
    }

    public BankTransactionDto(long id, BigDecimal amount, TransactionType transactionType, Long accountID) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.accountID = accountID;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }
    
}
