package com.kkooman.exam;

/**
 * 문제 설명
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 */
public class ProgrammersHash2 {
	
	public boolean solution(String[] phone_book) {
		
		String min = null;
		for (String s : phone_book) {
			if(min == null) {
				min = s;
				continue;
			}
			if(min.length() > s.length()) {
				min = s;
			}
		}
		int minCount = 0;
		for (String s : phone_book) {
			if(s.indexOf(min) == 0) {
				minCount++;
			}
		}
		boolean answer = minCount == 1;
		return answer;
	}
	
	public boolean solutionV2(String[] phone_book) {
		
		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[i].startsWith(phone_book[j])) {
					return false;
				}
				if (phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// solution 으로 통과는 했으나 solutionV2가 모범답안
		String[] type1 = new String[]{"119", "97674223", "1195524421"};
		String[] type2 = new String[]{"123", "456", "789"};
		String[] type3 = new String[]{"12", "123", "1235", "567", "88"};
		System.out.println(new ProgrammersHash2().solutionV2(type1));
		System.out.println(new ProgrammersHash2().solutionV2(type2));
		System.out.println(new ProgrammersHash2().solutionV2(type3));
	}
}
