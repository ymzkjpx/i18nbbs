package ex.i18nbbs.domain.model.challenge.userp1;

public class EventOrganizer {
    EventOrganizerNumber eventOrganizerNumber;
    EventOrganizerName eventOrganizerName;

    public EventOrganizer(EventOrganizerNumber eventOrganizerNumber, EventOrganizerName eventOrganizerName) {
        this.eventOrganizerNumber = eventOrganizerNumber;
        this.eventOrganizerName = eventOrganizerName;
    }

    public EventOrganizerNumber eventOrganizerNumber() {
        return eventOrganizerNumber;
    }

    public EventOrganizerName eventOrganizerName() {
        return eventOrganizerName;
    }
}
