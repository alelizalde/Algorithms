package com.practices;

import java.util.Arrays;

public class Java13 {

    private static void PrintVar() {
        var list = Arrays.asList(1, 2, 3, 4);
        for (var x: list){
            System.out.println(x);
        }
    }

    private static void PrintTextBlock() {
        String json = """
                {
                    id:1,
                    name:"Al"
                    gender: "Male"
                }
                """;
        System.out.println(json);

        var x = String.format("Hello, %s %s!", "Java", "13");
        System.out.println(x);
        x = String.format("""
                {
                id: %d,
                name: %s,
                gender: %s
                }
                """,1, "Al Elizalde", "Male");
        System.out.println(x);
    }

    private static void Switch(int x) {
        var y = switch(x) {
          case 1 -> "one";
          case 2 -> "two";
          default -> "other";
        };
        System.out.println(y);
    }

    public static void main(String[] args) {
        PrintVar();
        PrintTextBlock();
        Switch(2);
        Switch(3);
    }
}
