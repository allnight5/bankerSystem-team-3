package bankSystem;

import bankSystem.interFace.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //인터페이스들을 생성하기위한 부분
        MainInterface mainIn = new MainInterface();
        CustomerInterface customerInterface = new CustomerInterface();
        RePasswordInterface rePasswordInterface = new RePasswordInterface();
        BankInterface bankInterface = new BankInterface();
        //고객인지 관리자인지 알기위한 관리자비밀번호
        String adminpassword = "1234";
        //고객 정보 전체를를 담아둘 은행 하나 생성;
        Bank bankAll = new Bank();
        Customer customer = new Customer();
        //고객 창으로 이동을 위해 선언


        int adminCustomer = 0;
        mainIn.banner();
        while (true) {
            mainIn.run();
            // 메뉴 입력받기
            // InputMismatchException에 대한 예외처리 진행
            // 숫자를 제외한 형식을 입력했을때
            // 시스템 정지가 아닌 다시 입력하도록 함
            try {
                //고객인가 관리자인가 구분자 입력
                adminCustomer = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주시기 바랍니다.");
                scanner = new Scanner(System.in);
                continue;
            }
            switch (adminCustomer) {
                //관리자인가 고객인가 선택
                //메인밖에 클래스로 뺄것인가 아니면 이상태로 할것인가는;;
                //완성하거나 or 회의하고 바꾸는걸로
                //case1로 가면 뱅크 클래스 시스템으로 case2로 가면 고객 클래스 시스템으로
                //가는 형식 등
                case 1:
                    System.out.println("관리자 비밀번호를 입력해주시기 바랍니다.");
                    //비밀번호 입력
                    scanner = new Scanner(System.in);
                    String tempass = scanner.nextLine();
                    //비밀번호 일치여부 확인
                    if (adminpassword.equals(tempass)) {
                        //while문을 돌리기 위한 변수
                        boolean isInOut = false;
                        //관리자 메인으로 이동하거나 여기에서 while문 을 돌릴곳
                        while (!isInOut) {
                            bankInterface.bankRun();
                            scanner = new Scanner(System.in);
                            int adminSelect = 0;
                            try {
                                adminSelect = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("숫자만 입력해주시기 바랍니다.");
                                continue;
                            }
                            switch (adminSelect) {
                                case 1:
                                    bankAll.bankCreate();
                                    break;

                                case 2:
                                    bankAll.changeCustomer();
                                    break;

                                case 3:
                                    bankAll.deleteCustomer();
                                    break;

                                case 4:
                                    bankAll.selectAccountView();
                                    break;

                                case 5:
                                    bankAll.allAccountView();
                                    break;

                                default:
                                    isInOut = true;
                                    break;
                            }
                        }
                    } else {
                        rePasswordInterface.rePass();
                    }
                    continue;
                case 2:
                    customer.customertAccountView();
                    continue;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }break;
        }
    }
}
