package pl.sda.persistance.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "US_USER_NAME")
})
public class TbUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "US_ID", unique = true, nullable = false)
   private Integer user;

    @Column(name = "US_USER_NAME", unique = true, nullable = false, length = 25)
   private String login;

    @Column(name = "US_PASSWORD", nullable = false, length = 25)
    private String password;
}
