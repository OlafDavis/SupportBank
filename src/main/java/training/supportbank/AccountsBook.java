package training.supportbank;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;

public class AccountsBook {
    private static final Logger LOGGER = LogManager.getLogger();

    private HashMap<String, Account> accountsMap;

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
        String toKey = toName.toLowerCase();
        String fromKey = fromName.toLowerCase();
        Integer amount = transaction.GetAmountPence();
        if (this.accountsMap.containsKey(toKey)) {
            this.accountsMap.get(toKey).AddBalance(amount);
            this.accountsMap.get(toKey).AddTransaction(transaction);
        } else {
            Account newAccount = new Account(toName);
            newAccount.AddBalance(amount);
            newAccount.AddTransaction(transaction);
            this.accountsMap.put(toKey, newAccount);
        }
        if (this.accountsMap.containsKey(fromKey)) {
            this.accountsMap.get(fromKey).AddBalance(-amount);
            this.accountsMap.get(fromKey).AddTransaction(transaction);
        } else {
            Account newAccount = new Account(fromName);
            newAccount.AddBalance(-amount);
            newAccount.AddTransaction(transaction);
            this.accountsMap.put(fromKey, newAccount);
        }
    }

    public HashMap<String,Account> GetAccounts() {
        return this.accountsMap;
    }

    public void ListAll() {
        this.accountsMap.entrySet().forEach(item -> System.out.println(item.getValue().GetName() + ", bal: " + Main.FormatAmount(item.getValue().GetBalance())));
    }

    public void ListAccount(String name) {
        Account account = this.accountsMap.get(name);
        System.out.println(account.GetName());
        System.out.println("balance: " + Main.FormatAmount(account.GetBalance()));
        System.out.println();
        for (Transaction transaction : account.GetTransactions()) {
            LOGGER.log(Level.DEBUG,name + ": " + transaction.GetFrom() + " to " + transaction.GetTo());
            if (transaction.GetFrom().toLowerCase().equals(name)) {
                System.out.println("paid " + Main.FormatAmount(transaction.GetAmountPence()) + " to " + transaction.GetTo());
            } else {
                System.out.println("received " + Main.FormatAmount(transaction.GetAmountPence()) + " from " + transaction.GetFrom());
            }
        }
    }
}
