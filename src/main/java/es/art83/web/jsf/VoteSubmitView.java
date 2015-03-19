package es.art83.web.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class VoteSubmitView {

    private int themeId;

    private List<Theme> themes;

    private String question;

    private int[] votes;

    private boolean disabledVote;

    private int voteValue;

    @PostConstruct
    public void update() {
        System.out.println("Se actualizan datos de la capa de negocio");
        themes = new ArrayList<>();
        themes.add(new Theme(0, "Elige", ""));
        for (int i = 1; i < 6; i++) {
            themes.add(new Theme(i, "name" + i, "question" + i));
        }
        themeId = 0;
        this.updateVote();
        votes = new int[10];
        for (int i = 0; i < votes.length; i++) {
            votes[i] = i;
        }
    }

    private void updateVote() {
        question = themes.get(themeId).getQuestion();
        voteValue = 0;
        disabledVote = themeId == 0;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String processThemeId() {
        this.updateVote();
        return null;
    }

    public String processVote() {
        System.out.println("Se accede a la capa de negocio --->>> themeId: " + themeId
                + "; voteValue: " + voteValue);
        return null;
    }

    public int getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(int voteValue) {
        this.voteValue = voteValue;
    }

    public int getThemeId() {
        return themeId;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public String getQuestion() {
        return question;
    }

    public int[] getVotes() {
        return votes;
    }

    public boolean isDisabledVote() {
        return disabledVote;
    }

}
