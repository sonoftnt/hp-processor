package com.tnt.hp.ServiceImpl;

import com.tnt.hp.Entity.Event;
import com.tnt.hp.Repository.EventRepo;
import com.tnt.hp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepo eventRepo;

    @Override
    public void addEvent(Event event) {
        String contactEmail;
        if(event.isContactEmailSameAsRegisteredEmail()){
            event.setContactEmail(event.getRegisteredEmail());
        }
        eventRepo.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}
