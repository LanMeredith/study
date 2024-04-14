/**
 * 在RewriteEquals中重写的equals方法将不再比较两对象的地址值是否相同，而是比较他们的“实体内容”
 * 所以rewriteEqualsOne和rewriteEqualsThree的地址虽然不同，但“实体内容”相同，也能返回true
 *
 * @author shkstart
 * @create 2022-09-06-7:18
 */
public class RewriteEqualsTest {
    public static void main(String[] args) {
        RewriteEquals rewriteEqualsOne = new RewriteEquals(1, "first");
        RewriteEquals rewriteEqualsTwo = new RewriteEquals(2, "second");
        RewriteEquals rewriteEqualsThree = new RewriteEquals(1, "first");

        System.out.println(rewriteEqualsOne.hashCode());
        System.out.println(rewriteEqualsTwo.hashCode());
        System.out.println(rewriteEqualsThree.hashCode());
        System.out.println();

        System.out.println(rewriteEqualsOne.equals(rewriteEqualsTwo));
        System.out.println(rewriteEqualsOne.equals(rewriteEqualsThree));
    }
}
