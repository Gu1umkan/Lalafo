package uniqId;

public class GenerateId {
    private static long id1 = 1;
    private static long id2 = 1;
    private static long id3 = 1;
    public static long getAnnouncementId(){
        return id1++;
    }
    public static long getUserId(){
        return id2++;
    }
    public static long getFavorite(){
        return id3++;
    }
}
