package bankSystem;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

//고객 리스트는
//이름, 비밀번호, 계좌번호 로 구성된다
//이름을 고유로 할지 다른게 할지는 회의를 통해진행한다.
class bankSystemItem{
    private int idx;
    private String name, password, accountNumber, date;
    public bankSystemItem(){}
    public bankSystemItem(int idx, String name, String password, String accountNumber,String date){
        this.idx = idx;
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        this.date= date;
    }
    public int getBankIdx(){return idx;}
    public String getCustomerName(){return name;}
    public String getCustomerPassword(){return name;}
    public String getCustomerAccountNumber(){return accountNumber;}
    public String getCustomerConnectDate(){return date;}

}
public class bankList {
    static int count = 0;
    ArrayList<bankSystemItem> bankArraylist;

    //리스트 한개를 생성한다;
    public bankList(){
        bankArraylist = new ArrayList<>();
    }

    //이메소드로 맞는 계좌번호 하나를 가져올수있다.
    public bankSystemItem  accountGetter(String name){
        for (bankSystemItem item : bankArraylist) {
            if (item.getCustomerName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    //입력된값을 리스트에 넣어주는 setter
    //1번 계좌 등록에 사용되는 메소드
    public void Setter(String name, String password, String accountNumber){
        count++;
        Date dateUpdate = new Date();
        SimpleDateFormat formatterUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = formatterUpdate.format(dateUpdate);
        bankSystemItem data = new bankSystemItem(count,name,password,accountNumber, dateTime);
        bankArraylist.add(data);
        System.out.println("생성자수 :\t"+data.getBankIdx() +",\t고객명 :\t"+data.getCustomerName()+",\t비밀번호 :\t"+data.getCustomerPassword()+",\t계좌번호 :\t"+data.getCustomerAccountNumber()
                +",\t날짜시간 :\t"+data.getCustomerConnectDate());
    }
    //은행 2번 수정 메소드


    //은행 3번 삭제 메소드


    //은행 4번내용 이름 검색 내용 출력
    //이름 검색시 있다면 그 문자열을 반환해준다.
    // 우선 한개만 되는지 확인
    public void Getter(String name, int idx){
        bankSystemItem item = bankArraylist.get(idx);
        if(item.getCustomerName().equals(name)){
            System.out.println("계좌번호 : "+item.getCustomerAccountNumber()+"\t고객이름 : "+item.getCustomerName()+"\t비밀번호"+item.getCustomerPassword());
        }


    }
    //5번 내용 반환
    public bankSystemItem GetterAll(int idx){
        bankSystemItem item = bankArraylist.get(idx);
        item.getBankIdx();
        return item;
    }
    public int lengthGetter(){
        return bankArraylist.size();
    }


}
