/**
 * Class that generate pi number.
 */
public class PiNumber {
    private double pi;

    /**
     * Constructor that generate pi number with 6 decimal precision.
     */
    public PiNumber(){
        int defaultPrecision = 6;
        setPi(defaultPrecision);
    }

    /**
     * Constructor that generates pi with n decimal precision.
     * param@ precision Deciaml precision of the pi number.
     */
    public PiNumber(int precision){
        setPi(precision);
    }

    /**
     * Method that calculate the pi number with specified precision
     * @param precision The decimal precision of pi number to be calculated.
     * @return Pi number with the specified precision.
     */
    private double calculatePi(int precision){
        /*
        Formula to calculate pi/4:
        Summation from 0 to n of (-1)^i*1/(2*i+1)
         */
        double sum = 0;
        //The cost of precision grows exponentially
        int n = (int) Math.pow(10,precision);
        for(int i=0; i<n; i++){
            int sign = i%2 == 0 ? 1 : -1;
            sum += sign * 1.0 / (2.0*i+1);
        }
        return sum * 4; // Sum is pi/4
    }

    public void setPi(int precision){
        this.pi = calculatePi(precision);;
    }

    public double getPi() {
        return pi;
    }

    public String toString(){
        return getPi() + "";
    }

    public static void main(String [] args){
        PiNumber piNumber = new PiNumber(6);
        System.out.println("Pi number: " + piNumber.toString());
    }
}
