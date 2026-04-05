import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //지역변수 등 관련 기초
    ///저장소 먼저 만들기
    static final List<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {

        //1.입력받기
        ///scanner는 하나만
        Scanner sc = new Scanner(System.in);

        int choice;

        //2.
        while (true) {
            System.out.println("1: 계좌 생성");
            System.out.println("2: 입금");
            System.out.println("3: 출금");
            System.out.println("4: 모든 계좌 조회");
            System.out.println("5: 종료");

            if (!sc.hasNextInt()) {
                System.out.println("1~5번 중 다시 선택해 주세요");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            //계좌 생성
            if (choice == 1) {
                System.out.println("이름을 입력해 주세요");

                String name = sc.next();

                System.out.println("주민번호를 입력해 주세요");

                if (!sc.hasNextLong()){
                    System.out.println("숫자로 다시 입력해 주새요.");
                    sc.next();
                    continue;
                }

                Long accountNum = sc.nextLong();

                BankAccount bankAccount = new BankAccount(name, accountNum);
                accounts.add(bankAccount);
            }

            //입금
            if (choice == 2) {
                System.out.println("계좌번호를 입력해 주세요");

                if (!sc.hasNextLong()){
                    System.out.println("계좌번호를 다시 입력해 주세요");
                    sc.next();
                    continue;
                }

                BankAccount account = findAccount(sc.nextLong());
                if (account == null) {
                    System.out.println("계좌가 존재하지 않습니다.");
                    continue;
                }

                System.out.println("입금할 금액을 작성해주세요");

                if (!sc.hasNextLong()){
                    System.out.println("금액을 다시 입력해 주세요.");
                    sc.next();
                    continue;
                }

                Long amount = sc.nextLong();
                account.deposit(amount);
                System.out.println(account.getBalance());

            }

            if (choice == 3) {
                System.out.println("계좌를 입력하세요.");

                if (!sc.hasNextLong()) {
                    System.out.println("계좌를 다시 입력해 주세요.");
                    sc.next();
                    continue;
                }

                BankAccount account = findAccount(sc.nextLong());
                if (account==null) {
                    System.out.println("계좌가 존재하지 않습니다.");
                    continue;
                }

                System.out.println("출금할 금액을 입력하세요");

                if (!sc.hasNextLong()) {
                    System.out.println("금액을 다시 입력하세요");
                    sc.next();
                    continue;
                }

                Long amount = sc.nextLong();
                account.withdraw(amount);
                System.out.println(account.getBalance());
            }

            if (choice == 4) {
                findAllAccounts();
            }

            if (choice == 5) {
                break;
            }


        }
        //계좌 조회
        //종료

    }

    private static BankAccount findAccount(Long accountNum) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNum().equals(accountNum)){
                return acc;
            }
        }
        return null;
    }

    private static void findAllAccounts() {
        for (BankAccount account : accounts) {
            System.out.println("이름" + account.getName());
            System.out.println("계좌번호" + account.getAccountNum());
            System.out.println("잔액" +account.getBalance());
            System.out.println("------------------------");
        }
    }

}

///나중에 테스트 코드 작성
///테스트할때 목업 데이터도 넣는 코드 추가하기