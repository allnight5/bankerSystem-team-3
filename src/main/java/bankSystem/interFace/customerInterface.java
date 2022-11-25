package bankSystem.interFace;

import bankSystem.bank;
import bankSystem.customer;

import java.util.Scanner;

public class customerInterface extends customer {

    public void customerRun() {
        selectAccountView();
        while (true) {

            System.out.println("1.입금");
            System.out.println("2.출금");
            System.out.println("3.잔고 확인");
            System.out.println("메뉴를 선택해주세요. (메인 메뉴로 돌아가기 (0))");
            Scanner scanner = new Scanner(System.in);
            String selectedMenu = scanner.nextLine();
            int menu = Integer.parseInt(selectedMenu);

            if(menu == 0) {
                System.out.println("메인메뉴로 돌아갑니다.");
                break;
            }
            switch (menu) {
                case 1:
                    System.out.println("입금");
                    break;
                case 2:
                    System.out.println("출금");
                    break;
                case 3:
                    System.out.println("잔고 확인");
                    break;
            }
        }
    }
}
