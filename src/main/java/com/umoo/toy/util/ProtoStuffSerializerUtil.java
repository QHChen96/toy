package com.umoo.toy.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.ProtostuffOutput;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

/**
 * 
 * @author umoo
 * 序列化工具,简化ProtoStuff的操作
 */
public class ProtoStuffSerializerUtil {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 序列化对象
	 * @param object
	 * @return
	 */
	public static <T> byte[] serialize(T object) {
		if(object == null) {
			throw new RuntimeException("序列化对象(" +object + ")为空!");
		}
		@SuppressWarnings("unchecked")
		Schema<T> schema = (Schema<T>)RuntimeSchema.getSchema(object.getClass());
		LinkedBuffer buffer = LinkedBuffer.allocate(1024 * 1024);
		byte[] protoStuff = null;
		try {
			protoStuff = ProtostuffIOUtil.toByteArray(object, schema, buffer);
		} catch (Exception e) {
			throw new RuntimeException("序列化(" +object.getClass() + ")对象(" + object + ")发生异常!", e);
		} finally {
			buffer.clear();
		}
		return protoStuff;
	}
	/**
	 * 反序列化
	 * @param paramArrayOfByte
	 * @param targetClass
	 * @return
	 */
	public static <T> T deserialize(byte[] paramArrayOfByte, Class<T> targetClass) {
		if(paramArrayOfByte == null || paramArrayOfByte.length == 0) {
			throw new RuntimeException("反序列化对象发生异常,字节数组为空!");
		}
		T instance = null;
		try {
			instance = targetClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("反序列化过程中依据类型实例化失败!");
		}
		Schema<T> schema = (Schema<T>)RuntimeSchema.getSchema(targetClass);
		ProtostuffIOUtil.mergeFrom(paramArrayOfByte, instance, schema);
		return instance;
	}
	/**
	 * 序列化对象列表
	 * @param object
	 * @return
	 */
	public static <T> byte[] serializeList(List<T> objectList) {
		if(objectList == null && objectList.isEmpty()) {
			throw new RuntimeException("序列化对象列表(" +objectList + ")参数异常!");
		}
		Schema<T> schema = (Schema<T>)RuntimeSchema.getSchema(objectList.get(0).getClass());
		LinkedBuffer buffer = LinkedBuffer.allocate(1024 * 1024);
		byte[] protoStuff = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			ProtostuffIOUtil.writeListTo(bos, objectList, schema, buffer);
			protoStuff = bos.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException("序列化对象列表(" + objectList + ")发生异常!", e);
		} finally {
			buffer.clear();
			try {
				if(bos != null){
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return protoStuff;
	}
	/**
	 * 反序列化对象列表
	 * @param paramArrayOfByte
	 * @param targetClass
	 * @return
	 */
	public static <T> List<T> deserializeList(byte[] paramArrayOfByte, Class<T> targetClass) {
		if(paramArrayOfByte == null && paramArrayOfByte.length == 0) {
			throw new RuntimeException("反序列化对象列表发生异常,字节数组为空!");
		}
		Schema<T> schema = (Schema<T>)RuntimeSchema.getSchema(targetClass);
		List<T> list = null;
		try {
			list = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(paramArrayOfByte), schema);
		} catch (Exception e) {
			throw new RuntimeException("反序列化对象列表发生异常!", e);
		}
		return list;
	}
}
