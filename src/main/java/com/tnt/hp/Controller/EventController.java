package com.tnt.hp.Controller;


import com.tnt.hp.Entity.Event;
import com.tnt.hp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Event")
public class EventController {

    @Autowired
    EventService eventService;

    /*SAMPLE EVENT JSON OBJECT
    {
        "registeredEmail":"test@gmail.com",
        "eventName" : "xyz event",
        "eventAddress": "xyz lane"
        "contactEmail":"",
        "contactNumber1":"1234567",
        "contactNumber2": "",
        "eventDate":"",
        "eventStartTime":"",
        "eventDuration": "3 hrs"
        "contactEmailSameAsRegisteredEmail" : true
    }*/

    @PostMapping("/addEvent")
    public void addEvent(@RequestBody Event event) {
        System.out.println(event);
        eventService.addEvent(event);
    }

    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }


}

