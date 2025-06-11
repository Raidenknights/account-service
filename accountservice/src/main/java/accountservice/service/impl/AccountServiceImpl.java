package accountservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import accountservice.dto.AccountDTOResponse;
import accountservice.dto.request.AccountDTO;
import accountservice.entity.Account;
import accountservice.exceptions.NoAccountExistsException;
import accountservice.repository.AccountRepository;
import accountservice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	private final PasswordEncoder passwordEncoder;
	private final AccountRepository accountRepository;

	public AccountServiceImpl(PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
		this.passwordEncoder = passwordEncoder;
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional
	public void createAccount(AccountDTO accountDto, String uuid) {
		logger.debug("enterting create account with uuid:" + uuid);
		Account accountEntity = mapToEntityAccount(accountDto);
		accountRepository.save(accountEntity);
		logger.debug("exiting create account with uuid:" + uuid);
	}

	@Override
	@Transactional
	public void modifyAccount(Long accountId, AccountDTO account, String uuid) {

	}

	@Override
	@Transactional(readOnly = true)
	public AccountDTOResponse fetchAccountDetails(Long accountId, String uuid) throws NoAccountExistsException {
		logger.debug("entering fetchAccountDetails() method with uuid:" + uuid);

		return mapToAccountDTOResponse(accountRepository.getById(accountId));
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

	private AccountDTOResponse mapToAccountDTOResponse(Account account) {

		AccountDTOResponse accountDTOResponse = new AccountDTOResponse();

		accountDTOResponse.setFirstName(account.getFirstName());
		accountDTOResponse.setLastName(account.getLastName());
		accountDTOResponse.setUsername(account.getUsername());
		accountDTOResponse.setNumber(account.getNumber());
		accountDTOResponse.setId(account.getId());

		return accountDTOResponse;
	}

}
