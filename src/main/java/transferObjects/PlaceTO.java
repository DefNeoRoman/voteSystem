package transferObjects;

import java.util.Set;

public class PlaceTO {
    private Long id;
    private String name;
    private int vote;
    private Set<MenuTO> menuTOS;

    public PlaceTO() {
    }

    public PlaceTO(Long id, String name, int vote) {
        this.id = id;
        this.name = name;
        this.vote = vote;
    }

    public PlaceTO(Long id, String name, int vote, Set<MenuTO> menuTOS) {
        this.id = id;
        this.name = name;
        this.vote = vote;
        this.menuTOS = menuTOS;
    }

    public void setMenuTOS(Set<MenuTO> menuTOS) {
        this.menuTOS = menuTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return name+"\n"+"votes:" + vote;
    }
}
