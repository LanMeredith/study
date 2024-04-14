/**
 * 注解的使用：
 * 1.理解Annotation：
 * 1.1这是JDK5.0新增的内容
 * 1.2Annotation其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理
 * 通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。
 * 1.3在javaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。
 * 在javaEE/Android中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替javaEE旧版中所遗留的繁冗代码和XML配置等。
 *
 * 2.Annotation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查（JDK内置的三个基本注解）
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解：
 * 参照@SuppressWarinings定义
 * 3.1注解声明为@interface
 * 3.2内部定义成员，通常使用value表示
 * 3.3可以指定成员的默认值，使用default定义
 * 3.4如果自定义注解没有成员，表明是一个标识作用
 *
 * 注意：自定义的注解必须配上注解的信息处理流程（使用反射）才有意义
 * 如果注解有成员，在使用注解时，需要指明成员的值
 * 自定义注解通常都会指明两个元注解：Retention、Target
 *
 * 4.JDK提供的四种元注解
 * JDK的元注解（元Annotation）用于修饰其他Annotation定义
 * Retention：指定所修饰的Annotation的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
 * 只有声明为RUNTIME生命周期的注解才能通过反射获取
 * Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
 * Documented：表示所修饰的注解将在被javadoc解析时保留下来。默认情况下javadoc是不包括注解的
 * 定义为Documented的注解必须设置Retention值为RUNTIME
 * Inherited：被此修饰的Annotation将具有继承性
 *
 * 5.通过反射获取注解信息——到反射内容时系统讲解
 *
 * 6.JDK8中注解的新特性：可重复注解、类型注解
 * 6.1可重复注解：一：在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 * 二：MyAnnotation的Retention、Target等元注解和MyAnnotations相同。
 * 6.2类型注解：
 * ElementType.TYPE_PARAMETER表示该注解能写在类型变量的声明语句中（如：泛型声明）
 * ElementType.TYPE_USE表示该注解能写在使用类型的任何语句中
 *
 * @author shkstart
 * @create 2021-01-19-10:28
 */
public @interface MyAnnotation {
    String value() default "Hello";
}
