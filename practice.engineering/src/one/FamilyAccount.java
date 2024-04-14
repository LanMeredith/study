package one;

/**
 * @author shkstart
 * @create 2021-02-10-11:53
 */
public class FamilyAccount {
    public static int balance = 10000;

    public static void main(String[] args) {
        boolean loopFlag = true;
        String details = "收支\t账户金额\t收支金额\t说 明\n";
        while(loopFlag){
            switch (menu()){
                case '1':
                    System.out.println(details);
                    break;
                case '2':
                    System.out.println("本次收入金额：");
                    int i = Utility.readNumber();
                    balance += i;
                    System.out.println("本次收入说明：");
                    details += "收入\t" + balance + "\t"+i+"\t"+Utility.readString()+"\n";
                    break;
                case '3':
                    System.out.println("本次支出金额：");
                    int j = Utility.readNumber();
                    balance -= j;
                    System.out.println("本次支出说明：");
                    details += "支出\t" + balance + "\t"+j+"\t"+Utility.readString()+"\n";
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    if (Utility.readConfirmSelection() == 'Y'){
                        loopFlag = false;
                    }else {
                        continue;
                    }
                default:
            }
        }
    }

    public static char menu(){
        System.out.println("-----------家庭收支记账软件-------------");
        System.out.println("1 收支明细");
        System.out.println("2 登记收入");
        System.out.println("3 登记支出");
        System.out.println("4 退   出");
        System.out.println("请选择(1-4):_");
        return Utility.readMenuSelection();
    }
}
