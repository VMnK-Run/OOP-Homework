package com.huawei.classroom.student.h14;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 在本包下增加合适的类和方法， 本程序不但要测试通过，还需要写适当的注释
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class MyTools {

	public MyTools( ) {
		// TODO Auto-generated constructor stub
	}

	public static int CHUNK_SIZE = 4096;

	public static void copyIO(InputStream in, OutputStream out) throws IOException {
		byte[] buf = new byte[CHUNK_SIZE];
		int len = in.read(buf);
		while(len != -1) {
			out.write(buf, 0, len);
			len = in.read(buf);
		}
	}

	/**
	 * 复制文件
	 * @param src
	 * @param dst
	 * @throws IOException
	 * */
	public static void copyFile(String src, String dst) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			copyIO(in, out);
		} finally {
			close(in);
			close(out);
		}
	}

	public static void close(Closeable inout) {
		if(inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从文件种读取学生列表到List中，List的元素为String数组
	 */
	public List<String[]> getNameList(String fileName) throws IOException {
		List<String[]> res = new ArrayList<>();
		try (Reader reader = new FileReader(fileName);
			 	LineNumberReader lineReader = new LineNumberReader(reader)){
			String line = lineReader.readLine();
			while(line != null) {
				res.add(line.split("\t"));
				line = lineReader.readLine();
			}
		}
		return res;
	}

	public List<String> getExistsIdList(String filename) {
		List<String> res = new ArrayList<>();
		File file = new File(filename);
		File[] lists = file.listFiles();
		assert lists != null;
		for (File thisFile : lists) {
			if (thisFile.isFile() && thisFile.getName().matches("[0-9]{10}.jpg")) {
				res.add(thisFile.getName().substring(0, 10));
			}
		}
		return res;
	}

	public Set<String> copyToTargetDirAndReturnNoExist(String studentListFile,String srcDir,String target) throws Exception {
		Set<String> noExistSet = new HashSet<>();
		List<String> existIdList = getExistsIdList(srcDir);
		List<String[]> nameList = getNameList(studentListFile);
		for (String[] strings : nameList) {
			String id = strings[0];
			String name = strings[1];
			String classes = strings[2];
			File targetDir = new File(target, classes);
			if (!targetDir.exists()) {
				targetDir.mkdirs();
			}
			if (!existIdList.contains(id)) {
				noExistSet.add(id);
			} else {
				String src = srcDir + id + ".jpg";
				String dst = target + classes + "/" + id + "_" + name + ".jpg";
				copyFile(src, dst);
			}

		}
		return noExistSet;
	}
}
