package com.kkooman.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.stream.Collectors;

/**
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 * <p>
 * 종류	이름
 * 얼굴	동그란 안경, 검정 선글라스
 * 상의	파란색 티셔츠
 * 하의	청바지
 * 겉옷	긴 코트
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 */
public class ProgrammersHash3 {
	
	public static void main(String[] args) {
		String[][] type1 = new String[][]{{"yellow_hat", "headgear"}, {"green_turban", "headgear"}, {"blue_sunglasses", "eyewear"}};
		String[][] type2 = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(new ProgrammersHash3().solution(type1));
		System.out.println(new ProgrammersHash3().solution(type2));
	}
	
	public int solution(String[][] clothes) {
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			//의상종류, 갯수
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		
		int answer = 1;
		for (String key : map.keySet()) {
			answer *= map.get(key) + 1;
		}
		return answer - 1;
	}
	
	/**
	 * 나중에 따라 해볼 구문
	 * @param clothes
	 * @return
	 */
	public int solutionV2(String[][] clothes) {
		return Arrays.stream(clothes)
					 .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.counting())))
					 .values()
					 .stream()
					 .collect(Collectors.reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	}
}
