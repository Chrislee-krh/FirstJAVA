package day19;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class LambdaConsumer {

	public static void main(String[] args) {
		// Consumer Interface 매개 변수는 있고, 반환 값은 없다!
		
		// 객체 타입 하나를 매개변수
		Consumer<String> c1 = name -> System.out.println("제 이름은 "+name+"입니다.");
		c1.accept("홍길동");
		
		// 객체 타입 두 개
		BiConsumer<String, String> c2 = (lastname, firstname) -> {
			System.out.println("제 이름은 "+lastname+firstname+"입니다");
		};
 		c2.accept("홍", "길동");
 		
 		// 매개변수 값이 더블
 		DoubleConsumer c3 = (score) -> System.out.println(" 제 점수는" + score +"점 입니다.");
 		c3.accept(96.9);
 		
 		// 매개변수 값이 객체와 int인 경우
 		ObjIntConsumer<String> c4 = (lecture, i) -> {
 			System.out.println("제 " + lecture+"의 점수는 "+ i+"점 입니다.");
 		};
 		c4.accept("국어", 100);
 		
	}
}
