import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Output {
    public Output(Directory directory){
        int longestName = 0;
        int longestInitials = 0;
        int longestExt = 0;
        for (Entry entry:directory.toArrayList()){
            if (entry.surname().length() > longestName){
                longestName = entry.surname().length();
            }
            if (entry.initials().length() > longestInitials){
                longestInitials = entry.initials().length();
            }
            if (entry.ext().length() > longestExt){
                longestExt = entry.ext().length();
            }
        }
        if("Surname".length() > longestName){
            longestName = "Surname".length();
        }
        if("Initials".length() > longestInitials){
            longestInitials = "Initials".length();
        }
        if("Extension".length() > longestExt){
            longestExt = "Extension".length();
        }

        System.out.print(longestName + " ");
        System.out.print(longestInitials + " ");
        System.out.print(longestExt + "\n");
        System.out.println("****"+"*".repeat(longestName+longestInitials+longestExt));
        System.out.println("|Surname" + " ".repeat(longestName - 7)+"|Initials"+" ".repeat(longestInitials - 8) + "|Extension"+" ".repeat(longestExt - 9)+"|");
        System.out.println("****"+"*".repeat(longestName+longestInitials+longestExt));
        for (Entry entry:directory.toArrayList()){
            System.out.println(
                    "|" +entry.surname() +" ".repeat(longestName - entry.surname().length())+
                            "|" + entry.initials() +" ".repeat(longestInitials - entry.initials().length())+
                            "|" + entry.ext() +" ".repeat(longestExt - entry.ext().length())+"|");
        }
        System.out.println("****"+"*".repeat(longestName+longestInitials+longestExt));
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Long>>  arrayTimes = new ArrayList<>();
        ArrayList<ArrayList<Long>> arrayListTimes = new ArrayList<>();
        ArrayList<ArrayList<Long>>  hashMapTimes = new ArrayList<>();
        for(int x=0;x<10000;x++){
            ArrayDirectory ad = new ArrayDirectory();
            ArrayListDirectory ald = new ArrayListDirectory();
            HashMapDirectory hmd = new HashMapDirectory();
            arrayTimes.add(Test.TimeDirectory(ad));
            arrayListTimes.add(Test.TimeDirectory(ald));
            hashMapTimes.add(Test.TimeDirectory(hmd));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name to save performance report");
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(scanner.nextLine()));
            writer.println("ArrayDirectory:");
            writer.println("Insertion:");
            writer.println("Shortest Time:\n"+ Test.getLowest(arrayTimes.get(0)));
            writer.println("Average Time:\n"+ Test.getAverage(arrayTimes.get(0)));
            writer.println("Longest Time:\n"+ Test.getHighest(arrayTimes.get(0)));
            writer.println("Lookup:");
            writer.println("Shortest Time:\n"+ Test.getLowest(arrayTimes.get(1)));
            writer.println("Average Time:\n"+ Test.getAverage(arrayTimes.get(1)));
            writer.println("Longest Time:\n"+ Test.getHighest(arrayTimes.get(1)));
            writer.println("Deletion:");
            writer.println("Shortest Time:\n"+ Test.getLowest(arrayTimes.get(2)));
            writer.println("Average Time:\n"+ Test.getAverage(arrayTimes.get(2)));
            writer.println("Longest Time:\n"+ Test.getHighest(arrayTimes.get(2)));
            writer.println();
            writer.println("ArrayListDirectory:");
            writer.println("Insertion:");
            writer.println("Shortest Time:\n"+ Test.getLowest(arrayListTimes.get(0)));
            writer.println("Average Time:\n"+ Test.getAverage(arrayListTimes.get(0)));
            writer.println("Longest Time:\n"+ Test.getHighest(arrayListTimes.get(0)));
            writer.println("Lookup:");
            writer.println("Shortest Time:\n"+ Test.getLowest(arrayListTimes.get(1)));
            writer.println("Average Time:\n"+ Test.getAverage(arrayListTimes.get(1)));
            writer.println("Longest Time:\n"+ Test.getHighest(arrayListTimes.get(1)));
            writer.println("Deletion:");
            writer.println("Shortest Time:\n"+ Test.getLowest(arrayListTimes.get(2)));
            writer.println("Average Time:\n"+ Test.getAverage(arrayListTimes.get(2)));
            writer.println("Longest Time:\n"+ Test.getHighest(arrayListTimes.get(2)));
            writer.println();
            writer.println("HashMapDirectory:");
            writer.println("Insertion:");
            writer.println("Shortest Time:\n"+ Test.getLowest(hashMapTimes.get(0)));
            writer.println("Average Time:\n"+ Test.getAverage(hashMapTimes.get(0)));
            writer.println("Longest Time:\n"+ Test.getHighest(hashMapTimes.get(0)));
            writer.println("Lookup:");
            writer.println("Shortest Time:\n"+ Test.getLowest(hashMapTimes.get(1)));
            writer.println("Average Time:\n"+ Test.getAverage(hashMapTimes.get(1)));
            writer.println("Longest Time:\n"+ Test.getHighest(hashMapTimes.get(1)));
            writer.println("Deletion:");
            writer.println("Shortest Time:\n"+ Test.getLowest(hashMapTimes.get(2)));
            writer.println("Average Time:\n"+ Test.getAverage(hashMapTimes.get(2)));
            writer.println("Longest Time:\n"+ Test.getHighest(hashMapTimes.get(2)));

            writer.close();
        }
        catch(Exception FileNotFoundException){}
        scanner.close();
    }

}