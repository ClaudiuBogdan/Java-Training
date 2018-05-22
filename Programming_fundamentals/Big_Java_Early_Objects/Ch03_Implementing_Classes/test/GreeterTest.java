import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class GreeterTest {
    private Greeter greeter;
    private String myName;
    @Before
    public void initializeClass(){
        myName = "Claudiu";
        greeter = new Greeter(myName);
    }

    @Test
    public void sayHello() {
        String greeterHelloExpected =  "Hello, " + myName;
        System.out.println(greeterHelloExpected);
        assertThat(greeter.sayHello(),equalTo(greeterHelloExpected));
    }

    @Test
    public void sayGoodbye() {
        String greeterGoodbyeExpected =  "Goodbye, " + myName;
        System.out.println(greeterGoodbyeExpected);
        assertThat(greeter.sayGoodbye(),equalTo(greeterGoodbyeExpected));
    }

    @Test
    public void refuseHelp() {
        String greeterRefuseHelpExpected =  "I am sorry, " + myName + ". I am afraid I can’t do that.";
        System.out.println(greeterRefuseHelpExpected);
        assertThat(greeter.refuseHelp(),equalTo(greeterRefuseHelpExpected));
    }
}