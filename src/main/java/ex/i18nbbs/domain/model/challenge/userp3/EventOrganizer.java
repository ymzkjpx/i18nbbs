package ex.i18nbbs.domain.model.challenge.userp3;

public class EventOrganizer {
    EventOrganizerNumber eventOrganizerNumber;
    EventOrganizerName eventOrganizerName;
    UserType userType = UserType.管理者;

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

    public UserType userType() {
        return userType;
    }
}
