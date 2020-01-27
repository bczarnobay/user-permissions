package src.model;

// import src.model.enums.AppFunctions;
// import src.model.enums.PermissionLevel;

public class Permissions {
    String function;
    String level;

    public Permissions(String function, String level) {
        this.function = function;
        this.level = level;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Permissions() {
    }
}