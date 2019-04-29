import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 11:13
 * 4
 */
@Target(value = { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {

    /**
    * @Author ffc
    * @Description  对应数据库的表名
    * @Date  2019/4/26
    * @Param  * @param 
    * @return
    **/
    String value();
}
