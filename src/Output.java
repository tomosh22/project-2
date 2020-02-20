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

}