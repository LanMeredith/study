import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 * @author shkstart
 * @create 2021-01-30-16:06
 */
public class StudyCustomGeneric<T> {
    String name;
    int age;
    /**
     * 类的内部结构就可以使用类的泛型
     */
    T customT;

    public StudyCustomGeneric() {
    }

    public StudyCustomGeneric(String name, int age, T customT) {
        this.name = name;
        this.age = age;
        this.customT = customT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 如下的三个方法都不是泛型方法
     * @return
     */
    public T getCustomT() {
        return customT;
    }

    public void setCustomT(T customT) {
        this.customT = customT;
    }

    @Override
    public String toString() {
        return "StudyCustomGeneric{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", customT=" + customT +
                '}';
    }

//    静态方法中不能使用类的泛型
//    public static void show(T customT){
//        System.out.println(customT);
//    }
}

//    不是泛型类
class StudyCustomGenericOne extends StudyCustomGeneric<Integer>{
//    泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
//    换句话说：泛型方法所属类是不是泛型类都没有关系
//    泛型方法可以声明为静态的。原因：泛型参数是在调用方法时确定的，并非在实例化类时确定的
    public static <E> List<E> copy(E[] arr){
        ArrayList<E> es = new ArrayList<>();

        for (E e:
             arr) {
            es.add(e);
        }
        return es;
    }
}

//    仍是泛型类
class StudyCustomGenericTwo<T> extends StudyCustomGeneric<T>{
    public static <E> List<E> copy(E[] arr){
        ArrayList<E> es = new ArrayList<>();

        for (E e:
                arr) {
            es.add(e);
        }
        return es;
    }
}