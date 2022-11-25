package bankSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    ArrayList<TransactionData> transactionItems = new ArrayList<>();

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
                        ".   거래 여부: " + transactionItems.get(i).getType() + ".   거래 금액: " + transactionItems.get(i).getAmountOfTransfer() +
                        ".   잔고: " + transactionItems.get(i).getFinalBalance());
            }
        }
    }

    public void getTransactionListByAccountNumber(String accountNum) {
        for (int i = 0; i < transactionItems.size(); i++) {
            if (transactionItems.get(i).getAccountNum().equals(accountNum)) {
                System.out.println("거래 일자/시간: " + transactionItems.get(i).getDate() + ".   계좌번호: " + transactionItems.get(i).getAccountNum() +
                        ".   거래 여부: " + transactionItems.get(i).getType() + ".   거래 금액: " + transactionItems.get(i).getAmountOfTransfer() +
                        ".   잔고: " + transactionItems.get(i).getFinalBalance());
            }
        }
    }

    public String Shit(String userName) {
        return null;
    }
}