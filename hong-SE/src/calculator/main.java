package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

import util.TextFile;
import util.TwoTuple;

public class main {

	
	
	public static void main(String args[]) {
		  //检验参数是否有效，并保存为parameter和fileName两部分
        ArrayList<String> parameters = new ArrayList<String>();
        int expAmount = 100;
        int numRange = 10;
        String expfile = "";
        String ansfile = "";
        String parameterRegex = "-[ernx]";
        String numRegex = "[0-9]+";
        String fileNameRegex = "^[^-]\\S+$";
        for (String arg : args) {
            //判断是否为参数
        	parameters.add(arg);
        }
       
        for(int i=0; i<parameters.size(); i+=2) {
        	if (Pattern.matches(parameterRegex, parameters.get(i))) {
                if("-n".equals(parameters.get(i))) {
                	 if (Pattern.matches(numRegex, parameters.get(i+1))) {
                         expAmount = Integer.parseInt(parameters.get(i+1));
                     }
                }else if("-r".equals(parameters.get(i))) {
                	 if (Pattern.matches(numRegex, parameters.get(i+1))) {
                         numRange = Integer.parseInt(parameters.get(i+1));
                     }
                }else if("-e".equals(parameters.get(i))){
                	 if (Pattern.matches(fileNameRegex, parameters.get(i+1))) {
                         expfile = parameters.get(i+1);
                     }
                	 if("-a".equals(parameters.get(i+2))){
                		 if (Pattern.matches(fileNameRegex, parameters.get(i+3))) {
                			 ansfile = parameters.get(i+3);
                		 }
                	 }
                	 if(!expfile.equals("")&&!ansfile.equals("")) {
                		 expfile = "./"+expfile;
                		 ansfile = "./"+ansfile;
                		 try {
                             Correcting.correctAnswer(expfile,ansfile);
                             System.out.println("成功输出grade.txt文件");
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                	 }
                	
                	 System.exit(0);
                	
                }else {
               
                
                	System.out.println("参数错误");
                	 System.exit(0);
                }
                
        	}
        }
        if(parameters.size()==0) {
        	System.out.println("请输入必要参数");
    		System.exit(0);
        
        }
       ArithmeticGen Gen = new ArithmeticGen(numRange);
       TwoTuple<String,String> twoTuple = Gen.expBuilder(expAmount);
       TextFile.write("./exercise.txt", twoTuple.first);
       TextFile.write("./answer.txt", twoTuple.second);
       System.out.println("成功输出题目。。。");
       
       
        
        
        
	}
	
	
}
