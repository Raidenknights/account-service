package accountservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import accountservice.dto.request.Account;
import accountservice.service.AccountService;

@RestController
public class AccountServiceController {

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceController.class);

	private final AccountService accountService;

	public AccountServiceController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = "")
	public ResponseEntity<Object> createCustomerAccount(Account account, String uuid) {

		logger.debug("Entering createCustomerAccount() method");
		accountService.createAccount(null);
		return null;
	}

}
