import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map的实现类ThreeMap
 * ThreeMap：保证按照添加的key-value对进行排序，实现排序遍历。
 * 此时考虑key的自然排序或定制排序
 * @author shkstart
 * @create 2021-01-24-14:16
 */
public class StudyThreeMap {
    /**
     * 向ThreeMap中添加key-value，要求key必须是由同一个类创建的对象，因为要按照key进行排序
     * test1是自然排序
     * */
    @Test
    public void test1(){
        TreeMap treeMap = new TreeMap();
//        使用StudySet中的Affiliated类进行测试
        treeMap.put(new Affiliated("Tom",18),90);
        treeMap.put(new Affiliated("Jack",20),98);
        treeMap.put(new Affiliated("Yan",17),100);
        treeMap.put(new Affiliated("Liu",19),87);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

//    test2是定制排序
    @Test
    public void test2(){
        Comparator com = new Comparator(){
//            按照年龄从小到大排序，如果年龄相同则按照姓名从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Affiliated && o2 instanceof Affiliated){
                    Affiliated treeSet1 = (Affiliated) o1;
                    Affiliated treeSet2 = (Affiliated) o2;
                    if(treeSet1.getAge() == treeSet2.getAge()){
                        return treeSet1.getName().compareTo(treeSet2.getName());
                    }else{
                        return Integer.compare(treeSet1.getAge(),treeSet2.getAge());
                    }
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        };
        TreeMap treeMap = new TreeMap(com);
//        使用StudySet中的Affiliated类进行测试
        treeMap.put(new Affiliated("Tom",18),90);
        treeMap.put(new Affiliated("Jack",20),98);
        treeMap.put(new Affiliated("Yan",17),100);
        treeMap.put(new Affiliated("Liu",19),87);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
