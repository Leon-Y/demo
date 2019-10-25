package com.tool;


import java.io.File;
import java.util.Set;

public class TestClass {

	public static void main(String[] args) throws Exception {
		ForEachFile forEachFile = new ForEachFile();
		File file = new File("E:\\01 ZHGD\\03 Utility");

		Set<File> fileSet = forEachFile.getForEachFile(file);
		for (File fileDemo:fileSet){
			fileDemo.getName();
//			System.out.println(fileDemo.getName()+ fileDemo.getPath());
			RemoveUTF8BOM.trimBom(fileDemo.getPath());
		}
		System.out.print(fileSet.size());
	}
	
//	void testMethod1() throws Exception{
//		User user = new User();
//		UserDao userDao = new UserDao();
//		userDao.execSelect(null, null, null, null);
//	}
}
