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

        for(String s : num.split("")) {
            result += numMap.get(s) > prevValue ? numMap.get(s) - 2 * prevValue : numMap.get(s);
            prevValue = numMap.get(s);
        }

        return result;
}
