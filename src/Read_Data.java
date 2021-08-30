import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Read_Data {
    static ArrayList<String> array;

    public static void read() throws FileNotFoundException {
        array = new ArrayList<>();
        File myObj = new File("Data1.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            array.add(data);
        }
    }

    public static HashMap<String, Data> trigram(ArrayList<String> data) {
        HashMap<String, Data> trigram = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {

            String[] arr = data.get(i).split(" ");
            for (int j = 0; j < arr.length - 2; j++) {

                String key = arr[j] + " " + arr[j + 1];
                Target target;
                Data dataa = new Data();
                if (!trigram.containsKey(key)) {

                    target = new Target(arr[j + 2], 1);
                    ArrayList<Target> list = new ArrayList<>();
                    list.add(target);
                    dataa.setCounter(1);
                    dataa.setList(list);
                    dataa.setWord_1(key);
                    trigram.put(dataa.getWord_1(), dataa);

                } else {

                    trigram.get(key).setCounter(trigram.get(key).getCounter() + 1);
                    boolean flag = false;
                    for (int k = 0; k < trigram.get(key).getList().size(); k++) {
                        if (trigram.get(key).getList().get(k).getWord().equals(arr[j + 2])) {
                            trigram.get(key).getList().get(k).setCount(trigram.get(key).getList().get(k).getCount() + 1);
                            flag = true;
                        }
                    }
                    if (flag == false) {
                        trigram.get(key).getList().add(new Target(arr[j + 2], 1));
                    }
                }
            }
        }
        return trigram;
    }
}
