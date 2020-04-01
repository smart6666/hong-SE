package wordcounter;



import javax.swing.*;

import util.TextFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {

    public static void main(String args[]) {

        //检验参数是否有效，并保存为parameter和fileName两部分
        ArrayList<String> parameters = new ArrayList<String>();
        String fileName = null;
        String parameterRegex = "-[cwlxsa]";
        String fileNameRegex = "^[^-]\\S+$";
        for (String arg : args) {
            //判断是否为参数
            if (Pattern.matches(parameterRegex, arg)) {
                parameters.add(arg);
            }
            //判断是否为地址或文件名
            if (Pattern.matches(fileNameRegex, arg)) {
                fileName = arg;
            }
        }
        //判断参数是否齐全
        if (parameters.isEmpty()) {
            System.out.println("缺少参数");
            printHelp();
            return;
        }
      
        //检查文件是否需要通过文件选择框选取
        for (String parameter : parameters) {
            if (parameter.equals("-x")) {
                String path = getFilePathFromFileChooser();
                //检查文件路径
                if (path == null || path.equals("")) {
                    System.out.println("未选取文件");
                    return;
                } else
                    fileName = path;
            }
        }
        //根据用户输入执行不同的计算
        try {
        	WordCounter wordCounter = new WordCounter(fileName);
            for (String arg : parameters) {
                //用户选项为“-c”
                if (arg.equals("-c")) {
                    int charNum = wordCounter.charNumCounter();
                    if (charNum >= 0)
                        System.out.println("文件字符数为：" + charNum);
                    else
                        System.out.println("字符数计算出错");
                }
                //用户选项为“-w”
                if (arg.equals("-w")) {
                    int wordNum = wordCounter.wordNumCounter();
                    if (wordNum >= 0)
                        System.out.println("文件单词数为：" + wordNum);
                    else
                        System.out.println("单词计算出错");
                }
                //用户选项为“-l”
                if (arg.equals("-l")) {
                    int lineNum = wordCounter.lineNumCounter();
                    if (lineNum >= 0)
                        System.out.println("文件行数为：" + lineNum);
                    else
                        System.out.println("行数计算错误");
                }
                //用户选项为“-x"
                if (arg.equals("-x")) {
                    int lineNum = wordCounter.lineNumCounter();
                    int charNum = wordCounter.charNumCounter();
                    int wordNum = wordCounter.wordNumCounter();
                    if (charNum >= 0)
                        System.out.println("文件字符数为：" + charNum);
                    else
                        System.out.println("字符数计算出错");
                    if (wordNum >= 0)
                        System.out.println("文件单词数为：" + wordNum);
                    else
                        System.out.println("单词计算出错");
                    if (lineNum >= 0)
                        System.out.println("文件行数为：" + lineNum);
                    else
                        System.out.println("行数计算错误");
                }
            }
        } catch (FileNotFoundException fileNotFindException) {
            System.out.println("文件不存在");
            fileNotFindException.printStackTrace();
        } catch (IOException IOEx) {
            System.out.println("I/O错误");
            IOEx.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            if (fileName == null)
                System.out.println("文件名为空");
            else
                System.out.println("文件输入错误");
            nullPointerException.printStackTrace();
        }

    }

    //显示帮助
    private static void printHelp() {
        String help = "Help:\n" +
                "wc.exe [参数] [文件名]\n" +
                "可选的参数：\n" +
                "    -c    返回对应文件的字符数\n" +
                "    -w    返回对应文件的词数\n" +
                "    -l    返回对应文件的行数\n" +
                "文件名：\n" +
                "    首字符不能为“-”";
        System.out.println(help);
    }

    //从文件选择框选择文件
    private static String getFilePathFromFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("请选择文本文件");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);    //只支持选取文件
        fileChooser.setMultiSelectionEnabled(false);    //只支持选取单文件
        fileChooser.showDialog(new JLabel(), "选择");
        File selectedFile = fileChooser.getSelectedFile();
        if (selectedFile == null) {
            return null;
        }
        System.out.println(selectedFile.getAbsolutePath());
        return selectedFile.getAbsolutePath();
    }
}
