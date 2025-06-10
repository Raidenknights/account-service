package accountservice.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import accountservice.dto.request.AccountDTO;
import accountservice.entity.Account;
import accountservice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private final PasswordEncoder passwordEncoder;

	public AccountServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void createAccount(AccountDTO accountDto, String uuid) {
		Account accountEntity = mapToEntityAccount(accountDto);
	}

	@Override

	public void modifyAccount(Long accountId, AccountDTO account, String uuid) {
		// TODO Auto-generated method stub

	}

	private Account mapToEntityAccount(AccountDTO account) {

		Account accountEntity = new Account();
		accountEntity.setId(account.getId());
		accountEntity.setFirstName(account.getFirstName());
		accountEntity.setLastName(account.getLastName());
		accountEntity.setPassword(passwordEncoder.encode(account.getPassword()));
		accountEntity.setNumber(account.getNumber());

		return accountEntity;
	}

}
