package two;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-02-11-13:39
 */
public class CustomerView {
    public static void main(String[] args) {
        boolean isFlag = true;
        CustomerList list = new CustomerList(10);
        Scanner sc = new Scanner(System.in);
        while(isFlag){
            switch (menu()){
                case '1':
                    list.addCustomer();
                    break;
                case '2':
                    System.out.println("请输入待修改客户编号（-1退出）：");
                    int i = sc.nextInt();
                    if (i != -1) {
                        list.replaceCustomer(i - 1);
                        break;
                    }
                case '3':
                    System.out.println("请输入待删除客户编号（-1退出）：");
                    int j = sc.nextInt();
                    if (j == -1) {
                        continue;
                    }
                    list.deleteCustomer(j-1);
                    break;
                case '4':
                    list.getAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    if (CMUtility.readConfirmSelection() == 'Y'){
                        isFlag = false;
                    }else {
                        continue;
                    }
                default:
            }
        }
    }
    public static char menu(){
        System.out.println("-----------客户信息管理软件-------------");
        System.out.println("1 添加客户");
        System.out.println("2 修改客户");
        System.out.println("3 删除客户");
        System.out.println("4 客户列表");
        System.out.println("5 退   出");
        System.out.println("请选择(1-5):");
        return CMUtility.readMenuSelection();
    }
}
