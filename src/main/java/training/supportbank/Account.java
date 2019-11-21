package training.supportbank;

class Account {
    private String name;
    private Integer balancePence;
    public Account(String name, Integer balance) {
        this.name = name;
        this.balancePence = balance;
    }
    public void AddBalance(Integer increase) {
        this.balancePence += increase;
    }
    public Integer GetBalance() {
        return this.balancePence;
    }
    public String GetName() {
        return this.name;
    }
}