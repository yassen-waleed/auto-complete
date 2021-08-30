public class Target implements Comparable<Target> {
    private String word;
    private int count;

    public Target(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Target{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}' + "\n";
    }


    @Override
    public int compareTo(Target otherTarget) {
        return Integer.compare(this.count, otherTarget.getCount());
    }
}
