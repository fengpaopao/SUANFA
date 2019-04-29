import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 9:34
 * 4
 */
public class springiocdi {

    String pathxml;


    public springiocdi(String pathxml) {
        this.pathxml = pathxml;
    }

    /**
     * @Author ffc
     * @Description
     * @Date  2019/4/26
     * @Param  * @param id
     * @return 
     **/
    public Object getmethioc(String id) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {


        //用于解析xml的
        SAXReader saxReader = new SAXReader();
        //用于读取路径项目根目录路径下 读取
        Document read = saxReader.read(pathxml);
        //判断是否为空
        if (read == null) {
            return null;
        }
        //获取xml里的内容
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        if (elements.size() <= 0) {
            return null;
        }
        Object oj = null;
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            //通过id找到一个节点元素
            String beanid = element.attributeValue("id");


            if (StringUtils.isEmpty(beanid)) {
                return null;
            }
            if (!id.equals(beanid)) {
                continue;
                // throw new Exception("使用beanId:" + beanId + ",未找到该bean");
            }
            // 获取实体bean class地址
            String beanClass = element.attributeValue("class");
            //通过class生成一个类型
            Class<?> forNameClass = Class.forName(beanClass);
            //通过反射获取bean的一个无参构造函数来初始化对象；
            oj = forNameClass.newInstance();
            //获取子类下面的参数

            List<Element> elements1 = element.elements();
            if (elements1.size() <= 0) {
                return null;
            }

            for (int x = 0; x < elements1.size(); x++) {
                //获取name的值
                String name = elements1.get(x).attributeValue("name");

                //获取value字段的值
                String calue = elements1.get(x).attributeValue("value");
                //创建一个类的字段
                Field name1 = forNameClass.getDeclaredField(name);
                //因为在类里面类的属性为私有，只能被当前这个类锁访问，所有我们设置设个方法为true就可以获取他的私有属性。
                name1.setAccessible(true);
                //设置这个类的值。
                name1.set(oj, calue);

            }

        }

        return oj;
    }

    public static void main(String[] args) {
        springiocdi springiocdi = new springiocdi("D:\\SUANFA\\src\\main\\java\\Appledxml.xml");
        try {
            User user1 = (User) springiocdi.getmethioc("user1");
            System.out.println(user1.getUserId() + "  " + user1.getUserName());
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
