package org.lilacseeking.Test.ASync;

import org.lilacseeking.Test.UserTest;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/20 22:53
 * @Description:
 */
public class ASyncUserRegister implements Runnable {

    @Override
    public void run() {
        new UserTest().register();
    }
}
