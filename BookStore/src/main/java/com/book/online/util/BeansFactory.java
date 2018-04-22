package com.book.online.util;

public class BeansFactory {

	private static Object obj;
	
	public static Object newInstance(String key) {
		
		String classname = PropConfUtils.getValue(key);
		Class<?> c;
		try {
			c = Class.forName(classname);
			obj = c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
