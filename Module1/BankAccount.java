package Module1;
public class BankAccount {
    protected String firstName;
    protected String lastName;
    protected int accountID;
    protected double balance;

    protected BankAccount(){
        this.firstName = "";
        this.lastName = "";
        this.accountID = 0;
        this.balance = 0;
    }
    public void deposit(double dep){
        this.balance += dep;
        System.out.println(dep+" was added to your account.");
    }
    public void withdrawal(double wit){
        this.balance -= wit;
        System.out.println(wit+" was withdrawn from your account.");
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String first){
        this.firstName=first;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String last){
        this.lastName=last;
    }
    public int getAccountID(){
        return this.accountID;
    }
    public void setAccountID(int acc){
        this.accountID=acc;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double bal){
        this.balance=bal;
    }
    public void accountSummary(){
        System.out.println("-----Account Summary-----");
        System.out.println("First Name: "+this.firstName);
        System.out.println("Last Name: "+this.lastName);
        System.out.println("Account ID:"+ this.accountID);
        System.out.print("Current Balance: ");
        if(this.balance < 1 && this.balance > -1){
            System.out.print("¢"+this.balance+"\n");
        }
        else{
            System.out.print("$"+this.balance+"\n");
        }
    }
}