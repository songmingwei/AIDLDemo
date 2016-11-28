// IRemoteService.aidl
package com.wuxianedu.aidldemo;
// Declare any non-default types here with import statements

/** Example service interface */
/** 根据图书编号来查询图书*/
interface IBook {

   String queryBook(int bookNo);  
}