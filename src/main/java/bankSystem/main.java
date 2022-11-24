package bankSystem;
import bankSystem.interFace.bankInterface;
import bankSystem.interFace.customerInterface;
import bankSystem.interFace.mainInterface;
import bankSystem.interFace.rePasswordInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //인터페이스들을 생성하기위한 부분
        mainInterface mainIn = new mainInterface();
        customerInterface customerInterface = new customerInterface();
        rePasswordInterface rePasswordInterface = new rePasswordInterface();
        bankInterface bankInterface = new bankInterface();

        //고객인지 관리자인지 알기위한 관리자비밀번호
        String adminpassword = "1234";
        //고객 정보 전체를를 담아둘 은행 하나 생성;
        bank bankAll = new bank();
        customer customer = new customer();
        //고객 창으로 이동을 위해 선언

        //한번씩 비밀번호 입력받아서 확인할 변수선언
        String tempass="";
        //계좌번호를 입력받을 변수
        String AccountNumber;
        boolean isFirstWhile = false;
        int adminCustomer = 0;
        while(!isFirstWhile){
            mainIn.run();
            // 메뉴 입력받기
            // InputMismatchException에 대한 예외처리 진행
            // 숫자를 제외한 형식을 입력했을때
            // 시스템 정지가 아닌 다시 입력하도록 함
            try {
                //고객인가 관리자인가 구분자 입력
                adminCustomer = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주시기 바랍니다.");
                sc = new Scanner(System.in);
                continue;
            }
            switch (adminCustomer){
                //관리자인가 고객인가 선택
                case 1:
                    System.out.println("관리자 비밀번호를 입력해주시기 바랍니다.");
                    //비밀번호 입력
                    sc = new Scanner(System.in);
                    tempass = sc.nextLine();
                    //비밀번호 일치여부 확인
                    if (adminpassword.equals(tempass)){
                        boolean isInOut = false;
                        //관리자 메인으로 이동하거나 여기에서 while문 을 돌릴곳
                        while(!isInOut){
                            bankInterface.bankRun();
                            sc = new Scanner(System.in);
                            int adminSelect=0;
                            try {
                                adminSelect = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("숫자만 입력해주시기 바랍니다.");
                                continue;
                            }
                            switch (adminSelect){
                                case 1:
                                    bankAll.bankcreat();
                                    System.out.println(bankAll.banklist.toString());
                                    break;
                                case 2:
                                    break;
                                case 3:
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
                    }else{
                        rePasswordInterface.rePass();
                    }
                    break;
                case 2:
                    //비밀번호 입력
                    sc = new Scanner(System.in);
                    tempass = sc.nextLine();
                    if (adminpassword.equals(tempass)){
                        customerInterface.customerRun();
                        //고객 메인으로 이동하거나 여기에서 while문 을 돌릴곳
                    }else{
                        rePasswordInterface.rePass();
                    }

                    break;

                default:
                    System.out.println("종료");
                    isFirstWhile = true;
                    break;
            }
        }
    }
}
