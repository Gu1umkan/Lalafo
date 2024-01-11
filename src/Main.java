import dao.impl.AnnouncementDaoImpl;
import dao.impl.FavoriteDaoImpl;
import dao.impl.UserDaoImpl;
import db.Database;
import services.impl.AnnouncementServiceImpl;
import services.impl.FavoriteServiceImpl;
import services.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        Database database = new Database();
        AnnouncementServiceImpl announcementService = new AnnouncementServiceImpl(new AnnouncementDaoImpl(database) );
        FavoriteServiceImpl favoriteService = new FavoriteServiceImpl(new FavoriteDaoImpl(database));
        UserServiceImpl userService = new UserServiceImpl(new UserDaoImpl(database));

            while (true) {
                try {
                menu();
                System.out.println("     CHOICE COMMAND  ");
                int num = new Scanner(System.in).nextInt();
                switch (num) {
                    case 1 -> {
                        System.out.println("Enter user name; ");
userService.add();
                    }
                    case 2 -> {
userService.getUserById();
                    }
                    case 3 -> {
userService.getAllUsers();
                    }
                    case 4 -> {
userService.removeById();
                    }
                    case 5 -> {
userService.updateById();
                    }
                    case 6 -> {
announcementService.add();
                    }
                    case 7 -> {
announcementService.getAnnouncementById();
                    }
                    case 8 -> {
announcementService.getAllAnnouncements();
                    }
                    case 9 -> {
announcementService.getAnnouncementsByUser();
                    }
                    case 10 -> {
announcementService.getAnnouncementById();
                    }
                    case 11 -> {
announcementService.updateById();
                    }
                    case 12 -> {
announcementService.removeById();
                    }
                    case 13 -> {
favoriteService.add();
                    }
                    case 14 -> {
favoriteService.getFavoriteByUser();
                    }
                    case 15 -> {
favoriteService.updateById();
                    }
                    case 16 -> {
favoriteService.removeById();



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
                2. FIND USER BY ID                       13. DELETE ANNOUNCEMENT BY ID
                3. GET ALL USER
                4. DELETE USER                           14. ADD FAVORITE
                5. UPDATE USER                           15. GET FAVORITE BY USER ID
                6. ADD ANNOUNCEMENT                      16. GET ALL FAVORITE
                7. FIND ANNOUNCEMENT BY ID               17. DELETE FAVORITE BY USER ID
                8. GET ALL ANNOUNCEMENT                   
                9. GET ALL ANNOUNCEMENT BY USER ID       
                10. GET ANNOUNCEMENT BY ID               
                """);

    }
}