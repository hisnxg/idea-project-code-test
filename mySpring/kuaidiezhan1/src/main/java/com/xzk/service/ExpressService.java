package com.xzk.service;

import com.xzk.dao.ExpressDao;
import com.xzk.pojo.Express;
import com.xzk.dao.BaseExpressDao;
import com.xzk.dao.imp.ExpressDaoMysql;
import com.xzk.exception.DuplicateCodeException;
import com.xzk.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExpressService{

    @Autowired
    private static ExpressDao dao;
//    private static BaseExpressDao dao = new ExpressDaoMysql();
    /**
     * 用于查询数据库中的全部快递(总数+新增),待取件快递(总数+新增)
     *
     * @return [{size:总数,day:新增},{size:总数,day:新增}]
     */

    public static List<Map<String, Integer>> console() {
        return dao.console();
    }

    /**
     * 用于查询所有快递
     *
     * @param limit      是否分页的标记,true表示分页. false表示所有快递
     * @param offset     SQL语句的起始索引
     * @param pageNumber 页查询的数量
     * @return 快递的集合
     */

    public static List<Express> findAll(boolean limit, int offset, int pageNumber) {
        return dao.findAll(limit, offset, pageNumber);
    }

    /**
     * 根据快递单号,查询快递信息
     *
     * @param number 单号
     * @return 查询的快递信息, 单号不存在是返回null
     */

    public static Express findByNumber(String number) {
        return dao.findByNumber(number);
    }

    /**
     * 根据快递取件码,查询快递所有信息
     *
     * @param code 取件码
     * @return 查询的快递信息 ,取件码不存在时返回null
     */
    public static Express findBycode(String code) {
        return dao.findBycode(code);
    }

    /**
     * 根据用户手机号码,查询所有的快递信息
     *
     * @param userPhone 手机号码
     * @return 查询的快递信息列表
     */
    public static List<Express> findByUserPhone(String userPhone) {
        return dao.findByUserPhone(userPhone);
    }
    /**
     * 根据用户手机号码,查询所有的快递信息
     *
     * @param userPhone 手机号码
     *@param status 状态码
     * @return 查询的快递信息列表
     */
    public static List<Express> findByUserPhoneAndStatus(String userPhone,int status) {
        return dao.findByUserPhoneAndStatus(userPhone,status);
    }
    /**
     * 根据录入人的手机号码.查询录入的所有记录
     *
     * @param sysPhone 手机号码
     * @return 查询的快递信息列表
     */

    public static List<Express> findBySysPhone(String sysPhone) {
        return dao.findBySysPhone(sysPhone);
    }

    /**
     * 快递的录入
     * INSERT INTO EXPRESS (NUMBER,USERNAME,USERPHONE,COMPANY,CODE,INTIME,STATUS,SYSPHONE) VALUES(?,?,?,?,?,NOW(),0,?)
     *
     * @param e 要录入的跨地对象
     * @return 录入的结果, true表示成功, false表示失败
     */
    public static boolean insert(Express e) {
        //1.    生成了取件码
        e.setCode(RandomUtil.getCode()+"");
        boolean flag = false;
        try {
             flag = dao.insert(e);
//            if (flag){
                  //录入成功,发送短信
//                SMSUtil.send(e.getUserPhone(),e.getCode());
//            }
            return flag;
//            return dao.insert(e);
        } catch (DuplicateCodeException duplicateCodeException) {
            return insert(e); //通过递归的方式,避免取件码重复问题
        }
    }

    /**
     * 快递的修改
     * UPDATE EXPRESS SET NUMBER=?,USERNAME=?,COMPANY=?,STATUS=? WHERE ID=?
     *
     * @param id         要修改的快递id
     * @param newExpress 新的快递对象(number,company,username,userPhone)
     * @return
     *
     * 逻辑 bug
     */
    public static boolean update(int id, Express newExpress) {
        if (newExpress.getUserPhone()!=null){
            dao.delete(id);
           return insert(newExpress);
        }else{
            boolean update = dao.update(id, newExpress);
            Express e = dao.findByNumber(newExpress.getNumber());
            if (newExpress.getStatus() == 1){
                updateStatus(e.getCode());
            }
            return update;
        }
    }

    /**
     * 更改快递的状态为1,表示取件完成
     *
     * @param code 要修改的快递取件码
     * @return 修改的结果, true表示成功, false表示失败
     */

    public static boolean updateStatus(String code) {
        return dao.updateStatus(code);
    }

    /**
     * 根据id，删除单个快递信息
     *
     * @param id 要删除的快递id
     * @return 删除的结果，true表示成功，false表示失败
     */

    public static boolean delete(int id) {
        return dao.delete(id);
    }
}
