package com.aking.design.p14iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Demo01
 * @Description
 * @Author yk
 * @Date 2020/9/5 11:49
 * @Version 1.0
 **/
public class Demo01 {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name","Python大星");
        map.put("age","18");
        Set<Map.Entry<Object, Object>> set = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
