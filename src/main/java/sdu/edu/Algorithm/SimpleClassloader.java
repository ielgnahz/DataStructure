package sdu.edu.Algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class SimpleClassloader extends ClassLoader{
	
	/**
	 * 辅助方法
	 * @param filename		文件名
	 * @return				文件名对应的文件的二进制字节数组
	 * @throws IOException
	 */
	private byte[] getBytes(String filename) throws IOException {
		File file = new File(filename);
		long len = file.length();
		byte[] raw = new byte[(int) len];
		FileInputStream fin = new FileInputStream(file);
		// 一次读取class文件的全部二进制数据
		int r = fin.read(raw);
		if (r != len)
			throw new IOException("无法读取全部文件：" + r + " != " + len);
		fin.close();
		return raw;
	}
	
	
	/**
	 * 这个方法是覆盖的父类的方法   这个方法传入的是一个String类型，这里我们就可以认为是文件所在的目录
	 * 返回值是一个Class类型   Class类型 代表一个类的元数据  描述类的类。
	 * 得到了这个类型就可以通过反射  得到类中所有的属性和方法，甚至调用方法。
	 * 思考一个问题：  有了文件所在的目录，如何得到一个Class类型？
	 * 父类 ，也就是ClassLoader类中提供了一个defineClass方法
	 * 这个方法有四个参数   第一个就是累的名字   第二个就是这个类所对应的class文件的字节码数组（通过IO就可以轻易得到）
	 * 第三个参数就是字节码数组的偏移量位置    第四个  长度
	 * 
	 * 
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			System.out.println(name);
			byte[] raw = getBytes(name);
			int fullNameLength = (raw[14]<<8) + raw[15]; //14位置上的数为高位 15位置上的数为低位
			//，高位为xxxx xxxx左移8位加上低位构成长度 与0xff相与是为了只保留后八位 ff为1111 1111
			//第一个参数是类的全名称
//			String classFullName = new String(raw,16,fullNameLength);
//			System.out.println(classFullName);
//			String realName = classFullName.replace("/", ".");
//			System.out.println(realName);
			return defineClass(null, raw, 0, raw.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) throws Exception, InstantiationException, IllegalAccessException {
		SimpleClassloader scl = new SimpleClassloader();
		Class clazz = scl.loadClass("D:\\TestClassLoad.class");
		Object obj = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("f2", null);
		method.invoke(obj, null);
		
	}
}