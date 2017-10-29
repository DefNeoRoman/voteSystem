package model;

import java.io.DataOutputStream;
import java.util.Date;

public class Place  {

    private int votes;

    public Place() {
        this.votes = 0;
    }

    public Place(Integer id, String name) {

        this.votes = 0;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }


}
