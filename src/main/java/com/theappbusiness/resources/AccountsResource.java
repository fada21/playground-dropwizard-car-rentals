package com.theappbusiness.resources;

import com.theappbusiness.content.AccountContentManager;
import com.theappbusiness.model.Account;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountsResource extends CrudResource<Account, AccountContentManager> {

    public AccountsResource(AccountContentManager accountContentManager) {
        super(accountContentManager);
    }

    @GET
    public List<Account> listAccounts() {
        return super.listItems();
    }

    @GET
    public Account getAccount(@PathParam("id") LongParam id) {
        return super.getItem(id.get());
    }

    @POST
    @Path("{id}")
    public Account createAccount(Account item) {
        return super.createItem(item);
    }

    @PUT
    @Path("{id}")
    public Account updateAccount(@PathParam("id") LongParam id, Account item) {
        return super.updateItem(id.get(), item);
    }

    @DELETE
    @Path("{id}")
    public Response deleteAccount(@PathParam("id") LongParam id) {
        return super.deleteItem(id.get());
    }
}
