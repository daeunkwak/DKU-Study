package Command;

// 메뉴를 상징하는 RemoteControl
public class RemoteControl {
    // 버튼마다 myLight객체가 생성되면 안되므로 전역번수로 생성해준다
//    Light myLight = new Light("Living Room");
//    TV myTV = new TV("Living Room");

//    Command command1on = new Command() {
//        @Override
//        public void execute() {
//            Light livingRoomLight = new Light("Living Room");
//            livingRoomLight.on();
//        }
//    };

    Command[] onCommand = new Command[7];
    Command[] offCommand = new Command[7];
    Command undoCommand = new NullCommand();

    // NullCommand를 만들어서 처음 시작할 때 Setting
    RemoteControl(){
        for(int i = 0; i < 7; i++){
            onCommand[i] = new NullCommand();
            offCommand[i] = new NullCommand();
        }
    }

    // command array를 쓸 수 있음 다 on/off니까까
   public void setOnCommand(int num, Command myCommand){
        // setCommand 역할
        onCommand[num] = myCommand;
    }

    public void setOffCommand(int num, Command myCommand){
        offCommand[num] = myCommand;
    }

    public void onButtonWasPushed(int num) {
        // button1 눌렸을 때 코드
        // Light myLight = new Light("Living Room");
        // myLight.on();
        // command1on.execute();
        onCommand[num].execute();
    }

    // Decoupling <-> Light,, 이런거 몰라도됨됨
   public void offButtonWasPushed(int num) {
        // myLight를 알아야 키고 끌 수 있는 상황!
        // <-> 리모컨을 작동할 때 어떤 객체를 만들어야할지 다 알아야한다
        // myLight.off();
        offCommand[num].execute();
    }
//
//    public void onButton2WasPushed() {
//    }
//    public void offButton2WasPushed() {
//    }
//    public void onButton3WasPushed() {
//    }
//    public void offButton3WasPushed() {
//    }
//    public void onButton4WasPushed() {
//    }
//    public void offButton4WasPushed() {
//    }
//    public void onButton5WasPushed() {
//    }
//    public void offButton5WasPushed() {
//    }
//    public void onButton6WasPushed() {
//    }
//    public void offButton6WasPushed() {
//    }
//    public void onButton7WasPushed() {
//    }
//    public void offButton7WasPushed() {
//    }
//    public void undoButtonWasPushed() {
//    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
//		for (int i = 0; i < onCommands.length; i++) {
//			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
//				+ "    " + offCommands[i].getClass().getName() + "\n");
//		}
        return stringBuff.toString();
    }
}
