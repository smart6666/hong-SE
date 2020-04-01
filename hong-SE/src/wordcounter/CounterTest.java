package wordcounter;


import java.io.IOException;

public class CounterTest {
    private WordCounter wordCounter = null;

    //Constructor
    public CounterTest(String filePath) throws Exception {
        this.wordCounter = new WordCounter(filePath);
    }

    //����TextFile.charNumCounter()
    public void testCharNumCounter() {
        int charNum = wordCounter.charNumCounter();
        if (charNum >= 0)
            System.out.println("�ļ��ַ���Ϊ��" + charNum);
        else
            System.out.println("�ַ����������");
    }

    //����TextFile.wordNumCounter()
    public void testWordNumCounter() {
        int wordNum = wordCounter.wordNumCounter();
        if (wordNum >= 0)
            System.out.println("�ļ�������Ϊ��" + wordNum);
        else
            System.out.println("���ʼ������");
    }

    //����TextFile.lineNumCounter()
    public void testLineNumCounter() throws IOException {
        int lineNum = wordCounter.lineNumCounter();
        if (lineNum >= 0)
            System.out.println("�ļ�����Ϊ��" + lineNum);
        else
            System.out.println("�����������");
    }
    private static String[] paths = {"test.txt","test1.txt","test2.txt","src/wordcounter/test/CounterTest.java","src/wordcounter/main/Main.java"};

    public static void main(String[] args) throws Exception {
    	for(String path: paths) {
    		 CounterTest test = new CounterTest(path);
    		 System.out.println("�ļ�����" + path);
    	      test.testCharNumCounter();
    	      test.testWordNumCounter();
    	      test.testLineNumCounter();
    	      System.out.println();
    	}
      
       

    }

}
