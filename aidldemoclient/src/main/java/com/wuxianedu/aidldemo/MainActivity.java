package com.wuxianedu.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.wuxianedu.aidldemo.activity.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_result);
        imageView = (ImageView) findViewById(R.id.iv_id);
//        testDemo1();
//		testDemo2();
//        testDemo3();
//        testDemo4();
        testDemo5();
    }

    //传递自定义对象Student start
    private void testDemo5() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.wuxianedu.aidldemo",
                "com.wuxianedu.aidldemo.service.StudentService"));//第一个参数是包名(应用的包名)，第二个是类名
        bindService(intent, serviceConnection5, Context.BIND_AUTO_CREATE);
    }
    private ITransmitObject iTransmitObject;
    private ServiceConnection serviceConnection5 = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("--Main--", "-----------------");
            iTransmitObject = ITransmitObject.Stub.asInterface(service);

            try {
                String info1 = iTransmitObject.inStudentInfo(new Student(1, "Jim", "090415", 18));
                String info2 = iTransmitObject.outStudentInfo(new Student(2, "Lida", "090416", 17));
                String info3 = iTransmitObject.inOutStudentInfo(new Student(3, "Tom", "090417", 16));

                textView.setText(info1 + "\n" + "===========line=========" + "\n" + info2 + "\n" +
                        "===========line=========" + "\n" + info3);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
    //传递自定义对象Student end

    //传递Bitmap对象 start
    private void testDemo4() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.wuxianedu.aidldemo",
                "com.wuxianedu.aidldemo.service.ObtainBitmapService"));//第一个参数是包名(应用的包名)，第二个是类名
        bindService(intent, serviceConnection4, Context.BIND_AUTO_CREATE);
    }
    private IObtainBitmap iObtainBitmap;
    private ServiceConnection serviceConnection4 = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("--Main--", "---------1111--------");
            iObtainBitmap = IObtainBitmap.Stub.asInterface(service);
            try {
                byte[] bytes = iObtainBitmap.getBitmap();
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                Log.e("--Main--", "---------222--------");
                imageView.setImageBitmap(bitmap);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
    //传递Bitmap对象 end


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
                String result = iBook.queryBook(3);
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
                textView.setText(String.valueOf(mService.doCalculate(11.52, 10.48)));
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
