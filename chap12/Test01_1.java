package chap12;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;



public class Test01_1 {
	public static void main(String[] args) {

		/*File file =  new File("b.txt");
		if (file.exists()) {
			 Scanner sc = new Scanner(System.in);
					System.out.println("이미 존재하는 파일입니다.");
					System.out.println("덮어쓸까요? [Y/N]");
					String ans = sc.next();
					if (ans.equalsIgnoreCase("Y"))
						break;
					else if (ans.equalsIgnoreCase("N))"
							return;
		}
		sc.close(); */



					//System.out.println(args[0]+","+args[1]);
					long start = System.currentTimeMillis();
					Filecopy(args[0], args[1]);
					System.out.println("Filecopy :" + (System.currentTimeMillis()-start));
					Filecopy1(args[0], args[1]);
					System.out.println("Filecopy1 :" + (System.currentTimeMillis()-start));
	}

	private static void Filecopy(String string, String string2) {
		// TODO Auto-generated method stub
		try(BufferedInputStream fi = new BufferedInputStream(new FileInputStream(string));
				BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream(string2));){
			int c = 0;
			while((c = fi.read()) != -1) {
				fo.write(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void Filecopy1(String string, String string2) {
		// TODO Auto-generated method stub
		try(FileInputStream fi = new FileInputStream(string);
				FileOutputStream fo = new FileOutputStream(string2);){
			int c = 0;
			while((c = fi.read()) != -1) {
				fo.write(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}