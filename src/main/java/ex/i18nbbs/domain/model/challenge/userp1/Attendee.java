package ex.i18nbbs.domain.model.challenge.userp1;

public class Attendee {
    AttendeeNumber attendeeNumber;
    AttendeeName attendeeName;

    public Attendee(AttendeeNumber attendeeNumber, AttendeeName attendeeName) {
        this.attendeeNumber = attendeeNumber;
        this.attendeeName = attendeeName;
    }

    public AttendeeNumber attendeeNumber() {
        return attendeeNumber;
    }

    public AttendeeName attendeeName() {
        return attendeeName;
    }
}
