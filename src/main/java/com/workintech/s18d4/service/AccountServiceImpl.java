package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElseThrow(()-> new RuntimeException("account not found!"));
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(long id) {
        Account account = find(id);
        if(account != null){
            accountRepository.delete(account);
        }
        return null;
    }
}
