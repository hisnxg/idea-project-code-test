package com.nxg.spring.factory02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author nxg
 * date 2022/1/20
 * @apiNote
 */
public class Factory02 {
    //Properties:集合中的工具类，用来存储信息，可以用来炒作.properties文件（k--v），可以根据k值获取对应的v

    public static Car getCarInstance(String str) throws Exception {
        //1 创建Properties集合对象
        Properties properties = new Properties();
        // 2 加载（读取—）car.properties。把该配置文件的信息统一加载到了Properties集合对象中
        properties.load(new FileInputStream("D:\\code\\IdeaProjects\\mySpring\\spring\\src\\main\\resources\\car.properties"));
        //3参数str相当于car。properties中的key值，根据key取出对应的value
        //包名.类名（类的全限定名）
        String value = properties.getProperty(str);
        //4 反射创建对象： Class.forName(包名.类名).newInstance(); 根据包名.；类名来创建该类的对象
        Car car = (Car) Class.forName(value).newInstance();
        return car;
    }

}
