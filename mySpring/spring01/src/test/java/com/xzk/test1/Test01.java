package com.xzk.test1;

import com.xzk.pojo.Team;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Test01 {
    @Test
    public void test02(){
        String springConfig = "application.xml";
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springConfig);
        //子类对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(springConfig);
        Team team1 = (Team) applicationContext.getBean("team1");
        Team team11 = (Team) applicationContext.getBean("team1");
        System.out.println(team1);
        System.out.println(team11);
        Team team2 = (Team) applicationContext.getBean("team2");
        Team team22 = (Team) applicationContext.getBean("team2");
        System.out.println(team2);
        System.out.println(team22);

        applicationContext.close();//关闭容器

    }
    @Test
    public void test01(){
        //Team team1 = new Team();//原有写法,程序员自己创建对象
        //spring容器创建对象的格式
        String springConfig = "application.xml";
        //1.获取spring容器
        //方式一
        //BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("D:/code/mySpring/spring01/src/main/resources/application.xml"));
        //beanFactory.getBean("team1");//根据id从IOC容器获取对象
        //方式二--常用,推荐
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springConfig);
        //2.从容器中根据ID获取对象
        Team team1 = (Team) applicationContext.getBean("team1");
        //方式三
        //ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:/code/mySpring/spring01/src/main/resources/application.xml");
        //3.    容器中的其他API
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println("容器中的对象的个数:"+beanDefinitionCount);
        System.out.println("容器中所有对象的名字:");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //遍历  通过快捷输入 iter 即可快速生成
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("\t"+beanDefinitionName);
        }

        //4.    获取非自定义的对象
        Object date1 = applicationContext.getBean("date1");
        //System.out.println("获取非自定义对象date="+date1);
    }
}
