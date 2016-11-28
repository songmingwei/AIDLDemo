package com.wuxianedu.aidldemo.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.wuxianedu.aidldemo.IObtainBitmap;
import com.wuxianedu.aidldemo.R;

import java.io.ByteArrayOutputStream;

/**
 * http://blog.csdn.net/feiduclear_up/article/details/51314430#t7
 * Created by terrysong on 2016/11/28.
 */

public class ObtainBitmapService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IObtainBitmap.Stub mBinder = new IObtainBitmap.Stub() {
        @Override
        public byte[] getBitmap() throws RemoteException {
            Bitmap bitmap = BitmapFactory.decodeResource(ObtainBitmapService.this.getResources(), R.mipmap.ic_launcher);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, baos);//压缩位图
            return baos.toByteArray();//创建分配字节数组
        }
    };
}
