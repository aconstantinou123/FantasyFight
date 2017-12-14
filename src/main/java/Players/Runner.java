package Players;

import Baddies.*;
import Rooms.*;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private Rooms rooms;
    private Players players;

    public Runner(Rooms rooms, Players players){
        this.rooms = rooms;
        this.players = players;
    }

    public static void main(String[] args) {

        Rooms rooms = new Rooms();
        Players players = new Players();

        Room room = new Room();
        Room room2 = new Room();
        Room room3 = new Room();


        Troll troll = new Troll("Steve", 50, 50, "Troll", AttackModifier.NORMAL);
        Troll troll2 = new Troll("Graham", 50, 50, "Troll", AttackModifier.NORMAL);
        Troll troll3 = new Troll("George", 50, 50, "Troll", AttackModifier.NORMAL);
        Dragon dragon = new Dragon("Harry", 50, 50, "Dragon", AttackModifier.NORMAL);
        Dragon dragon2 = new Dragon("Bill", 50, 50, "Dragon", AttackModifier.NORMAL);
        Dragon dragon3 = new Dragon("Harold", 50, 50, "Dragon", AttackModifier.NORMAL);
        Orc orc = new Orc("Robert", 50, 50, "Orc", AttackModifier.NORMAL);
        Orc orc2 = new Orc("Barry", 50, 50, "Orc", AttackModifier.NORMAL);
        Orc orc3 = new Orc("Sean", 50, 50, "Orc", AttackModifier.NORMAL);
        Wizard wizard = new Wizard("Spell Boy", 500, WeaponType.SPELL, DefenseType.NONE);
        Cleric cleric = new Cleric("Heal Boy", 250, WeaponType.SPELL, DefenseType.NONE);
        Warrior warrior = new Warrior("Sword Boy", 1000, WeaponType.SWORD, DefenseType.NONE);

        players.addPlayers(warrior);
        players.addPlayers(cleric);
        players.addPlayers(wizard);

        room.addMonsters(orc);
        room.addMonsters(troll);
        room.addMonsters(dragon);

        room2.addMonsters(troll2);
        room2.addMonsters(dragon2);

        room3.addMonsters(orc2);
        room3.addMonsters(orc3);
        room3.addMonsters(dragon3);
        room3.addMonsters(troll3);

        rooms.addRoom(room);
        rooms.addRoom(room2);
        rooms.addRoom(room3);


        Runner runner = new Runner(rooms, players);
        runner.run();
    }

    private void run() {
        int roomIndex = 0;
        String choice;
        System.out.println("Welcome to Fantasy Fight");
        System.out.println("Press any key to continue or q to quit\n");
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        choice = scanner.nextLine();
        if (choice.equals("q")){
            System.exit(0);
        }
        do  {
            System.out.println("1: Warrior\n2: Cleric\n3: Wizard\n" );
            System.out.println("Please choose your character");
            Integer playerCharacter = Integer.parseInt(scanner.nextLine());
            playerCharacter -=1;
                if (playerCharacter != 1) {
                    String choice2;
                    System.out.println("You chose " + players.getPlayers().get(playerCharacter).getName() + "\n");
                    do {
                        Room room = rooms.getRooms().get(roomIndex);
                        System.out.println(room.listAllMonsters() + "\n");
                        System.out.println("type monster name to Attack or Defend");
                        String input = scanner.nextLine();
                            if (input.equals("Defend"))
                            {
                                System.out.println(players.getPlayers().get(playerCharacter).defend());
                            } else
                                {
                                System.out.println(players.getPlayers().get(playerCharacter).attack(input, room));
                            }
                            if (room.checkRoomEmpty() == true)
                            {
                                roomIndex += 1;
                                if (rooms.lastRoom(roomIndex) == true)
                                {
                                    System.out.println("You win");
                                    System.exit(0);
                                }
                                else {

                                    room = rooms.getRooms().get(roomIndex);
                                    System.out.println("You have entered a new room \n");
                                }
                            }
                        System.out.println(room.getRandomMonster().attack(players.getPlayers().get(playerCharacter)) + "\n");
                            if (players.getPlayers().get(playerCharacter).checkDeath() == true) {
                                System.exit(0);
                            }
                        players.getPlayers().get(playerCharacter).setDefenseType(DefenseType.NONE);
                        System.out.println("press q to choose a new character or enter to attack again");
                        choice2 = scanner.nextLine();
                    } while (!choice2.equals("q"));
                }
                else {
                    String choice3;
                    do {
                        System.out.println("You chose " + players.getPlayers().get(playerCharacter).getName() + "\n");
                        System.out.println("Write a players name to heal");
                        System.out.println("1: Warrior - Sword Boy \n2: Cleric - Heal Boy \n3: Wizard - Spell Boy");
                        String playerToHeal = scanner.nextLine();
                        System.out.println(players.getPlayers().get(playerCharacter).heal(players, playerToHeal));
                        System.out.println("press q to choose a new character");
                        choice3 = scanner.nextLine();
                    } while (!choice3.equals("q"));
                }

            }while (!choice.equals("q"));


        }




}
