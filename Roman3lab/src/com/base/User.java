package com.base;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User {
    private String name;
    private String login;
    private String pass;
    private LocalDate birthdate;
    private List<Post> posts;
    private long age;
    private int rating;


    public User(String name, String login, String pass, LocalDate birthdate) {
        this.name = name;
        this.login = login;
        this.pass = pass;
        this.birthdate = birthdate;
        this.posts = new ArrayList<>();
        this.age = usersAge();
        this.rating = rating();
    }

    public long usersAge(){
        LocalDate currentDate = LocalDate.now();
        long years = ChronoUnit.YEARS.between(this.birthdate, currentDate);
        System.out.println(years);
        return years;
    }

    public void addPost(Post post){
        posts.add(post);
    }
    public int rating(){
        int count = 0;

        for (Post post: this.posts) {
            if (post.getPublicationDate().getMonth().getValue() > LocalDate.now().minusMonths(1).getMonth().getValue()){
                count++;
            }
        }
        return count;
    }

    public Post getLastPost(){
        Post lastPost = new Post(LocalDate.of(1,1,1), " ");
        for (int i =0; i< posts.size(); i++) {
            if (posts.get(i).getPublicationDate().getDayOfYear()>posts.get(i+1).getPublicationDate().getDayOfYear()){
                lastPost = posts.get(i);
            }
        }
        return lastPost;
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public long getAge() {
        return age;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.login;
    }
}
