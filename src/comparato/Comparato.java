package comparato;

/**
 * Created by Administrator on 13.01.2016.
 */
public class Comparato implements Comparable<Comparato> {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Comparato o) {
        return  this.name.compareTo(o.getName());

    }
}
