package practice;


import util.Universal;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 从控制台向数据库的表customers中插入一条数据
 * @author shkstart
 * @date: 2022.10.01
 */
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = scanner.next();
        System.out.println("请输入email");
        String email = scanner.next();
        System.out.println("请输入生日");
        String birth = scanner.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = simpleDateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String sql = "insert into customers (name,email,birth) values (?,?,?)";
//        调用由我自行编写的增删改方法
        int value = Universal.update(sql, name, email, new Date(date.getTime()));
        if (value > 0) {
            System.out.println("操作成功");
        } else {
            System.out.println("操作失败");
        }
    }
}
