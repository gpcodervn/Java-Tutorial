/**
 * HelloWorldService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gpcoder;

public interface HelloWorldService extends javax.xml.rpc.Service {
    public java.lang.String getHelloWorldAddress();

    public com.gpcoder.HelloWorld getHelloWorld() throws javax.xml.rpc.ServiceException;

    public com.gpcoder.HelloWorld getHelloWorld(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
