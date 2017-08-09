import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class testing {

	public static void main (String [] args){
		String thisString = "Hi Ryan, hello, how are you";
		
		
		String [] strings = thisString.split(",");
		
		ArrayList<String> list = new ArrayList<String>();
		
		Collections.addAll(list, strings); 
		
		System.out.println(list.get(0));

		for (int i = 0; i < list.size(); i ++){
			System.out.print(list.get(i));
			
			
			ArrayList database = new ArrayList();
			
			
		}
	}
	
	
}
