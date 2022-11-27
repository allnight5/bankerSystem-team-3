package bankSystem;

class TransactionData {
    private int finalBalance;
    private int amountOfTransfer;
    private int idx;
    private String userName;
    private String accountNum;
    private String password;
    private String date;
    private String type;

    public TransactionData(int idx, String userName, String date, String accountNum, String type, int amountOfTransfer, int finalBalance) {
        this.idx = idx;
        this.finalBalance = finalBalance;
        this.userName = userName;
        this.accountNum = accountNum;
        this.amountOfTransfer = amountOfTransfer;
        this.date = date;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(int finalBalance) {
        this.finalBalance = finalBalance;
    }

    public int getAmountOfTransfer() {
        return amountOfTransfer;
    }

    public void setAmountOfTransfer(int amountOfTransfer) {
        this.amountOfTransfer = amountOfTransfer;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void putAccountInListNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}