package day05;

import java.util.Arrays;

public class ArrayExample {

	public static void main(String[] args) {
		// 배열
		// 같은 타입의 변수를 한번에 여러개 선언하는 방법.
		
		// 배열의 선언 방법
		// 1. 타입[] 변수명 = new 타입명[배열의 길이];
		// 2. 타입[] 변수명 = {데이터, ,---}
		// 3. 타입[] 변수명 = new 타입명[] {데이터};
		
		int[] number = new int[10];
		boolean[] win = {true, false, false, false, true};
		String[] welcome = new String[] {
				"오늘 날씨는 흐리고 비 입니다.", 
				"배고파요. 여러분은 어때요?", ""
						+ "모두 잘 오셨습니다."
		};

		System.out.println(welcome[0]);
		System.out.println("welcome 배열의 길이: " + welcome.length);
		System.out.println(number); //??출력법은?
		System.out.println(number.length);
		System.out.println(win);
		System.out.println(win.length);
		
		for (int i = 0; i < welcome.length; i++) { // 0 1 2
			System.out.println(welcome[i]); 
//			오늘 날씨는 흐리고 비 입니다.
//			배고파요. 여러분은 어때요?
//				모두 잘 오셨습니다.
		}
		
		// Enhanced For문
		System.out.println("\nEnhanced for문을 이용한 반복");
		for(String str: welcome) { //for(타입 변수명: 선언된 변수)
			System.out.println(str);
		}
//		Enhanced for문을 이용한 반복
//		오늘 날씨는 흐리고 비 입니다.
//		배고파요. 여러분은 어때요?
//		모두 잘 오셨습니다.
		
		for(int i = 0; i<win.length; i++) {
			if(win[i]) { //	true일 땐 위쪽, false는 else 아래쪽을 출력
				System.out.println(i+1 + "번째 전적: 승리");
			} else {
				System.out.println(i+1 + "번째 전적: 패배");
			}
		}
//		1번째 전적: 승리
//		2번째 전적: 패배
//		3번째 전적: 패배
//		4번째 전적: 패배
//		5번째 전적: 승리
		
		
		// 배열의 내용 출력(Arrays.toString() 메서드를 사용- static메서드)
		System.out.println(Arrays.toString(win));
		System.out.println(Arrays.toString(number));	
		System.out.println(Arrays.toString(welcome));
		
		// 배열은 선언시 자동적으로 기본값으로 초기화
		// 정수: 0, 실수: 0.0, boolean: false, 참조형: null
		String[] byeMessage = new String[10];
		System.out.println(Arrays.toString(byeMessage)); //참조형은 (obj)형으로 선택 //[null, null, null, null, null, null, null, null, null, null]
		
		// 배열의 복사
		// 배열의 얕은 복사(shallow copy)와 깊은 복사(deep copy)
		String[] byeMessage2 = new String[] {"good bye", "bye bye", "see you"};
		
		// shallow copy는 byeMessage 변수에 byeMessage2의 주소자체를  byeMessage가 갖고 있는 곳으로 변경. 값을 복사한게 아니다.
		// 얕은 복사
//		byeMessage = byeMessage2;
//		byeMessage2[1] = "hello bye bye";
//		System.out.println(Arrays.deepToString(byeMessage));
		
		// 깊은 복사 (deep copy)
		// System.arraycopy(src, srcPos, dest, destPos, length);
		// src: 원본 배열의 이름
		// srcPos: 복사를 시작할 원본의 위치
		// dest: 붙여넣기 할 배열의 이름(destination)
		// destPos: 붙여넣기를 시작할 위치를 설정
		// length: 복사를 몇 개나 할 것인지 결정
		
//		System.arraycopy(byeMessage2, 1, byeMessage, 5, 1);
//		System.out.println("bye1: " + Arrays.toString(byeMessage));
//		System.out.println("bye2: " + Arrays.toString(byeMessage2));
//		
//		byeMessage[0] = "Good bye!!";
//		System.out.println("bye1: " + Arrays.toString(byeMessage));
//		System.out.println("bye2: " + Arrays.toString(byeMessage2));
		
		// 깊은 복사를 통해서 byeMessage에 byeMessage2에 있는 배열의 값을 모두 다 복사하세요.
		
		System.arraycopy(byeMessage2, 0, byeMessage, 0, 3);
		System.out.println("byeMessage: " + Arrays.toString(byeMessage));
		
	}

}
