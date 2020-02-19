import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class ArrayDirectory implements Directory {
    private Entry[] directory ={};
    public static void main(String[] args){
        ArrayDirectory ad = new ArrayDirectory();
        String file = ArrayDirectory.class.getResource("test_data.csv").getFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");
                Entry entry = new Entry(values[0],values[1],values[2]);
                ad.insertEntry(entry);
            }
            reader.close();
        }
        catch(Exception FileNotFoundException){
            System.out.println("File does not exist");
        }
        for(Entry entry:ad.toArrayList()){
            System.out.println(entry.surname());
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

    public void insertEntry(Entry entry){
        if(!this.contains(entry)){
            this.directory = Arrays.copyOf(this.directory, this.directory.length + 1);
            this.directory[this.directory.length-1] = entry;
        }
    }

    public void deleteEntryUsingName(String surname) {
        Entry[] dupeDir = {};
        for(Entry entry:this.directory){
            if(!entry.surname().equals(surname)){
                dupeDir = Arrays.copyOf(dupeDir,dupeDir.length + 1);
                dupeDir[dupeDir.length-1] = entry;
            }
        }
        this.directory = dupeDir;
    }

    public void deleteEntryUsingExtension(String number) {
        Entry[] dupeDir = {};
        for(Entry entry:this.directory){
            if(!entry.ext().equals(number)){
                dupeDir = Arrays.copyOf(dupeDir,dupeDir.length + 1);
                dupeDir[dupeDir.length-1] = entry;
            }
        }
        this.directory = dupeDir;
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
        ArrayList<Entry> arrayList = new ArrayList<>();
        for(Entry entry:this.directory){
            arrayList.add(entry);
        }
        return arrayList;
    }

}