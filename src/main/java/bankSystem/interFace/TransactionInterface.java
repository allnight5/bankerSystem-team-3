package bankSystem.interFace;

public class TransactionInterface {
    public String findType (int beforeBalance, int afterBalance)  {
        if (beforeBalance > afterBalance) {
            return "Withdraw";
        } else if (beforeBalance == afterBalance) {
            return "No Transaction Occurred";
        } else return "Deposit";
    }

    public int findAmountOfTransaction (int beforeBalance, int afterBalance) {
        int amount = afterBalance - beforeBalance;
        return Math.abs(amount);
    }
}
