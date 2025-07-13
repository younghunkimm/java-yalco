package org.example.sec06.chap06.ex02;

public class Button {
    // 클래스 안에 열거형을 선언할 수 있다.
    // 응집도가 올라간다.
    enum Mode { LIGHT, DARK }
    enum Space { SINGLE, DOUBLE, TRIPLE }

    private Mode mode = Mode.LIGHT;
    private Space space = Space.SINGLE;

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setSpace(Space space) {
        this.space = space;
    }
}
