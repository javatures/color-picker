package color.picker;

public class Color {
    private int red;
    private int green;
    private int blue;
    User creator;
    String name;

    public Color(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(String name, int red, int green, int blue){
        this.name = name;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
