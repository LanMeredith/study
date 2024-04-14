package self_study;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Retention：指定所修饰的Annotation的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
 * 只有声明为RUNTIME生命周期的注解才能通过反射获取
 * @author shkstart
 * @create 2021-07-29-22:20
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "Hello";
}
