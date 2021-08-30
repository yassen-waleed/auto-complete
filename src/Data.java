import java.util.ArrayList;
import java.util.HashMap;

public class Data {

    private String word_1;
    private int counter;
    private ArrayList<Target> list;

    public Data() {
    }

    public Data(String word_1, int counter, ArrayList<Target> list) {
        this.word_1 = word_1;
        this.counter = counter;
        this.list = list;
    }

    public String getWord_1() {
        return word_1;
    }

    public void setWord_1(String word_1) {
        this.word_1 = word_1;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ArrayList<Target> getList() {
        return list;
    }

    public void setList(ArrayList<Target> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < list.size(); i++) {

        }
        return "Data{" +
                "word_1='" + word_1 + '\'' +
                ", counter=" + counter +
                '}';
    }
}
