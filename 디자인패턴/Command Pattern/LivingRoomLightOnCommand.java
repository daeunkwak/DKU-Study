package Command;

// command를 setting해주는 함수를 만들자
public class LivingRoomLightOnCommand implements Command{
    Light light;

    public LivingRoomLightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
