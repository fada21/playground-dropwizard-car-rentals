package com.fada21.dropwizard.resources;

import com.fada21.dropwizard.content.AccountContentManager;
import com.fada21.dropwizard.model.Account;
import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.Path;

@Path(AccountsResource.PATH)
@Api(value = AccountsResource.PATH, description = "Operations on accounts")
public class AccountsResource extends CrudResource<Account, AccountContentManager> {

    public static final String PATH = "/accounts";

    public AccountsResource(AccountContentManager accountContentManager) {
        super(accountContentManager);
    }

}
