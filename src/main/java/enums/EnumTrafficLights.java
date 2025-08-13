package enums;

public enum EnumTrafficLights {
    RED("Stop"),
    YELLOW("Wait"),
    GREEN("Go");

    private String action;

    //constructeur private car on peut pas instancier un enum
    private EnumTrafficLights(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

class TrafficLightTest {
    public static void main(String[] args) {
        EnumTrafficLights[] lights = EnumTrafficLights.values();

        for(EnumTrafficLights light : lights){
            System.out.println("Light : "+light.name()+" Action : "+light.getAction()+" Order in enum : "+light.ordinal()+" To String : "+ light);
        }
    }
}
