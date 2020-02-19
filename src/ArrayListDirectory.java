import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class ArrayListDirectory implements Directory{
    private ArrayList<Entry> directory = new ArrayList<Entry>();
    public static void main(String[] args){
        ArrayListDirectory ald = new ArrayListDirectory();
        String file = ArrayDirectory.class.getResource("test_data.csv").getFile();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");
                Entry entry = new Entry(values[0],values[1],values[2]);
                ald.insertEntry(entry);
            }
            reader.close();
        }
        catch(Exception FileNotFoundException){
            System.out.println("File does not exist");
        }
    }
    public boolean contains(Entry entry){
        for(Entry entryCheck:this.directory){
            if (entryCheck.equals(entry)){
                return true;
            }
        }
        return false;
    }
    public void insertEntry(Entry entry) {
        if(!this.contains(entry)){
            this.directory.add(entry);
        }
    }

    public void deleteEntryUsingName(String surname) {
        for(Entry entry:this.directory){
            if(entry.surname().equals(surname)){
                this.directory.remove(entry);
            }
        }
    }

    public void deleteEntryUsingExtension(String number) {
        for(Entry entry:this.directory){
            if(entry.ext().equals(number)){
                this.directory.remove(entry);
            }
        }
    }

    public void updateExtensionUsingName(String surname, String newNumber) {
        for(Entry entry:this.directory){
            if(entry.surname().equals(surname)){
                entry.ext(newNumber);
            }
        }
    }

    public String lookupExtension(String surname) {
        for(Entry entry:this.directory){
            if(entry.surname().equals(surname)){
                return entry.ext();
            }
        }
        return("Name not found");
    }

    public List<Entry> toArrayList() {
        return this.directory;
    }
}
