package com.yangyan.xxp.aidlstudy

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName
    private var mIBinder: IMyAidlInterface? = null
    private val mServiceConnection by lazy {
        object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {
                Log.i(TAG, "连接失败")

            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.i(TAG, "连接成功")
                mIBinder = IMyAidlInterface.Stub.asInterface(service)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent()
        intent.setComponent(ComponentName(this, "com.yangyan.xxp.aidlstudy.TestService"))
        bindService(intent, mServiceConnection, Service.BIND_AUTO_CREATE)
        mBtnAddUser.setOnClickListener {
            mIBinder?.let {
                val user = User("哈哈哈哈")
                it.addUser(user)
                mTvShow.append("\n" +user.toString() )
                        //it.users.get(it.users.lastIndex).toString())
            }
        }

    }


}
