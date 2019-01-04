package cn.C3P0;

import java.util.UUID;

public class UUIDUtil {
	//得到一个随机的字符串
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}
