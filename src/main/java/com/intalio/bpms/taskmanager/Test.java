package com.intalio.bpms.taskmanager;

public class Test {
	
	public static void main(String... s){
		String pattern = "[\\p{L}0-9_\\-]*";
		System.out.println("Hello".matches(pattern));
	}

}
