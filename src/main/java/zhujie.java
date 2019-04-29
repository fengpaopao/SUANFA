import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 10:36
 * 4
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface zhu{

    int beanId() default 0;
    String className() default "";
    String[]arrays();

}

public class zhujie {

    @zhu(beanId=0,className = "classname",arrays = {"q","2"})
    public void add(){

    }
}
