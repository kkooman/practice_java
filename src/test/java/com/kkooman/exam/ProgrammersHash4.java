package com.kkooman.exam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * <p>
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * <p>
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 */
public class ProgrammersHash4 {
	
	public static void main(String[] args) {
		String[] type1 = new String[]{"classic", "pop", "pop", "classic", "classic", "pop", "classic"};
		int[] type2 = new int[]{500, 600, 150, 950, 800, 2500, 700};
		
		String[] type3 = new String[]{"classic"};
		int[] type4 = new int[]{500};
		
		String[] type5 = new String[]{"classic", "pop"};
		int[] type6 = new int[]{500, 600};
		
		String[] type7 = new String[]{"classic", "classic"};
		int[] type8 = new int[]{700, 600};
		
		System.out.println("\n### result 1 : " + Arrays.toString(new ProgrammersHash4().solutionV3(type1, type2)));
		System.out.println("\n### result 2 : " + Arrays.toString(new ProgrammersHash4().solutionV3(type3, type4)));
		System.out.println("\n### result 3 : " + Arrays.toString(new ProgrammersHash4().solutionV3(type5, type6)));
		System.out.println("\n### result 4 : " + Arrays.toString(new ProgrammersHash4().solutionV3(type7, type8)));
	}
	
	public int[] solutionV3(String[] genres,
							int[] plays) {
		Map<String, Integer> sumMap = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		List<Integer> list = new ArrayList<>();
		List<Map.Entry<String, Integer>> entries = sumMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
		
		int[] two_track;
		for (Map.Entry<String, Integer> entry : entries) {
			two_track = new int[]{-1, -1};
			for (int i = 0; i < genres.length; i++) {
				if (entry.getKey().equals(genres[i]) == false) {
					continue;
				}
				if (two_track[0] == -1) {
					two_track[0] = i;
					continue;
				}
				
				if (plays[two_track[0]] < plays[i]) {
					if (two_track[1] == -1) { // 1순위를 2순위로
						two_track[1] = two_track[0];
					} else if (plays[two_track[1]] < plays[i]) {
						two_track[1] = two_track[0];
					}
					two_track[0] = i; // 1순위로
				} else {
					if (two_track[1] == -1) { // 새로운 값을 2순위로
						two_track[1] = i;
					} else if (plays[two_track[1]] < plays[i]) {
						two_track[1] = i;
					}
				}
			}
			if (two_track[0] > -1) {
				list.add(two_track[0]);
			}
			if (two_track[1] > -1) {
				list.add(two_track[1]);
			}
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
