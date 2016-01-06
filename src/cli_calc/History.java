package cli_calc;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class History {
	private static List<CalcResult>results;
	
	private History(){
		results = new ArrayList<CalcResult>();
	}
	
	public static boolean addToHistory(CalcResult result){
		if(results == null){
			results = new ArrayList<CalcResult>();
			return add(result);
		}else{
			return add(result);
		}
	}
	
	public static boolean clearHistory(){
		if(results == null){
			results = new ArrayList<CalcResult>();
			return true;
		}else{
			return clear();
		}
	}
	
	private static boolean add(CalcResult result){
		return results.add(result);
	}
	
	private static boolean clear(){
		Iterator<CalcResult>itr = results.iterator();
		while( itr.hasNext()){
			itr.remove();
		}
		return results.size() == 0;
	}
}