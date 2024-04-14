/**
 * @author shkstart
 * @date: 2022.09.11
 */
public class AnimalTest {
    public static void main(String[] args) {
        /*
        有了对象的多态性后，我们在编译过程中只能调用父类中声明的方法，即Animal类声明的方法
        form()是Cat子类中独有的方法，当我们调用时会出现报错：animalCat.form();
        在运行时，eat()和sleep()实际调用的都是Cat子类重写的方法
        */
        Animal animalCat = new Cat();
        animalCat.eat();
        animalCat.sleep();
//        此处输出的是动物，因为对象的多态性只适用于方法，不适用于属性
        System.out.println(animalCat.NAME);
        System.out.println();

        Dog dog = new Dog();
//        进行向上转型
        Animal animalDog = dog;
//        向上转型之后调用eat()和sleep()方法，实际调用的仍然是Dog子类重写的方法
        animalDog.eat();
        animalDog.sleep();
        System.out.println(animalDog.NAME);
        System.out.println();

//        如果animalCat对象是Cat类的实例，则进行向下转型
        if (animalCat instanceof Cat) {
            Cat cat = (Cat) animalCat;
            System.out.println("animalCat对象完成向下转型，强制转换为Cat类的实例");
//            向下转型之后就可以调用Cat子类的方法了
            cat.form();
        } else if (animalCat instanceof Dog) {
            Dog animalCatDog = (Dog) animalCat;
            System.out.println("animalCat对象完成向下转型，强制转换为Dog类的实例");
            dog.eat();
        }

//        在这里animalCat对象一定会是Object类的实例，就像Cat子类会是Animal的实例一样
        if (animalCat instanceof Object) {
            System.out.println("***Object***");
        }
    }
}
