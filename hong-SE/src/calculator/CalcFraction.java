package calculator;

import java.util.Random;

public class CalcFraction {
	
	private static Random random = new Random(47);
	public  static Fraction CreatFraction(int num) {
	       int fz, fm;
	       fz = (int) (random.nextInt(num));//����ȡ0--num�������
	       fm = (int) (random.nextInt(num)+1);//��ĸȡ1--num�������
	       Fraction frac = new Fraction(fz, fm);
	        return frac;
	 }//�����������
	
    public static Fraction add(Fraction f1, Fraction f2) {

        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        Fraction f = new Fraction(fz1 * fm2 + fm1 * fz2, fm1 * fm2);
        return f;

    }//�ӷ�����

    public static Fraction sub(Fraction f1, Fraction f2) {
        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        Fraction f = new Fraction(fz1 * fm2 - fm1 * fz2, fm1 * fm2);
        return f;
    }//��������

    public static Fraction mul(Fraction f1, Fraction f2) {
        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        Fraction f = new Fraction(fz1 * fz2, fm1 * fm2);
        return f;
    }//�˷�����

    public static Fraction div(Fraction f1, Fraction f2) {
        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        Fraction f = new Fraction(fz1 * fm2, fm1 * fz2);
        return f;
    }//��������

    public static boolean compare(Fraction f1, Fraction f2) {
        int fz1 = f1.getNumerator();
        int fz2 = f2.getNumerator();
        int fm1 = f1.getDenominator();
        int fm2 = f2.getDenominator();
        if (fz1 * fm2 >= fz2 * fm1) {
            return true;
        } else
            return false;
    }//�Ƚ��������Ĵ�С
    
    public static Fraction calculate(Fraction f1, Fraction f2, char opt) {
    	switch(opt) {
    	case '+': return add(f1, f2);
    	case '-': return sub(f1, f2);
    	case '*': return mul(f1, f2);
    	case '��': return div(f1, f2);
    	default: return null;
    	}
    }

}