package bankSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class TransactionItems {
    private int finalBalance, amountOfTransfer, idx;
    private String userName;
    private String accountNum;
    private String password;
    private String date;
    private String type;

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

    public void setAccountNum(String accountNum) {
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

    public TransactionItems(int idx, String userName, String date, String accountNum, String type, int amountOfTransfer, int finalBalance) {
        this.idx = idx;
        this.finalBalance = finalBalance;
        this.userName = userName;
        this.accountNum = accountNum;
        this.amountOfTransfer = amountOfTransfer;
        this.date = date;
        this.type = type;
    }
}

public class Transaction {
    static ArrayList<TransactionItems> transactionItems = new ArrayList<>();

    static int transactionCount = 0;

    public void makeTransactionIntoList(String userName, String accountNum, String type, int amountOfTransfer, int finalBalance) {
        transactionCount++;
        Date dateUpdate = new Date();
        SimpleDateFormat formatterUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = formatterUpdate.format(dateUpdate);
        TransactionItems transactionData = new TransactionItems( transactionCount, userName, dateTime, accountNum, type, amountOfTransfer, finalBalance);
        transactionItems.add(transactionData);
    }

    public void transactionListGetterByName(String userName) {
        for (int i = 0; i < transactionItems.size(); i++) {
            if (transactionItems.get(i).getUserName().equals(userName)) {
                System.out.println("거래 일자/시간: " + transactionItems.get(i).getDate() + ".   계좌번호: " + transactionItems.get(i).getAccountNum() + ".   거래 여부: " + transactionItems.get(i).getType() + ".   거래 금액: " + transactionItems.get(i).getAmountOfTransfer() + ".   잔고: " + transactionItems.get(i).getFinalBalance());
            }
        }
    }

    public void getTransactionListByAccountNumber(String accountNum) {
        for (int i = 0; i < transactionItems.size(); i++) {
            if (transactionItems.get(i).getAccountNum().equals(accountNum)) {
                System.out.println("거래 일자/시간: " + transactionItems.get(i).getDate() + ".   계좌번호: " + transactionItems.get(i).getAccountNum() + ".   거래 여부: " + transactionItems.get(i).getType() + ".   거래 금액: " + transactionItems.get(i).getAmountOfTransfer() + ".   잔고: " + transactionItems.get(i).getFinalBalance());
            }
        }
    }

    public String getTransactionListByUserName(String userName) {
        for (int i = 0; i < transactionItems.size(); i++) {
            if (transactionItems.get(i).getUserName().equals(userName)) {
                return userName;
            }
        }
    }
}

