package training.supportbank;

class Account {
    private String name;
    private Integer balancePence;
    public Account(String name, Integer balance) {
        this.name = name;
        this.balancePence = balance;
    }
    public AddBalance(Integer increase) {
        this.balancePence += increase;
    }
    public Integer Balance() {
        return this.balancePence;
    }
    public String Name() {
        return this.name;
    }
}