# -*- coding:utf-8 -*-
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer
from YouGetModule.YouGet import Hello
import you_get
import sys
class HelloHandler:
    def __init__(self):
        self.log = {}

    def helloString(self, word):
        sys.argv=['you-get','-u',word]
        you_get.main()
        return 'SUCCESS'
if __name__ == '__main__':
    handler = HelloHandler()
    processor = Hello.Processor(handler)
    transport = TSocket.TServerSocket(host='127.0.0.1', port=9090)
    tfactory = TTransport.TBufferedTransportFactory()
    pfactory = TBinaryProtocol.TBinaryProtocolFactory()

    server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)
    print( 'python server:ready to start')
    server.serve()