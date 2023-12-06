package dvdrental.pg.jsf.view;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import dvdrental.pg.jsf.entities.Actor;
import dvdrental.pg.jsf.repos.ActorJpaRepository;

import java.io.Serializable;
import java.util.List;

@Named("dtActorView")
@ViewScoped
public class ActorViewBean implements Serializable {

    private List<Actor> actors;

    @Inject
    private transient ActorJpaRepository service;

    @PostConstruct
    public void init() {
        actors = service.findAll();
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setService(ActorJpaRepository service) {
        this.service = service;
    }
}
