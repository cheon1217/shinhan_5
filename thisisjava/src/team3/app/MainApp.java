package team3.app;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import team3.analystics.JoinAnalytics;
import team3.domain.Users;
import team3.domain.UsersCars;
import team3.service.CarsService;
import team3.service.UsersCarsService;
import team3.service.UsersService;

public class MainApp {

    static UsersService usersService = new UsersService();
    static CarsService carsService = new CarsService();
    static UsersCarsService usersCarsService = new UsersCarsService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        printAsciiArt();
        
        while (isRunning) {
            System.out.println("\n==== 메인 메뉴 ====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 통계 메뉴");
            System.out.println("0. 종료");
            System.out.print("선택 >> ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> register(scanner);
                case 2 -> login(scanner);
                case 3 -> adminMenu(scanner);
                case 0 -> {
                    System.out.println("프로그램 종료");
                    isRunning = false;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
        scanner.close();
    }

    private static void register(Scanner scanner) {
        System.out.println("[회원가입]");
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();
        System.out.print("나이: ");
        int age = Integer.parseInt(scanner.nextLine());

        int newUserId = usersService.generateNewUserId();
        Users newUser = new Users(newUserId, email, password, age, 50);
        boolean success = usersService.registerUser(newUser);

        System.out.println(success ? "✅ 회원가입 성공" : "❌ 회원가입 실패");
    }

    private static void login(Scanner scanner) {
        System.out.println("[로그인]");
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        Users user = usersService.loginUser(email, password);

        if (user != null) {
            System.out.println("✅ 로그인 성공");
            userMenu(scanner, user);
        } else {
            System.out.println("❌ 로그인 실패");
        }
    }

    private static void userMenu(Scanner scanner, Users user) {
        boolean isLoggedIn = true;

        while (isLoggedIn) {
            System.out.println("\n==== 유저 메뉴 ====");
            System.out.println("1. 마이페이지");
            System.out.println("2. 차량 목록 조회");
            System.out.println("3. 차량 대여하기");
            System.out.println("4. 대여 내역 조회");
            System.out.println("5. 차량 반납");
            System.out.println("6. 차량 대여 취소");
            System.out.println("7. 회원 탈퇴");
            System.out.println("0. 로그아웃");
            System.out.print("선택 >> ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> JoinAnalytics.showUserMyPage(user.getUserId());
                case 2 -> {
                	System.out.println("[차량 목록 조회]");
                    List<String> cars = carsService.getAllCarsWithStatus();
                    cars.forEach(System.out::println);

                    System.out.println("\n[특정 날짜 예약 가능한 차량 조회]");
                    System.out.print("조회할 날짜 (YYYY-MM-DD): ");
                    String input = scanner.nextLine();
                    try {
                        Date date = Date.valueOf(input);
                        List<String> availableCars = carsService.getAvailableCarsByDate(date);
                        if (availableCars.isEmpty()) {
                            System.out.println("해당 날짜에 예약 가능한 차량이 없습니다.");
                        } else {
                            availableCars.forEach(System.out::println);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("날짜 형식이 올바르지 않습니다.");
                    }
                }
                case 3 -> usersCarsService.rentCar(scanner, user.getUserId());
                case 4 -> {
                    List<UsersCars> rentals = usersCarsService.getRentList(user.getUserId());
                    rentals.forEach(System.out::println);
                }
                case 5 -> {
                	List<UsersCars> rentals = usersCarsService.getJigeumRentList(user.getUserId());
                    rentals.forEach(System.out::println);
                    System.out.println();
                	usersCarsService.returnCar(scanner, user.getUserId());
                }
                case 6 -> usersCarsService.cancelRent(scanner, user.getUserId());
                case 7 -> {
                    boolean result = usersService.deleteUser(user.getUserId());
                    System.out.println(result ? "회원 탈퇴 완료" : "탈퇴 실패");
                    isLoggedIn = false;
                }
                case 0 -> {
                    System.out.println("로그아웃 완료");
                    isLoggedIn = false;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void adminMenu(Scanner scanner) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n==== 통계 메뉴 ====");
            System.out.println("1. 전체 대여 내역 조회");
            System.out.println("2. 지점별 차량 목록");
            System.out.println("3. 차량별 대여 내역");
            System.out.println("4. 인기 차량 순위");
            System.out.println("5. 연령대별 차량 선호");
            System.out.println("6. 차량별 결제 통계");
            System.out.println("0. 돌아가기");
            System.out.print("선택 >> ");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1 -> JoinAnalytics.showAllRentals();
                    case 2 -> JoinAnalytics.showCarsByBranch();
                    case 3 -> {
                        System.out.print("차량 ID 입력: ");
                        int carId = Integer.parseInt(scanner.nextLine());
                        JoinAnalytics.showRentalsByCar(carId);
                    }
                    case 4 -> JoinAnalytics.showPopularCars();
                    case 5 -> JoinAnalytics.showAgeGroupCarPreference();
                    case 6 -> JoinAnalytics.showCarPaymentStats();
                    case 0 -> isRunning = false;
                    default -> System.out.println("잘못된 입력입니다.");
                }
            } catch (Exception e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }
    }
    
    private static void printAsciiArt() {
	    String[] lines = {
	        // 신한
	        " $$$$$$\\  $$\\       $$\\           $$\\                                 ",
	        "$$  __$$\\ $$ |      \\__|          $$ |                                ",
	        "$$ /  \\__|$$$$$$$\\  $$\\ $$$$$$$\\  $$$$$$$\\   $$$$$$\\  $$$$$$$\\        ",
	        "\\$$$$$$\\  $$  __$$\\ $$ |$$  __$$\\ $$  __$$\\  \\____$$\\ $$  __$$\\       ",
	        " \\____$$\\ $$ |  $$ |$$ |$$ |  $$ |$$ |  $$ | $$$$$$$ |$$ |  $$ |      ",
	        "$$\\   $$ |$$ |  $$ |$$ |$$ |  $$ |$$ |  $$ |$$  __$$ |$$ |  $$ |      ",
	        "\\$$$$$$  |$$ |  $$ |$$ |$$ |  $$ |$$ |  $$ |\\$$$$$$$ |$$ |  $$ |      ",
	        " \\______/ \\__|  \\__|\\__|\\__|  \\__|\\__|  \\__| \\_______|\\__|  \\__|   ",

	        // 렌트카
	        "$$$$$$$\\                       $$\\            $$$$$$\\                            $$\\ $$\\ $$\\ ",
	        "$$  __$$\\                      $$ |          $$  __$$\\                           $$ |$$ |$$ |",
	        "$$ |  $$ | $$$$$$\\  $$$$$$$\\ $$$$$$\\         $$ /  \\__| $$$$$$\\   $$$$$$\\        $$ |$$ |$$ |",
	        "$$$$$$$  |$$  __$$\\ $$  __$$\\\\_$$  _|        $$ |       \\____$$\\ $$  __$$\\       $$ |$$ |$$ |",
	        "$$  __$$< $$$$$$$$ |$$ |  $$ | $$ |          $$ |       $$$$$$$ |$$ |  \\__|      \\__|\\__|\\__|",
	        "$$ |  $$ |$$   ____|$$ |  $$ | $$ |$$\\       $$ |  $$\\ $$  __$$ |$$ |                        ",
	        "$$ |  $$ |\\$$$$$$$\\ $$ |  $$ | \\$$$$  |      \\$$$$$$  |\\$$$$$$$ |$$ |            $$\\ $$\\ $$\\ ",
	        "\\__|  \\__| \\_______|\\__|  \\__|  \\____/        \\______/  \\_______|\\__|            \\__|\\__|\\__|"
	    };

	    for (String line : lines) {
	        System.out.println(line);
	        try {
	            Thread.sleep(70); 
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}
}
