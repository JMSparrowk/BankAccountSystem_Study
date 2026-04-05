public class BankAccount {

    private String name;

    private Long accountNum;

    private Long balance;

    public BankAccount(String name, Long accountNum){
        this.name = name;
        this.accountNum = accountNum;
        this.balance = 0L;
    }

    public String getName() {
        return name;
    }

    public Long getAccountNum(){
        return accountNum;
    }

    public Long getBalance() {
        return balance;
    }

    public void deposit(Long amount) {
        this.balance += amount;
    }

    public void withdraw(Long amount) {
        this.balance -= amount;
    }
}
