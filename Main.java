package practice;

import java.util.Scanner;
import lib.Input;

public class Main {
    public static void main(String[] args) {
        Card card = new Card(new String[] { "ハート", "スペード", "ダイヤ", "クローバー" },
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 });

        // プレイヤーとCPUを作ってランダムに２枚配る
        Player player = new Player("tom");
        Player cpu = new Player("CPU");
        for (int i = 0; i < 2; i++) {
            player.cards[i] = (int) (Math.random() * 13 + 1);
            cpu.cards[i] = (int) (Math.random() * 13 + 1);
        }
        // 手札の枚数
        int hands = 2;

        // プレイヤーとCPUの合計の初期化
        int player_total = 0;
        int cpu_total = 0;

        // プレイヤーの合計を算出
        for (int j = 0; j < hands; j++) {
            player_total += player.cards[j];
            player.setTotal(player_total);
        }
        // CPUの合計を算出
        for (int k = 0; k < hands; k++) {
            cpu_total += cpu.cards[k];
            cpu.setTotal(cpu_total);
        }

        System.out.println("ブラックジャックをしましょう！\n最初の手札は2枚です");

        // 手札を表示
        System.out.print("Playerの手札 : ");
        for (int n = 0; n < hands; n++) {
            System.out.print(player.getCards()[n] + "  ");
        }
        System.out.println(player.getTotal());
        System.out.println("\n-------------------------");
        System.out.print("CPUの手札 : ");
        for (int n = 0; n < hands; n++) {
            System.out.print(cpu.getCards()[n] + "  ");
        }
        System.out.println(cpu.getTotal());

        // カードを引く処理と判定をする
        while (player.getTotal() < 21 && cpu.getTotal() < 21) {
            System.out.println("\nカードを引きますか？引く場合は1、やめる場合は0を入力してください");
            int play = Input.getInt();
            if (play == 0) {
                while (1 < cpu.getTotal() && cpu.getTotal() < 15) {
                    cpu.setCards(hands, (int) (Math.random() * 13 + 1));
                    for (int k = 0; k < hands; k++) {
                        cpu_total += cpu.cards[k];
                        cpu.setTotal(cpu_total);
                    }

                    ++hands;

                    System.out.print("Playerの手札 : ");
                    for (int n = 0; n < hands; n++) {
                        System.out.print(player.getCards()[n] + "  ");
                    }
                    System.out.println(player.getTotal());
                    System.out.println("\n-------------------------");
                    System.out.print("CPUの手札 : ");
                    for (int n = 0; n < hands; n++) {
                        System.out.print(cpu.getCards()[n] + "  ");
                    }
                    System.out.println(cpu.getTotal());
                    break;
                }
            } else if (play == 1) {
                if (player.getTotal() <= 21 && 1 <= cpu.getTotal() && cpu.getTotal() <= 15) {
                    player.setCards(hands, (int) (Math.random() * 13 + 1));
                    for (int j = 0; j < hands; j++) {
                        player_total += player.cards[j];
                        player.setTotal(player_total);
                    }

                    cpu.setCards(hands, (int) (Math.random() * 13 + 1));
                    for (int k = 0; k < hands; k++) {
                        cpu_total += cpu.cards[k];
                        cpu.setTotal(cpu_total);
                    }

                    ++hands;

                    System.out.print("Playerの手札 : ");
                    for (int n = 0; n < hands; n++) {
                        System.out.print(player.getCards()[n] + "  ");
                    }
                    System.out.println(player.getTotal());
                    System.out.println("\n-------------------------");
                    System.out.print("CPUの手札 : ");
                    for (int n = 0; n < hands; n++) {
                        System.out.print(cpu.getCards()[n] + "  ");
                    }
                    System.out.println(player.getTotal());
                } else if (player.getTotal() <= 21 && cpu.getTotal() >= 15) {
                    player.setCards(hands, (int) (Math.random() * 13 + 1));
                    for (int j = 0; j < hands; j++) {
                        player_total += player.cards[j];
                        player.setTotal(player_total);
                    }
                    hands++;
                    System.out.print("Playerの手札 : ");
                    for (int n = 0; n < hands; n++) {
                        System.out.print(player.getCards()[n] + "  ");
                    }
                    System.out.println(player.getTotal());
                    System.out.println("\n-------------------------");
                    System.out.print("CPUの手札 : ");
                    for (int n = 0; n < hands; n++) {
                        System.out.print(cpu.getCards()[n] + "  ");
                    }
                    System.out.println(cpu.getTotal());
                }
            }break;
        }

        if (player.getTotal() > 21 && cpu.getTotal() > 21 || player.getTotal() == cpu.getTotal()) {
            System.out.println("引き分けです");
        } else if (player.getTotal() > 21 && cpu.getTotal() <= 21) {
            System.out.println("プレイヤーの負けです");
        } else if (player.getTotal() <= 21 && cpu.getTotal() <= 21 && player.getTotal() - cpu.getTotal() < 0) {
            System.out.println("プレイヤーの負けです");
        } else if (player.getTotal() <= 21 && cpu.getTotal() > 21) {
            System.out.println("プレイヤーの勝ちです");
        } else if (player.getTotal() <= 21 && cpu.getTotal() <= 21 && player.getTotal() - cpu.getTotal() > 0) {
            System.out.println("プレイヤーの勝ちです");
        }

    }
}

// for (int i = 1; i <= playerNum; i++) {
// Player player = new Player(String.format("Player%d", i), new int[] {
// card.numbers[(int) ((Math.random() * 12) + 1)],
// card.numbers[(int) ((Math.random() * 12) + 1)]
// });
// System.out.println(player.getName());
// for (int n : player.getCards()) {
// System.out.print(n + ",");
// }

// int total = 0;

// for (int j = 0; j < player.getCards().length; j++) {
// total += player.getCards()[j];
// player.setTotal(total);
// }

// }