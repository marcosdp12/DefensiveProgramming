package exe4;

import javax.script.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeInjection1 {
	
	public static void run(String filename){
		String pattern = "[a-zA-Z0-9\\-\\_]*";
		
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(filename);
		if(!m.find()){
			throw new IllegalArgumentException();
		}			
		
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			engine.eval(new java.io.FileReader("resources/" + filename + ".js")); //para linux
			//engine.eval(new java.io.FileReader("C:\\Compartilhada\\" + filename + ".js")); //para windows
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ScriptException{
		String filePath = "filename";
		CodeInjection1.run(filePath);
	}
}
