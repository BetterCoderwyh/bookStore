package com.book.online.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropConfUtils {

	private static Properties prop;
	static {
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("beans.properties");
		prop=new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			throw new RuntimeException("配置文件加载失败");
		}
	}
	
	public static String getValue(String key)
	{
		return prop==null?null:prop.getProperty(key);
	}
}
