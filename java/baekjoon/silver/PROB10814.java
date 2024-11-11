package silver;

import java.io.*;
import java.util.*;

public class PROB10814 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static List<User> users;

    static class User {
        int age;
        int order;
        String name;

        User(int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        sort();
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        users = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int age = Integer.parseInt(input[0]);
            String name = input[1];
            users.add(new User(age, i, name));
        }
    }

    public static void sort() {
        users.sort((u1, u2) -> {
            if (u1.age == u2.age)
                return u1.order - u2.order;

            return u1.age - u2.age;
        });
    }

    public static void print() {
        for (User user : users) {
            System.out.println(user.age + " " + user.name);
        }
    }
}
