package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.AccountRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.AccountUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUseCaseImpl implements AccountUseCase {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.create(account);
    }

    @Override
    public Account update(int accountID, Account account) {
        return accountRepository.update(accountID, account);
    }

    @Override
    public void delete(int accountID) {
        accountRepository.delete(accountID);
    }

    @Override
    public Account getByID(int accountID) {
        return accountRepository.getByID(accountID);
    }

    @Override
    public List<Account> fetch() {
        return accountRepository.fetch();
    }
}
