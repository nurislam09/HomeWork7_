package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import util.Util;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String deadLine;
    private String task;
    @ManyToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = LAZY)
    private Lesson lesson;

    public Task( String name, String deadLine, String task) {
        this.name = name;
        this.deadLine = deadLine;
        this.task = task;
    }

    public Task(Long ID, String name, String deadLine, String task, Long lesson_ID) {
        this.ID = ID;
        this.name = name;
        this.deadLine = deadLine;
        this.task = task;
        this.lesson = lesson2(lesson_ID);
    }

    private Lesson lesson2(Long ID) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, ID);
        entityManager.getTransaction().begin();
        entityManager.close();
        return lesson1;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
