package bankSystem.interFace;

public class TransactionInterface {

    public int findAmountOfTransaction (int beforeBalance, int afterBalance) {
        int amount = afterBalance - beforeBalance;
        return Math.abs(amount);
    }
}
