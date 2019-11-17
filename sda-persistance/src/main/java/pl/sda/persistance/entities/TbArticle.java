package pl.sda.persistance.entities;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="TB_ARTICLE")
public class TbArticle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AR_ID")
    private int id;
    @JoinColumn(name = "AR_USER_ID", nullable = false)
    @ManyToOne
    private TbUser user;
    @Column(name = "AR_Content")
    private String content;
}
