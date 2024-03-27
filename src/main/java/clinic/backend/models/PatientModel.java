package clinic.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="patients")
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @MapsId
    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserModel user;
}
