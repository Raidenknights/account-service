package accountservice.service;

import accountservice.dto.AccountDTOResponse;
import accountservice.dto.request.AccountDTO;

public interface AccountService {

	void createAccount(AccountDTO account, String uuid);

	void modifyAccount(Long accountId, AccountDTO account, String uuid);

	AccountDTOResponse fetchAccountDetails(Long accountId, String uuid);
}
