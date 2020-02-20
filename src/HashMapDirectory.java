import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDirectory implements Directory{
    private HashMap<Integer,Entry> directory = new HashMap<Integer,Entry>();
    public boolean contains(Entry entry){
        return false;
    }
    public void insertEntry(Entry entry) {
        this.directory.put(entry.hashCode(),entry);
    }

    public void deleteEntryUsingName(String surname) {
        Integer toRemove = null;
        for(Map.Entry<Integer,Entry> entry:this.directory.entrySet()){
            if(entry.getValue().surname().equals(surname)){
                toRemove = entry.getKey();
            }
        }
        this.directory.remove(toRemove);
    }

    public void deleteEntryUsingExtension(String number) {
        Integer toRemove = null;
        for(Map.Entry<Integer,Entry> entry:this.directory.entrySet()){
            if(entry.getValue().ext().equals(number)){
                toRemove = entry.getKey();
            }
        }
        this.directory.remove(toRemove);
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
        for(Map.Entry<Integer,Entry> map:this.directory.entrySet()){
            arrayList.add(this.directory.get(map.getKey()));
        }
        return arrayList;
    }
    public Entry getRandomEntry(){
        Integer key = (int)this.directory.keySet().toArray()[(int) (Math.random() * this.directory.keySet().toArray().length)];
        return this.directory.get(key);
    }
}
