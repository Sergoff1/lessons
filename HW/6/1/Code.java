public class Code {

    public int romanToInt(String num) {
        Map<String, Integer> numMap = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000);

        int result = 0;
        int prevValue = 0;

        for (String s : num.split("")) {
            int currentValue = numMap.getOrDefault(s, 0);
            if(currentValue == 0) {
                return 0;
            }
            result += currentValue > prevValue ? currentValue - 2 * prevValue : currentValue;
            prevValue = currentValue;
        }

        return result;
}
