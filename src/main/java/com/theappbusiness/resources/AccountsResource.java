package com.theappbusiness.resources;

import com.theappbusiness.content.AccountContentManager;
import com.theappbusiness.model.Account;

import javax.ws.rs.Path;

@Path("/accounts")
public class AccountsResource extends CrudResource<Account, AccountContentManager> {

    public AccountsResource(AccountContentManager accountContentManager) {
        super(accountContentManager);
    }

}
