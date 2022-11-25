package bankSystem;

import java.util.Scanner;

public class Customer extends Bank {
    public void selectAccountView() {
        Scanner sc = new Scanner(System.in);
        if (banklist.lengthGetter() == 0) {
            System.out.println("가지고 계신 계좌가 없습니다.");
            return;
        }
        while (true) {
            System.out.println("계좌번호로 계좌찾기 (1)\n" + "소유주명으로 계좌찾기(2)");
            int numberOrName = Integer.parseInt(sc.nextLine());

            CustomerList customerlist;

            switch (numberOrName) {
                case 1:
                    System.out.println("찾고 싶은 계좌명을 입력해주세요");
                    String accountNumber = sc.nextLine();

                    for (int i = 0; i < banklist.lengthGetter(); i++) {
                        BankSystemItem temp = banklist.Getter(accountNumber, i);
                        if (temp == null) {
                            System.out.println("고객이 가진 계좌가 없습니다.");
                            continue;
                        }
                        System.out.println("고객명 :\t" + temp.getCustomerName() + ",\t계좌번호 :\t" + temp.getCustomerAccountNumber() + ",\t잔고 :\t" + temp.getCustomerBalance());
                    }
                    break;
                case 2:
                    System.out.println("찾고 싶은 계좌의 소유자명을 입력해주세요");
                    String inName = sc.nextLine();
//        //이제막 입력된것이 맨위로 보이게 하고싶을때
//        for (int i =banklist.lengthGetter(); i>0; i--){
//            bankSystemItem temp = banklist.Getter(inName,i-1);
//            if(temp == null) continue;
//            System.out.println("고객수 : "+temp.getBankIdx() +",\t고객명 :\t"+temp.getCustomerName()+",\t비밀번호 :\t"+temp.getCustomerPassword()+",\t계좌번호 :\t"+temp.getCustomerAccountNumber());
//        }
                    //입력되어있는순으로 출력하고싶을때
                    for (int i = 0; i < banklist.lengthGetter(); i++) {
                        BankSystemItem temp = banklist.Getter(inName, i);
                        if (temp == null) {
                            System.out.println("고객이 가진 계좌가 없습니다.");
                            continue;
                        }
                        System.out.println("고객명 :\t" + temp.getCustomerName() + ",\t계좌번호 :\t" + temp.getCustomerAccountNumber() + ",\t잔고 :\t" + temp.getCustomerBalance());
                    }

            }
            break;
        }
    }
}