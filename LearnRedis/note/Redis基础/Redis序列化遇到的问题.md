自己写的Redis序列化  解析的时候如果bean的包名不同也会出现问题
解析出来是null  因此需要包名完全一样  坑!!!

一般是把bean转成json存进去  取出来的时候再解析

附件:
公司某位大神自己写的Redis序列化的代码,直接导致了上面的问题

```java
private String setObjectImpl(String key, Object value) {
   Jedis shardedJedis = getShardedJedis(key);
 try {
      byte[] byteArray = objectToByte(value);
  String setObjectRet = shardedJedis.set(key.getBytes(), byteArray);
  String str1 = setObjectRet;
 return str1;
  } catch (Exception e) {
      returnBrokenResource(key,shardedJedis);
  e.printStackTrace();
  } finally {
      returnResource(key, shardedJedis);
  }
   return null; }
```


