package Players;

import Baddies.*;
import Rooms.Room;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Runner {
    private Warrior warrior;
    private Wizard wizard;
    private Cleric cleric;
    private Room room;

    public Runner(Warrior warrior, Room room, Wizard wizard, Cleric cleric){
        this.warrior = warrior;
        this.room = room;
        this.wizard = wizard;
        this.cleric = cleric;
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

        Runner runner = new Runner(warrior, room, wizard, cleric);
        runner.run();
    }

    private void run() {
        String choice;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        do{
            System.out.println("Welcome to Fantasy Fight");
            System.out.println("1: Warrior");

            choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    String choice2;
                    do {
                        System.out.println(room.listAllMonsters());
                        System.out.println("type monster name to Attack or Defend");
                        String input = scanner.nextLine();
                        if (input.equals("Defend")) {
                            System.out.println(warrior.defend());
                             }
                        else
                                {
                            System.out.println(warrior.attack(input, room));
                                }
                            System.out.println(room.getRandomMonster().attack(warrior));
                        if (warrior.checkDeath() == true){
                            System.exit(0);
                        }
                            warrior.setDefenseType(DefenseType.NONE);
                                choice2 = scanner.nextLine();
                            } while (!choice2.equals("q"));


            }


        } while (!choice.equals("q"));

    }


}
