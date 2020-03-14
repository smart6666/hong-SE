package wordcounter.counter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Stream;

import util.TextFile;

public class WordCounter {

    private String wordString = null;
    
    public WordCounter(String filePath) {
    	wordString = TextFile.read(filePath);
    }
 

    /**
     * �����ļ��ַ���
     */
    public int charNumCounter() {
        int charNum = 0;
        charNum = (int) this.wordString.toString().toCharArray().length;
        return charNum;
    }

    /**
     * �����ļ�������
     */
    public int wordNumCounter() {
        //String wordRegex = "\\b[a-zA-Z]+";
        String wordRegex = "\\b";
        int wordNum = 0;
        //wordNum = (int) stringStream.filter(word->word.matches(wordRegex)).count();
        String[] temp = wordString.split(wordRegex);
        for (String str : temp) {
            if (str.matches("\\b[a-zA-Z]+"))
                wordNum++;
        }
        return wordNum;
    }

    /**
     * �����ļ�����
     */
    public int lineNumCounter() throws IOException {
        return wordString.toString().split("\\n").length;
    }
}

