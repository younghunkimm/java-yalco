package org.example.sec07.chap01.ex02;

import java.util.Objects;

public class Click {
    int x;
    int y;
    int timestamp;

    public Click(int x, int y, int timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }

    //  ⭐️ 아래를 주석해제하고 다시 실행해 볼 것
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Click)) return false;
        return this.x == ((Click) obj).x && this.y == ((Click) obj).y;
    }

    // 생성 명령어를 사용하여 toString(), equals() 메소드들을 자동생성할 수 있다.
    @Override
    public String toString() {
        return "Click{" +
                "x=" + x +
                ", y=" + y +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
