package enumerato;

/**
 * Created by Administrator on 05.01.2016.
 */
public enum EnumDean {
    MMF("Bender"), FPMI("Fry"), GEO("Zoydberg");
    String name;

    EnumDean(String arg) {
        name = arg;
    }

    String getName() {
        return name;
    }
}
