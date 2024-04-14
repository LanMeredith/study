import java.util.Arrays;

/**
 * Comparable接口的使用举例        自然排序
 * 1.像String、包装类等实现了Comparable接口，重写了CompareTo(obj)方法，给出了比较两个对象大小的方式
 * 2.像String、包装类等重写了CompareTo()方法以后，进行了从小到大的排列
 * 3.重写CompareTo(obj)的规则：
 * 如果当前对象this大于形参对象obj，则返回正整数
 * 如果当前对象this小于形参对象obj，则返回负整数
 * 如果当前对象this等于形参对象obj，则返回零
 * 4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写CompareTo(obj)方法
 * 在CompareTo()方法中指明如何排序
 *
 * @author shkstart
 * @create 2021-01-17-12:02
 */
public class StudyComparable implements Comparable {
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private int prices;

    /**
     * 因为Test测试只能写一个无参的构造器，所以这里只能使用main验证
     */
    public static void main(String[] args) {
        StudyComparable[] arr = new StudyComparable[5];
        arr[0] = new StudyComparable("华为手机", 4999);
        arr[1] = new StudyComparable("小米手机", 2999);
        arr[2] = new StudyComparable("vivo手机", 3999);
        arr[3] = new StudyComparable("锤子手机", 1999);
        arr[4] = new StudyComparable("小米手机", 1999);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public StudyComparable() {
    }

    public StudyComparable(String name, int prices) {
        this.name = name;
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "StudyComparable{" +
                "name='" + name + '\'' +
                ", prices=" + prices +
                '}';
    }

    /**
     * 指明按照特定的方式进行排序，这里是按照价格从低到高排序，如果价格相等则按照名称从低到高排序
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof StudyComparable) {
            StudyComparable studyComparable = (StudyComparable) o;
//            方式一
            return this.prices > studyComparable.prices ? 1 :
                    (this.prices < studyComparable.prices ? -1 :
                            (this.name.compareTo(studyComparable.name)));
//            方式二
//            if(Integer.compare(this.prices,studyComparable.prices) == 0){
//                return this.name.compareTo(studyComparable.name);
//            }else{
//                return Integer.compare(this.prices,studyComparable.prices);
//            }
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
