package command;

public class SomeOtherController implements Command{

	public void process(String someOtherThing){
		System.out.println("Processing... " + someOtherThing);
	}
	
}
