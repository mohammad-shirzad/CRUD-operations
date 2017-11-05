package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
    private static ApplicationContext IocContainer=new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
    private SpringUtil(){

    }
    public static Object getBean(String beanId){
        return IocContainer.getBean(beanId);
    }
}
