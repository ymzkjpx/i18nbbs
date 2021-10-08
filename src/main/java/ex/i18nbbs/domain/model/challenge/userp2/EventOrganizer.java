package ex.i18nbbs.domain.model.challenge.userp2;

public class EventOrganizer {
    EventOrganizerNumber eventOrganizerNumber;
    Attendee attendee;

    public EventOrganizer(EventOrganizerNumber eventOrganizerNumber, Attendee attendee) {
        this.eventOrganizerNumber = eventOrganizerNumber;
        this.attendee = attendee;
    }

    public EventOrganizerNumber eventOrganizerNumber() {
        return eventOrganizerNumber;
    }

    public Attendee attendee() {
        return attendee;
    }
}
