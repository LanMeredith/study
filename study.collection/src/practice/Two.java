package practice;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author shkstart
 * @create 2021-01-21-14:53
 */
public class Two {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person p1 = new Person("AA", 1001);
        Person p2 = new Person("BB", 1002);

        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);

//        因为p1在修改之前哈希值对应的位置为x，修改之后哈希值不变，p1仍在位置x
//        而执行删除操作，首先算出修改之后的哈希值对应的位置y，在位置y上没有发现相应的元素，故此删除失败
        p1.name = "CC";
        hashSet.remove(p1);
        System.out.println(hashSet);

//        因为p1修改后，仍然在x位置，而新添的元素经过计算后发现其哈希值对应的位置y上并没有相应的元素，故添加成功
        hashSet.add(new Person("CC",1001));
        System.out.println(hashSet);

//        新添的元素经过计算后发现其哈希值对应的位置x上已有元素p1，则进行比较哈希值，发现哈希值也相同，遂进行equals()比较，成功添加
        hashSet.add(new Person("AA",1001));
        System.out.println(hashSet);
    }
}

class Person{
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
