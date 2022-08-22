package com.nxg.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Teacher {
    private Object[] objects;
    private List list;
    private Set set;
    private Map map;
    private Properties properties;

    public Teacher() {
    }

    public Teacher(Object[] objects, List list, Set set, Map map, Properties properties) {
        this.objects = objects;
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
