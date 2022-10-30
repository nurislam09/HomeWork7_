package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String videoLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_ID")
    private Course course;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "lesson_ID")
    private List<Task> tasks = new ArrayList<>();

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }

    private Course course2(Long ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, ID);
        entityManager.getTransaction().begin();
        entityManager.close();
        return course1;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }
}
