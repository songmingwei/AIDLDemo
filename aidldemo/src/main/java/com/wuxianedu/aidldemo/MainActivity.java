package com.wuxianedu.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_result);
//        testDemo1();
		testDemo2();
//		testDemo3();
    }


    //查询图书 start
    private void testDemo3() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.wuxianedu.aidldemo",
                "com.wuxianedu.aidldemo.service.BookService"));//第一个参数是包名(应用的包名)，第二个是类名
        bindService(intent, serviceConnection3, Context.BIND_AUTO_CREATE);
    }
    private IBook iBook;
    private ServiceConnection serviceConnection3 = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("--Main--", "-----------------");
            iBook = IBook.Stub.asInterface(service);
            try {
                String result = iBook.queryBook(1);
                textView.setText(result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
    //查询图书 end

    //获取pid start
    private void testDemo2() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.wuxianedu.aidldemo",
                "com.wuxianedu.aidldemo.service.DDService"));//第一个参数是包名(应用的包名)，第二个是类名
        bindService(intent, serviceConnection2, Context.BIND_AUTO_CREATE);
    }
    private IRemote remoteService;
    private ServiceConnection serviceConnection2 = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("--Main--", "-----------------");
            remoteService = IRemote.Stub.asInterface(service);
            try {
                int result = remoteService.getPid();
                textView.setText(String.valueOf(result));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
    //获取pid end

    //计算start
    private void testDemo1() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.wuxianedu.aidldemo",
                "com.wuxianedu.aidldemo.service.CalculateService"));//第一个参数是包名(应用的包名)，第二个是类名
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }
    private CalculateInterface mService;
    private ServiceConnection serviceConnection = new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = CalculateInterface.Stub.asInterface(service);
            try {
                textView.setText(String.valueOf(mService.doCalculate(10.52, 10.48)));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };
    //计算end

}
