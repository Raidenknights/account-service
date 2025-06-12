package accountservice.service;

import org.springframework.data.domain.Page;

import accountservice.dto.AccountDTOResponse;
import accountservice.entity.Account;

public interface AccountAdminService {

	Page<Account> findAllAccounts(String name, String uuid);

	AccountDTOResponse accountRecoveryPasswordChange(Long accountId, String newPassword, String uuid);

}
