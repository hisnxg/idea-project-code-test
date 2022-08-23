package com.nxg.spring.factory;

import com.nxg.spring.pojo.User;

/**
 * @author nxg
 * date 2022/1/9
 * @apiNote
 */
public class UserFactory {

    //1静态方法
    public  static User getUserStaticInstance(){
        System.out.println("");
        return new User(1001,"meijueshitai","1aasa");
    }

    public User getUserInstance(){
        System.out.println("");
        return new User(1002,"xiaozhao","12454");
    }

}
