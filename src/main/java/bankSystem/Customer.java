package bankSystem;

import java.util.Scanner;

public class Customer extends Bank {
    Transaction transaction = new Transaction();

    public void referCustomerAccount() {
        Scanner scanner = new Scanner(System.in);
        if (banklist.getArrayListLength() == 0) {
            System.out.println("가지고 계신 계좌가 없습니다.");
            return;
        }
        while (true) {
            System.out.println("계좌번호로 계좌찾기을 원하시면 (1).\n" + "소유주명으로 계좌찾기을 원하시면 (2).");
            int numberOrName = Integer.parseInt(scanner.nextLine());

            switch (numberOrName) {
                case 1:
                    System.out.println("찾고 싶은 계좌명을 입력해주세요");
                    String checkAccountNumber = scanner.nextLine();

                    for (int i = 0; i < banklist.getArrayListLength(); i++) {
                        BankSystemItem accountNumber = banklist.searchAccountNumber(checkAccountNumber, i);
                        if (accountNumber == null) {
                            if (i == (banklist.getArrayListLength() - 1)) {
                                System.out.println("일치하는 계좌가 없습니다.");
                            }
                        } else {
                            System.out.println("비밀번호를 입력해주세요");
                            String password = scanner.nextLine();
                            if (!(accountNumber.getCustomerPassword().equals(password))) {
                                System.out.println("비밀번호가 틀렸습니다.");
                                break;
                            }
                            while (true) {
                                System.out.println("입금을 원하시면 (1).\n" + "출금을 원하시면 (2).\n" + "거래내역 조회를 원하시면 (3).\n" + "잔고 조회를 원하시면 (4).");
                                int depositOrWithdraw = Integer.parseInt(scanner.nextLine());

                                switch (depositOrWithdraw) {
                                    case 1:
                                        System.out.println("입금하시려는 액수를 입력해주세요.");
                                        String tempType = "입금";
                                        int deposit = Integer.parseInt(scanner.nextLine());
                                        int tempDepositBalance = banklist.depositToAccount(accountNumber, deposit);
                                        transaction.sortTransactionDataIntoArrayList(accountNumber.getCustomerName(), accountNumber.getCustomerAccountNumber(), tempType, deposit, tempDepositBalance);
                                        break;

                                    case 2:
                                        System.out.println("출금하시려는 액수를 입력해주세요.");
                                        String tempType2 = "출금";
                                        int withdraw = Integer.parseInt(scanner.nextLine());
                                        int tempWithdrawBalance = banklist.withdrawFromAccount(accountNumber, withdraw);
                                        transaction.sortTransactionDataIntoArrayList(accountNumber.getCustomerName(), accountNumber.getCustomerAccountNumber(), tempType2, withdraw, tempWithdrawBalance);
                                        break;
                                    case 3:
                                        System.out.println("-------거래내역-------");
                                        transaction.getTransactionListByAccountNumber(accountNumber.getCustomerAccountNumber());
                                        break;
                                    case 4:
                                        System.out.println("계좌 잔고는 " + banklist.checkBalance(accountNumber) + "원 입니다.");

                                }
                                break;
                            }
                        } break;
                    }
                    break;

                case 2:
                    System.out.println("찾고 싶은 계좌의 소유주명을 입력해주세요");
                    String checkAccountName = scanner.nextLine();
                    System.out.println("소유주명 " + checkAccountName + "으로 등록된 계좌는 다음과 같습니다.");
                    for (int i = 0; i < banklist.getArrayListLength(); i++) {
                        BankSystemItem accountName = banklist.searchOwnerName(checkAccountName, i);
                        if (accountName == null) {
                            if (i == (banklist.getArrayListLength() - 1)) {
                                System.out.println("일치하는 계좌가 없습니다.");
                            }
                        }
                        System.out.println(accountName.getCustomerAccountNumber());
                    }

                    System.out.println("찾고 싶은 계좌명을 입력해주세요");
                    String checkAccountNumberFromName = scanner.nextLine();

                    for (int i = 0; i < banklist.getArrayListLength(); i++) {
                        BankSystemItem accountNumber = banklist.searchAccountNumber(checkAccountNumberFromName, i);
                        if (accountNumber == null) {
                            if (i == (banklist.getArrayListLength() - 1)) {
                                System.out.println("일치하는 계좌가 없습니다.");
                            }
                        } else {
                            System.out.println("비밀번호를 입력해주세요");
                            String password = scanner.nextLine();
                            if (!(accountNumber.getCustomerPassword().equals(password))) {
                                System.out.println("비밀번호가 틀렸습니다.");
                                break;
                            }
                            while (true) {
                                System.out.println("입금을 원하시면 (1).\n" + "출금을 원하시면 (2).\n" + "거래내역 조회를 원하시면 (3).\n" + "잔고 조회를 원하시면 (4).");
                                int depositOrWithdraw = Integer.parseInt(scanner.nextLine());

                                switch (depositOrWithdraw) {
                                    case 1:
                                        System.out.println("입금하시려는 액수를 입력해주세요.");
                                        String tempType = "입금";
                                        int deposit = Integer.parseInt(scanner.nextLine());
                                        int tempDepositBalance = banklist.depositToAccount(accountNumber, deposit);
                                        transaction.sortTransactionDataIntoArrayList(accountNumber.getCustomerName(), accountNumber.getCustomerAccountNumber(), tempType, deposit, tempDepositBalance);
                                        break;

                                    case 2:
                                        System.out.println("출금하시려는 액수를 입력해주세요.");
                                        String tempType2 = "출금";
                                        int withdraw = Integer.parseInt(scanner.nextLine());
                                        int tempWithdrawBalance = banklist.withdrawFromAccount(accountNumber, withdraw);
                                        transaction.sortTransactionDataIntoArrayList(accountNumber.getCustomerName(), accountNumber.getCustomerAccountNumber(), tempType2, withdraw, tempWithdrawBalance);
                                        break;
                                    case 3:
                                        System.out.println("-------거래내역-------");
                                        transaction.getTransactionListByAccountNumber(accountNumber.getCustomerAccountNumber());
                                        break;
                                    case 4:
                                        System.out.println("계좌 잔고는 " + banklist.checkBalance(accountNumber) + "원 입니다.");

                                }
                                break;
                            }
                        }
                        break;
                    }
                    break;
            } break;
        }
    }
}

