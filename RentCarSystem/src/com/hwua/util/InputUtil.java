package com.hwua.util;

import java.util.Scanner;

public class InputUtil {
	 private static Scanner input = new Scanner(System.in);
	 
	 public static Integer getInt() {
		 return input.nextInt();
	 }
	 
	 public static String getString() {
		 return input.next();
	 }
	 
	 public static long getLong(){
		 return input.nextLong();
	 }
}
