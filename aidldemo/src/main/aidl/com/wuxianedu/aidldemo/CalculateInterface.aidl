// CalculateInterface.aidl
package com.wuxianedu.aidldemo;

// Declare any non-default types here with import statements

interface CalculateInterface {
   /* *//**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     *//*
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);*/

    double doCalculate(double a, double b);
}
