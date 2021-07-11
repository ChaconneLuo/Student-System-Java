package com.luo.sys.util;

import lombok.var;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MapperUtils {

    private static SqlSession sqlSession;

    static {
        try (var config = Resources.getResourceAsStream("mybatisConfig.xml")) {
            var sessionFactory = new SqlSessionFactoryBuilder().build(config);
            sqlSession = sessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T getMapper(Class<T> requiredType) {
        return sqlSession.getMapper(requiredType);
    }
}
