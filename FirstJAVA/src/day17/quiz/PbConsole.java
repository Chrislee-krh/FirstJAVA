package day17.quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import util.Closure;

public class PbConsole {
	static Map<String, Map<Long,String>> pb = new HashMap<>();
	static Map<Long,String> info = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
//	Map group = new HashMap();
//	Map info = new HashMap();


	public static void main(String[] args) throws Exception {	
		
		while (true) {
			System.out.println("==== What to do ====");			
			System.out.println("1. New Group");
			System.out.println("2. Print");
			System.out.println("3. New Address");
			System.out.println("4. Find Phone");
			System.out.println("5. Find Name");
			System.out.println("6. Exit");
			System.out.println("> ");
			int behavior = sc.nextInt();
			sc.nextLine();
			
			switch (behavior) {
			case 1:
				doNewGroup();
				break;
			case 2:
//				loadMember();
				printAll();
				break;
			case 3:
				doNewAddress();
				break;
			case 4:		
				printAllByNum();
				break;
			case 5:
				printAllByName();
				break;
			case 6:
				exitPb();
				break;
			default:
				break;
			}
		}		
	}

	public static void doNewGroup() {

		System.out.println("Group Name: ");
		String gName = sc.nextLine();
		if(!pb.containsKey(gName)) {
			pb.put(gName, new HashMap<>());
		} else {
			System.out.println("Group already exists");
		}
	}
	public static void printAll() {
		if(pb == null)loadMember();
		
		for(Map.Entry<String, Map<Long, String>> gEntry : pb.entrySet()) {
			String gName = gEntry.getKey();
			System.out.println("Group: " + gName);
			Map<Long, String> gInfo = gEntry.getValue();
			for(Map.Entry<Long, String> gValue : gInfo.entrySet()) {
				long pNum = gValue.getKey();
				String pName = gValue.getValue();
				System.out.println("Phone Number: " + pNum + ", Name: " + pName);
				
			}
		}	
//		Set<Map.Entry<String, Map<Long,String>>> s = pb.entrySet();
//		System.out.println(s);
	}
	
	public static String loadMember() {
		File f = new File("E:\\games\\memberlist.txt");
		FileReader fr = null;
		BufferedReader br = null;
		String code = null;
		
		try {
			code = new String();
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
				code += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fr!=null)
				try {Closure.close(fr);} catch (Exception e2) {}
			if(br!=null)
				try {Closure.close(br);} catch (Exception e2) {}
		}
		System.out.println(code);
		return code;
	}
	
	public static void doNewAddress() {
		if(pb.keySet() == null) {
			System.out.println("Group does not exist.");
		} else {
		System.out.println("Type in the name of a group you want to add your member's phone number and name!");
		System.out.println(">");
		String gName = sc.nextLine();
		if(pb.containsKey(gName)) {
			System.out.println("Type in Phone Number & Name");
			System.out.println("Phone number>");
			long pNum = sc.nextLong();
			sc.nextLine();
			System.out.println("Name>");
			String name = sc.nextLine();
			
			Map<Long, String> info = pb.get(gName);
			if(!info.containsKey(pNum)) {
				info.put(pNum, name);
				System.out.println("Phone# & MemberName are added to Group " + gName + ".");
				saveMember(gName +" "+ name + ": " + pNum);
				
			} else {
				System.out.println("This number already exists.");
			}
			
			
//			Set<Long> keySet = new HashSet<Long>();
//			for(Long num : info.keySet()) {
//				if(!keySet.add(num)) {System.out.println("중복된 번호입니다.");}
//			} else {
//			
//			pb.get(gName).put(pNum, name);
		
			
		} else { System.out.println("That group does not exist!");}
		}	
	}
	
	public static void saveMember(String content) {
		
		File memberList = new File("E:\\games\\memberlist.txt");
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(memberList, true);
			bw = new BufferedWriter(fw);
			
			bw.write(content);
			bw.newLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bw != null) 
				 try {Closure.close(bw);} catch (Exception e2) {}
			if(fw != null) 
				try {Closure.close(fw);} catch (Exception e2) {}
		}
		
	}
	
	public static boolean isNumExist() {
		return false;
		
	}
	
	
	public static void printAllByNum() {
		System.out.println("Show all the member information");
		System.out.println("Type in part of phone number you can remember :) >");
		long partialPNum = sc.nextLong();
//		boolean found = false;
		
		
		for(Map.Entry<String, Map<Long,String>> gEntry : pb.entrySet()) {
//			String gName = gEntry.getKey();
			Map<Long, String> entry = gEntry.getValue();
			for(Map.Entry<Long, String> info : entry.entrySet()) {
				long pNum = info.getKey();
//				while(found == false) {
				if(String.valueOf(pNum).contains(String.valueOf(partialPNum))) {
					String gName = gEntry.getKey();
					String pName = info.getValue();
					System.out.println("Group name: " + gName + "Member Name: " + pName + "Phone #: " + pNum);
//					found = false;
				} 
				if(!String.valueOf(pNum).contains(String.valueOf(partialPNum))) {
					System.out.println("No member matches with those numbers.");
				}
				}
			}
		
		}
//		}
//				String pName = info.getValue();
//				if(info.getKey().equals(partialPNum)) {
			
		
		
		
		
		
//		long numPart = sc.nextlong();
//		info.keySet();
	
		
	
	public static void printAllByName() {
		String partialName;
		System.out.println("Type in member's name to get the lists of members who are under those parts of names");
		partialName = sc.nextLine();
		
		for(Map.Entry<String, Map<Long,String>> pEntry : pb.entrySet()) {
//			String gName = pEntry.getKey();
			Map<Long,String> entry = pEntry.getValue();
			for(Map.Entry<Long, String> info : entry.entrySet()) {	
				String pName = info.getValue();
				if (pName.contains(partialName)) {	
					String gName = pEntry.getKey();
					long pNum = info.getKey();
					
					System.out.println("Group name: " + gName + "Member Name: " + pName + "Phone #: " + pNum);	
				} 
				if (!pName.contains(partialName)) {
					System.out.println("No member matches with those partial names");
				}
			}
		}
	}
	
	public static void exitPb() {
		System.out.println("Exiting the phonebook program!");	
		System.exit(0);	
		
	}
	
	
	
	
}



