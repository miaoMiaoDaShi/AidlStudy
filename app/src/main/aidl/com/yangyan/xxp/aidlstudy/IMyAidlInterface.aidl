// IMyAidlInterface.aidl
package com.yangyan.xxp.aidlstudy;

// Declare any non-default types here with import statements
import com.yangyan.xxp.aidlstudy.User;

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    User addUser(out User user);

    List<User> getUsers();
}
