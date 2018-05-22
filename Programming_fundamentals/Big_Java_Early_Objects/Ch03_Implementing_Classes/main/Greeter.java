import com.sun.istack.internal.NotNull;

/**
 * Class that create customized gratings.
 */
public class Greeter {
    private String nameOfUser;

    /**
     * Constructor that instantiate a greeter object with the user name.
     * @param name User name toward who greetings will be addressed.
     */
    public Greeter(@NotNull String name) {
        this.nameOfUser = name;
    }

    /**
     * Method that say hello to the user.
     * @return String with the personalized hello message.
     */
    public String sayHello(){
        return "Hello, ".concat(nameOfUser);
    }

    /**
     * Method that say goodbye to the user.
     * @return String with the personalized goodbye message.
     */
    public String sayGoodbye(){
        return "Goodbye, ".concat(nameOfUser);
    }

    public String refuseHelp(){
        return "I am sorry, " + nameOfUser + ". I am afraid I can’t do that.";
    }
}

