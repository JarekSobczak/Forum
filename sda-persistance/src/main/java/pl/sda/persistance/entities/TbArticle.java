package pl.sda.persistance.entities;

import com.google.gson.annotations.Expose;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="TB_ARTICLE")
public class TbArticle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AR_ID")
    @Expose
    private int id;
    @JoinColumn(name = "AR_USER_ID", nullable = false)
    @ManyToOne
    @Expose
    private TbUser user;
    @Column(name = "AR_Content")
    @Expose
    private String content;
    @Column(name = "AR_Title")
    @Expose
    private String title;
}
