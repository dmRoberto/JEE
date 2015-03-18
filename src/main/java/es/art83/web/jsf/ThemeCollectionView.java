package es.art83.web.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ThemeCollectionView {

    private List<Theme> themes;

    private String themeId;

    @PostConstruct
    public void update() {
        themes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            themes.add(new Theme(i, "name" + i, "description" + i));
        }
        System.out.println("themes: " + themes);
    }


    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public String getThemeId() {
        return themeId;
    }


    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }


    public String process() {
        System.out.println("theme id: " + themeId);
        return null;
    }

}
