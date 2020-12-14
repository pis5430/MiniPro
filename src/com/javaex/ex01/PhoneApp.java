package com.javaex.ex01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		
		//switch로 다시 해보기

		Reader fr = new FileReader("C:\\javaStudy\\강의자료\\02.Java_Programming\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		List<Person> person = new ArrayList<Person>();

		Scanner sc = new Scanner(System.in);

		System.out.println("********************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("********************************************");

		while (true) {
			System.out.println("1. 리스트  2. 등록  3.삭제  4.검색  5.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">메뉴번호: ");

			String menu = sc.nextLine(); //입력값

			if ("5".equals(menu)) { //종료
				System.out.println("********************************************");
				System.out.println("*                감사합니다                *");
				System.out.println("********************************************");
				break;
			} else if ("1".equals(menu)) { //1번 리스트 출력을 먼저 해줘야 3번,4번이 오류없이 실행됨 --> 방법찾기
				System.out.println("<1.리스트>");

				while (true) {
					String str = br.readLine(); //한줄씩 읽어오기

					if (str == null) { // 읽어올 문장이 없으면 종료
						break;
					}

					String[] tArray = str.split(","); //,을 기준으로 배열 나누기
					person.add(new Person(tArray[0], tArray[1], tArray[2]));
				}

				for (int i = 0; i < person.size(); i++) {
					System.out.print(i+1 + ".  ");
					person.get(i).showInfo();
				}
				System.out.println("");
			} else if ("2".equals(menu)) { //등록
				System.out.println("<2.등록>");
				
				String name , hp, company;

				System.out.print(">이름: ");
				name = sc.nextLine();
				System.out.print(">휴대전화: ");
				hp = sc.nextLine();
				System.out.print(">회사전화: ");
				company = sc.nextLine();

				Person p01 = new Person(name, hp, company);

				person.add(p01);

				System.out.println("[등록되었습니다.]");
				System.out.println("");
			} else if ("3".equals(menu)) { //삭제
				System.out.println("<3.삭제>");

				System.out.print(">번호: ");
				int num = sc.nextInt();

				person.remove(num);
				sc.nextLine();
				System.out.println("[삭제되었습니다.]");
				System.out.println("");
			} else if ("4".equals(menu)) { //검색
				System.out.println("<4.검색>");

				System.out.print(">이름: ");
				String name = sc.nextLine();

				for (int i = 0; i < person.size(); i++) {
					
					// >> 포함 여부만을 true, false로 반환
					if (person.get(i).getName().contains(name)) { 
						person.get(i).showInfo();
					//contains() 대상 문자열에 특정 문자열이 포함되어 있는지 확인하는 함수 , 대소문자도 구분
					//공백도 체크함 ,  포함여부를 true, false 로 나타냄
					//특정 문자를 가지고 있는 i를 호출하여 출력
						
					//indexOf()	문자열내에서 보다 작은 단위의 문자열을 찾을때 사용
					//검색 기능을 가진 함수 
						
						
					}
				}
				System.out.println("");
			} else {
				System.out.println("[다시 입력해주세요.]");
				System.out.println("");
			}
		}
		br.close();
		sc.close();

	}

}