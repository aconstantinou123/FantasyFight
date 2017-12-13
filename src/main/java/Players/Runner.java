package Players;

import Baddies.*;
import Rooms.Room;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Runner {
    private Room room;

    public Runner(Room room){
        this.room = room;
    }

    public static void main(String[] args) {

        Warrior warrior = new Warrior("Sword Boy", 1000, WeaponType.SWORD, DefenseType.NONE);
        Room room = new Room();
        Troll troll = new Troll("Steve", 50, 50, "Troll", AttackModifier.NORMAL);
        Dragon dragon = new Dragon("Harry", 50, 50, "Dragon", AttackModifier.NORMAL);
        Orc orc = new Orc("Robert", 50, 50, "Orc", AttackModifier.NORMAL);
        Wizard wizard = new Wizard("Spell Boy", 500, WeaponType.SPELL, DefenseType.NONE);
        Cleric cleric = new Cleric("Heal Boy", 250, WeaponType.SPELL, DefenseType.NONE);
        room.addMonsters(troll);
        room.addMonsters(dragon);
        room.addMonsters(orc);
        room.addPlayerz(warrior);
        room.addPlayerz(cleric);
        room.addPlayerz(wizard);

        Runner runner = new Runner(room);
        runner.run();
    }

    private void run() {
        String choice;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        do  {
            System.out.println("Welcome to Fantasy Fight");
            System.out.println("1: Warrior\n2: Cleric\n3: Wizard");
            System.out.println("Press any key to continue or q to quit\n");
            choice = scanner.nextLine();
            System.out.println("Please choose your character");
            Integer playerCharacter = Integer.parseInt(scanner.nextLine());
            playerCharacter -=1;
                if (playerCharacter != 1) {
                    String choice2 = new String();
                    do {
                        System.out.println("You chose " + room.getPlayerz().get(playerCharacter).getName() + "\n");
                        System.out.println(room.listAllMonsters() + "\n");
                        System.out.println("type monster name to Attack or Defend");
                        String input = scanner.nextLine();
                        if (input.equals("Defend")) {
                            System.out.println(room.getPlayerz().get(playerCharacter).defend());
                        } else {
                            System.out.println(room.getPlayerz().get(playerCharacter).attack(input, room));
                        }
                        System.out.println(room.getRandomMonster().attack(room.getPlayerz().get(playerCharacter)) + "\n");
                        if (room.getPlayerz().get(playerCharacter).checkDeath() == true) {
                            System.exit(0);
                        }
                        room.getPlayerz().get(playerCharacter).setDefenseType(DefenseType.NONE);
                        System.out.println("press q to choose a new character");
                        choice2 = scanner.nextLine();
                    } while (!choice2.equals("q"));
                }
                else {
                    String choice3;
                    do {
                        System.out.println("You chose " + room.getPlayerz().get(playerCharacter).getName() + "\n");
                        System.out.println("Write a players name to heal");
                        System.out.println("1: Warrior - Sword Boy \n2: Cleric - Heal Boy \n3: Wizard - Spell Boy");
                        String playerToHeal = scanner.nextLine();
                        System.out.println(room.getPlayerz().get(playerCharacter).heal(room, playerToHeal));
                        System.out.println("press q to choose a new character");
                        choice3 = scanner.nextLine();
                    } while (!choice3.equals("q"));
                }

            }while (!choice.equals("q"));


        }




}
