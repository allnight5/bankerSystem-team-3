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

    public bankList(){
        bankArraylist = new ArrayList<>();
    }

    //입력된값을 리스트에 넣어주는 setter
    public void Setter(String name, String password, String accountNumber, LocalDateTime date){
        count++;
        SimpleDateFormat formatterUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateUpdate = new Date();
        //입력넣어주기formatterUpdate.format(dateUpdate)
        String tDateTime = "";
        tDateTime = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        bankSystemItem data = new bankSystemItem(count,name,password,accountNumber, tDateTime);
        bankArraylist.add(data);
        System.out.println("생성자수 :\t"+data.getBankIdx() +",\t고객명 :\t"+data.getCustomerName()+",\t비밀번호 :\t"+data.getCustomerPassword()+",\t계좌번호 :\t"+data.getCustomerAccountNumber()
                +",\t날짜시간 :\t"+data.getCustomerConnectDate());
    }
    //이름 검색시 있다면 그 문자열을 반환해준다.
    // 우선 한개만 되는지 확인
    public bankSystemItem Getter(String name){
        for (bankSystemItem item : bankArraylist) {
            if (item.equals(name)) {
                return item;
            }
        }
        return null;
    }
    public bankSystemItem GetterAll(int idx){
        bankSystemItem item = bankArraylist.get(idx);
        item.getBankIdx();
        return item;
    }
    public int lengthGetter(){
        return bankArraylist.size();
    }


}
