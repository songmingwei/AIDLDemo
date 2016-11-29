package com.wuxianedu.aidldemo.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.wuxianedu.aidldemo.ITransmitObject;
import com.wuxianedu.aidldemo.Student;

/**
 * Created by terrysong on 2016/11/28.
 */

public class StudentService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final ITransmitObject.Stub mBinder = new ITransmitObject.Stub() {

        @Override
        public int add(int arg1, int arg2) throws RemoteException {
            return arg1 + arg2;
        }

        @Override
        public String inStudentInfo(Student student) throws RemoteException {
            /*return "Student in:id="+student.getId()+
                    ",name="+student.getName()+
                    ",className="+student.getClassName()+
                    ",age="+student.getAge();*/

            String msg = "table1" + "\n" + "----------------------------------------------" + "\n" + "|" +
                    " id " + "|" + " " +
                    "age " +
                    "|" + " name " + "|" + " className " + "|" + "\n" +
                    "----------------------------------------------" + "\n" + "|  " + student.getId() + " " +
                    "|  " + student
                    .getAge() + "  |  " + student.getName() + "   |     " + student.getClassName() + "   | " +
                    "\n" + "----------------------------------------------";
            return msg;
        }

        @Override
        public String outStudentInfo(Student student) throws RemoteException {
            /*return "Student out:id="+student.getId()+
                    ",name="+student.getName()+
                    ",className="+student.getClassName()+
                    ",age="+student.getAge();*/
//            student.setClassName("090412");
//            student.setName("Tom2");

//            String msg = "Id = " + student.getId() + " age = " + student.getAge() + " ClassName = " +
//                    student.getClassName() + " Name = " + student.getName();
            String msg = "table2" + "\n" + "----------------------------------------------" + "\n" + "|" +
                    " id " + "|" + " " +
                    "age " +
                    "|" + " name " + "|" + " className " + "|" + "\n" +
                    "----------------------------------------------" + "\n" + "|  " + student.getId() + " " +
                    "|  " + student
                    .getAge() + "  |  " + student.getName() + "   |     " + student.getClassName() + "   | " +
                    "\n" + "----------------------------------------------";
            return msg;
        }

        @Override
        public String inOutStudentInfo(Student student) throws RemoteException {
            /*return "Student in out:id="+student.getId()+
                    ",name="+student.getName()+
                    ",className="+student.getClassName()+
                    ",age="+student.getAge();*/

            student.setClassName("090411");
            student.setAge(22);
            String msg = "table3" + "\n" + "----------------------------------------------" + "\n" + "|" +
                    " id " + "|" + " " +
                    "age " +
                    "|" + " name " + "|" + " className " + "|" + "\n" +
                    "----------------------------------------------" + "\n" + "|  " + student.getId() + " " +
                    "|  " + student
                    .getAge() + "  |  " + student.getName() + "   |     " + student.getClassName() + "   | " +
                    "\n" + "----------------------------------------------";

            return msg;
        }
    };

    /**
     * get current process name
     *
     * @param context
     * @return
     */
    private String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
