package es.art83.web.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BeanFinalView {

    @ManagedProperty(value = "#{beanInitialView}")
    private BeanInitialView beanInitialView;

    private String name2;

    @PostConstruct
    public void update() {
        name2 = beanInitialView.getName();
    }

    public String process() {
        return null;
    }

    public void setBeanInitialView(BeanInitialView beanInitialView) {
        this.beanInitialView = beanInitialView;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
