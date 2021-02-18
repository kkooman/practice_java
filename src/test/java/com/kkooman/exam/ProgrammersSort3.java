package com.kkooman.exam;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 문제 설명
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 * <p>
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 * <p>
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
 * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 */
public class ProgrammersSort3 {
	
	public static void main(String[] args) {
		System.out.println(new ProgrammersSort3().solution(new int[]{0,0,0}) == 0);
		System.out.println(new ProgrammersSort3().solution(new int[]{3, 0, 6, 1, 5}) == 3);
		System.out.println(new ProgrammersSort3().solution(new int[]{12,11,10,9,8,1}) == 5);
		System.out.println(new ProgrammersSort3().solution(new int[]{6,6,6,6,6,1}) == 5);
		System.out.println(new ProgrammersSort3().solution(new int[]{20,21,22,23}) == 4);
		System.out.println(new ProgrammersSort3().solution(new int[]{4,4,4,}) == 3);
	}
	
	
	public int solution(int[] citations) {
		int sum = Arrays.stream(citations).sum();
		if(sum == 0) {
			return 0;
		}
		/*저널에 등재한 전체 논문중 많이 인용된 순으로 정렬한 후, 피인용수가 논문수와 같아지거나 피인용수가 논문수보다 작아지기 시작하는 숫자가 바로 나의 h가 됩니다.
		이 표에서는 10이 H-지수가 되는 것입니다. 다시 말하여, 이 연구원은 논문 인용횟수가 10이 넘는 논문이 적어도 10편이 된다는 것을 의미합니다.
		45 5 <- 표 다름
		40 4
		5  3
		2  2
		1  1
		*/
		int[] sortedArray = Arrays.stream(citations).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
		int hindex = 0;
		for (int i = 0; i < sortedArray.length; i++) {
			if(sortedArray[i] <= i) {
				hindex = i;
				break;
			}
		}
		if(hindex == 0) {
			hindex = citations.length;
		}
		return hindex;
		
	}
}
