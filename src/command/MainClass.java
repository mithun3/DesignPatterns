package command;

/**
 * 
 * @author mithun
 * 
 * Command Pattern : 
 * Encapsulate a request as an object, thereby letting you parameterize clients with different requests.
 * Promote "invocation of a method on an object" to full object status
 * An object-oriented callback
 * 
 */

public class MainClass {
	
	public void process(String someRequest){
		Command command = null;
		
		if(someRequest.equals("something")){
			command = new SomeController();
			command.process(someRequest);
		}
		
		if(someRequest.equals("someOtherThing")){
			command = new SomeOtherController();
			command.process(someRequest);
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Starting command pattern");
		MainClass mainClass = new MainClass();
		mainClass.process("something");
		
		mainClass.process("someOtherThing");
		
	}

}
