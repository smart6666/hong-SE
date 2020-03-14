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
     * 计算文件字符数
     */
    public int charNumCounter() {
        int charNum = 0;
        charNum = (int) this.wordString.toString().toCharArray().length;
        return charNum;
    }

    /**
     * 计算文件单词数
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
     * 计算文件行数
     */
    public int lineNumCounter() throws IOException {
        return wordString.toString().split("\\n").length;
    }
}

