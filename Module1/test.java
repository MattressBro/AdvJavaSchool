package Module1;

public class test {
    public static void main(String[] args){
        BankAccount bank = new BankAccount();
        CheckingAccount check = new CheckingAccount();
        bank.setFirstName("Braden");
        bank.setLastName("Heeney");
        bank.setAccountID(4593982);
        bank.accountSummary();
        check.setFirstName("John");
        check.setLastName("Doe");
        check.setAccountID(5589467);
        check.accountSummary();
        check.displayAccount();
        bank.withdrawal(40);
        bank.accountSummary();
        check.withdrawal(40);
        check.displayAccount();
    }
}
