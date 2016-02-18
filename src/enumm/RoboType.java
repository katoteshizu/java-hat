package enumm;

/**
 * Created by Administrator on 11.01.2016.
 */
public enum RoboType {
    TYPE1 {
        @Override
        public void doTask() {
            super.doTask();
            System.out.println("TYPE1 method");
        }
    }, TYPE2 {
        @Override
        public void doTask() {
            super.doTask();
            System.out.println("TYPE2 method");
        }
    };

    public void doTask() {
        System.out.println("Enum method");
    }

    public static void main(String[] args) {
        RoboType current = RoboType.TYPE1;
        current.doTask();
        current = RoboType.TYPE2;
        current.doTask();
        Enum enOut1 = RoboType.valueOf("TYPE1");
//        Enum enOut2 = RoboType.valueOf("XXXX");
        System.out.println("TYPE1: " + enOut1);
    }
}
