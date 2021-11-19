package Command;

public class Main {
    // RemoteController의 기능들을 모두 밖으로 빼버린것!
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light bedRoomLight = new Light("Bed Room");
        TV myTV = new TV("Living Room");
        RemoteControl myRemote = new RemoteControl();

//        myRemote.setCommand(0, new LightOnCommand(new Light("Living Room")));
//        myRemote.onButton1WasPushed();
//        myRemote.onButton2WasPushed();
//        myRemote.offButton1WasPushed();
        //myRemote.setOnCommand(0, new LightOnCommand(livingRoomLight));

        // Setting 하고
        myRemote.setOnCommand(0, new LightOnCommand(livingRoomLight));
        myRemote.setOnCommand(1, new TVOnCommand(myTV));
        myRemote.setOffCommand(1, new TVOffCommand(myTV));
        myRemote.setOnCommand(5, new enterCommand(livingRoomLight, myTV));

        // 버튼을 누르는것
        myRemote.onButtonWasPushed(0);
        // -> RemoteControl이 lightCommand의 on을 execute한다
        myRemote.onButtonWasPushed(1);
        myRemote.offButtonWasPushed(0);
        myRemote.onButtonWasPushed(5);
    }
}
