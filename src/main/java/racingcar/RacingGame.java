package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class RacingGame {
    private final HashMap<String, RacingCar> playerTable;
    private int n;
    private final Vector<String> winnerList;

    public RacingGame() {
        playerTable = new HashMap<>();
        winnerList = new Vector<>();
    }

    public void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String[] playerList = input.split(",");
        for (String player : playerList) {
            if (player.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
            }
            playerTable.put(player, new RacingCar());
        }

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        n = Integer.parseInt(input);
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            playerTable.forEach((playerName, racingCar) -> {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random > 3) {
                    racingCar.moveForward();
                }
                printStatus(playerName, racingCar);
            });
        }
    }

    private void printStatus(String playerName, RacingCar racingCar) {
        System.out.printf(
                "%s : %s\n",
                playerName,
                racingCar.getOdoMeter().toString());
    }

    public void finish() {
        findWinner();
        printWinnerList();
    }

    private void findWinner() {
        int max = 0;
        for (Map.Entry<String, RacingCar> entry : playerTable.entrySet()) {
            String playerName = entry.getKey();
            RacingCar racingCar = entry.getValue();

            int distance = racingCar.getOdoMeter().get();
            if (max < distance) {
                max = distance;
                winnerList.clear();
                winnerList.add(playerName);
            } else if (max == distance) {
                winnerList.add(playerName);
            }
        }
    }

    private void printWinnerList() {
        System.out.print("최종 우승자 : " + winnerList.firstElement());
        for (int i = 1; i < winnerList.size(); i++) {
            System.out.printf(", %s", winnerList.elementAt(i));
        }
    }
}
