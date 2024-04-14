package dynamic_agent;

/**
 * 被代理类
 * @author shkstart
 * @create 2021-08-07-13:15
 */
public class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I belief I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢" + food);
    }
}
