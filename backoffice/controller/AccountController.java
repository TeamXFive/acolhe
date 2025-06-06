package backoffice.controller;

import backoffice.model.User;
import backoffice.service.AccountService;

public class AccountController {

    AccountService oAccountService = new AccountService();
    
    public void createAccount() {
        oAccountService.createAccount();
    }
}
