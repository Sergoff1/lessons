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

        if (num.length() == 1) {
            return numMap.get(num);
        } else {
            return switch (num) {
                case "II" -> 2;
                case "IV" -> 4;
                case "XI" -> 11;
                case "XL" -> 40;
                case "CI" -> 101;
                case "CM" -> 900;
                case "MM" -> 2000;
                default -> 0;
            };
        }
}
