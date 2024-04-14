package study.hashTable;

import java.util.Scanner;

/**
 * 哈希表测试
 * @author shkstart
 * @create 2021-11-06-15:35
 */
public class HashTabDemo {
    public static void main(String[] args) {
//        创建一个哈希表
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int id;
            String name;
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("del：删除雇员");
            System.out.println("amend：修改雇员");
            System.out.println("exit：退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入id");
                    id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的雇员id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "del":
                    System.out.println("请输入要删除的雇员id");
                    id = scanner.nextInt();
                    hashTab.delEmpById(id);
                    break;
                case "amend":
                    System.out.println("请输入要修改的雇员id");
                    id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    name = scanner.next();
                    hashTab.amend(new Emp(id, name));
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
