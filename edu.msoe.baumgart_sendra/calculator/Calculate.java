package calculator;
import java.util.List;
import java.util.ArrayList;

public class Calculate {
	
	List<Result>results;
	public static int substitution;
	
	public Calculate(){
		results = new ArrayList<Result>();
	}
	
	public void calculate(String input, String cmd, List<Integer>list){
		
		if(cmd.equalsIgnoreCase("add")){
			
		}else if(cmd.equalsIgnoreCase("sub")){
			
		}else if(cmd.equalsIgnoreCase("mul")){
			
		}else if(cmd.equalsIgnoreCase("div")){
			
		}else if(cmd.equalsIgnoreCase("hist")){
			
		}else if(cmd.contains("!")){
			
		}else if(cmd.equalsIgnoreCase("clearhist")){
			
		}else if(cmd.equalsIgnoreCase("sqr")){
			
		}
	}
	
	private Result add(List<Integer>list){
		Result result = null;
		
		return result;
	}
	
	private Result sub(List<Integer>list){
		Result result = null;
		
		return result;
	}
	
	private Result mul(List<Integer> list){
		Result result = null;
		
		return result;
	}
	
	private Result div(List<Integer>list){
		Result result = null;
		
		return result;
	}
	
	private void clearHistory(){
		
	}
	
	private String displayHistory(){
		String display = null;
		
		return display;
	}
	
	private Result sqr(List<Integer>list){
		Result result = null;
		
		return result;
	}
	
	public void substitute(List<Integer>list){
		
	}
}
