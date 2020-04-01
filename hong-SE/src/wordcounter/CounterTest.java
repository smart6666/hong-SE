package wordcounter;


import java.io.IOException;

public class CounterTest {
    private WordCounter wordCounter = null;

    //Constructor
    public CounterTest(String filePath) throws Exception {
        this.wordCounter = new WordCounter(filePath);
    }

    //测试TextFile.charNumCounter()
    public void testCharNumCounter() {
        int charNum = wordCounter.charNumCounter();
        if (charNum >= 0)
            System.out.println("文件字符数为：" + charNum);
        else
            System.out.println("字符数计算出错");
    }

    //测试TextFile.wordNumCounter()
    public void testWordNumCounter() {
        int wordNum = wordCounter.wordNumCounter();
        if (wordNum >= 0)
            System.out.println("文件单词数为：" + wordNum);
        else
            System.out.println("单词计算出错");
    }

    //测试TextFile.lineNumCounter()
    public void testLineNumCounter() throws IOException {
        int lineNum = wordCounter.lineNumCounter();
        if (lineNum >= 0)
            System.out.println("文件行数为：" + lineNum);
        else
            System.out.println("行数计算错误");
    }
    private static String[] paths = {"test.txt","test1.txt","test2.txt","src/wordcounter/test/CounterTest.java","src/wordcounter/main/Main.java"};

    public static void main(String[] args) throws Exception {
    	for(String path: paths) {
    		 CounterTest test = new CounterTest(path);
    		 System.out.println("文件名：" + path);
    	      test.testCharNumCounter();
    	      test.testWordNumCounter();
    	      test.testLineNumCounter();
    	      System.out.println();
    	}
      
       

    }

}
