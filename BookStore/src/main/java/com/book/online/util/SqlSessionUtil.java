package com.book.online.util;
/**
 * 
 * @author wyh
 * @date 2018年1月23日
 * @requirementTODO
 * 此类是mybatis操作的一个工具类,封装SqlSessionFactory的初始化以及获取SqlSession的方法
 */

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {

	private static SqlSessionFactory factory;

	private SqlSessionUtil() {
		super();
	}
	/**
	 * 采用饿汉式,在JVM加载时初始化factory对象
	 */
	static 
	{
		//1.构建 SqlSessionFactory对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//		Reader reader = null;
		//2.定义配置文件的路径
		String config="mybatis-config.xml";
		InputStream is=null;
		try {
			//3.通过Resoureces把路径转换成Reader对象
			is = Resources.getResourceAsStream(config);
			//4.通过builder的build方法来构建SqlSessionFactory实例
			 factory = builder.build(is);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
				if(factory!=null)
					return factory;
				else
					throw new RuntimeException("获取SqlSessionFactory失败...");
	}
	
	public static SqlSession getSqlSession()
	{
		if(factory!=null)
			return factory.openSession();
		else
			throw new RuntimeException("获取SqlSession失败...");
	}
	public static SqlSession getSqlSession(ExecutorType et)
	{
		if(factory!=null)
			return factory.openSession(et);
		else
			throw new RuntimeException("获取SqlSession失败...");
	}
}
