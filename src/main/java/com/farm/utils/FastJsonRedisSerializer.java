package com.farm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @name: FastJsonRedisSerializer
 * @author: sutton
 * @date: 2023-04-27 11:03
 * @description: 处理 key 乱码
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;


    //作用是开启fastjson的autotype功能
    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    /**
     * @param clazz 1
     * @name: FastJsonRedisSerializer
     */
    public FastJsonRedisSerializer (Class<T> clazz) {
        super();
        this.clazz = clazz;
    }


    /**
     * @param t param
     * @return 字节
     * @throws SerializationException 序列化异常
     * @name: serialize
     * @description 序列化
     * a: WriteClassName：序列化时写入类型信息，默认为false，如果需要类型信息，需要设置为true
     */
    @Override
    public byte[] serialize (T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }


    /**
     * @param bytes 字节
     * @return T
     * @throws SerializationException q: 为什么要用fastjson反序列化，而不用jackson反序列化？ a: 因为jackson反序列化时，会将类型信息也反序列化出来，导致反序列化失败
     */
    @Override
    public T deserialize (byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);

        return JSON.parseObject(str, clazz);
    }


    protected JavaType getJavaType (Class<?> clazz) {
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}
