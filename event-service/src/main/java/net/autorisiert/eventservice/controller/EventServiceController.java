package net.autorisiert.eventservice.controller;

import net.autorisiert.eventservice.helper.EntityExtensions;
import net.autorisiert.eventservice.model.Event;
import net.autorisiert.eventservice.model.EventDto;
import net.autorisiert.eventservice.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class EventServiceController {

    private static final Logger log = LoggerFactory.getLogger(EventServiceController.class);

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/allocateTicket")
    public String allocateTicket(@RequestBody String eventId){
        log.info("allocate ticket for {}", eventId);
        Event event = eventRepository.findOne(eventId);
        event.setTicketsBooked(event.getTicketsBooked() + 1);
        eventRepository.save(event);
        return UUID.randomUUID().toString();
    }

    @RequestMapping(value = "/{id}", produces = {"application/xml", "application/json"})
    @ResponseBody
    public EventDto FindByid(@PathVariable String id){
        Event ev = eventRepository.findOne(id);
        EventDto dto = EntityExtensions.ToDto(ev);
        return dto;
    }

    @PostMapping("save")
    public EventDto SaveDto(@RequestBody EventDto dto, BindingResult result){
        List<ObjectError> allErrors = result.getAllErrors();
        return dto;
    }
}
