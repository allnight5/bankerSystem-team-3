package bankSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class CustomerItem {
    String name, password, accountNumber;
    int nowMoney;
    //생각해본방식 2
//    ArrayList<accountNumberItem> accountNumberSave;
//    public customerItem(){
//        accountNumberSave = new ArrayList<>();
//    }
    //우선 1
    public CustomerItem(){ }
    public CustomerItem(String name, String password, String accountNumber, int nowMoney){
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        this.nowMoney = nowMoney;
    }
    public String getName(){return name;}
    public String getAccountNumber(){return accountNumber;}
    public int getNowMoney(){ return nowMoney;}

    public String getPassword() { return password; }

    public void setPlusMoney(int inMoney){
        nowMoney += inMoney;
    }
    public void setMinusMoney(int inMoney){
        nowMoney -= inMoney;
    }
}
public class CustomerList {
    ArrayList<CustomerItem> customerArraylist;

    public CustomerList(){
        customerArraylist = new ArrayList<>();
    }

    //고객 생성
    public void setterCustomer(String name, String password, String accountNumber, int nowMoney){
        CustomerItem data = new CustomerItem(name,password,accountNumber, nowMoney);
        customerArraylist.add(data);
    }
    //리스트 길이
    public int getterCustomerLength(){
        return customerArraylist.size();
    }

    //고객 계좌에 따른 비밀번호 체크
    public boolean getCustomerPasswordCheck(String accountNumber,String password){
        for(CustomerItem item: customerArraylist){
            if(item.getPassword().equals(password) && item.getAccountNumber().equals(accountNumber)){
                return true;
            }
        }
        return false;
    }

    //잔액확인 메소드
    public void getterCustomer(String accountNumber){
        for(CustomerItem item: customerArraylist){
            if(item.getAccountNumber().equals(accountNumber)) {
                System.out.println("현재 잔액은 : " +item.getNowMoney() + " 원 입니다.");
            }
        }
    }

    //입급 메소드
    public void setterPlustMoney(String accountNumber){
        for(CustomerItem item: customerArraylist){
            if(item.getAccountNumber().equals(accountNumber)) {
                System.out.println("입급하실 금액을 입력해주시기 바랍니다.");
                Scanner sc = new Scanner(System.in);
                int inMoney = 0;
                try {
                    inMoney = sc.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("숫자만 입력해주세요");
                }
                item.setPlusMoney(inMoney);
            }
        }
    }
    // 출금 메소드
    public void setterMinusMoney(String accountNumber){
        for(CustomerItem item: customerArraylist){
            if(item.getAccountNumber().equals(accountNumber)) {
                System.out.println("출금하실 금액을 입력해주시기 바랍니다.");
                Scanner sc = new Scanner(System.in);
                int outMoney = 0;
                try {
                    outMoney = sc.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("숫자만 입력해주세요");
                }
                item.setMinusMoney(outMoney);
            }
        }
    }
//    public customerItem getterCustomer(String accountNumber){
//        for (customerItem item : customerArraylist){
//            if(item.getAccountNumber().equals(accountNumber)) return item;
//        }
//        return null;
//    }
}