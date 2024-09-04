package org.shitj.bean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.shitj.mapper.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class KeanFactoryBean<T> implements FactoryBean<T> {

    private SqlSession sqlSession;

    private Class<T> mapperInterface;

    public KeanFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public T getObject() throws Exception {
        this.sqlSession.getConfiguration().addMapper(this.mapperInterface);
        return this.sqlSession.getMapper(this.mapperInterface);
    }

    @Override
    public Class<T> getObjectType() {
        return this.mapperInterface;
    }
}
