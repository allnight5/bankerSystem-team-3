package bankSystem;

class UserAccountItem
{
    private String transationDate, transationTime, userAccount, inOut, bankName;
    public UserAccountItem() {}
    public UserAccountItem(String transationDate, String transationTime, String userAccount, String inOut, String bankName) {
        this.transationDate = transationDate;
        this.transationTime = transationTime;
        this.userAccount = userAccount;
        this.inOut = inOut;
        this.bankName = bankName;
    }

    public String getTransationDate() { return transationDate; }
    public String getTransationTime() { return transationTime; }
    public String getPassword() { return userAccount; }
    public String getInOut() { return inOut; }
    public String getBankName() { return bankName; }
}

public class CustomerAccount {


}