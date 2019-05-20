package net.autorisiert.eventservice.helper;

import net.autorisiert.eventservice.model.Event;
import net.autorisiert.eventservice.model.EventDto;

public class EntityExtensions {

    public static EventDto ToDto(Event event) {
        EventDto dto = new EventDto();
        dto.setName(event.getName());
        return dto;
    }

}
