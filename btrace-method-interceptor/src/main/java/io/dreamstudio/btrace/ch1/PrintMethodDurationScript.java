package io.dreamstudio.btrace.ch1;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 监控某一个方法的执行时间
 * @author Ricky Fung
 */
@BTrace
public class PrintMethodDurationScript {

    @OnMethod(clazz = "io.dreamstudio.demo.web.DemoController",
            method = "getAllUsers",
            location=@Location(Kind.RETURN))
    public static void printMethodRunTime(@ProbeClassName String probeClassName, @Duration long duration){

        BTraceUtils.println(probeClassName + ",duration:" + duration / 1000000 + " ms");
    }
}
