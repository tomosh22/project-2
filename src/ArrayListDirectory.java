import java.util.List;
import java.util.ArrayList;

public class ArrayListDirectory implements Directory{
    private ArrayList<Entry> directory = new ArrayList<>();
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
        Entry toRemove = null;
        for(Entry entry:this.directory){
            if(entry.surname().equals(surname)){
                toRemove = entry;
            }
        }
        this.directory.remove(toRemove);
    }

    public void deleteEntryUsingExtension(String number) {
        Entry toRemove = null;
        for(Entry entry:this.directory){
            if(entry.ext().equals(number)){
                toRemove = entry;
            }
        }
        this.directory.remove(toRemove);
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
