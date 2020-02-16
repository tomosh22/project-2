import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class ArrayDirectory implements Directory {
    Entry[] directory ={};
    public static void main(String[] args){
        ArrayDirectory ad = new ArrayDirectory();
        String file = ArrayDirectory.class.getResource("test_data.csv").getFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                String[] values = line.split(",");
                Entry entry = new Entry();
                entry.surname(values[0]);
                entry.initials(values[1]);
                entry.ext(values[2]);
                ad.insertEntry(entry);
            }
            reader.close();
        }
        catch(Exception FileNotFoundException){
            System.out.println("File does not exist");
        }
        //ad.printDirectory();
        for(Entry entry:ad.toArrayList()){
            System.out.println(entry.surname());
        }

    }
    public boolean contains(Entry entry){
        for(Entry entryCheck:directory){
            if (entryCheck.equals(entry)){
                return true;
            }
        }
        return false;
    }
    public void printDirectory(){
        for(Entry entry:directory){
            System.out.println(entry.surname()+entry.initials()+entry.ext());
        }
    }
    public void insertEntry(Entry entry){
        if(!this.contains(entry)){
            directory = Arrays.copyOf(directory, directory.length + 1);
            directory[directory.length-1] = entry;
        }
    }

    public void deleteEntryUsingName(String surname) {
        Entry[] dupeDir = {};
        for(Entry entry:directory){
            if(entry.surname()!=surname){
                dupeDir = Arrays.copyOf(dupeDir,dupeDir.length + 1);
                dupeDir[dupeDir.length-1] = entry;
            }
        }
        directory = dupeDir;
    }

    public void deleteEntryUsingExtension(String number) {
        Entry[] dupeDir = {};
        for(Entry entry:directory){
            if(entry.ext()!=number){
                dupeDir = Arrays.copyOf(dupeDir,dupeDir.length + 1);
                dupeDir[dupeDir.length-1] = entry;
            }
        }
        directory = dupeDir;
    }

    public void updateExtensionUsingName(String surname, String newNumber) {
        for(Entry entry:directory){
            if(entry.surname() == surname){
                entry.ext(newNumber);
            }
        }
    }

    public String lookupExtension(String surname) {
        for(Entry entry:directory){
            if(entry.surname() == surname){
                return entry.ext();
            }
        }
        return("Name not found");
    }

    public List<Entry> toArrayList() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for(Entry entry:directory){
            arrayList.add(entry);
        }
        return arrayList;
    }

}