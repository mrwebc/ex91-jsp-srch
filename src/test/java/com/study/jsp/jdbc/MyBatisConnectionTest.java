package com.study.jsp.jdbc;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import myBatis.MyBatisManager;

public class MyBatisConnectionTest {

  SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
  SqlSession sqlSession = sqlSessionFactory.openSession();


  @Test
  public void sqlSessionTest() {
    assertNotNull(sqlSession);
    
    String timeStr = sqlSession.selectOne("timeMapper.getTime");

    System.out.println(timeStr);

    sqlSession.close();    
  }
  
  

}
