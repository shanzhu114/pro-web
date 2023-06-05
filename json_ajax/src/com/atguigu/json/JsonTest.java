package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import org.junit.Test;

public class JsonTest {

    @Test
    public void test01(){
        Person person = new Person(1,"英明神武的熊");

        Gson gson = new Gson();
        // toJson方法可以把java对象转换成为json字符串形式
        String personToJsonStr = gson.toJson(person);
        System.out.println(personToJsonStr);

        // fromJson 把json字符串转换回java对象
        // 第一个参数：json字符串
        // 第二个参数：转换回去的java对象类型
        Person jsonStringToPerson = gson.fromJson(personToJsonStr, Person.class);
        System.out.println(jsonStringToPerson);
    }

}
