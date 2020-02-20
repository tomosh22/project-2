public class Test {
    public static boolean TestDirectory(Directory directory){
        Input input = new Input("test_data.csv");
        input.InputFromCSVToDirectory(directory);
        directory.deleteEntryUsingExtension("18934");
        if(directory.contains(new Entry("Colt","L.C","18934"))){
           return false;
        }
        directory.deleteEntryUsingName("Lant");
        if(directory.contains(new Entry("Lant","N.C.L","77527"))){
            return false;
        }
        if(!directory.lookupExtension("Durnill").equals("79393")){
            return false;
        }
        directory.updateExtensionUsingName("Purnell","12345");
        if(!directory.lookupExtension("Purnell").equals("12345")){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("ArrayDirectory working: "+TestDirectory(new ArrayDirectory()));
        System.out.println("ArrayListDirectory working: "+TestDirectory(new ArrayListDirectory()));
        System.out.println("HashMapDirectory working: "+TestDirectory(new HashMapDirectory()));
    }
}