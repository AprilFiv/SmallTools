package com.yuin.smalltools.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Service;

@Service
public class ThriftService {
    public void transUrl(String url) throws Exception {
        //配置服务端的请求信息
        TTransport transport = new TSocket("127.0.0.1", 9090);
        try {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);

            //接口调用
            String rs = client.helloString( url);
            //打印调用结果
            System.out.println("java c  lient:" + rs);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
            throw e;
        } catch (TException e) {
            e.printStackTrace();
            throw e;
        }
    }
}