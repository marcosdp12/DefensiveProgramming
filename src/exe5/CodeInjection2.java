package exe5;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;

import javax.script.*;

public class CodeInjection2 {
	private static class RestrictedAccessControlContext {
		private static final AccessControlContext INSTANCE;
		static {
			INSTANCE = new AccessControlContext(new ProtectionDomain[]{ new ProtectionDomain(null,null)});
		}
	}
	
	public static void evalScript(String string) throws ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		final ScriptEngine engine = manager.getEngineByName("JavaScript");
		System.out.println(string);
		try{
			AccessController.doPrivileged(new PrivilegedExceptionAction<Object>(){
				public Object run() throws ScriptException{
					engine.eval("print('"+ string + "')");
					return null;
				}
			},
			RestrictedAccessControlContext.INSTANCE);
		} catch(PrivilegedActionException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){

	}
}
