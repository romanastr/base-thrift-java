package org.astroman.base.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrossPlatformServiceServer {

  private static final Logger LOG = LoggerFactory.getLogger(CrossPlatformServiceServer.class);

  public void start() throws TTransportException {
    TServerTransport serverTransport = new TServerSocket(ServerConfig.PORT);

    TServer server = new TSimpleServer(new TServer.Args(serverTransport)
        .processor(
            new CrossPlatformService.Processor<>(
                new CrossPlatformServiceImpl())
        )
    );

    LOG.info("Starting the server... ");

    server.serve();

    LOG.info("Done.");
  }

  public static void main(String[] argv) throws TTransportException {
    new CrossPlatformServiceServer().start();
  }
}