package org.lilacseeking.Test;

import junit.framework.TestCase;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/20 20:16
 * @Description:
 */
public class UserTestTest extends TestCase {

    public void testRegister() {
//        for (int i = 0;i<10 ;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    new UserTest().register();
//                }
//            }).start();
//        }
//        ExecutorService exec = Executors.newFixedThreadPool(20);
//        exec.execute(new ASyncUserRegister());
        for (int i = 0;i<10000 ;i++){
            new UserTest().register();
        }

    }
}