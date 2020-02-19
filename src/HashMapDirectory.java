import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDirectory implements Directory{
    private HashMap<Integer,Entry> directory = new HashMap<Integer,Entry>();
    public static void main(String[] args){
        HashMapDirectory hmd = new HashMapDirectory();
        String file = ArrayDirectory.class.getResource("test_data.csv").getFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");
                Entry entry = new Entry(values[0],values[1],values[2]);
                hmd.insertEntry(entry);
            }
            reader.close();
        }
        catch(Exception FileNotFoundException){
            System.out.println("File does not exist");
        }
        for(Entry entry:hmd.toArrayList()){
            System.out.println(entry.surname());
        }
    }
    public boolean contains(Entry entry){
        return false;
    }
    public void insertEntry(Entry entry) {
        this.directory.put(entry.hashCode(),entry);
    }

    public void deleteEntryUsingName(String surname) {
        for(Map.Entry<Integer,Entry> entry:this.directory.entrySet()){
            if(entry.getValue().surname().equals(surname)){
                this.directory.remove(entry.getKey());
            }
        }
    }

    public void deleteEntryUsingExtension(String number) {
        for(Map.Entry<Integer,Entry> entry:this.directory.entrySet()){
            if(entry.getValue().ext().equals(number)){
                this.directory.remove(entry.getKey());
            }
        }
    }

    public void updateExtensionUsingName(String surname, String newNumber) {
        for(Map.Entry<Integer,Entry> entry:this.directory.entrySet()){
            if(entry.getValue().surname().equals(surname)){
                this.directory.get(entry.getKey()).ext(newNumber);
            }
        }
    }

    public String lookupExtension(String surname) {
        for(Map.Entry<Integer,Entry> entry:this.directory.entrySet()){
            if(entry.getValue().surname().equals(surname)){
                return this.directory.get(entry.getKey()).ext();
            }
        }
        return("Name not found");
    }

    public List<Entry> toArrayList() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for(Map.Entry<Integer,Entry> map:directory.entrySet()){
            arrayList.add(directory.get(map.getKey()));
        }
        return arrayList;
    }
}
