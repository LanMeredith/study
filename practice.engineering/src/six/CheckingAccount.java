package six;

/**
 * 支票账户
 * @author shkstart
 * @create 2021-08-28-9:45
 */
public class CheckingAccount extends Account {
    /**
     * 透支保护
     */
    private SavingsAccount protectedBy = null;

    /**
     * @param amt
     * @return
     */
    @Override
    public boolean withdraw(double amt) {
        if (amt > balance) {
//            判断是否存在透支保护，如果存在的话进入下一层判断
            if (protectedBy == null) {
                return false;
            } else {
                if (protectedBy.getBalance() < (amt - balance)) {
                    return false;
                } else {
                    protectedBy.withdraw(amt - balance);
                    balance = 0;
                    return true;
                }
            }
        } else {
            balance -= amt;
            return true;
        }
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, SavingsAccount protectedBy) {
        super(balance);
        this.protectedBy = protectedBy;
    }
}
