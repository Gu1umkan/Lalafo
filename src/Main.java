import dao.impl.AnnouncementDaoImpl;
import dao.impl.FavoriteDaoImpl;
import dao.impl.UserDaoImpl;
import db.Database;
import enums.Role;
import models.Announcement;
import models.Favorite;
import models.User;
import services.UserService;
import services.impl.AnnouncementServiceImpl;
import services.impl.FavoriteServiceImpl;
import services.impl.UserServiceImpl;
import uniqId.GenerateId;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static String inputString(Scanner scanner, String print) {
        while (true) {
            System.out.print(print);
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                return name;
            } else {
                System.out.println("Значение не может быть путым!");
            }
        }
    }

    public static Long getUserId(String print, Scanner scanner, UserService userMethod) {
        while (true) {
            try {
                System.out.print(print);
                long id = scanner.nextLong();
                if (userMethod.getUserById(id) != null) {
                    return id;
                } else {
                    System.out.println("Неправильный id!");
                    return null;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите правильное значение!");
                scanner.nextLine();
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        UserDaoImpl userDao = new UserDaoImpl(database);
        AnnouncementDaoImpl announcementDao = new AnnouncementDaoImpl(database);
        FavoriteDaoImpl favoriteDao = new FavoriteDaoImpl(database);

        AnnouncementServiceImpl announcementService = new AnnouncementServiceImpl(announcementDao);
        UserServiceImpl userService = new UserServiceImpl(userDao);
        FavoriteServiceImpl favoriteService = new FavoriteServiceImpl(favoriteDao);
        boolean exit = true;

        System.out.print("Hello and welcome!");
        System.out.println();

        while (exit) {
            try {
                menu();
                System.out.print("CHOICE COMMAND: ");
                int num = new Scanner(System.in).nextInt();
                switch (num) {
                    case 1 -> {
                        User user = new User();
                        user.setId(GenerateId.getUserId());
                        user.setUserName(inputString(scanner, "Введите имя пользователя: "));
                        user.setEmail(inputString(scanner, "Введите email: "));
                        user.setPass(inputString(scanner, "Введите пароль: "));
                        getRoleUser(scanner, user);
                        System.out.println(userService.add(user));
                    }
                    case 2 -> {
                        if (userService.getAllUsers().isEmpty()) {
                            System.out.println("Пользователей нет!");
                        } else {
                            Long id = getUserId("Введите id пользователя: ", scanner, userService);
                            if (id != null) {
                                System.out.println(userService.getUserById(id));
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Все пользователи: ");
                        userService.getAllUsers().forEach(System.out::println);
                    }

                    case 4 -> {
                        if (userService.getAllUsers().isEmpty()) {
                            System.out.println("Пользователей нет!");
                        } else {
                            Long id = getUserId("Введите id пользователя которого хотите удалить:  ", scanner, userService);
                            if (id != null) {
                                System.out.println(userService.removeById(id));
                            }
                        }
                    }
                    case 5 -> {
                        if (userService.getAllUsers().isEmpty()) {
                            System.out.println("Пользователей нет!");
                        } else {
                            Long id = getUserId("Введите id пользователя которого хотите изменить: ", scanner, userService);
                            scanner.nextLine();
                            if (id != null) {
                                User updatedUser = new User();
                                updatedUser.setId(id);
                                updatedUser.setUserName(inputString(scanner, "Введите имя пользователя: "));
                                updatedUser.setEmail(inputString(scanner, "Введите email: "));
                                updatedUser.setPass(inputString(scanner, "Введите пароль: "));
                                System.out.println("Выберите роль: \n 1 -> Admin,  2 -> User,  3 Vendor");
                                getRoleUser(scanner, updatedUser);
                                System.out.println(userService.updateById(id, updatedUser));
                            }
                        }
                    }
                    case 6 -> {
                        if (userService.getAllUsers().isEmpty()) {
                            System.out.println("Пользователей нет!");
                        } else {
                            Announcement announcement = new Announcement();
                            announcement.setId(GenerateId.getAnnouncementId());
                            createNewAnnouncement(scanner, announcement);
                            System.out.println("Все пользователи:");
                            userService.getAllUsers().forEach(System.out::println);
                            Long id = getUserId("Введите id которому хотите добавить объявление: ", scanner, userService);
                            if (id != null) {
                                announcement.setOwner(userService.getUserById(id));
                                System.out.println(announcementService.add(announcement));
                            }
                        }

                    }
                    case 7 -> {
                        if (announcementService.getAllAnnouncements().isEmpty()) {
                            System.out.println("Объявлений нет!");
                        } else {
                            try {
                                System.out.print("Напишите id объявление:  ");
                                long id = scanner.nextLong();
                                if (announcementService.getAnnouncementById(id) != null) {
                                    System.out.println(announcementService.getAnnouncementById(id));
                                } else {
                                    throw new InputMismatchException();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Неправильное id!");
                            }
                        }

                    }
                    case 8 -> {
                        if (announcementService.getAllAnnouncements().isEmpty()) {
                            System.out.println("Объявлений нет!");
                        } else {
                            System.out.println("Все объявления: ");
                            announcementService.getAllAnnouncements().forEach(System.out::println);
                        }
                    }
                    case 9 -> {
                        if (announcementService.getAllAnnouncements().isEmpty()) {
                            System.out.println("Объявлений нет!");
                        } else {
                            Long id = getUserId("Введите id пользователя: ", scanner, userService);
                            if (id != null) {
                                User user = userService.getUserById(id);
                                if (!user.getAnnouncements().isEmpty()) {
                                    System.out.println("Все объявления: ");
                                    user.getAnnouncements().forEach(System.out::println);
                                } else {
                                    System.out.println("Объявлений нету!");
                                }
                            }
                        }
                    }

                    case 10 -> {
                        if (announcementService.getAllAnnouncements().isEmpty()) {
                            System.out.println("Объявлений нет!");
                        } else {
                            try {
                                System.out.print("Напишите id объявление:  ");
                                scanner.nextLine();
                                long id = scanner.nextLong();
                                scanner.nextLine();
                                if (announcementService.getAnnouncementById(id) != null) {
                                    Announcement announcement = new Announcement();
                                    announcement.setId(announcementService.getAnnouncementById(id).getId());
                                    createNewAnnouncement(scanner, announcement);
                                    announcement.setOwner(announcementService.getAnnouncementById(id).getOwner());
                                    System.out.println(announcementService.updateById(id, announcement));
                                } else {
                                    throw new InputMismatchException();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Неправильное id!");
                            }
                        }

                    }
                    case 11 -> {
                        if (announcementService.getAllAnnouncements().isEmpty()) {
                            System.out.println("Объявлений нет!");
                        } else {
                            try {
                                System.out.print("Напишите id объявление:  ");
                                scanner.nextLine();
                                long id = scanner.nextLong();
                                System.out.println(announcementService.removeById(id));

                            } catch (InputMismatchException e) {
                                System.out.println("Неправильное id!");
                            }
                        }

                    }
                    case 12 -> {
                        if (userService.getAllUsers().isEmpty()) {
                            System.out.println("Пользователей нет!");
                        } else {
                            System.out.println("Все пользователи: ");
                            userService.getAllUsers().forEach(System.out::println);
                            scanner.nextLine();
                            Long id = getUserId("Введите id пользователя к которому хотите добавить избранное: ", scanner, userService);
                            if (id != null) {
                                Favorite newFavorite = new Favorite();
                                newFavorite.setUser(userService.getUserById(id));
                                System.out.println(favoriteService.add(newFavorite));
                            }
                        }
                    }
                    case 13 -> {
                        if (userService.getAllUsers().isEmpty()) {
                            System.out.println("Пользователей нет!");
                        } else {
                            System.out.println("Все пользователи: ");
                            userService.getAllUsers().forEach(System.out::println);
                            Long id = getUserId("Введите id пользователя: ", scanner, userService);
                            if (id != null) {
                                if (favoriteService.getFavoriteByUser(userService.getUserById(id)) != null) {
                                    System.out.println(favoriteService.getFavoriteByUser(userService.getUserById(id)));
                                } else {
                                    System.out.println("Избранного нету!");
                                }
                            }
                        }
                    }
                    case 14 -> {
                        if (userService.getAllUsers().isEmpty()) {
                            System.out.println("Пользователей нет!");
                        } else {
                            System.out.println("Все пользователи: ");
                            userService.getAllUsers().forEach(System.out::println);
                            Long id = getUserId("Введите id пользователя: ", scanner, userService);
                            if (id != null) {
                                if (favoriteService.getFavoriteByUser(userService.getUserById(id)) != null) {
                                    System.out.println("Все объявления: ");
                                    announcementService.getAllAnnouncements().forEach(System.out::println);
                                    try {
                                        System.out.print("Напишите id объявление:  ");
                                        long announcementId = scanner.nextLong();
                                        if (announcementService.getAnnouncementById(announcementId) != null) {
                                            favoriteService.getFavoriteByUser(userService.getUserById(id)).getAnnouncements().add(announcementService.getAnnouncementById(announcementId));
                                            System.out.println("Объявление успешно добавлено!");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Неправильное id!");
                                    }

                                } else {
                                    System.out.println("Избранного нету!");
                                }
                            }
                        }
                    }
                    case 15 -> {
                        if (userService.getAllUsers().isEmpty()) {
                            System.out.println("Пользователей нет!");
                        } else {
                            System.out.println("Все пользователи: ");
                            userService.getAllUsers().forEach(System.out::println);
                            Long id = getUserId("Введите id пользователя: ", scanner, userService);
                            if (id != null) {
                                if (favoriteService.getFavoriteByUser(userService.getUserById(id)) != null) {
                                    System.out.println(favoriteService.removeById(id));
                                } else {
                                    System.out.println("Избранного нету!");
                                }
                            }
                        }
                    }
                    case 16 -> {
                        System.out.println("Вы успешно вышли!");
                        exit = false;
                    }

                    default -> System.err.println("   INCORRECT CHOICE!!!   ");
                }
            } catch (InputMismatchException e) {
                System.out.println("ENTER NUMBER!!!");
            }
        }
    }

    private static void createNewAnnouncement(Scanner scanner, Announcement announcement) {
        announcement.setName(inputString(scanner, "Напишите имя объявление: "));
        announcement.setDescription(inputString(scanner, "Oписание объявления:  "));
        System.out.print("Цена объявления:  ");
        while (true) {
            if (scanner.hasNextInt()) {
                announcement.setPrice(scanner.nextInt());
                break;
            } else {
                System.out.println("Введите число!");
                scanner.nextLine();
            }
        }
    }

    private static void getRoleUser(Scanner scanner, User updatedUser) {
        do {
            System.out.println("Выберите роль: \n 1 -> Admin,  2 -> User,  3 Vendor ");
            switch (scanner.nextLine()) {
                case "1" -> updatedUser.setRole(Role.ADMIN);
                case "2" -> updatedUser.setRole(Role.USER);
                case "3" -> updatedUser.setRole(Role.VENDOR);
            }
        } while (updatedUser.getRole() == null);
    }

    public static void menu() {
        System.out.println("""
                1. ADD USER                              9.  GET ANNOUNCEMENT BY USER ID
                2. FIND USER BY ID                       10. UPDATE ANNOUNCEMENT
                3. GET ALL USERS                         11. DELETE ANNOUNCEMENT BY ID
                4. DELETE USER                           12. ADD FAVORITE
                5. UPDATE USER                           13. GET FAVORITE BY USER ID
                6. ADD ANNOUNCEMENT                      14. ADD ANNOUNCEMENT TO FAVORITE
                7. FIND ANNOUNCEMENT BY ID               15. DELETE FAVORITE BY USER ID
                8. GET ALL ANNOUNCEMENTS                 16. LEAVE""");

    }
}