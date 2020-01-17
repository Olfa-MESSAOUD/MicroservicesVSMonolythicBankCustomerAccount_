/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.ensi.ilsi.accountsmanagement_uservice.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.ensi.ilsi.accountsmanagement_uservice.domain.Account;
import tn.ensi.ilsi.accountsmanagement_uservice.repository.AccountRepository;
import tn.ensi.ilsi.bankaccountmanagment_common.dto.AccountDto;



@Service
@Transactional
public class AccountService {
    
    private final Logger log = LoggerFactory.getLogger(AccountService.class);
    
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
  
    public AccountDto create(AccountDto accountDto) {
        log.debug("Request to create Account : {}", accountDto);
        
        return mapToDto(
            this.accountRepository.save(
                    new Account(
                            accountDto.getBalance(), 
                            accountDto.getCustomerId(),
                            Collections.emptyList()
                    )
            )
        );
    }

    public List<AccountDto> findAll() {
        log.debug("Request to get all Accounts");
        return this.accountRepository.findAll()
                .stream()
                .map(AccountService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AccountDto findById(Long id) {
        log.debug("Request to get Account : {}", id);
        return this.accountRepository.findById(id).map(AccountService::mapToDto).orElse(null);
    }

    public void delete(Long id) {
        log.debug("Request to delete Account : {}", id);

        Account account = this.accountRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));

        this.accountRepository.delete(account);
    }

    public static AccountDto mapToDto(Account account) {
        if (account != null) {
            return new AccountDto(
                    account.getId(),
                    account.getBalance(),
                    account.getCustomerId(),
                    account.getTransactions().stream().map(TransactionService::mapToDto).collect(Collectors.toList())
            );
        }
        return null;
    }
    
}
