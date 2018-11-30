package io.dreamstudio.btrace.ch1;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * @author Ricky Fung
 */
@BTrace // 注明这是一个BTrace脚本
public class PrintArgsScript {

    // 指定需要拦截的方法
    @OnMethod(
            // 类的路径
            clazz = "org.zero01.monitor_tuning.controller.BTraceController",
            // 方法名
            method = "arg1",
            // 在什么时候进行拦截
            location = @Location(Kind.ENTRY)
    )

    public static void printArgs(@ProbeClassName String pcn, // 被拦截的类名
                               @ProbeMethodName String pmn, // 被拦截的方法名
                               AnyType[] args // 被拦截的方法的参数值
    ) {
        // 打印数组
        BTraceUtils.printArray(args);
        // 打印行
        BTraceUtils.println("className: " + pcn +", methodName: " + pmn);
        BTraceUtils.println();
    }
}
