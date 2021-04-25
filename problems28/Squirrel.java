public class Squirrel
{
    private int numberOfNuts;

    private Squirrel(int numberOfNuts) {
      this.numberOfNuts = numberOfNuts;
    }

    private Squirrel(float numberOfNuts) {
      this.numberOfNuts = Math.round(numberOfNuts);
    }

    public static Squirrel RealNumberOfNuts(float numberOfNuts){
      Squirrel squirrel;
      return squirrel = new Squirrel(numberOfNuts);
    }
    
    public static Squirrel IntegerNumberOfNuts(int numberOfNuts){
      Squirrel squirrel;
      return squirrel = new Squirrel(numberOfNuts);
    }


    public int getNumberOfEmeralds()
      {
        int factorial = 1;
        int firstFactorialDigit = 0;
        for (int i = 1; i <= numberOfNuts; i++) {
            factorial = factorial * i;	
	      }

        firstFactorialDigit = factorial;
        while (firstFactorialDigit > 9) {
          firstFactorialDigit /= 10;
        }

        return firstFactorialDigit;
      }
}
