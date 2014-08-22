import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		if (args.length < 1){
			//no file given in command line
			System.out.println("Something went wrong");
			System.exit(1);
		}
		//get file included in command line
		File file = new File(args[0]);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);	
		String line;
		while((line = bufferedReader.readLine()) != null){
			//pop every other item
			String[] nums = line.split(" ");
			Stack stack = new Stack();
			for (String numString : nums){
				stack.push(numString);
			}
			while(stack.head != null){
				System.out.print(stack.pop());
				if(stack.head == null){
					//stack is empty
					break;
				}
				stack.pop();
				if(stack.head != null){
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		fileReader.close();
		System.exit(0);

	}
	
	public static class Stack {
		//linked list implementation of stack
		public Node head;
		
		public void push(String value){
			Node newHead = new Node(value, this.head);
			this.head = newHead;
		}
		
		public String pop(){
			Node popped = this.head;
			if(popped != null){
				this.head = this.head.next;
				return popped.getValue();
			}
			else {
				return null;
			}
		}
		
	}
	
	public static class Node {
		public String value;
		public Node next;
		
		public Node(String value, Node next){
			this.value = value;
			this.next = next;
		}
		
		public String getValue() {
			return this.value;
		}
	}

}
