/**
 * @author baumgartd
 * @date 1/1132016
 * This class is used to to handle the calculators history.
 */
package cli_calc;

import java.util.List;
import java.util.ArrayList;

public class History {
	private static List<CalcResult>results;
	private static History history;
	
	/**
	 * The constructor for the class. Can not be called directly. Instantiates a list to hold the results.
	 */
	private History(){
		results = new ArrayList<>();
	}
	
	/**
	 * Adds the calculated result to the results list. 
	 * @param result to be added
	 * @return true if successfully added, false if not 
	 */
	public static boolean addToHistory(CalcResult result){
		//If this is the first time calling the method, instantiate
		if(history == null) {
			history = new History();
		}

		boolean wasAdded = false; 
		try{
			if (result.getCmd().getCmd().equals("hist") || result.getCmd().getCmd().equals("clearhist"))
				wasAdded = false;
			
			wasAdded = add(result);
		}catch(NullPointerException e){
			wasAdded = false;
		}
        return wasAdded;
	}
	
	/**
	 * Empty the results list
	 */
	public static void clearHistory(){
		if(history == null){
			history = new History();
		}else{
			clear();
		}
	}
	
	/**
	 * Gets the history
	 * @return the results list
	 */
	public static List<CalcResult> getFullHist() {
		if (history == null) {
			history = new History();
		}
		return results;
	}


	/**
	 * Get a specific result
	 * @param index 
	 * @return CalcResult
	 * @throws IndexOutOfBoundsException
	 */
	public static CalcResult getResult(int index) throws IndexOutOfBoundsException{
		CalcResult result;
		if(history == null)
			history = new History();
		
		if(results.size() <= index){
			throw new IndexOutOfBoundsException();
		}else{
			result = results.get(index);
		}
		return result;
	}

	/**
	 * Helper method for adding a result to the results list.
	 * @param result
	 * @return the added result
	 */
	private static boolean add(CalcResult result){
		if(result == null)
			throw new NullPointerException();
		
		return results.add(result);
	}

	/**
	 * Helper method for clearing the results list.
	 */
	private static void clear(){
		results.clear();
	}
}
