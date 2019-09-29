package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author huangzhaoyu
 * @date 2019/9/29 11:17
 */
@Aspect
public class Test {


        @Pointcut("execution(* *.test(..))")
        public void test(){
        }

        @Before("test()")
        public void beforeTest(){
            System.out.println("beforeTest");
        }

        @Around("test()")
        public Object aroundTest(ProceedingJoinPoint p){
            System.out.println("around.....before");
            Object o = null;
            try{
                o = p.proceed();
            }catch(Throwable e){
                e.printStackTrace();
            }
            System.out.println("around.....after");
            return o;
        }

        @After("test()")
        public void afterTest()
        {
            System.out.println("afterTest");
        }
}
