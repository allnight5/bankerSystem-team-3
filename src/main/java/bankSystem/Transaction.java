package bankSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Transaction {
    List<TransactionData> transactionItems = new ArrayList<>();

    int transactionMarkerCount = 0;

    public void sortTransactionDataIntoArrayList(String userName, String accountNumber, String type, int amountOfTransfer, int finalBalance) {
        transactionMarkerCount++;
        Date date = new Date();
        SimpleDateFormat formatterUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = formatterUpdate.format(date);
        TransactionData transactionData = new TransactionData(transactionMarkerCount, userName, dateTime, accountNumber, type, amountOfTransfer,
                finalBalance);
        transactionItems.add(transactionData);
    }

    public void getTransactionListByUserName(String userName) {
        for (int i = 0; i < transactionItems.size(); i++) {
            if (transactionItems.get(i).getUserName().equals(userName)) {
                System.out.println("거래 일자/시간: " + transactionItems.get(i).getDate() + ".   계좌번호: " + transactionItems.get(i).getAccountNum() +
                        ".   거래 종류: " + transactionItems.get(i).getType() + ".   거래 금액: " + transactionItems.get(i).getAmountOfTransfer() +
                        ".   잔고: " + transactionItems.get(i).getFinalBalance());
            }
        }
    }

    public void getTransactionListByAccountNumber(String accountNum) {
        for (int i = 0; i < transactionItems.size(); i++) {
            if (transactionItems.get(i).getAccountNum().equals(accountNum)) {
                System.out.println("거래 일자/시간: " + transactionItems.get(i).getDate() + ".   계좌번호: " + transactionItems.get(i).getAccountNum() +
                        ".   거래 종류: " + transactionItems.get(i).getType() + ".   거래 금액: " + transactionItems.get(i).getAmountOfTransfer() +
                        ".   잔고: " + transactionItems.get(i).getFinalBalance());
            }
        }
    }

    public String findAccountNumberByName(String name) {
        for (int i = 1; i < transactionItems.size(); i++) {
            if (transactionItems.get(i).getUserName().equals(name)) {
                return transactionItems.get(i).getAccountNum();
            }
        }
        return null;
    }

    public String findNameByAccountNumber(String accountNumber) {
        for (int i = 1; i < transactionItems.size(); i++) {
            if (getAccountNumFromTransactionData(accountNumber, i).equals(accountNumber)) {
                return transactionItems.get(i).getUserName();
            }
        }
        return null;
    }

    public TransactionData getAccountNumFromTransactionData(String accountNumber, int id) {
        TransactionData item = transactionItems.get(id);
        if (item.getAccountNum().equals(accountNumber)) {
            return item;
        } else {
            return null;
        }
    }

    public TransactionData getNameFromTransactionData(String name, int id) {
        TransactionData item = transactionItems.get(id);
        if (item.getUserName().equals(name)) {
            return item;
        } else {
            return null;
        }
    }
}