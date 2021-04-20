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
        int firstFactorialDigit = 1;
        for (int i = 1; i <= numberOfNuts; i++) {
            firstFactorialDigit = firstFactorialDigit * i;	
	    }
        return Integer.valueOf(Integer.toString(firstFactorialDigit).substring(0,1));
      }
}
