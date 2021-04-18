package color.picker;

import java.awt.Color;
import java.util.HashMap;
import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private HashMap<UUID, Color> colors;
    public User(String username){
        this.username = username;
        this.id = UUID.randomUUID();
        this.colors = new HashMap<UUID, Color>();
    }

    public void addColor(Color color){
        UUID key = UUID.randomUUID();
        this.colors.put(key, color);
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public HashMap<UUID, Color> getColors() {
        return colors;
    }

}
