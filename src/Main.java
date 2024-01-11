import dao.UserDao;
import dao.impl.AnnouncementDaoImpl;
import dao.impl.FavoriteDaoImpl;
import dao.impl.UserDaoImpl;
import db.Database;
import enums.Role;
import models.Announcement;
import models.User;
import services.impl.AnnouncementServiceImpl;
import services.impl.FavoriteServiceImpl;
import services.impl.UserServiceImpl;
import uniqId.GenerateId;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> newUserss = null;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Database database = new Database();
        UserDaoImpl userDao = new UserDaoImpl(database);
        UserServiceImpl userService = new UserServiceImpl(userDao);
        AnnouncementDaoImpl announcementDao = new AnnouncementDaoImpl(database);
        AnnouncementServiceImpl announcementService = new AnnouncementServiceImpl(announcementDao);
        FavoriteDaoImpl favoriteDao = new FavoriteDaoImpl(database);
        FavoriteServiceImpl favoriteService = new FavoriteServiceImpl(favoriteDao);


        System.out.print("Hello and welcome!");
        System.out.println();

        while (true) {
            try {
                menu();
                System.out.println("     CHOICE COMMAND:  ");
                int num = new Scanner(System.in).nextInt();
                switch (num) {
                    case 1 -> {
                        User user = new User();
                        user.setId(GenerateId.getUserId());
                        Whail1:
                        while (true) {
                            System.out.print("Введите имя пользователя:  ");
                            String name = scanner.nextLine();
                            if (!name.isEmpty()) {
                                user.setUserName(name);
                                break Whail1;
                            } else {
                                System.err.println("Имя не может быть путым!");
                            }
                        }
                        Whail2:
                        while (true) {
                            System.out.print("Логин: ");
                            String email = scanner.nextLine();
                            if (!email.isEmpty()) {
                                user.setEmail(email);
                                break Whail2;
                            } else {
                                System.err.println("Логин не может быт пустым!");
                            }
                        }
                        Whail3:
                        while (true) {
                            System.out.print("Создайте пароль: ");
                            String pas = scanner.nextLine();
                            if (pas.length() > 3) {
                                user.setPass(pas);
                                break Whail3;
                            } else {
                                System.err.print("Пароль должен быть не менше 4!");
                            }
                        }
                        System.out.println("Выберите роль: \n 1 -> Admin,  2 -> User,  3 Vendor ");
                        switch (scanner.nextLine()) {
                            case "1" -> user.setRole(Role.ADMIN);
                            case "2" -> user.setRole(Role.USER);
                            case "3" -> user.setRole(Role.VENDOR);
                        }
                        System.out.println(userService.add(user));
                    }
                    case 2 -> {
                        System.out.print("Введите id пользователя: ");
                        long id = scanner1.nextLong();
                        System.out.println(userService.getUserById(id));
                    }
                    case 3 -> {
                        List<User> allUsers = userService.getAllUsers();
                        System.out.println(allUsers);
                        newUserss = allUsers;
                    }

                    case 4 -> {
                        System.out.print("Введите id пользователя которую хотите удалить:  ");
                        long id = scanner1.nextLong();
                        System.out.println(userService.removeById(id));
                    }
                    case 5 -> {
                        System.out.print("Введите id пользователя которую хотите изменит:  ");
                        long id = scanner1.nextLong();
                        User users = new User();
                        Whail1:
                        while (true) {
                            System.out.print("Введите имя:  ");
                            String name = scanner.nextLine();
                            if (!name.isEmpty()) {
                                users.setUserName(name);
                                break Whail1;
                            } else {
                                System.err.println("Имя не может быть пустым!");
                            }
                        }
                        Whail2:
                        while (true) {
                            System.out.print("Логин:   ");
                            String email = scanner.nextLine();
                            if (!email.isEmpty()) {
                                users.setEmail(email);
                                break Whail2;
                            } else {
                                System.err.println("Логин не может быт пустым!");
                            }
                        }
                        Whail3:
                        while (true) {
                            System.out.print("Создайте пароль:  ");
                            String pas = scanner.nextLine();
                            if (pas.length() > 3) {
                                users.setPass(pas);
                                break Whail3;
                            } else {
                                System.err.println("Пароль должен быть не менше 4!");
                            }
                        }
                        System.out.println("Выберите роль: \n 1 -> Admin,  2 -> User,  3 Vendor");
                        switch (scanner.nextLine()) {
                            case "1" -> users.setRole(Role.ADMIN);
                            case "2" -> users.setRole(Role.USER);
                            case "3" -> users.setRole(Role.VENDOR);
                        }
                        System.out.println(userService.updateById(id, users));

                    }
                    case 6 -> {
                        User userr = null;
                        Announcement announcement = new Announcement();
                        announcement.setId(GenerateId.getAnnouncementId());
                        System.out.print("Напишите имя объявление:  ");
                        String ann = scanner.nextLine();
                        announcement.setName(ann);
                        System.out.print("Oписание объявления:  ");
                        String des = scanner.nextLine();
                        announcement.setDescription(des);
                        System.out.print("Цена объявления:  ");
                        int price = new Scanner(System.in).nextInt();
                        announcement.setPrice(price);
                        for (User user : newUserss) {
                            userr = user;
                        }
                        announcement.setOwner(userr);
                        System.out.println(announcementService.add(announcement));
                    }
                    case 7 -> {
                        System.out.print("Напишите id объявление:  ");
                        long id = scanner1.nextLong();
                        System.out.println(announcementService.getAnnouncementById(id));
                    }
                    case 8 -> {
                        System.out.println(announcementService.getAllAnnouncements());
                    }
                    case 9 ->{

                    }

                    case 10 -> {
                        System.out.println();
                    }
                    case 11 -> {

                    }
                    case 12 -> {

                    }
                    case 13 -> {
                        User user = new User();
                        System.out.println("Список пользователей: ");
                        System.out.println(newUserss);
                    }
                    case 14 -> {

                    }
                    case 15 -> {

                    }
                    case 16 -> {

                    }


                    default -> {
                        System.err.println("   INCORRECT CHOICE!!!   ");
                    }
                }
            } catch (RuntimeException e) {
                System.err.println("     ENTER NUMBER!!!");
            }
        }
    }

    public static void menu() {
        System.out.println("""
                1. ADD USER                             
                2. FIND USER BY ID                       11.  DELETE ANNOUNCEMENTS BY USER ID
                3. GET ALL USER                          12.  DELETE ANNOUNCEMENT BY ID  
                4. DELETE USER                           13. ADD FAVORITE
                5. UPDATE USER                           14. GET FAVORITE BY USER ID
                6.  ADD ANNOUNCEMENT                     15. GET ALL FAVORITE
                7. FIND ANNOUNCEMENT BY ID               16. DELETE FAVORITE BY USER ID
                8. GET ALL ANNOUNCEMENT                  
                9.  GET ANNOUNCEMENT BY USER ID                
                10. UPDATE ANNOUNCEMENTS                 
                """);

    }
}