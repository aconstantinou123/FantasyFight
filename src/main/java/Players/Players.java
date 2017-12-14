package Players;

import java.util.ArrayList;

public class Players {

    private ArrayList<Player> players;

    public Players(){
        this.players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        this.players.add(player);
    }
}
