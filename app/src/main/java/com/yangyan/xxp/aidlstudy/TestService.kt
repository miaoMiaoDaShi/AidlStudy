package com.yangyan.xxp.aidlstudy

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/6/1
 * Description :
 */
class TestService:Service() {
    private val mUsers = mutableListOf<User>()
    override fun onBind(intent: Intent?): IBinder = mMyBinder

    private val mMyBinder by lazy {
         object:IMyAidlInterface.Stub(){
             override fun addUser(user: User):User {
              return   user.apply {
                  Log.e("start",user.toString())
                     name = "啪啪啪"
                     mUsers.add(this)
                  Log.e("end",user.toString())
                 }
             }

             override fun getUsers(): MutableList<User> {
                 return  mUsers
             }

         }
    }
}