package chap10;

import java.util.HashMap;
import java.util.Set;

public class Test07 {
	public static void main(String[] args) {
		HashMap<String, String>dic = new HashMap<String, String>();
		
		dic.put("고진감래", "고생 끝");
		dic.put("분골쇄신", "몸이 부서짐");
		dic.put("권토중래", "실패");
		dic.put("교학상자", "성장함");
		dic.put(null, null);
		
		for(String key : dic.keySet()) {
			System.out.println(String.format("%s : %s",key, dic.get(key)));
		}
		Set<String> keys = dic.keySet();
		for (String key : keys) {
			System.out.println(String.format("%s : %s",key, dic.get(key)));
		}
		
	}
}
