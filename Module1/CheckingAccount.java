package Module1;
public class CheckingAccount extends BankAccount {
    protected double intRate;
    protected CheckingAccount(){
        super();
        this.intRate=3;
    }
    @Override
    public void withdrawal(double wit){
        this.balance -= wit;
        System.out.println("Account ID: "+this.accountID);
        System.out.println(wit+" was withdrawn from your account.");
        processWithdrawal();
    }
    public void processWithdrawal(){
        if(this.getBalance() <0){
            System.out.println("WARNING: Overdraft Penalization");
            System.out.println("Account balance: "+this.getBalance());
            System.out.println("  Overdraft fee: $30");
            double newBal = getBalance();
            newBal -=30;
            this.setBalance(newBal);
            System.out.println("Account balance: "+this.getBalance());
        }
    }
    public void displayAccount(){
        accountSummary();
        System.out.println("Interest Rate:"+intRate);
    }
}
