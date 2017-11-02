package transferObjects;

public class PlaceTO {
    private Long id;
    private String name;
    private int vote;

    public PlaceTO(Long id, String name, int vote) {
        this.id = id;
        this.name = name;
        this.vote = vote;
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
}
