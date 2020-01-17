/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.accountsmanagement_uservice.domain;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;
import tn.ensi.ilsi.bankaccountmanagment_common.enumeration.TransactionType;



@Entity
@Table(name = "bank_transaction")
public class BankTransaction extends AbstractEntity{
    
    private BigDecimal amount;
    
    private TransactionType transactionType;
    
    @ManyToOne
    private Account account;

    public BankTransaction() {
        super();
        //JPA! super better!
    }

    public BankTransaction(BigDecimal amount, TransactionType transactionType,
            Account account) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" + "amount=" + amount + ", transactionType=" 
                + transactionType + ", account=" + account + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.amount);
        hash = 97 * hash + Objects.hashCode(this.transactionType);
        hash = 97 * hash + Objects.hashCode(this.account);
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
        final BankTransaction other = (BankTransaction) obj;
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (this.transactionType != other.transactionType) {
            return false;
        }
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        return true;
    }

}
