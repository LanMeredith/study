import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 关于变量的赋值
 * 如果变量是基本数据类型，此时赋值的是变量所保存的数据
 * 如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值
 *
 * @author shkstart
 * @create 2022-08-30-16:44
 */
public class ArraysCopy {
    public static void main(String[] args) {
//        创建一个数组
        int[] str = {32, 12, 23, 34, 54, 65, 21};
        System.out.println("数组内容：" + Arrays.toString(str));

//        创建一个新数组，令新数组长度等于str数组
        int[] copyStr = new int[str.length];
        /*
         * 进行数组复制
         * System.arraycopy(src,int srcPos,dest,int destPos,int length);
         * 第一个参数是   被复制的数组名称
         * 第二个参数是   被复制数组的起始位置
         * 第三个参数是   要复制数组的名称
         * 第四个参数是   要复制数组的起始位置
         * 第五个参数是   复制长度
         */
        System.arraycopy(str, 0, copyStr, 0, str.length);
//        验证
        System.out.println("这是原数组：" + Arrays.toString(str) + "以及原数组的地址" + str.toString());
        System.out.println("这是新数组：" + Arrays.toString(copyStr) + "以及新数组的地址" + copyStr.toString());

//        这时候对原数组进行修改，可见新数组没有发生改变
        str[3] = 1234;
        System.out.println("更改后的原数组：" + Arrays.toString(str));
        System.out.println("未发生变化的原数组：" + Arrays.toString(copyStr));

//        创建一个新的数组，并令其等于str
        int[] sameStr = str;
        str[2] = 789;
        System.out.println("这是sameStr数组，可见在str数组进行更改后，它也跟着发生了变化" + Arrays.toString(sameStr));
//        可见str与sameStr指向了同一堆空间，实际上就是str将自己的地址赋值给了sameStr。
//        sameStr不能算是新创建了一个对象，只能说这是一个新声明的变量
        System.out.println("他们的地址也是相同的，str地址：" + str.toString() + " sameStr地址：" + sameStr.toString());
    }
}
