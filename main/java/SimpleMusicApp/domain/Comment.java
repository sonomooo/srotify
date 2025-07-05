package SimpleMusicApp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String content;

    @Column
    private String author;

    @ManyToOne
    @JoinColumn(name = "post_id") //fk값 지정
    private Post post;

}
