import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private int probeg;

    public Car(String name, int probeg) {
        this.name = name;
        this.probeg = probeg;
    }

    public void go() {
        for (int i = 0; i < 10; i++) {
            probeg += 10;
            System.out.println(name + " проехал 10км");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", probeg=" + probeg +
                '}';
    }
}
