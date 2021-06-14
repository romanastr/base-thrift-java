package org.astroman.base.thrift;

import java.util.List;
import java.util.Random;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrossPlatformClient {
  private static final Logger LOG = LoggerFactory.getLogger(CrossPlatformClient.class);
  private static final Random RAND = new Random();

  public static void main(String[] argv) throws TException {
    TTransport transport = new TSocket("localhost", ServerConfig.PORT);
    transport.open();

    TProtocol protocol = new TBinaryProtocol(transport);
    CrossPlatformService.Client client = new CrossPlatformService.Client(protocol);

    boolean result = client.ping();
    LOG.info("Ping result: {} ", result);

    client.save(new CrossPlatformResource(RAND.nextInt(), "Bob"));
    client.save(new CrossPlatformResource(RAND.nextInt(), "Mary"));

    List<CrossPlatformResource> resourceList = client.getList();
    LOG.info("Resources retrieved from the server: {}", resourceList);

    transport.close();
  }
}
