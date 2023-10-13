package com.tnt.hp.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Document(collection = "event")
public class Event {
    @Id
    private String eventId =  UUID.randomUUID().toString();
    @Indexed(unique = true)
    private String registeredEmail;
    private String eventName;
    private String eventAddress;
    private String contactEmail;
    private String contactNumber1;
    private String contactNumber2;
    private Date eventDate;
    private String eventStartTime;
    private String eventDuration;
    private boolean contactEmailSameAsRegisteredEmail;
}
