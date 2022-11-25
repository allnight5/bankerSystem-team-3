package bankSystem;

import java.util.Scanner;

public class Customer extends Bank {
    Transaction transaction = new Transaction();

    public void selectAccountView() {
        Scanner scanner = new Scanner(System.in);
        if (banklist.lengthGetter() == 0) {
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

                    for (int i = 0; i < banklist.lengthGetter(); i++) {
                        BankSystemItem accountNumber = banklist.GetterAccountNumber(checkAccountNumber, i);
                        if (accountNumber == null) {
                            System.out.println("고객이 가진 계좌가 없습니다.");
                        } else {
                            while (true) {
                                System.out.println("입금을 원하시면 (1).\n" + "출금을 원하시면 (2).\n" + "거래내역 조회를 원하시면 (3).\n" + "잔고 조회를 원하시면 (4).");
                                int depositOrWithdraw = Integer.parseInt(scanner.nextLine());

                                switch (depositOrWithdraw) {
                                    case 1:
                                        System.out.println("입금하시려는 액수를 입력해주세요.");
                                        int deposit = Integer.parseInt(scanner.nextLine());
                                        banklist.depositSetter(accountNumber, deposit);
                                        break;

                                    case 2:
                                        System.out.println("출금하시려는 액수를 입력해주세요.");
                                        int withdraw = Integer.parseInt(scanner.nextLine());
                                        banklist.withdrawSetter(accountNumber, withdraw);
                                        break;
                                    case 3:
                                        System.out.println("-------거래내역-------");
                                        transaction.transactionListGetterByAccount(checkAccountNumber);
                                        break;
                                    case 4:
                                        System.out.println("계좌 잔고는 " + banklist.readBalance(accountNumber) + "원 입니다.");

                                }
                                break;
                            }
                        }
                    } break;
                case 2:
                    System.out.println("찾고 싶은 계좌의 소유주명을 입력해주세요");
                    String checkAccountName = scanner.nextLine();
                    for (int i = 0; i < banklist.lengthGetter(); i++) {
                        BankSystemItem accountName = banklist.Getter(checkAccountName, i);
                        if (accountName == null) {
                            System.out.println("고객이 가진 계좌가 없습니다.");
                        } else {
                            while (true) {
                                System.out.println("입금을 원하시면 (1).\n" + "출금을 원하시면 (2).\n" + "거래내역 조회를 원하시면 (3).\n" + "잔고 조회를 원하시면 (4).");
                                int depositOrWithdraw = Integer.parseInt(scanner.nextLine());

                                switch (depositOrWithdraw) {
                                    case 1:
                                        System.out.println("입금하시려는 액수를 입력해주세요.");
                                        int deposit = Integer.parseInt(scanner.nextLine());
                                        banklist.depositSetter(accountName, deposit);
                                        break;
                                    case 2:
                                        System.out.println("출금하시려는 액수를 입력해주세요.");
                                        int withdraw = Integer.parseInt(scanner.nextLine());
                                        banklist.withdrawSetter(accountName, withdraw);
                                        break;
                                    case 3:
                                        System.out.println("-------거래내역-------");
                                        transaction.transactionListGetterByName(checkAccountName);
                                        break;
                                    case 4:
                                        System.out.println("계좌 잔고는 " + banklist.readBalance(accountName) + "원 입니다.");

                                }
                                break;

                            }
                        }
                    }
            } break;
        }
    }
}