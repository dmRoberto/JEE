package es.art83.web.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ThemeCollectionView {

    private List<Theme> themes;

    private int themeId = 0;

    @PostConstruct
    public void update() {
        System.out.println("Se actualizan datos de la capa de negocio");
        themes = new ArrayList<>();
        themes.add(new Theme(0, "Elige", ""));
        for (int i = 1; i < 5; i++) {
            themes.add(new Theme(i, "name" + i, "description" + i));
        }
    }

    public String process() {
        System.out.println("Se accede a la capa de negocio --->>> themeId: " + themeId);
        return null;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

}
