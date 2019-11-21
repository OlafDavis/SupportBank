package training.supportbank;

import java.util.Arrays;
import java.util.HashMap;

public class AccountsBook {
    HashMap<String, Account> accountsMap;
    public  AccountsBook() {
        this.accountsMap = new HashMap<String,Account>();
    }
    private void AddAccount(Account newAccount) {
        // maybe put error handling here?
        this.accountsMap.put(newAccount.GetName(), newAccount);
    }
    public void ProcessTransaction(Transaction transaction) {
        String toName = transaction.GetTo();
        String fromName = transaction.GetFrom();
        Integer amount = transaction.GetAmountPence();
        if (this.accountsMap.containsKey(toName)) {
            this.accountsMap.get(toName).AddBalance(amount);
        } else {
            this.accountsMap.put(toName, new Account(toName,amount));
        }
        if (this.accountsMap.containsKey(fromName)) {
            this.accountsMap.get(fromName).AddBalance(-amount);
        } else {
            this.accountsMap.put(fromName, new Account(toName,-amount));
        }
    }
}
