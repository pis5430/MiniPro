package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		//미완성
		
		Reader fr = new FileReader("C:\\javaStudy\\강의자료\\02.Java_Programming\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Person> pList = new ArrayList<Person>();
		
		Scanner sc = new Scanner(System.in);
		Person ps = new Person();
		
		System.out.println("********************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("********************************************");

		
		while(true) {
			
			System.out.println("1. 리스트  2. 등록  3.삭제  4.검색  5.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">메뉴번호: ");
			
			int num = sc.nextInt();
			
			switch(num) { //입력값에 대한 출력
				case 1: 
					System.out.println("<1.리스트>");
					while(true) {
					String str = br.readLine();
						
					if(str == null) { //읽어올 문장이 없으면 종료
						break;
					}
						
					String[] tArray = str.split(","); // ","을 기준으로 배열 나누기
					Person p01 = new Person(tArray[0],tArray[1],tArray[2]);

					pList.add(p01); //기존 내용을 리스트에 추가
						
					for(int i=0; i<pList.size(); i++) {
						System.out.print(pList.size()+".   " );
						p01.showInfo();
						break;
						}
					}
					break;
					
				case 2: 
					String name, hp, company;
					
					System.out.println("<2.등록>"); // 엔터값 확인하기
					System.out.print(">이름: ");
					name = sc.next();	
					System.out.print(">휴대전화: ");
					hp = sc.next();
					System.out.print(">회사전화: ");
					company = sc.next();

					
					Person p02 = new Person(name,hp,company);
					
					pList.add(p02); // 새로운 값 등록
					
					System.out.println("[등록되었습니다.]");
					break;
					
				case 3:
					System.out.println("<3.삭제>");
					break;
				case 4: 
					System.out.println("<4.검색>");
					break;
				case 5: 
					System.out.println("********************************************");
					System.out.println("*                감사합니다                *");
					System.out.println("********************************************");
					break;
				default: System.out.println("[다시 입력해 주세요]");
					break;
			}
			
			if(num == 5 ) { // 5를 입력시 종료
				break;
			}
			
		
		}
		
		br.close();
		sc.close();

	}

}
