package es.art83.web.jsf;

public class Theme {
    private int id;

    private String name;

    private String question;

    public Theme(int id, String name, String question) {
        super();
        this.id = id;
        this.name = name;
        this.question = question;
    }

    public Theme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Theme [id=" + id + ", name=" + name + ", question=" + question + "]";
    }

}
