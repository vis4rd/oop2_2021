import java.util.ArrayList;

public class Bank
{
    private static int INSTANCE = 0;
    public static final double EURO = 4.6;
    public static final double USD = 3.95;
    public static final double PLN = 1.0;

    private ArrayList<Account> m_accounts;

    {
        m_accounts = new ArrayList<>();
    }

    Bank()
    {
        INSTANCE = INSTANCE + 1;
    }

    public void addAccount(Account new_acc)
    {
        m_accounts.add(new_acc);
        int min = 100;
        int max = 999;
        int serial = min + (int) (Math.random() * ((max- min) + 1));
        new_acc.setAccountNumber(Bank.INSTANCE * 1000 + serial);
    }

    public void printAccounts()
    {
        for(var a : m_accounts)
            System.out.println(a);
    }

    public Account findAccount(String number)
    {
        for(var a : m_accounts)
        {
            if(a.getNumber().equals(number))
            { return a; }
        }
        System.out.println("Could not find given account");
        return null;
    }

    public void transferToDifferentCurrency(String number, String currency)
    {
        var acc = this.findAccount(number);
        if(acc == null)
        {
            System.out.println("Cannot transfer, wrong account number");
            return;
        }
        String prev_curr = acc.getCurrency();
        if(prev_curr.equals(currency))
            return;

        double d = 0.0;
        switch(prev_curr)
        {
            case "EURO": d = Bank.EURO; break;
            case "USD":  d = Bank.USD; break;
            case "PLN":
            default:     d = Bank.PLN; break;
        }

        double a = 0.0;
        switch(currency)
        {
            case "EURO": a = Bank.EURO; break;
            case "USD":  a = Bank.USD; break;
            case "PLN":
            default:     a = Bank.PLN; break;
        }

        acc.setBalance(acc.getAccountBalanceDouble() * d / a);
        acc.setCurrency(currency);
    }

    public void transfer(String number1, String number2, double balance)
    {
        var acc1 = this.findAccount(number1);
        if(acc1 == null)
        {
            System.out.println("Cannot transfer, wrong account number1");
            return;
        }

        var acc2 = this.findAccount(number2);
        if(acc2 == null)
        {
            System.out.println("Cannot transfer, wrong account number2");
            return;
        }
        if(acc1.getAccountBalanceDouble() < balance)
        {
            System.out.println("Account "+acc1.getNumber()+" has insufficient balance to complete the transfer.");
            return;
        }
        
        acc1.setBalance(acc1.getAccountBalanceDouble() - balance);
        String prev = acc2.getCurrency();
        this.transferToDifferentCurrency(number2, acc1.getCurrency());
        acc2.setBalance(acc2.getAccountBalanceDouble() + balance);
        this.transferToDifferentCurrency(number2, prev);
    }

    public void transfer(String number1, String number2, double balance, Bank bank2)
    {
        var acc1 = this.findAccount(number1);
        if(acc1 == null)
        {
            System.out.println("Cannot transfer, wrong bank");
            return;
        }
        if(bank2 == null)
        {
            System.out.println("Cannot transfer, bank does not exist");
            return;
        }

        var acc2 = bank2.findAccount(number2);
        if(acc2 == null)
        {
            System.out.println("Cannot transfer, wrong bank");
            return;
        }
        acc1.setBalance(acc1.getAccountBalanceDouble() - balance);
        String prev = acc2.getCurrency();
        bank2.transferToDifferentCurrency(number2, acc1.getCurrency());
        acc2.setBalance(acc2.getAccountBalanceDouble() + balance);
        bank2.transferToDifferentCurrency(number2, prev);
    }
}