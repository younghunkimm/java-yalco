package org.example.sec07.chap04;

public enum Side {
    RED("레드"), BLUE("블루");
    private String name;

    Side(String name) { this.name = name; }

    public String getName() { return name; }
}
