package org.astroman.base.thrift;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrossPlatformServiceImpl implements CrossPlatformService.Iface {
  private final Map<Integer, CrossPlatformResource> resourceMap = new HashMap<>();

  @Override
  public CrossPlatformResource get(int id) {
    return resourceMap.get(id);
  }

  @Override
  public void save(CrossPlatformResource resource) {
    resourceMap.put(resource.getId(), resource);
  }

  @Override
  public List<CrossPlatformResource> getList() {
    return List.copyOf(resourceMap.values());
  }

  @Override
  public boolean ping() {
    return true;
  }
}