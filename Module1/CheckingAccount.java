package Module1;
public class CheckingAccount extends BankAccount {
    protected double intRate;
    protected CheckingAccount(){
        super();
        this.intRate=3;
    }
    public void processWithdrawal(){
        System.out.println();
    }
}
