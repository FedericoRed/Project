package ese.zoo;
import java.util.Arrays;

public enum Direction {
    NORTH ("north"),
    SOUTH ("south"),
    EAST ("east"),
    WEST ("west");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Direction of(String s) {
        return Arrays.stream(values())
                .filter(d -> s.equalsIgnoreCase(String.valueOf(d)))
                .findAny()
                .orElse(null);
    }

}
