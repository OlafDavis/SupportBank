package training.supportbank;

public class Transaction {
    private String fromName;
    private String toName;
    private Integer amountPence;
    public Transaction(String from, String to, Integer amount) {
        this.fromName = from;
        this.toName = to;
        this.amountPence = amount;
    }
    public String GetFrom() {
        return this.fromName;
    }
    public String GetTo() {
        return this.toName;
    }
    public Integer GetAmountPence() {
        return this.amountPence;
    }
}
