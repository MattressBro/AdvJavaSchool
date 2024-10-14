package Module1;

public class test {
    public static void main(String[] args){
        BankAccount bank = new BankAccount();
        CheckingAccount check = new CheckingAccount();
        bank.setFirstName("Braden");
        bank.setLastName("Heeney");
        bank.setAccountID(4593982);
        bank.accountSummary();
        System.out.println();
        check.setFirstName("John");
        check.setLastName("Doe");
        check.setAccountID(5589467);
        check.accountSummary();
        System.out.println();
        check.displayAccount();
        System.out.println();
        bank.withdrawal(40);
        System.out.println();
        bank.accountSummary();
        System.out.println();
        check.withdrawal(40);
        System.out.println();
        check.displayAccount();
    }
}
