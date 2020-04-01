package calculator;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
    	
    }
    public Fraction(int numerator, int denominator) {
        super();
        this.numerator = numerator;
        this.denominator = denominator;
//        if(numerator == 0) {
//        	this.denominator = 1;
//        }else {
//        	this.denominator = denominator;
//        }
        this.simplify(numerator, denominator);
    }


    public static int GCD(int m, int n) {
        if(m<n) {//��֤���������ڳ���
        	int temp = m;
        	m = n;
        	n = temp;
        }
       
        while(m%n != 0) {//����������Ϊ0ʱ������ѭ��
        	int temp = m%n;
        	m = n;
        	n = temp;
        }
        return n; //�������Լ��
    }

    public void simplify(int numerator, int denominator) { 
    	if(numerator!=0) {
    		int GCD = GCD(numerator, denominator);
            this.numerator = numerator / GCD;
            this.denominator = denominator / GCD;

    	}
    }//�������

    @Override
    public String toString() {
    
    	int integer=numerator/denominator;
    	
    	int remainder=numerator % denominator;
        if (numerator == 0) {
            return 0 + "";
        } else if (remainder == 0) {
            return integer + "";
        } else {	
        	if(integer==0){
        		return numerator + "/" + denominator;
        	}else{
        		return ""+integer+"'"+remainder+"/"+denominator;
        	}
        }
    }//��дtoString�����Ϊ������ʽ

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + denominator;
//        result = prime * result + numerator;
//        return result;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fraction other = (Fraction) obj;
        if (denominator != other.denominator)
            return false;
        if (numerator != other.numerator)
            return false;
        return true;
    }
    public boolean greater(Fraction f1) {
    	if(f1==null)
    		return false;
    	if(this.numerator*f1.denominator>=this.denominator*f1.numerator) {
    		return true;
    	}else {
    		return false;
    	}
    }

}

