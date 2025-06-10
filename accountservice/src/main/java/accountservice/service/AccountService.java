package accountservice.service;

import accountservice.dto.request.Account;

public interface AccountService {
	
	void createAccount(Account accountId);
	void modifyAccount(String accountId, Account account);
}
