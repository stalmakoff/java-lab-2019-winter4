package com.base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperUser extends User {
    private List<User> users = new ArrayList<>();
    private Post lastPost = super.getLastPost();

    public SuperUser(String name, String login, String pass, LocalDate birthdate) {
        super(name, login, pass, birthdate);
    }

    public static boolean passAndLoginChecking(String login, String pass){
        if ((pass.length() > 8) && (pass.matches(".*\\w(a-z, A-Z)\\d.*")) && (login.matches("\\w(A-Z).*\\d+.*"))) {
            return true;
        }
        return false;
    }

    public void comparator(){
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.rating()>o2.rating()){
                    return 1;
                } else if (o1.rating()<o2.rating()){
                    return -1;
                } else{
                    return 0;
                }
            }
        });
    }

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return super.getLogin() + " - " + super.getAge() + super.getLastPost().getText();
    }
}
