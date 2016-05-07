package by.home.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Darya on 28.04.16.
 */
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "explanation", nullable = false)
    private String explanation;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercise")
    private List<OptionExercise> options;

    public Exercise() {
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<OptionExercise> getOptions() {
        return options;
    }

    public void setOptions(List<OptionExercise> options) {
        this.options = options;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
