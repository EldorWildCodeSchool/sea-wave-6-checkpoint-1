package dev.wilders;

public class Support extends ITPerson {

    protected int level;

    public Support(String name, int level) {
        super(name);
        this.level = level;
    }

    @Override
    public boolean hasReadAccess() {
        switch(this.level){
            case 0 : return false;
            case 1 : return true;
            case 2 : return true;
            default : return false;
        }
    }

    @Override
    public boolean hasWriteAccess() {
        switch(this.level){
            case 0 : return false;
            case 1 : return false;
            case 2 : return true;
            default : return false;
        }
    }
}
