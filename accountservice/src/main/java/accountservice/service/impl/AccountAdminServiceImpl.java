package accountservice.service.impl;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;

import accountservice.entity.Account;
import accountservice.repository.AccountRepository;
import accountservice.service.AccountAdminService;

public class AccountAdminServiceImpl implements AccountAdminService {

	private static final Logger logger = Logger.getLogger(AccountAdminServiceImpl.class);

	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;

	public AccountAdminServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Page<Account> findAllAccounts(String name,String uuid) {
		logger.debug("Entering method findAllAccounts() with uuid:"+uuid);
		Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
		return accountRepository.findAll(pageable);
	}

	@Override
	public Account accountRecoveryPasswordChange(Long accountId) {

		return null;
	}

}
