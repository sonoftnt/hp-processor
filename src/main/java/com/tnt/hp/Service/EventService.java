package com.tnt.hp.Service;

import com.tnt.hp.Entity.Event;

import java.util.List;

public interface EventService {

    public void addEvent(Event event);

    public List<Event> getAllEvents();
}
