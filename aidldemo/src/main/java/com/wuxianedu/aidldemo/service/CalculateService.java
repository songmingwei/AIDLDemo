package com.wuxianedu.aidldemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.wuxianedu.aidldemo.Calculate;
import com.wuxianedu.aidldemo.CalculateInterface;

/**
 * 参考博客
 * http://www.cnblogs.com/BeyondAnyTime/p/3204119.html
 * http://www.cnblogs.com/herenzhiming/articles/4504392.html
 * http://www.linuxidc.com/Linux/2015-01/111148.htm
 * http://blog.csdn.net/cjjky/article/details/7562652
 * @author terrysong
 */
public class CalculateService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.e("--Main--", "onCreate------------------------");
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	private final CalculateInterface.Stub mBinder = new CalculateInterface.Stub() {
		@Override
		public double doCalculate(double a, double b) throws RemoteException {
			Log.e("Calculate", "远程计算中");
			Calculate calculate = new Calculate();
			double answer = calculate.calculateSum(a, b);
			return answer;
		}
	};

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.e("--Main--", "onDestroy------------------------");
	}


}
