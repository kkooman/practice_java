package com.kkooman.exam;

import java.util.*;

/**
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */
public class ProgrammersHash {
	
	public String solution(String[] participant, String[] completion) {
		
		List<String> list = new ArrayList(Arrays.asList(participant));
		for (String human : completion) {
			if(list.indexOf(human) > -1) {
				list.remove(list.indexOf(human));
			}
		}
		
		String answer = "";
		if(!list.isEmpty()) {
			answer = list.get(0);
		}
		return answer;
	}
	
	public String solutionV2(String[] participant, String[] completion) {
		
		Map<String, Integer> map = new HashMap<>(participant.length);
		for (String human : participant) {
			map.put(human, map.getOrDefault(human, 0) + 1);
		}
		for (String human : completion) {
			map.put(human, map.get(human) - 1);
		}
		
		String answer = "";
		for (String s : map.keySet()) {
			if(map.get(s) > 0) {
				answer = s;
				break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// 정확성 100
		// 효율성 0
		String[] participant = new String[]{"leo", "kiki", "eden"};
		String[] completion = new String[]{"eden", "kiki"};
		System.out.println(new ProgrammersHash().solution(participant, completion));
		// 정확성 100
		// 효율성 100
		System.out.println(new ProgrammersHash().solutionV2(participant, completion));
	}
}
