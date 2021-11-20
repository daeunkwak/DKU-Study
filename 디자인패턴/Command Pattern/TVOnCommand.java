package Command;

public class TVOnCommand implements Command {
    TV myTV = null;

    TVOnCommand(TV tv){
        this.myTV = tv;
    }

    @Override
    public void execute() {
        myTV.on();
    }
}
