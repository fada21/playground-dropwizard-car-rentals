package com.fada21.dropwizard.content;

import com.fada21.dropwizard.model.Account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountContentManager extends BaseMockedContentManager<Account> {

    private final Map<Long, Account> accountsMap = new ConcurrentHashMap<>();

    public AccountContentManager() {
        Account.AccountBuilder builder = Account.builder();
        accountsMap.put(1l, builder.id(1).name("Adam Admins").isAdmin(true).token("A").build());
        accountsMap.put(2l, builder.id(2).name("Brunhilde Bubble").isAdmin(false).token("B").build());
        accountsMap.put(3l, builder.id(3).name("Cecil Cockburns").isAdmin(false).token("C").build());
        accountsMap.put(4l, builder.id(4).name("Daniel Dude").isAdmin(false).token("D").build());
    }

    @Override
    protected Map<Long, Account> getMockMap() {
        return accountsMap;
    }

    public void setToken(long id, String token) {
        accountsMap.get(id).setToken(token);
    }

    public Account findByToken(String token) {
        for (Map.Entry<Long, Account> acEntry : accountsMap.entrySet()) {
            String nextToken = acEntry.getValue().getToken();
            if (token.equals(nextToken)) {
                return acEntry.getValue();
            }
        }
        return null;
    }
}
