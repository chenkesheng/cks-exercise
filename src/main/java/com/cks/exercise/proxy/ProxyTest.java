package com.cks.exercise.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: cks
 * @Date: Created by 下午2:09 2021/1/28
 * @Package: com.cks.exercise.proxy
 * @Description:
 */
public class ProxyTest {
    public static void main(String[] arg) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MySqlServiceReal.class);
        MySqlServiceReal target = new MySqlServiceReal();
        enhancer.setCallback(new MySqlServiceReal.MethodInterceptorImpl(target));
        MySqlServiceReal demo = (MySqlServiceReal) enhancer.create();
//        System.out.println(demo);
        System.out.println(target);
        demo.getName();

    }

    public static class MySqlServiceReal {

        public String getName() {
            System.out.println("execute something sql");
            saveName();
            return "sql result";
        }

        public void saveName() {
            System.out.println("save my name");
        }

        private static class MethodInterceptorImpl implements MethodInterceptor {

            private final MySqlServiceReal target;

//             把被代理的对象传入进来，模拟Spring获取target的场景
            public MethodInterceptorImpl(MySqlServiceReal real) {
                target = real;
            }

            @Override
            public Object intercept(Object object,
                                    Method method,
                                    Object[] args,
                                    MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
            Object res = methodProxy.invokeSuper(object, args);
                // 调用target的方法
//                Object res = methodProxy.invoke(target, args);
                System.out.println("After");
                return res;
            }
        }
    }
}
