package bankSystem;

public class BankSystemItem {
    private int idx, balance;
    private String name, password, accountNumber, date;

    public BankSystemItem(int idx, String name, String password, String accountNumber, String date) {
        this.idx = idx;
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        this.date = date;
    }

    //순서대로 생성수, 고객이름,비밀번호,계좌번호,날짜이다.
    public int getBankIdx() {
        return idx;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerPassword() {
        return password;
    }

    public String getCustomerAccountNumber() {
        return accountNumber;
    }

    public int getCustomerBalance() {
        return balance;
    }

    public String getCustomerConnectDate() {
        return date;
    }

    //은행 관리자로 접속하여 계좌의 이름, 비밀번호,계좌번호 변경을 위한 메소드
    public void setCustomerName(String changeName) { name = changeName; }

    public void setCustomerPassword(String changePass) {
        password = changePass;
    }

    public void setCustomerAccountNumber(String changeAccountNumber) {
        accountNumber = changeAccountNumber;
    }

    // 은행 고객의 계좌 잔고에 입금, 출금을 위한 메소드

    public void depositToBalance(int deposit) {
        balance += deposit;
    }

    public void withdrawToBalance(int withdraw) {
        balance -= withdraw;
    }
}