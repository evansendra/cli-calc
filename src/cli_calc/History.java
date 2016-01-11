package cli_calc;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class History {
	private static List<CalcResult>results;
	
	private History(){
		results = new ArrayList<>();
	}
	
	public static boolean addToHistory(CalcResult result){
		if(results == null){
			results = new ArrayList<>();
			return add(result);
		}else{
			return add(result);
		}
	}
	
	public static CalcResult clearHistory(){
		if(results == null){
			results = new ArrayList<CalcResult>();
			return null;
		}else{
			return clear();
		}
	}
	public static List<CalcResult> getFullHist() {
		if (results == null) {
			results = new ArrayList<>();
		}
		return results;
	}


	
	public static CalcResult getResult(int index) throws IndexOutOfBoundsException{
		CalcResult result;
		if(results == null)
			results = new ArrayList<>();
		
		if(results.size() <= index){
			throw new IndexOutOfBoundsException();
		}else{
			result = results.get(index);
		}
		return result;
	}

	
	private static boolean add(CalcResult result){
		return results.add(result);
	}

	private static CalcResult clear(){
		CalcResult result = null;
		for(int i = 0; i < results.size(); i++){
			result = results.remove(i);
		}
		return result;
	}
}
