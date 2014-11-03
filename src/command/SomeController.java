package command;

public class SomeController implements Command{

	@Override
	public void process(String someRequest) {
		System.out.println("Processing... " + someRequest);
	}

}
