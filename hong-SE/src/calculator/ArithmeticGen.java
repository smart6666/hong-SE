package calculator;

import java.util.Random;
import static util.Tuple.*;
import util.TwoTuple;

public class ArithmeticGen {
	
	public ArithmeticGen(int num) {
		this.num = num;
	}

	private static Random random = new Random(47);
	private  int num ;
	
	 
	 public static boolean check(String input) {
	       	if (input.matches("[0-9]+")||input.matches("[0-9]+/[0-9]+")) {
	            return true;
	        } else
	            return false;
	  }//利用正则表达式处理用户输入的答案
	 
	 
	 private ExpressionBean createExp(ExpressionBean expBean1) {
		 ExpressionBean expBean=new ExpressionBean();
	    	Boolean flagZero = false;
	    	Fraction f2=CalcFraction.CreatFraction(num);
	    	//随机设置f2自然数
	    	if(random.nextBoolean()){
				f2.setDenominator(1);
			}
	        char opt = '+';
	        switch(random.nextInt(4))  {
	            case 0 : opt = '+';    break;
	            case 1 : opt = '-';    break;
	            case 2 : opt = '*';    break;
	            case 3 : opt = '÷';    break;

	            default: break;
	        };
	       
	        if((expBean1.getExpression()).equals("")) {
	        	Fraction f1=CalcFraction.CreatFraction(num);
	        	if(random.nextBoolean()){
					f1.setDenominator(1);
				}
	        	if(f2.getNumerator()==0&&opt=='÷')
	        		opt = '+';
	        	if(!f1.greater(f2)&&opt=='-') {
	        		expBean.setExpression( "" + f2 + opt + f1);
		        	expBean.setFraction(CalcFraction.calculate(f2, f1, opt));
	        	}else {
	        		expBean.setExpression( "" + f1 + opt + f2);
		        	expBean.setFraction(CalcFraction.calculate(f1, f2, opt));
	        	}
	        	
	        }else {
	        	if(random.nextBoolean()) {
	        		if(f2.getNumerator()==0&&opt=='÷')
		        		opt = '+';
	        		if(!expBean1.getFraction().greater(f2)&&opt=='-') {
	        			expBean.setExpression("" + f2 + opt + "(" + expBean1 + ")");
		        		expBean.setFraction(CalcFraction.calculate(f2, expBean1.getFraction(), opt));
	        		}else {
	        			expBean.setExpression( "(" + expBean1 + ")" + opt + f2);
		        		expBean.setFraction(CalcFraction.calculate(expBean1.getFraction(), f2, opt));
	        		}
	        		
	        	}else {
	        		if(expBean1.getFraction().getNumerator()==0&&opt=='÷')
	        			opt = '+';
	        		if(expBean1.getFraction().greater(f2)&&opt=='-') {
	        			expBean.setExpression( "(" + expBean1 + ")" + opt + f2);
		        		expBean.setFraction(CalcFraction.calculate(expBean1.getFraction(), f2, opt));
	        		}else {
	            		expBean.setExpression("" + f2 + opt + "(" + expBean1 + ")");
		        		expBean.setFraction(CalcFraction.calculate(f2, expBean1.getFraction(), opt));
	        		}
	
	        	}
	        }
	        return expBean;
	    }
	 
	 public TwoTuple<String,String> expBuilder(int expAmount) {
		 StringBuilder exptext = new StringBuilder();
		 StringBuilder anstext = new StringBuilder();
		 for(int i=1; i<=expAmount; i++) {
			 ExpressionBean expBean = new ExpressionBean();
			 expBean=createExp(expBean);
			 if(random.nextBoolean()) {
				 expBean=createExp(expBean);
			 }
			 exptext.append("第" + i + "题: " + expBean.getExpression() + "   请作答:"+"\n");
			 anstext.append("第" + i + "题: " + expBean.getFraction() + "\n");
		 }
		 return tuple(exptext.toString(), anstext.toString());
	 }
	 

}
