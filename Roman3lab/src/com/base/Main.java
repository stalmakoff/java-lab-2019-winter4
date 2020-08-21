package com.base;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        User user = new User("Ivan", "Credo32", "lolkarvalol", LocalDate.of(1970, 1, 20));
        user.addPost(new Post(LocalDate.of(2019, 12, 10), "some text"));
        user.addPost(new Post(LocalDate.of(2019, 12, 16), "some text"));
        user.addPost(new Post(LocalDate.of(2019, 9, 10), "some text"));
        System.out.println(user.rating());
        System.out.println(user);
        User user1 = new User("Andrey", "kekcheburek", "qwertyu", LocalDate.of(1891,2,1));
        user.addPost(new Post(LocalDate.of(2019, 12, 16), "some text"));
        user.addPost(new Post(LocalDate.of(2019, 9, 10), "some text"));
        System.out.println(SuperUser.passAndLoginChecking(user.getLogin(), user.getPass()));
        SuperUser su = new SuperUser("Nikolay", "rere", "qwer", LocalDate.of(1976, 3,2));
        su.addUser(user);
        su.addUser(user1);
        su.comparator();

        for ( User userOne: su.getUsers()) {
            System.out.println(userOne);
        }

    }
}
