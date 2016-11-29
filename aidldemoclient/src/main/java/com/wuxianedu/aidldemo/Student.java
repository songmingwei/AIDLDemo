package com.wuxianedu.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by terrysong on 2016/11/28.
 */

public class Student implements Parcelable {

    private int id;
    private String name;
    private String className;
    private int age;


    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
        className = in.readString();
        age = in.readInt();
    }

    public Student(int id, String name, String className, int age) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.age = age;
    }

    public Student(){}


    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(className);
        parcel.writeInt(age);
    }

    public void readFromParcel(Parcel source) {
        id = source.readInt();
        name = source.readString();
        className = source.readString();
        age = source.readInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
