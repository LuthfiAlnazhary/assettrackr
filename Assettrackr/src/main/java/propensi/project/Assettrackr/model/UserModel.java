package propensi.project.Assettrackr.model;




import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "user_model")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Size(max = 50)
    @Column(name = "username", nullable = false,unique = true)
    private String username;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 50)
    @Column(name = "tanggal_bergabung", nullable = false)
    private String tanggal_bergabung;

    @NotNull
    @Size(max = 50)
    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @NotNull
    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "divisi_id")
    private Divisi divisi;


    @NotNull
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


}
