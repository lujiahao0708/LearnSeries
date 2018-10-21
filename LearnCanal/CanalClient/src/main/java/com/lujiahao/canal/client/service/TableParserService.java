package com.lujiahao.canal.client.service;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lujiahao.canal.client.domain.bo.TestTableParserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 数据库表转换service
 *
 * @author lujiahao
 * @date 2018/10/21
 */
@Service
public class TableParserService {
    protected final static Logger LOGGER = LoggerFactory.getLogger(TableParserService.class);


    public TestTableParserBO analysisColumn(List<CanalEntry.Column> columns) {
        TestTableParserBO testTableParserBO = new TestTableParserBO();
        try {
            for (CanalEntry.Column column : columns) {
                reflectObject(column, testTableParserBO);
            }
        } catch (Exception e) {

        }
        return testTableParserBO;
    }

    /**
     * 反射对象
     *
     * @return 是否有数据为null
     * @throws Exception
     */
    public boolean reflectObject(CanalEntry.Column column , Object obj) throws Exception {
        boolean len = true;

        // 获取实体类的所有属性，返回Field数组
        Field[] field = obj.getClass().getDeclaredFields();
        // 遍历所有属性
        for (int j = 0; j < field.length; j++) {
            // 获取属性的名字
            String name = field[j].getName();
            String columnName = column.getName();
            if (columnName.equals(name) && column.getValue() != null) {
                // 将属性的首字符大写，方便构造get，set方法
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                //name = name.substring(0, name.length() -1);
                // 获取属性的类型
                //String type = field[j].getGenericType().toString();
                // 如果type是类类型，则前面包含"class "，后面跟类名
//                System.out.println("属性为：" + name);
                Method m = obj.getClass().getMethod("set" + name, String.class);
                // 调用getter方法获取属性值
                m.invoke(obj, column.getValue());
                break;
            }
            continue;
        }
        return len;
    }

    /**
     * 反射 list
     *
     * @param list
     * @return 第几行数据
     * @throws Exception
     */
    public static Integer reflectList(List list) {
        int count = 1;
        try {
            for (int i = 0; i <= list.size(); i++) {
                Class clazz = list.get(i).getClass();
                // 获取实体类的所有属性，返回Field数组
                Field[] field = clazz.getClass().getDeclaredFields();
                // 遍历所有属性
                for (int j = 0; j < field.length; j++) {
                    // 获取属性的名字
                    String name = field[j].getName();
                    // 将属性的首字符大写，方便构造get，set方法
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    // 获取属性的类型
                    String type = field[j].getGenericType().toString();
                    // 如果type是类类型，则前面包含"class "，后面跟类名
                    System.out.println("属性为：" + name);
                    Method m = clazz.getClass().getMethod("get" + name);
                    // 调用getter方法获取属性值
                    String value = (String) m.invoke(clazz);
                    if (value != null) {
                        /*System.out.println("属性值为：" + value);*/
                    } else {
                        /* System.out.println("属性值为：空");*/
                        return count;

                    }


                }
                count++;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
