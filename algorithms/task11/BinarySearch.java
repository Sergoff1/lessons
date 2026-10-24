package task11;

public class BinarySearch {

    public int Left;
    public int Right;

    private final int[] array;
    private boolean isFound;
    private boolean isSearchCompleted;

    public BinarySearch(int[] array) {
        this.array = array;
        Left = 0;
        Right = array.length - 1;
        isFound = false;
        isSearchCompleted = false;
    }

    public void Step(int N) {
        if (isSearchCompleted || Left > Right) {
            return;
        }

        int centralIdx = (Left +  Right) / 2;

        if (N == array[centralIdx]) {
            isFound = true;
            isSearchCompleted = true;
            return;
        }

        if (N > array[centralIdx]) {
            Left = centralIdx + 1;
        }

        if (N < array[centralIdx]) {
            Right = centralIdx - 1;
        }

        if (Right - Left <= 1) {
            isSearchCompleted = true;
            isFound = N == array[Right];
        }
    }

    public int GetResult() {
        if (!isSearchCompleted) {
            return 0;
        }

        return isFound ? 1 : -1;
    }
}
