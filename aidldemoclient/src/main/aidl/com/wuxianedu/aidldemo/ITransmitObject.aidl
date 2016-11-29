// IRemoteService.aidl
package com.wuxianedu.aidldemo;
// Declare any non-default types here with import statements

import com.wuxianedu.aidldemo.Student;
/** Example service interface */
interface ITransmitObject {

    /*in：参数由客户端设置，或者理解成客户端传入参数值。
      out：参数由服务端设置，或者理解成由服务端返回值。
      inout：客户端服务端都可以设置，或者理解成可以双向通信。*/

   int add(int arg1, int arg2);

   String inStudentInfo(in Student student);

   String outStudentInfo(out Student student);

   String inOutStudentInfo(inout Student student);
}