package domain;

import org.hibernate.type.LocalDateTimeType;

import javax.persistence.*;


@Entity
@Table(name = "t_reservation")
public class Reservation {


    @Id
    @GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq",
                      sequenceName = "reservation_id_seq",
                      initialValue = 1000,
                      allocationSize = 5)
    private Long id;


    @Column(nullable = false)
    //private LocalDate checkIn;
    private LocalDateTimeType checkIn;

    @Column(nullable = false)
    private LocalDateTimeType checkOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)//opsiyonel
    private Guest guest;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Room room;

    //getter-setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTimeType getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTimeType checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTimeType getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTimeType checkOut) {
        this.checkOut = checkOut;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
