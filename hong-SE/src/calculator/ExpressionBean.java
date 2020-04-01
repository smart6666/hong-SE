package calculator;

public class ExpressionBean {

	private String expression = "";
	
	private Fraction fraction;
	
	
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	public Fraction getFraction() {
		return fraction;
	}
	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}
	
	public String toString() {
		return this.expression;
	}
	
}
