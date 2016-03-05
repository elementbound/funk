package funk;

import funk.lang.Object;
import funk.lang.types.Error;

public class Utils {
	public static Error gatherErrors(Object... objects) {
		for(Object o : objects)
			if(o instanceof Error)
				return (Error) o;
		
		return null;
	}
}
