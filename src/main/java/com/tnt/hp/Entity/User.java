package com.tnt.hp.Entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "user")
public class User {
    @Id
    private String emailId;
    @Indexed(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
}
