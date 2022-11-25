package bankSystem;

public class Customer {

    CustomerList customerlist;

    public Customer(){
        customerlist = new CustomerList();
    }

    public void customerCreate(String name, String password, String accountNumber){
        //0으로 할지 잔금을 바꿔줄지는 회의에서 결정
        //이부분에서 스캐너를 써서 입력해준다면
        //잔금을 바꿀수 있고 아니면 0으로 들어가게 둔다.
        customerlist.setterCustomer(name,password,accountNumber,0);
    }
//    public void getCustomerList(){
//        if(customerlist.getterCustomerLength() == 0){
//            System.out.println("가지고 계신 계좌가 없습니다");
//            System.out.println("은행에가셔서 계좌를 등록 해주시기 바랍니다.");
//            return;
//        }
//        for (int i =0; i<customerlist.getterCustomerLength(); i++){
//            customerItem temp = customerlist.getterCustomer();
//            System.out.println("\t고객명 :\t"+temp.getName()+",\t계좌번호 :\t"+temp.getAccountNumber()+",\t잔고 : "+ temp.getNowMoney());
//        }
//    }
}