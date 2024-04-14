package two;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-02-11-13:39
 */
public class CustomerList {
    //    用来保存客户对象的数组
    private Customer[] customers;
    //    记录以保存客户对象的数组
    private int total = 0;
    private static Scanner sc = new Scanner(System.in);

    /**
    指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
    将参数customer添加到数组中最后一个客户对象记录之后
     */
    public boolean addCustomer() {
        if (total >= customers.length) {
            return false;
        }
        System.out.println("---------添加客户-----------");
        System.out.print("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(15);
        System.out.print("---------添加完成-----------");
        Customer cust = new Customer(name, gender, age, phone, email);
        customers[total++] = cust;
        return true;
    }

    /**
    用参数customer替换数组中由index指定的对象
     */
    public boolean replaceCustomer(int index) {
        if (customers[index] == null) {
            System.out.println("索引无效无法替换");
            return false;
        }
        System.out.print("姓名(" + customers[index].getName() + ")：");
        String name = CMUtility.readString(4, customers[index].getName());

        System.out.print("性别(" + customers[index].getGender() + ")：");
        char gender = CMUtility.readChar(customers[index].getGender());

        System.out.print("年龄(" + customers[index].getAge() + ")：");
        int age = CMUtility.readInt(customers[index].getAge());

        System.out.print("电话(" + customers[index].getPhone() + ")：");
        String phone = CMUtility.readString(15, customers[index].getPhone());

        System.out.print("邮箱(" + customers[index].getEmail() + ")：");
        String email = CMUtility.readString(15, customers[index].getEmail());

        System.out.println("---------修改完成-----------");
        Customer cust1 = new Customer(name, gender, age, phone, email);
        customers[index] = cust1;
        return true;
    }

    /**
    从数组中删除参数index指定索引位置的客户对象记录
     */
    public boolean deleteCustomer(int index) {
        if (customers[index] == null) {
            System.out.println("索引无效无法删除");
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[index] = customers[++index];
        }
        customers[--total] = null;
        System.out.println("---------删除完成-----------");
        return true;
    }

    /**
    返回数组中记录的所有客户对象
     */
    public void getAllCustomers() {
        System.out.println("——————————————客户列表——————————————");
        if (total == 0) {
            System.out.println("没有客户信息！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
            for (int i = 0; i<total; i++) {
                System.out.print(i+1 + "\t");
                System.out.print(customers[i].getName() + "\t");
                System.out.print(customers[i].getGender() + "\t");
                System.out.print(customers[i].getAge() + "\t");
                System.out.print(customers[i].getPhone() + "\t");
                System.out.print(customers[i].getEmail() + "\n");
            }
            System.out.println("—————————————客户列表完成—————————————");
        }
    }

    public Customer getCustomer(int index) {
        if (customers[index] == null) {
            System.out.println("索引无效，请重新输入");
            getCustomer(sc.nextInt());
        }
        return customers[index];
    }

    public int getTotal() {
        return total;
    }
}
