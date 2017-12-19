# -*- coding:utf-8 -*-    
from thrift.transport import TSocket  
from thrift.transport import TTransport  
from thrift.protocol import TBinaryProtocol  
from thrift.server import TServer

#根据实际的包结构去引入  
from hellp import Hello
import os, sys
import you_get

class TestServiceHandler:  

    def callBack(self,url):
        return url
    def helloString(self, word):
        sys.argv[0]='you-get'
        sys.argv.append('-u')
        sys.argv.append(word)
        print(sys.argv)
        you_get.main()
        return '1'
if __name__ == '__main__':
    handler = TestServiceHandler()  
    processor = Hello.Processor(handler)
    transport = TSocket.TServerSocket(host='127.0.0.1',port=9090)  
    tfactory = TTransport.TBufferedTransportFactory()  
    pfactory = TBinaryProtocol.TBinaryProtocolFactory()  
  
    server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)  
    print ('python server:ready to start')
    server.serve()

