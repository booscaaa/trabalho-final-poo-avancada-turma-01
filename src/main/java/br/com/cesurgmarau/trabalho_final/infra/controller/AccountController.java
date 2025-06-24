package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.AccountUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountUseCase accountUseCase;

    @PostMapping("/account")
    public Account create(@RequestBody Account account) {
        accountUseCase.create(account);
        return account;
    }

    @PutMapping("/account/{accountID}")
    public Account update(@PathVariable int accountID, @RequestBody Account account) {
        accountUseCase.update(accountID, account);
        return account;
    }

    @DeleteMapping("/account/{accountID}")
    public void delete(@PathVariable int accountID) {
        accountUseCase.delete(accountID);
    }

    @GetMapping("/account/{accountID}")
    public Account getByID(@PathVariable int accountID) {
        return accountUseCase.getByID(accountID);
    }

    @GetMapping("/account")
    public List<Account> fetch() {
        return accountUseCase.fetch();
    }
}
