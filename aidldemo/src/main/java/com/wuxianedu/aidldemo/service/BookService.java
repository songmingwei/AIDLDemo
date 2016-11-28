package com.wuxianedu.aidldemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.wuxianedu.aidldemo.IBook;

/**
 * 查询书籍的服务
 *
 * @author terrysong
 *
 */
public class BookService extends Service {

	private String[] bookNames = { "Java编程思想", "设计模式", "Android开发设计" };

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	/**
	 * 服务中交互的方法
	 *
	 * @param bookNo
	 * @return
	 */
	public String queryBookName(int bookNo) {
			return bookNames[bookNo % 3];
	}

	private IBook.Stub mBinder = new IBook.Stub() {
		@Override
		public String queryBook(int bookNo) throws RemoteException {
			return queryBookName(bookNo);
		}
	};

}
