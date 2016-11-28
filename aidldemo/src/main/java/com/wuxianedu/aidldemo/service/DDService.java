package com.wuxianedu.aidldemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.wuxianedu.aidldemo.IRemote;

public class DDService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("--Main--", "DDService onCreate-------Thread:" +
                Thread.currentThread().getName());
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("--Main--", "DDService onBind");
        return mBinder;
    }

    private final IRemote.Stub mBinder = new IRemote.Stub() {
        @Override
        public int getPid() throws RemoteException {
            Log.e("--Main--", "DDService getPid.....Thread:" +
                    Thread.currentThread().getName());
            return android.os.Process.myPid();
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString)
                throws RemoteException {
            Log.e("--Main--", "basicTypes aDouble.....Thread:" +
                    Thread.currentThread().getName());
        }
    };

}
