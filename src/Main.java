import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

            while (true) {
                try {
                menu();
                System.out.println("     CHOICE COMMAND  ");
                int num = new Scanner(System.in).nextInt();
                switch (num) {
                    case 1 -> {

                    }
                    case 2 -> {

                    }
                    case 3 -> {

                    }
                    case 4 -> {

                    }
                    case 5 -> {

                    }
                    case 6 -> {

                    }
                    case 7 -> {

                    }
                    case 8 -> {

                    }
                    case 9 -> {

                    }
                    case 10 -> {

                    }
                    case 11 -> {

                    }
                    case 12 -> {

                    }
                    case 13 -> {

                    }
                    case 14 -> {

                    }
                    case 15 -> {

                    }
                    case 16 -> {

                    }
                    case 17 -> {

                    }
                    case 18 -> {

                    }
                    case 19 -> {

                    }
                    case 20 -> {


                    }
                    default -> {
                        System.err.println("   INCORRECT CHOICE!!!   ");
                    }
                }
            }catch (RuntimeException e){
                System.err.println("     ENTER NUMBER!!!");
        }
        }
    }
    public static  void menu(){
        System.out.println("""
                1. ADD USER                              11. UPDATE ANNOUNCEMENTS
                2. FIND USER BY ID                       12. DELETE ANNOUNCEMENTS BY USER ID
                3. GET ALL USER                          13. DELETE ANNOUNCEMENT BY ID  
                4. DELETE USER                           14. ADD FAVORITE
                5. UPDATE USER                           15. GET FAVORITE BY USER ID
                6. ADD ANNOUNCEMENT                      16. GET ALL FAVORITE
                7. FIND ANNOUNCEMENT BY ID               17. DELETE FAVORITE BY USER ID
                8. GET ALL ANNOUNCEMENT                  18. 
                9. GET ALL ANNOUNCEMENT BY USER ID       19.
                10. GET ANNOUNCEMENT BY ID               20.
                """);

    }
}