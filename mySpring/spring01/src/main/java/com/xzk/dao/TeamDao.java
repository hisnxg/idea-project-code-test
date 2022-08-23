package com.xzk.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Component 注解标识在类上,表示对象由spring容器创建
 * value属性表示创建的id值
 * 这value值可以省略,值也可以省略,默认就是类名首字母小写
 * @Repository和@Component作用相同,而@Repository常用于dao层
 *
 * @Component有三个子注解@Repository/@Service/@Controller
 */
@Repository("teamDao1")
//@Component(value = "teamDao")
//这注解跟这效果系统<bean id="teamDao" class="com.xzk.dao.TeamDao"></bean>
public class TeamDao {

    public void add(){
        System.out.println("TeamDao---add----");
    }
    public TeamDao(){
        System.out.println("TeamDao---默认的构造方法");
    }
}
