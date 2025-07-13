package org.example.sec06.chap07.ex01;

/**
 * ⭐️ 레코드로 작성
 * - JavaScript의 JSON, C의 구조체 같은 개념
 * - 레코드는 `final`
 *     - 다른 클래스로 상속되거나 `abstract` 로 선언 불가
 * - 레코드의 각 항목들은 `private`, `final`
 *     - 각각 같은 이름의 getter가 기본으로 만들어짐
 * - 인스턴스 필드를 가질 수 없음
 *     - 클래스 필드는 가능
 */
public record Child(
        String name,
        int birthYear,
        Gender gender
) {}
