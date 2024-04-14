/**
 * Object类中equals方法用于检测一个对象是否等于另一个对象。
 * Object类中实现的equals方法将确定两个对象引用是否相等
 *
 * 本次将要重写equals方法
 * 重写后的equals不再是比较两个引用地址值是否相同
 * 而是比较两个对象的“实体内容”是否相同
 * @author shkstart
 * @create 2022-09-05-7:46
 */
public class RewriteEquals {
    private int rewrite;
    private String name;

    /**
     * 比较两个对象的实体内容是否相同
     * 在此类中进行重写
     *
     * @Override 这个注解的作用就在于告诉编译器一下是重写父类的方法
     * 如果不写这个注解直接去重写方法的话，编译器无法判断是否正确重写了父类的方法。
     * 如重写方法时参数与父类不同，程序是不会报错的，而是会留下一个bug。
     * 写上这个注解之后，程序会自动判断是否正确重写。
     * @param object 传入参数必须得是个对象，所以这里必须设置为Object。
     *               不能设置为RewriteEquals是因为不确定进行对比的对象是这个类的。
     * @return
     */
    @Override
    public boolean equals(Object object) {
//        调用方法的对象和引用形参的对象如果地址相同，则直接返回true
        if (this == object) {
            return true;
        }

        /*
        * instanceof关键字的作用是判断左边对象是否是右边类的实例
        * 如果是，则向下转型
        * 判断调用方法对象的参数rewrite和name是否与形参的参数rewrite和name相同
        * 相同说明是实体内容相同
        * 若左边对象不是右边类的实例，则不用比较，直接返回false即可
        * */
        if (object instanceof RewriteEquals) {
            RewriteEquals re = (RewriteEquals) object;
            return this.rewrite == re.rewrite && this.name.equals(re.name);
        } else {
            return false;
        }
    }

    public RewriteEquals(int rewrite, String name) {
        super();
        this.rewrite = rewrite;
        this.name = name;
    }

    public int getRewrite() {
        return rewrite;
    }

    public String getName() {
        return name;
    }

    public void setRewrite(int rewrite) {
        this.rewrite = rewrite;
    }

    public void setName(String name) {
        this.name = name;
    }
}
