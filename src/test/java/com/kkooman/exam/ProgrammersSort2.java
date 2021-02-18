package com.kkooman.exam;

import java.util.*;

/**
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * <p>
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * <p>
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */
public class ProgrammersSort2 {
	
	public static void main(String[] args) {
		int[] type99 = new int[100000];
		for (int i = 0; i < type99.length; i++) {
			type99[i] = (int) (Math.random() * 100000);
		}
		System.out.println(new ProgrammersSort2().solution(new int[]{3, 30, 31, 34, 33, 5, 9}).equals("95343333130")); // 9 5 34 33 3 31 30
		System.out.println(new ProgrammersSort2().solution(new int[]{6, 10, 2}).equals("6210"));
		System.out.println(new ProgrammersSort2().solution(new int[]{3, 30, 34, 5, 9}).equals("9534330"));
		System.out.println(new ProgrammersSort2().solution(new int[]{1, 11, 111, 1111}).equals("1111111111"));
		System.out.println(new ProgrammersSort2().solution(new int[]{0, 0, 0, 0, 0, 0}).equals("0"));
		System.out.println(new ProgrammersSort2().solution(new int[]{0, 0, 0, 1, 0, 0}).equals("100000"));
		System.out.println(new ProgrammersSort2().solution(new int[]{3054, 305}).equals("3054305"));
		System.out.println(new ProgrammersSort2().solution(new int[]{40, 405}).equals("40540"));
		System.out.println(new ProgrammersSort2().solution(new int[]{40, 404}).equals("40440"));
		System.out.println(new ProgrammersSort2().solution(new int[]{70, 0, 0, 0}).equals("70000")); // 70000
		System.out.println(new ProgrammersSort2().solution(new int[]{0, 0, 0, 1000}).equals("1000000")); // 1000000
		System.out.println(new ProgrammersSort2().solution(new int[]{1, 11, 111, 1111}).equals("1111111111")); // 1111111111
		System.out.println(new ProgrammersSort2().solution(new int[]{10, 101}).equals("10110"));
	}
	
	public String solution(int[] numbers) {
		int[] ia = Arrays.stream(numbers).boxed().sorted((a, b) -> ((b + "" + a).compareTo(a + "" + b))).mapToInt(i -> i).toArray();
		StringBuilder builder = new StringBuilder();
		if (ia[0] == 0) {
			builder.append("0");
		} else {
			for (int i = 0; i < ia.length; i++) {
				builder.append(ia[i]);
			}
		}
		return builder.toString();
	}
	
	public String 또실패(int[] numbers) {
		Integer[][] newArray = new Integer[numbers.length][2];
		final int[] std = {0, 100000, 10000, 100, 10, 1};
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 0) {
				int digits = (int) (Math.log10(numbers[i]) + 1);
				newArray[i][0] = numbers[i] * std[digits];
				newArray[i][1] = digits;
			} else {
				newArray[i][0] = 0;
				newArray[i][1] = 0;
			}
		}
		Arrays.sort(newArray, (o1, o2) -> {
			if (o1[0].intValue() > o2[0].intValue()) {
				return -1;
			} else if (o1[0].intValue() == o2[0].intValue()) {
				return 0;
			}
			return 1;
		});
		
		StringBuilder builder = new StringBuilder();
		if (newArray[0][0] == 0) {
			builder.append("0");
		} else {
			for (int i = 0; i < newArray.length; i++) {
				builder.append(newArray[i][0] / std[newArray[i][1]]);
			}
		}
		return builder.toString();
	}
}
