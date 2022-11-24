package bankSystem;
import bankSystem.interFace.bankInInterface;

import java.util.Scanner;

public class bank {
    bankList banklist;

    public bank(){banklist = new bankList();}

    //계좌 생성 메소드
    public void bankcreat(){
        String  name, password, AccountNumber;
//        LocalDateTime date = LocalDateTime.now();
        boolean istrueAccountNumber = false;
        Scanner sc = new Scanner(System.in);

        bankInInterface bankInInterface = new bankInInterface();
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
            bankInInterface.inRun();
            // 계좌번호 작성
            sc = new Scanner(System.in);
            //정규표현식 변수
            String check = "^(\\d{1,4})(-(\\d{1,5}))(-(\\d{1,4}))";
            //계좌번호 작성
            AccountNumber = sc.nextLine();
            if (AccountNumber.equals("0")){
                break;
            }
            if (AccountNumber.matches(check)){
                if(banklist.lengthGetter() != 0){
                    boolean isTrue = banklist.accountGetter(AccountNumber);
                    if(!isTrue){
                        System.out.println("중복입니다.");
                        System.out.println("다른 계좌번호를 입력해주세요");
                        continue;
                    }
                }
                banklist.Setter(name, password,AccountNumber);
                istrueAccountNumber = true;
            }else {
                System.out.println("계좌번호 규칙을 준수해주시기 바랍니다..");
            }
        }
    }
    //4번 계좌 검색 소유자명
    public void selectAccountView(){
        if (banklist.lengthGetter() == 0){
            System.out.println("가지고 계신 계좌가 없습니다.");
            return;
        }
        System.out.println("찾고 싶은 계좌의 소유자명을 입력해주세요");
        Scanner sc = new Scanner(System.in);
        String inName = sc.nextLine();
//        //이제막 입력된것이 맨위로 보이게 하고싶을때
//        for (int i =banklist.lengthGetter(); i>0; i--){
//            bankSystemItem temp = banklist.Getter(inName,i-1);
//            if(temp == null) continue;
//            System.out.println("고객수 : "+temp.getBankIdx() +",\t고객명 :\t"+temp.getCustomerName()+",\t비밀번호 :\t"+temp.getCustomerPassword()+",\t계좌번호 :\t"+temp.getCustomerAccountNumber());
//        }
        //입력되어있는순으로 출력하고싶을때
        for (int i =0; i<banklist.lengthGetter(); i++){
            bankSystemItem temp = banklist.Getter(inName, i);
            if(temp == null) continue;
            System.out.println("고객수 : "+temp.getBankIdx() +",\t고객명 :\t"+temp.getCustomerName()+",\t비밀번호 :\t"+temp.getCustomerPassword()+",\t계좌번호 :\t"+temp.getCustomerAccountNumber());
        }
    }
    //5번 전체 조회하기
    public void allAccountView(){
        //비어있다면 그만둔다
        if(banklist.lengthGetter() == 0) return;
        System.out.println("이용자수\t고객명\t비밀번호\t계좌번호");
        System.out.println("------------------------------------");
        //이제막 입력된것이 맨위로 보이게 하고싶을때
//        for (int i =banklist.lengthGetter(); i>0; i--){
//            bankSystemItem temp = banklist.GetterAll(i-1);
//            System.out.println("고객수 : "+temp.getBankIdx() +",\t고객명 :\t"+temp.getCustomerName()+",\t비밀번호 :\t"+temp.getCustomerPassword()+",\t계좌번호 :\t"+temp.getCustomerAccountNumber());
//        }
        //입력되어있는순으로 출력하고싶을때
        for (int i =0; i<banklist.lengthGetter(); i++){
            bankSystemItem temp = banklist.GetterAll(i);
            System.out.println("고객수 : "+temp.getBankIdx() +",\t고객명 :\t"+temp.getCustomerName()+",\t비밀번호 :\t"+temp.getCustomerPassword()+",\t계좌번호 :\t"+temp.getCustomerAccountNumber());
        }
    }

}
