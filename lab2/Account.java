public class Account
{
    private String m_name;
    private String m_surname;
    private long m_accountNumber;
    private double m_currentBalance;
    private String m_currency;

    public static int NUMBER_OF_CREATED_ACCOUNTS = 0;

    {
        m_name = "Unknown";
        m_surname = "Unknown";
        m_accountNumber = 0;
        m_currentBalance = 0.0;
        m_currency = "Unknown";
    }

    Account(String name, String surname, String currency)
    {
        m_name = name;
        m_surname = surname;
        m_currency = currency;
        Account.NUMBER_OF_CREATED_ACCOUNTS = Account.NUMBER_OF_CREATED_ACCOUNTS + 1;
    }

    Account(String name, String surname, double balance, String currency)
    {
        m_name = name;
        m_surname = surname;
        m_currency = currency;
        m_currentBalance = balance;
        Account.NUMBER_OF_CREATED_ACCOUNTS = Account.NUMBER_OF_CREATED_ACCOUNTS + 1;
    }

    public String toString()
    {
        String s_name = "" + m_name;
        String s_surname = "" + m_surname;
        String s_acc = "" + m_accountNumber;
        String s_cur_b = "" + m_currentBalance;
        String result = "Account{firstName='"+s_name+"', lastName='"+s_surname+"', number='"+s_acc+"', balance='"+s_cur_b+" "+m_currency+"'}";
        return result;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;

        Account another = (Account)o;
        return m_name.equals(another.m_name) &&
            m_surname.equals(another.m_surname) &&
            (m_accountNumber == another.m_accountNumber) &&
            (m_currentBalance == another.m_currentBalance) &&
            m_currency.equals(another.m_currency);
    }

    public String getOwner() { return m_name+m_surname; }
    public double getAccountBalanceDouble() { return m_currentBalance; }
    public String getAccountBalance() { return "" + m_currentBalance + " " + m_currency; }
    public void setBalance(double new_balance) { m_currentBalance = new_balance; }
    public void setAccountNumber(long number) { m_accountNumber = number; }
    public void setCurrency(String new_currency) { m_currency = new_currency; }
    public String getNumber() { return String.valueOf(m_accountNumber); }
    public String getCurrency() { return m_currency; }
}