//package com.codeup.springbootblog.models;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @Column(unique = true, nullable = false)
//    private String username;
//
//    private String password;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<Post> posts;
//}
