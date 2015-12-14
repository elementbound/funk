package funk.lang;

import funk.lang.types.Error;

public class StandardErrors {
	public static Error IllegalCast(Object from, Class<?> to) {
		return new Error("IllegalCast")
				.addField("from", from.toString())
				.addField("to", to.getSimpleName());
	}
	
	
	public static Error IllegalOperation(String op, Object self) {
		return new Error("IllegalOperation")
				.addField("op", op)
				.addField("self", self.toString());
	}
	
	public static Error IllegalOperation(String op, Object lhs, Object rhs) {
		return new Error("IllegalOperation")
				.addField("op", op)
				.addField("lhs", lhs.toString())
				.addField("rhs", rhs.toString());
	}
	
	public static Error UnknownType(String typeName) {
		return new Error("UnknownType", "type", typeName);
	}
	
	public static Error UnknownVariable(String variable) {
		return new Error("UnknownVariable", "name", variable);
	}
	
	public static Error UnknownFunction(String name, Object self, int argCount) {
		return new Error("UnknownFunction")
					.addField("function", name)
					.addField("self", self.toString())
					.addField("argCount", Integer.toString(argCount));
	}
	
	public static Error FailedInstantiation(String typeName) {
		return new Error("FailedInstantiation", "type", typeName);
	}
	
	public static Error UnknownUnaryOperator(String op) {
		return new Error("UnknownUnaryOperator", "op", op);
	}
	
	public static Error UnknownBinaryOperator(String op) {
		return new Error("UnknownBinaryOperator", "op", op);
	}
	
	public static Error UnknownField(String field, Object self) {
		return new Error("UnknownField", "field", field, "self", self.toString());
	}
	
	public static Error UnknownIndexError(Object index, Object self) {
		return new Error("UnknownIndex")
				.addField("index", index.toString())
				.addField("to", self.toString());
	}
	
	public static Error WrongLiteral(String type, String literal) {
		return new Error("WrongBooleanLiteral")
					.addField("literal", literal)
					.addField("type", type);
	}
	
	public static Error WrongArgumentCount(int argCount, int expected) {
		return new Error("WrongArgumentCount")
				.addField("argCount", Integer.toString(argCount))
				.addField("expectedArgCount", Integer.toString(expected));
	}
	
	public static Error WrongArgumentType(String type, String expected) {
		return new Error("WrongArgumentType")
				.addField("argType", type)
				.addField("expectedType", expected);
	}

	public static Object InvalidInheritance(String baseTypeName) {
		return new Error("InvalidInheritance")
				.addField("notAggregateType", baseTypeName);
	}
	

}
