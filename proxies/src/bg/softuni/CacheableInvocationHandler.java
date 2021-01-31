package bg.softuni;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheableInvocationHandler implements InvocationHandler {

  private Object realObject;
  private Map<String, Object> cache = new HashMap<>();

  public CacheableInvocationHandler(Object realObject) {
    this.realObject = realObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Cacheable cacheableAnotation =
        realObject.
            getClass().
            getMethod(method.getName(), method.getParameterTypes()).
            getAnnotation(Cacheable.class);

    if (cacheableAnotation == null) {
      return method.invoke(realObject, args);
    } else {
      String cacheName = cacheableAnotation.value();
      if (cache.get(cacheName) != null) {
        return cache.get(cacheName);
      } else {
        Object result = method.invoke(realObject, args);
        cache.put(cacheName, result);
        return result;
      }
    }
  }
}
