package com.theappbusiness.resources;

import com.theappbusiness.content.AccountContentManager;
import com.theappbusiness.model.Account;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/accounts")
public class AccountsResource extends CrudResource<Account, AccountContentManager> {

    public AccountsResource(AccountContentManager accountContentManager) {
        super(accountContentManager);
    }

}
