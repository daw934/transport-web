package pl.transport.transportapp.UserAuth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class VerificationToken {
//    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

//    private Date expiryDate;


    public VerificationToken() {
    }

    public VerificationToken(User user, String token ) {
        this.token = token;
        this.user = user;

    }

//    private Date calculateExpiryDate(int expiryTimeInMinutes) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Timestamp(cal.getTime().getTime()));
//        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
//        return new Date(cal.getTime().getTime());
//    }
}
