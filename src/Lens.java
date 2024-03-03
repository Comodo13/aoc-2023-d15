import java.util.Objects;

public class Lens {
    String label;
    int focalLength;

    Lens(String label, int focalLength) {
        this.label = label;
        this.focalLength = focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lens lens = (Lens) o;
        return label.equals(lens.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
