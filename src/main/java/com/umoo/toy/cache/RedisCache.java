package com.umoo.toy.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.umoo.toy.util.ProtoStuffSerializerUtil;

public class RedisCache {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	/**
	 * 添加缓存(没有过期时间)
	 * @param key
	 * @param object
	 * @return
	 */
	public <T> boolean putCache(String key, T object) {
		final byte[] bkey = key.getBytes();
		final byte[] bvalue = ProtoStuffSerializerUtil.serialize(object);
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.setNX(bkey, bvalue);
				return null;
			}
		});
		return result;
	}
	/**
	 * 添加缓存(有过期时间)
	 * @param key
	 * @param object
	 * @param expireTime
	 */
	public <T> void putCacheWithExpireTime(String key, T object, final long expireTime) {
		final byte[] bkey = key.getBytes();
		final byte[] bvalue = ProtoStuffSerializerUtil.serialize(object);

		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.setEx(bkey, expireTime, bvalue);
				return true;
			}
		});
	}
	/**
	 * 缓存对象列表(不过期)
	 * @param key
	 * @param objectList
	 * @return
	 */
	public <T> boolean putListCache(String key, List<T> objectList) {
		final byte[] bkey = key.getBytes();
		final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objectList);
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.setNX(bkey, bvalue);
			}
		});
		return result;
	}
	/**
	 * 缓存对象列表(有过期时间)
	 * @param key
	 * @param objectList
	 * @param expireTime
	 */
	public <T> void putListCacheWithExpireTime(String key, List<T> objectList,final long expireTime) {
		final byte[] bkey = key.getBytes();
		final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objectList);
		redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.setEx(bkey, expireTime, bvalue);
				return true;
			}
		});
	}
	
}
