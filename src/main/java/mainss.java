import java.lang.reflect.Field;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 11:18
 * 4
 */
public class mainss {

    /**
     * @Author chengpunan
     * @Description //TODO
     * @Date  2019/4/26
     * @Param  * @param args
     * @return 
     **/
    public static void main(String[] args) throws ClassNotFoundException {
        //反射class
        Class<?> user = Class.forName("User");
        //通过反射的getAnnotation传入注解类的class就可以获取到注解类的实列
        SetTable annotation = user.getAnnotation(SetTable.class);

        //获取这个类上面注解中所输入的数据
        String tablename = annotation.value();
        //获取类里面的所有属性
        Field[] declaredFields = user.getDeclaredFields();

        StringBuffer sb = new StringBuffer();

        sb.append("select");

       for (int i = 0; i < declaredFields.length; i++) {

           //获取某一个字段
            Field field = declaredFields[i];

            //获取这个字段上注解的值
             SetProperty annotation1 = field.getAnnotation(SetProperty.class);

             //并把它添加到字符串里面
            sb.append(" " + annotation1.name() + " ");

            if (i == declaredFields.length - 1) {
                sb.append("form  ");
            } else {
                sb.append(",");
            }

        }
        sb.append(tablename);
        System.out.println(sb.toString());


    }
}
