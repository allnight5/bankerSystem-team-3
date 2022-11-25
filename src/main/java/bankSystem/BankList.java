package bankSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//고객 리스트는
//이름, 비밀번호, 계좌번호 로 구성된다
//이름을 고유로 할지 다른게 할지는 회의를 통해진행한다.
class BankSystemItem {
    private int idx, balance;
    private String name, password, accountNumber, date;
    public BankSystemItem(){}
    public BankSystemItem(int idx, String name, String password, String accountNumber, int balance, String date){
        this.idx = idx;
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        this.date= date;
        this.balance = balance;
    }
    //순서대로 생성수, 고객이름,비밀번호,계좌번호,날짜이다.
    public int getBankIdx(){return idx;}
    public String getCustomerName(){return name;}
    public String getCustomerPassword(){return password;}
    public String getCustomerAccountNumber(){return accountNumber;}
    public int getCustomerBalance(){return balance;}
    public String getCustomerConnectDate(){return date;}

    //순서대로 이름, 비밀번호,계좌번호이다.
    public void setCustomerName(String changeName){
        password = changeName;
    }
    public void setCustomerPassword(String changePass){
        password = changePass;
    }
    public void setCustomerAccountNumber(String changeAccountNumber){
        accountNumber = changeAccountNumber;
    }
}
public class BankList {
    static int count = 0;
    static ArrayList<BankSystemItem> bankArraylist;

    //리스트 한개를 생성한다;
    public BankList(){
        bankArraylist = new ArrayList<>();
    }

    //계좌번호 중복 검사를 해주는 메소드
    public boolean accountGetter(String accountName){
        for (BankSystemItem item : bankArraylist) {
            //중복검사 문자열인 getCustomerAccountNumer와 들어온 어카운트가 같은지 확인한다.
            //같다면 false보내서 !(반대로 바꾸는거 flase -> true) 조건문을 충족시킨다
            if (item.getCustomerAccountNumber().equals(accountName)) {
                return false;
            }
        }
        return true;
    }
    //나중에 비교 메소드 만들어보기
    //너무많이쓰니까 규칙찾아서 클래스나 메소드 하나로 만들어서 사용하는것이 좋을것같다.
//    public boolean checkEquals(){
//
//        return
//    }
    //입력된값을 리스트에 넣어주는 setter
    //1번 계좌 등록에 사용되는 메소드
    public void Setter(String name, String password, String accountNumber){
        count++;
        int balance = 0;
        Date dateUpdate = new Date();
        SimpleDateFormat formatterUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = formatterUpdate.format(dateUpdate);
        BankSystemItem data = new BankSystemItem(count,name,password,accountNumber, balance, dateTime);
        bankArraylist.add(data);
        System.out.println("생성자수 :\t"+data.getBankIdx() +",\t고객명 :\t"+data.getCustomerName()+",\t비밀번호 :\t"+data.getCustomerPassword()+",\t계좌번호 :\t"+data.getCustomerAccountNumber()
                +",\t잔고 :\t"+data.getCustomerBalance()+",\t날짜시간 :\t"+data.getCustomerConnectDate());

    }
    //은행 2,3번 수정,삭제 Get메소드
    //계좌 번호와 비밀번호를 받을것인지 고객명과 비밀번호를 받을것인지
    //입력값이 은행에 존재하는지 확인해주는 메소드
    public boolean aBooleanchangeGetter(String accountNumber, String password){
        for(BankSystemItem item: bankArraylist){
            if(item.getCustomerAccountNumber().equals(accountNumber) && item.getCustomerPassword().equals(password)){
                return false;
            }
        }
        return true;
    }
    //은행 2-2번 수정 Set 메소드
    //무엇을 수정할것인지 선택하게 할것인가
    //비밀번호만 변경할것인가
    //비밀번호를 변경해주는 메소드
    public void changeSetter(String accountNumber, String changePassword){
        for(BankSystemItem item: bankArraylist){
            if(item.getCustomerAccountNumber().equals(accountNumber)){
                item.setCustomerPassword(changePassword);
            }
        }
    }
    //은행 3번 삭제 메소드
    public boolean deleteCustomer(String accountNumber, String password){
        for(BankSystemItem item: bankArraylist){
            if(item.getCustomerAccountNumber().equals(accountNumber) && item.getCustomerPassword().equals(password)){
                bankArraylist.remove(item);
                return false;
            }
        }
        return true;
    }

    //은행 4번내용 이름 검색 내용 출력
    //이름 검색시 있다면 그 문자열을 반환해준다.
    // 우선 한개만 되는지 확인
    public BankSystemItem Getter(String name, int idx){
        BankSystemItem item = bankArraylist.get(idx);
        if(item.getCustomerName().equals(name)){
            return item;
        }else{
            return null;
        }

    //은행 4번내용 계좌번호 검색 내용 출력
    //이름 검색시 있다면 그 문자열 반환해준다.
    }public BankSystemItem GetterAccountNumber(String accountNumber, int idx){
        BankSystemItem item = bankArraylist.get(idx);
        if(item.getCustomerAccountNumber().equals(accountNumber)){
            return item;
        }else{
            return null;
        }
    }
    //5번 내용 반환
    public BankSystemItem GetterAll(int idx){
        BankSystemItem item = bankArraylist.get(idx);
        return item;
    }
    public int lengthGetter(){
        return bankArraylist.size();
    }
}