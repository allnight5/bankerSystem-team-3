package bankSystem;

import bankSystem.interFace.TransactionInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class TransactionItems {
    private double finalBalance, amountOfTransfer;
    private String userName, accountNum, bankName, password, date;

    public TransactionItems(String userName, String password, String date, String accountNum, int amountOfTransfer, String bankName, int finalBalance) {
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
    HashMap<String, ArrayList<TransactionItems>> listOfTransactions;

    TransactionInterface transactionInterface = new TransactionInterface();

    public Transaction() { listOfTransactions = new HashMap<>(); }

    public void TransactionSetter(String userName, String password, String accountNum, String type, int amountOfTransfer, String bankName, int finalBalance) {
        Date dateUpdate = new Date();
        SimpleDateFormat formatterUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = formatterUpdate.format(dateUpdate);
        TransactionItems transactionData = new TransactionItems(userName, password, accountNum, type, amountOfTransfer, bankName, finalBalance);
        transactionItems.add(transactionData);
        listOfTransactions.put(userName, transactionItems);
    }

    public void TransactionListGetter(String userName) {
        System.out.println(listOfTransactions.get(userName));
    }
}

