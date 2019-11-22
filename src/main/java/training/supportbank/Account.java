package training.supportbank;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

class Account {
    private static final Logger LOGGER = LogManager.getLogger();

    private String name;
    private Integer balancePence;
    private List<Transaction> transactionList;
    public Account(String name) {
        this.name = name;
        this.balancePence = 0;
        this.transactionList = new ArrayList<Transaction>();
    }
    public void AddBalance(Integer increase) {
        this.balancePence += increase;
    }
    public void AddTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }
    public Integer GetBalance() {
        return this.balancePence;
    }
    public String GetName() {
        return this.name;
    }
    public List<Transaction> GetTransactions() {
        return this.transactionList;
    }
}