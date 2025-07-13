package org.example.sec07.chap01.ex01;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button("엔터", Button.Mode.DARK, 3);

        /**
         * `toString` 메소드
         * - 기본적으로는 클래스명과 해시명을 반환
         * - `println` 메소드로 객체 출력시 기본적으로 이 메소드의 결과값 출력
         * - intelliJ 코드 생성 메뉴에서 선택
         */

        //  💡 메소드를 ctrl/command + 클릭하여 Object 클래스 사양 살펴보기
        System.out.println(button1); // ⭐️ toString() 을 붙인 것과 같음
    }
}
