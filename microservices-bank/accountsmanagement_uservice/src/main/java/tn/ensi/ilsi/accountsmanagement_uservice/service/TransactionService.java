/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.accountsmanagement_uservice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.ensi.ilsi.accountsmanagement_uservice.domain.Account;
import tn.ensi.ilsi.accountsmanagement_uservice.domain.BankTransaction;
import tn.ensi.ilsi.accountsmanagement_uservice.repository.AccountRepository;
import tn.ensi.ilsi.accountsmanagement_uservice.repository.BankTransactionRepository;
import tn.ensi.ilsi.bankaccountmanagment_common.dto.BankTransactionDto;
import tn.ensi.ilsi.bankaccountmanagment_common.enumeration.TransactionType;


@Service
@Transactional
public class TransactionService {
    
        
    private final Logger log = LoggerFactory.getLogger(TransactionService.class);
    
    private final BankTransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(BankTransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository=transactionRepository;
        this.accountRepository=accountRepository;
    }
    
    public BankTransactionDto create(BankTransactionDto transactionDto) {
        log.debug("Request to create Transaction from : {} with {}", transactionDto.getAccountID(), transactionDto.getAmount());
        Account account = this.accountRepository.findById(transactionDto.getAccountID())
        .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + transactionDto.getAccountID()));
        if(transactionDto.getTransactionType()==TransactionType.Deposit){
            account.setBalance(account.getBalance().add(transactionDto.getAmount()));     
        }
        else{
            if (account.getBalance().subtract(transactionDto.getAmount()).equals(new BigDecimal("0"))){
                account.setBalance(account.getBalance().subtract(transactionDto.getAmount()));
            }
            else {
                throw new IllegalStateException("Cannot find Customer with id " + transactionDto.getAmount());   
            }
        }
    	System.out.println("REST "+account.toString()+"  "+account.getCustomerId() );
        return mapToDto(
            this.transactionRepository.save(
                    new BankTransaction(
                            transactionDto.getAmount(),
                            transactionDto.getTransactionType(),
                            account)
            )
        );
    }

    public BankTransactionDto withdraw(Long id, BigDecimal amount) {
        log.debug("Request to create Transaction withdrow from : {} with {}", id, amount);
        Account account = this.accountRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));
        if (account.getBalance().subtract(amount).equals(new BigDecimal("0"))){
            account.setBalance(account.getBalance().subtract(amount));
        }
        else {
            throw new IllegalStateException("Cannot find Customer with id " + id);   
        }
        return mapToDto(
            this.transactionRepository.save(
                    new BankTransaction(
                            amount,
                            TransactionType.withdrow,
                            account)
            )
        );
    }
    
    public List<BankTransactionDto> findAll() {
        log.debug("Request to get all Transactions");
        return this.transactionRepository.findAll()
                .stream()
                .map(TransactionService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BankTransactionDto findById(Long id) {
        log.debug("Request to get Transaction : {}", id);
        return this.transactionRepository.findById(id).map(TransactionService::mapToDto).orElse(null);
    }

    public void delete(Long id) {
        log.debug("Request to delete Transaction : {}", id);

        BankTransaction transaction = this.transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Transaction with id " + id));

        this.transactionRepository.delete(transaction);
    }

    public static BankTransactionDto mapToDto(BankTransaction transaction) {
        if (transaction != null) {
            return new BankTransactionDto(
                    transaction.getId(),
                    transaction.getAmount(),
                    transaction.getTransactionType(),
                    transaction.getId()
            );
        }
        return null;
    }
    
}
