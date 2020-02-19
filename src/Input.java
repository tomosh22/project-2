import java.util.Scanner;
import java.io.FileReader;
import java.util.Arrays;

public class Input{
    private String path = "";

    public void InputFromCSVToDirectory(Directory directory){
        Entry[] array = {};
        try {
            Scanner scanner = new Scanner(new FileReader(this.path));
            String line;
            while((line = scanner.nextLine()) != null){
                String[] values = line.split(",");
                Entry entry = new Entry(values[0],values[1],values[2]);
                directory.insertEntry(entry);
            }
            scanner.close();
        }
        catch(Exception FileNotFoundException){
            System.out.println("File does not exist");
        }
    }



    public void InputFromConsoleToDirectory(Directory directory){
        Entry[] array = {};
        Boolean cont = true;
        Scanner scanner = new Scanner(System.in);
        while(cont){
            System.out.println("Enter entry in format SURNAME,INITIALS,EXTENSION");
            String[] values = scanner.nextLine().split(",");
            if (values.length == 3){
                array = Arrays.copyOf(array, array.length + 1);
                Entry entry = new Entry(values[0],values[1],values[2]);
                directory.insertEntry(entry);
            }
            System.out.println("Enter 'yes' to add more");
            if(!scanner.nextLine().equals("yes")){
                cont = false;
            }
        }
    }



    public Input(String file){
        this.path = Input.class.getResource(file).getFile();
    }
}