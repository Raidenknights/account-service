package accountservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import accountservice.constants.Constants;
import accountservice.dto.request.AccountDTO;
import accountservice.service.AccountService;

@RestController
public class AccountServiceController {

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceController.class);

	private final AccountService accountService;

	public AccountServiceController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = Constants.CREATE_ACCOUNT_URL)
	public ResponseEntity<Object> createCustomerAccount(@Valid @RequestBody AccountDTO account, String uuid) {

		logger.debug("Entering createCustomerAccount() method with UUID:" + uuid);
		accountService.createAccount(account, uuid);
		logger.debug("Exiting createCustomerAccount() method with UUID" + uuid);

		return new ResponseEntity<>(Constants.ACCOUNT_CREATED_SUCCESS, HttpStatus.CREATED);
	}

	@PostMapping(path = Constants.MODIFY_ACCOUNT_URL)
	public ResponseEntity<Object> modifyCustomerDetails(@Valid @RequestBody AccountDTO account, String uuid) {

		logger.debug("Entering modifyCustomerDetails() method with uuid:" + uuid);
		accountService.modifyAccount(account.getId(), account, uuid);
		logger.debug("exiting modifyCustomerDetails() method with uuid:" + uuid);
		return null;

	}

}
