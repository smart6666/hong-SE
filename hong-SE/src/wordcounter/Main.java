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

        //��������Ƿ���Ч��������Ϊparameter��fileName������
        ArrayList<String> parameters = new ArrayList<String>();
        String fileName = null;
        String parameterRegex = "-[cwlxsa]";
        String fileNameRegex = "^[^-]\\S+$";
        for (String arg : args) {
            //�ж��Ƿ�Ϊ����
            if (Pattern.matches(parameterRegex, arg)) {
                parameters.add(arg);
            }
            //�ж��Ƿ�Ϊ��ַ���ļ���
            if (Pattern.matches(fileNameRegex, arg)) {
                fileName = arg;
            }
        }
        //�жϲ����Ƿ���ȫ
        if (parameters.isEmpty()) {
            System.out.println("ȱ�ٲ���");
            printHelp();
            return;
        }
      
        //����ļ��Ƿ���Ҫͨ���ļ�ѡ���ѡȡ
        for (String parameter : parameters) {
            if (parameter.equals("-x")) {
                String path = getFilePathFromFileChooser();
                //����ļ�·��
                if (path == null || path.equals("")) {
                    System.out.println("δѡȡ�ļ�");
                    return;
                } else
                    fileName = path;
            }
        }
        //�����û�����ִ�в�ͬ�ļ���
        try {
        	WordCounter wordCounter = new WordCounter(fileName);
            for (String arg : parameters) {
                //�û�ѡ��Ϊ��-c��
                if (arg.equals("-c")) {
                    int charNum = wordCounter.charNumCounter();
                    if (charNum >= 0)
                        System.out.println("�ļ��ַ���Ϊ��" + charNum);
                    else
                        System.out.println("�ַ����������");
                }
                //�û�ѡ��Ϊ��-w��
                if (arg.equals("-w")) {
                    int wordNum = wordCounter.wordNumCounter();
                    if (wordNum >= 0)
                        System.out.println("�ļ�������Ϊ��" + wordNum);
                    else
                        System.out.println("���ʼ������");
                }
                //�û�ѡ��Ϊ��-l��
                if (arg.equals("-l")) {
                    int lineNum = wordCounter.lineNumCounter();
                    if (lineNum >= 0)
                        System.out.println("�ļ�����Ϊ��" + lineNum);
                    else
                        System.out.println("�����������");
                }
                //�û�ѡ��Ϊ��-x"
                if (arg.equals("-x")) {
                    int lineNum = wordCounter.lineNumCounter();
                    int charNum = wordCounter.charNumCounter();
                    int wordNum = wordCounter.wordNumCounter();
                    if (charNum >= 0)
                        System.out.println("�ļ��ַ���Ϊ��" + charNum);
                    else
                        System.out.println("�ַ����������");
                    if (wordNum >= 0)
                        System.out.println("�ļ�������Ϊ��" + wordNum);
                    else
                        System.out.println("���ʼ������");
                    if (lineNum >= 0)
                        System.out.println("�ļ�����Ϊ��" + lineNum);
                    else
                        System.out.println("�����������");
                }
            }
        } catch (FileNotFoundException fileNotFindException) {
            System.out.println("�ļ�������");
            fileNotFindException.printStackTrace();
        } catch (IOException IOEx) {
            System.out.println("I/O����");
            IOEx.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            if (fileName == null)
                System.out.println("�ļ���Ϊ��");
            else
                System.out.println("�ļ��������");
            nullPointerException.printStackTrace();
        }

    }

    //��ʾ����
    private static void printHelp() {
        String help = "Help:\n" +
                "wc.exe [����] [�ļ���]\n" +
                "��ѡ�Ĳ�����\n" +
                "    -c    ���ض�Ӧ�ļ����ַ���\n" +
                "    -w    ���ض�Ӧ�ļ��Ĵ���\n" +
                "    -l    ���ض�Ӧ�ļ�������\n" +
                "�ļ�����\n" +
                "    ���ַ�����Ϊ��-��";
        System.out.println(help);
    }

    //���ļ�ѡ���ѡ���ļ�
    private static String getFilePathFromFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("��ѡ���ı��ļ�");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);    //ֻ֧��ѡȡ�ļ�
        fileChooser.setMultiSelectionEnabled(false);    //ֻ֧��ѡȡ���ļ�
        fileChooser.showDialog(new JLabel(), "ѡ��");
        File selectedFile = fileChooser.getSelectedFile();
        if (selectedFile == null) {
            return null;
        }
        System.out.println(selectedFile.getAbsolutePath());
        return selectedFile.getAbsolutePath();
    }
}
