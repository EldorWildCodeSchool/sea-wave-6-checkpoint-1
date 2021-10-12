package dev.wilders;

public abstract class ITPerson {

    protected String name;

    public ITPerson(String name) {
        //Split names if there is a underline as a separator
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean hasReadAccess();

    public abstract boolean hasWriteAccess();

}

