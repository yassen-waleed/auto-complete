import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Read_Data.read();
        ArrayList<String> array = Read_Data.array;
        HashMap<String, Data> trigram = Read_Data.trigram(array);
        System.out.println(trigram.size());
        System.out.println(trigram.get("في فلسطين").getList().toString());
    }
}
