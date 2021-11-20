package Command;

public class TVOffCommand implements Command {
    TV myTV = null;

    TVOffCommand(TV tv){
        this.myTV = tv;
    }

    @Override
    public void execute() {
        myTV.off();
    }
}