/**
 * @author baumgartd
 * @date 1/1132016
 * This class is used to to handle the calculators history.
 */
package cli_calc;

import java.util.ArrayList;
import java.util.List;

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
	 * instantiates the singleton if wasn't done already
	 */
	private static void nullCheck() {
		if (history == null)
			history = new History();
	}
	
	/**
	 * Adds the calculated result to the results list. 
	 * @param result to be added
	 * @return true if successfully added, false if not 
	 */
	public static boolean addToHistory(CalcResult result){
		//If this is the first time calling the method, instantiate
		nullCheck();

		boolean wasAdded;
		try{
			if (result.getCmd().getCmd().equals("hist") || result.getCmd().getCmd().equals("clearhist")) {
				wasAdded = false;
			} else {
				wasAdded = add(result);
			}
		}catch(NullPointerException e){
			wasAdded = false;
		}
        return wasAdded;
	}
	
	/**
	 * Empty the results list
	 */
	public static void clearHistory(){
		nullCheck();
		clear();
	}
	
	/**
	 * Gets the history
	 * @return the results list
	 */
	public static List<CalcResult> getFullHist() {
		nullCheck();
		return results;
	}


	/**
	 * Get a specific result
	 * @param index the index of the result to get in list
	 * @return CalcResult
	 * @throws IndexOutOfBoundsException
	 */
	public static CalcResult getResult(int index) throws IndexOutOfBoundsException{
		CalcResult result;
		nullCheck();
		
		if(results.size() <= index){
			throw new IndexOutOfBoundsException();
		}else{
			result = results.get(index);
		}
		return result;
	}

	/**
	 * Helper method for adding a result to the results list.
	 * @param result the result to add to the history
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
