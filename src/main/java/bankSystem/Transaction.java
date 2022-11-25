package bankSystem;

import bankSystem.interFace.TransactionInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class TransactionItems {
    private int finalBalance, amountOfTransfer, idx;
    private String userName, accountNum, bankName, password, date;

    public TransactionItems(int idx, String userName, String password, String date, String accountNum, int amountOfTransfer, String bankName, int finalBalance) {
        this.idx = idx;
        this.finalBalance = finalBalance;
        this.userName = userName;
        this.accountNum = accountNum;
        this.bankName = bankName;
        this.amountOfTransfer = amountOfTransfer;
        this.password = password;
        this.date = date;
    }
}

public class Transaction {
    ArrayList<TransactionItems> transactionItems;
    HashMap<String, ArrayList<TransactionItems>> listOfTransactionsByName;
    HashMap<String, ArrayList<TransactionItems>> listOfTransactionsByAccount;

    TransactionInterface transactionInterface = new TransactionInterface();

    public Transaction() { listOfTransactionsByName = new HashMap<>(); }
    static int transactionCount = 0;

    public void TransactionSetter(String userName, String password, String accountNum, String type, int amountOfTransfer, String bankName, int finalBalance) {
        transactionCount++;
        Date dateUpdate = new Date();
        SimpleDateFormat formatterUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = formatterUpdate.format(dateUpdate);
        TransactionItems transactionData = new TransactionItems(transactionCount, userName, password, accountNum, type, amountOfTransfer, bankName, finalBalance);
        transactionItems.add(transactionData);
        listOfTransactionsByName.put(userName, transactionItems);
        listOfTransactionsByAccount.put(accountNum, transactionItems);
    }

    public void transactionListGetterByName(String userName) {
        listOfTransactionsByName.get(userName);
    }

    public void transactionListGetterByAccount(String accountNum) {
        listOfTransactionsByName.get(accountNum);
    }
}

