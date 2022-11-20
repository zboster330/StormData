package project2;

public class EmptySetException extends Exception { //special exception for if the set is empty

	public EmptySetException() {
		super();
		System.out.println("hey the set is empty");
		printStackTrace();
	}
	
	public EmptySetException(String str) {
		super(str);
		System.out.println(str);
		printStackTrace();
	}
	
}
