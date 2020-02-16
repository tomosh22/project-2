import java.util.Objects;

public class Entry {
    private String surname;
    private String initials;
    private String ext;
    public void surname(String surname){
        this.surname = surname;
    }
    public String surname(){
        return this.surname;
    }
    public void initials(String initials){
        this.initials = initials;
    }
    public String initials(){
        return this.initials;
    }
    public void ext(String ext){
        this.ext = ext;
    }
    public String ext(){
        return this.ext;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return surname.equals(entry.surname) &&
                initials.equals(entry.initials) &&
                ext.equals(entry.ext);
    }
    public int hashCode() {
        return Objects.hash(surname, initials, ext);
    }
}
