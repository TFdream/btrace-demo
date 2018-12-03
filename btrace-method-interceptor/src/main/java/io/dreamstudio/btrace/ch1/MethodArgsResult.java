package io.dreamstudio.btrace.ch1;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 获取方法的入参和返回值
 * @author Ricky Fung
 */
@BTrace
public class MethodArgsResult {

    @OnMethod(
            clazz = "io.dreamstudio.demo.service.UserService",
            method = "insertUser",
            location = @Location(Kind.RETURN)
    )
    public static void printSigniture(String name, Integer age, @Return Long result) {
        BTraceUtils.println("name: " + name);
        BTraceUtils.println("age: " + age);
        BTraceUtils.println(result);
    }

    //------------------------
    //可以对字符串进行正则匹配以达到监控特定问题的目的
    @OnMethod(
            clazz = "io.dreamstudio.demo.service.UserService",
            method = "insertUser",
            location = @Location(Kind.RETURN)
    )
    public static void printWithFilter(String name, Integer age, @Return Long result) {

        if(BTraceUtils.matches("ricky*", name)) {
            BTraceUtils.println("name: " + name);
            BTraceUtils.println("age: " + age);
            BTraceUtils.println(result);
        }
    }
}
