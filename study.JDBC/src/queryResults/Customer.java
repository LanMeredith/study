package queryResults;

import java.util.Date;

/**
 * 在CustomerForQuery类中进行的查询操作
 * 返回的结果集由这个类进行接收
 *
 * ROM编程思想（object relational mapping)
 * 一个数据表对应一个java类
 * 表中的一条记录对应java类的一个对象
 * 表中的一个字段对应java类的一个属性
 *
 * 为什么要有set()get()？
 * 因为后续在Dbutils中调用BeanHandler创建结果集处理器后
 * 因为缺失set()get()导致返回的对象全是null
 * @author shkstart
 * @date: 2022.09.29
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private Date birth;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirth() {
        return birth;
    }

    public Customer() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Results{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
