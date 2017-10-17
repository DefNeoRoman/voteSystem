package model;

import java.io.DataOutputStream;
import java.util.Date;

public class Place extends BaseEntity {

    private int votes;

    public Place() {
        this.votes = 0;
    }

    public Place(String uuid, String name) {
        super(uuid, name);
        this.votes = 0;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }


}
