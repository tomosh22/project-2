import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static boolean TestDirectory(Directory directory){
        Input input = new Input("test_data.csv");
        input.InputFromCSVToDirectory(directory);
        Entry testEntry = directory.getRandomEntry();
        directory.deleteEntryUsingExtension(testEntry.ext());
        if(directory.contains(new Entry(testEntry.surname(),testEntry.initials(),testEntry.ext()))){
           return false;
        }
        testEntry = directory.getRandomEntry();
        directory.deleteEntryUsingName(testEntry.surname());
        if(directory.contains(new Entry(testEntry.surname(),testEntry.initials(),testEntry.ext()))){
            return false;
        }
        testEntry = directory.getRandomEntry();
        if(!directory.lookupExtension(testEntry.surname()).equals(testEntry.ext())){
            return false;
        }
        testEntry = directory.getRandomEntry();
        directory.updateExtensionUsingName(testEntry.surname(),"12345");
        if(!directory.lookupExtension(testEntry.surname()).equals("12345")){
            return false;
        }
        return true;
    }
    public static ArrayList<Long> TimeDirectory(Directory directory){
        Input input = new Input("test_data.csv");
        input.InputFromCSVToDirectory(directory);
        Entry testEntry = new Entry("test","test","test");
        ArrayList<Long> toReturn = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        directory.insertEntry(testEntry);
        toReturn.add(stopWatch.getElapsedTime());
        stopWatch.reset();
        testEntry = directory.getRandomEntry();

        stopWatch.start();
        directory.lookupExtension(testEntry.surname());
        toReturn.add(stopWatch.getElapsedTime());
        stopWatch.reset();
        testEntry = directory.getRandomEntry();

        stopWatch.start();
        directory.deleteEntryUsingExtension(testEntry.ext());
        toReturn.add(stopWatch.getElapsedTime());
        stopWatch.reset();
        testEntry = directory.getRandomEntry();

        stopWatch.start();
        directory.deleteEntryUsingName(testEntry.surname());
        toReturn.set(2, toReturn.get(2) + stopWatch.getElapsedTime());
        stopWatch.reset();

        return toReturn;
    }
    public static long getLowest(ArrayList<Long> array){
        long lowest = Long.MAX_VALUE;
        for(long x:array){
            if(x < lowest){
                lowest = x;
            }
        }
        return lowest;
    }
    public static long getHighest(ArrayList<Long> array){
        long highest = 0;
        for(long x:array){
            if(x > highest){
                highest = x;
            }
        }
        return highest;
    }
    public static long getAverage(ArrayList<Long> array){
        long sum = 0;
        for(long x:array){
            sum += x;
        }
        return sum / array.size();
    }
    public static void main(String[] args){
        System.out.println("ArrayDirectory working: "+TestDirectory(new ArrayDirectory()));
        System.out.println("ArrayListDirectory working: "+TestDirectory(new ArrayListDirectory()));
        System.out.println("HashMapDirectory working: "+TestDirectory(new HashMapDirectory()));



    }
}