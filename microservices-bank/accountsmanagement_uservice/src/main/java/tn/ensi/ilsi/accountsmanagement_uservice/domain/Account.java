/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.accountsmanagement_uservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name = "account")
public class Account extends AbstractEntity{
    
    @Column(name = "balance")
    private BigDecimal balance;
    
    private Long customerId; 

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="account")
    private List<BankTransaction> transactions;

    public Account() {
        super();
        // JPA! super() is better No?
    }

    public Account(BigDecimal balance, Long customerId, List<BankTransaction> transactions) {
        this.balance = balance;
        this.customerId = customerId;
        this.transactions = transactions;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Collection<BankTransaction> getTransactions() {
        return transactions;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCustomer(Long customerId) {
        this.customerId = customerId;
    }

    public void setTransactions(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" + "balance=" + balance + ", customer=" + 
                customerId + ", transactions=" + transactions + '}';
    }

}
