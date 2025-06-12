package accountservice.service.impl;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import accountservice.dto.AccountDTOResponse;
import accountservice.entity.Account;
import accountservice.exceptions.NoAccountExistsException;
import accountservice.repository.AccountRepository;
import accountservice.service.AccountAdminService;

@Service
public class AccountAdminServiceImpl implements AccountAdminService {

	private static final Logger logger = Logger.getLogger(AccountAdminServiceImpl.class);

	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;

	public AccountAdminServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Page<Account> findAllAccounts(String name, String uuid) {
		logger.debug("Entering method findAllAccounts() with uuid:" + uuid);
		Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
		return accountRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public AccountDTOResponse accountRecoveryPasswordChange(Long accountId, String newPassword, String uuid) {
		logger.debug("Entering accountRecoveryPasswordChange() with uuid:" + uuid + "and account ID:" + accountId);
		Optional<Account> account = Optional.ofNullable(accountRepository.findById(accountId)
				.orElseThrow(() -> new NoAccountExistsException("No account with this account id:" + accountId)));
		account.get().setPassword(passwordEncoder.encode(newPassword));
		accountRepository.save(account.get());
		return mapToAccountDTOResponse(account.get());
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
