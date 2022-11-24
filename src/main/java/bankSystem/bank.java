package bankSystem;

import java.time.LocalDateTime;
import java.util.Scanner;

public class bank {
    bankList banklist;

    public bank(){
        banklist = new bankList();
    }
    public void bankcreat(){
        String  name, password, AccountNumber;
        LocalDateTime date = LocalDateTime.now();
        boolean istrueAccountNumber = false;
        Scanner sc = new Scanner(System.in);

        // 메모 작성전 입력해야하는 정보(고객이름, 비밀번호, 계좌번호) 입력받기
        System.out.println("------작성------");

        // 고객이름 작성
        System.out.println("고객이름 입력 : ");
        name = sc.nextLine();

        // 비밀번호번호 작성
        System.out.println("비밀번호 입력 : ");
        password = sc.nextLine();

        //계좌 번호
        while(!istrueAccountNumber) {
            // 계좌번호 작성
            sc = new Scanner(System.in);
            System.out.println("계좌번호을 입력해주세요.");
            System.out.println("번호는x-x-x ~ xxxx-xxxxx-xxxx의 형태의 숫자로 이루어집니다");
            System.out.println("계좌 생성을 그만두고 싶으시다면 (0)을 입력해주세요");
            String check = "^(\\d{1,4})(-(\\d{1,5}))(-(\\d{1,4}))";
            AccountNumber = sc.nextLine();
            if (AccountNumber.equals("0")){
                break;
            }
            if (AccountNumber.matches(check)){
                banklist.Setter(name, password,AccountNumber, date);
                istrueAccountNumber = true;
            }else {
                System.out.println("계좌번호 규칙을 준수해주시기 바랍니다..");
                System.out.println("번호는x-x-x ~ xxxx-xxxx-xxxx의 형태의 숫자로 이루어집니다");
            }
            System.out.println("");
        }
    }
    public void selectAccountView(){

    }
    public void allAccountView(){
        System.out.println("이용자수\t고객명\t비밀번호\t계좌번호");
        System.out.println("------------------------------------");
        System.out.println(banklist.lengthGetter());
//        for (int i =banklist.lengthGetter(); i>0; i--){
//            bankSystemItem temp = banklist.GetterAll(i-1);
//
//            if (temp.getBankIdx() == -1) continue;
//            System.out.println("고객수 : "+temp.getBankIdx() +",\t고객명 :\t"+temp.getCustomerName()+",\t비밀번호 :\t"+temp.getCustomerPassword()+",\t계좌번호 :\t"+temp.getCustomerAccountNumber());
//        }
        for (int i =0; i<banklist.lengthGetter(); i++){
            bankSystemItem temp = banklist.GetterAll(i+1);
            if (temp.getBankIdx() == -1) continue;
            System.out.println("고객수 : "+temp.getBankIdx() +",\t고객명 :\t"+temp.getCustomerName()+",\t비밀번호 :\t"+temp.getCustomerPassword()+",\t계좌번호 :\t"+temp.getCustomerAccountNumber());
        }
    }

}
