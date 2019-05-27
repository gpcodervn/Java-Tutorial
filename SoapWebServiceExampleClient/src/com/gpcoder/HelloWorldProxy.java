package com.gpcoder;

public class HelloWorldProxy implements com.gpcoder.HelloWorld {
  private String _endpoint = null;
  private com.gpcoder.HelloWorld helloWorld = null;
  
  public HelloWorldProxy() {
    _initHelloWorldProxy();
  }
  
  public HelloWorldProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloWorldProxy();
  }
  
  private void _initHelloWorldProxy() {
    try {
      helloWorld = (new com.gpcoder.HelloWorldServiceLocator()).getHelloWorld();
      if (helloWorld != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloWorld)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloWorld != null)
      ((javax.xml.rpc.Stub)helloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.gpcoder.HelloWorld getHelloWorld() {
    if (helloWorld == null)
      _initHelloWorldProxy();
    return helloWorld;
  }
  
  public java.lang.String sayHelloWorld(java.lang.String name) throws java.rmi.RemoteException{
    if (helloWorld == null)
      _initHelloWorldProxy();
    return helloWorld.sayHelloWorld(name);
  }
  
  
}