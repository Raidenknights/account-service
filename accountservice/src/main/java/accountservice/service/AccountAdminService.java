package accountservice.service;

import org.springframework.data.domain.Page;

import accountservice.entity.Account;

public interface AccountAdminService {

	Page<Account> findAllAccounts(String name, String uuid);

	Account accountRecoveryPasswordChange(Long accountId);

}
