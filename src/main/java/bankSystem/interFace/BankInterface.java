package bankSystem.interFace;

public class BankInterface {
    public void bankRun() {
        System.out.println("---------목록---------");
        System.out.println("앞에 번호를 입력해주세요");
        System.out.print("1.계좌등록\t\t");
        System.out.println("2.계좌관리(수정)");
        System.out.print("3.계좌관리(삭제)\t");
        System.out.println("4.계좌검색(소유자명)");
        System.out.print("5.모든 계좌 \t\t");
        System.out.println("6.종료");
        System.out.println("---------------------");
    }
}
