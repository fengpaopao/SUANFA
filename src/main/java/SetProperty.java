import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 11:14
 * 4
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetProperty {
    /**
     *
     * @methodDesc: 功能描述:(字段名称)
     * @author: ffc
     * @param: @return
     * @createTime:
     * @returnType:@return String
     *
     */
    String name();
    /**
     *
     * @methodDesc: 功能描述:(长度)
     * @author: ffc
     * @param: @return
     * @createTime:
     * @returnType:@return int
     *
     */
    int leng();

}
