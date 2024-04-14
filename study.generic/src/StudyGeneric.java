import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

/**
 * 1.泛型的使用：
 * JDK5新增的特性
 * <p>
 * 2.在集合中使用泛型：
 * 总结：
 * 2.1：集合接口或集合类在JDk5时都修改为带泛型的结构
 * 2.2：在实例化集合类时，可以指明具体的泛型类型
 * 2.3：指明完以后，在集合类或接口中凡是定义类或接口时
 * 内部结构（比如方法、构造器、属性）使用到类的泛型的位置，都指定为实例化的泛型类型
 * 比如：add(E e)==>实例化以后：add(integer e)
 * 2.4：注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换。
 * 2.5：如果实例化时，没有指定泛型的类型。默认类型为java.lang.Object类型
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法
 * 见StudyCustomGeneric
 *
 * 注意：
 * 1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
 * 2. 泛型类的构造器如下：public GenericClass(){}
 * 而下面是错误的：public GenericClass<E>(){}
 * 3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
 * 4. 泛型不同的引用不能相互赋值。
 *      尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中。
 * 5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。经验：泛型要使用一路都用。要不用，一路都不要用。
 * 6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象
 * 7. jdk1.7，泛型的简化操作：ArrayList<Fruit> flist = new ArrayList<>();
 * 8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
 * 9. 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。但在静态方法中不能使用类的泛型。
 * 10. 异常类不能是泛型的
 * 11. 不能使用new E[]。但是可以：E[] elements = (E[])new Object[capacity];
 * 参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组。
 * 12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
 *  子类不保留父类的泛型：按需实现
 *  没有类型 擦除
 *  具体类型
 *  子类保留父类的泛型：泛型子类
 *  全部保留
 *  部分保留
 * @author shkstart
 * @create 2021-01-30-14:30
 */
public class StudyGeneric {
    public static void main(String[] args) {
//        JDK7新特性：类型推断
        TreeSet<Student> students = new TreeSet<>();
//        标准写法
//        TreeSet<Student> students = new TreeSet<Student>();
        students.add(new Student("颜铭鹤", 90, 193056277));
        students.add(new Student("袁经睿", 92, 193056567));
        students.add(new Student("杨帆", 98, 193012345));
        students.add(new Student("Tom", 98, 193012341));
        students.add(new Student("Tom", 88, 193232341));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 测试自定义泛型类
     */
    @Test
    public void test1(){
        StudyCustomGeneric<Integer> generic = new StudyCustomGeneric<>();
        generic.setCustomT(1234);

        StudyCustomGenericOne genericOne = new StudyCustomGenericOne();
        genericOne.setCustomT(1234);
        Integer[] arr = new Integer[]{123,345,123,23214,1232412,123123};
//        泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换。
//        int[] arr = new int[]{123,345,123,23214,1232412,123123};
        List<Integer> copy = StudyCustomGenericOne.copy(arr);
        for (int i:
             copy) {
            System.out.println(i);
        }

        StudyCustomGenericTwo<String> genericTwo = new StudyCustomGenericTwo<>();
        genericTwo.setCustomT("Tom");

        /*
        泛型在继承方面的体现：
        虽然类A是类B的父类，但是G<A>和G<B>，二者不具备子父类关系，二者是并列关系。
        补充：类A是类B的父类，A<G>是B<G>的父类

        反证法：
        假设：genericTwo1 = genericTwo;
        则genericTwo1.add(123);会导致混入非String的数据。出错。
         */
        StudyCustomGenericTwo<Object> genericTwo1 = new StudyCustomGenericTwo<>();
//        此时的genericTwo和genericTwo1不具有父子关系
//        genericTwo1 = genericTwo;
    }
}

class Student implements Comparable<Student> {
    //    姓名
    String name;
    //    成绩
    double score;
    //    学号
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student() {
    }

    public Student(String name, double score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Double.compare(student.score, score) == 0 && id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, id);
    }

    @Override
    public int compareTo(Student o) {
        if (Double.compare(this.score, o.score) == 0) {
            return this.name.compareTo(o.name);
        } else {
            return -Double.compare(this.score, o.score);
        }
    }

//    没有添加泛型的写法
    //    按照成绩排名，如果成绩相同则按照姓名排
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Student){
//            Student stu = (Student) o;
//            if(Double.compare(this.score, stu.score) == 0){
//                return this.name.compareTo(stu.name);
//            }else{
//                return -Double.compare(this.score, stu.score);
//            }
//        }
//        throw new RuntimeException("传入的数据类型不一致！");
//    }
}