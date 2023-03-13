import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    boolean choice = true;
    while(choice){
      game();
      System.out.println("Would you like to play again?");
      String yn = sc.next();
      if (yn.toLowerCase().equals("no")){
        System.out.println();
        System.out.println("Ok, goodbye.");
        break;
      } else{
        continue;
      }
    }  
  }
  public static void game(){
    String one = "gravy";
    String two = "turkey";
    String three = "pie";
    String four = "yams";
    String five = "corn";
    String six = "cider";
    final boolean play = true;
    
    String comword = "";
    
    int tries = 3;
    System.out.println("Let's Play hangman!");
    System.out.println("Thanksgiving edition!");
    int num = (int)((Math.random() * 5) + 1);
    switch (num){
      case 1:
        comword = one;
        break;
      case 2:
        comword = two;
        break;
      case 3:
        comword = three;
        break;
      case 4: 
        comword = four;
        break;
      case 5:
        comword = five;
        break;
      case 6:
        comword = six;
        break;
    }
    
    String display = "";
    
    for (int i = 1; i<= comword.length(); i++){
      display = display + "_";
    }
    
    int given = (int)(Math.random() * display.length());
    int given2 = (int)(Math.random() * display.length());
    if (display.length() <= 4){
      display = display.substring(0, given) + comword.charAt(given) + display.substring(given+1);
    } else{ 
      display = display.substring(0, given) + comword.charAt(given) + display.substring(given+1);
      display = display.substring(0, given2) + comword.charAt(given2) + display.substring(given2+1);
    }

    System.out.println();
    Scanner sc = new Scanner(System.in);
    while (play){
      System.out.println(display);
      System.out.print("Guess a letter: ");
      String letter = sc.next();
      if (letter.equals(comword)){
        System.out.println("Congrats! You win! The word was " + comword + ".");
        break;
      }
      if (comword.contains(letter)){
        System.out.println("Yes! " + letter + " is in the word.");
        display = display.substring(0,comword.indexOf(letter)) + letter + display.substring(comword.indexOf(letter) + 1);
        System.out.println();
      } else{
        System.out.println("No! " + letter + " is not in the word. Try again!");
        System.out.println();
        tries--;
      }
      if (tries == 0){
        System.out.println("Sorry no more tries left. You lose. The word was " + comword + ".");
        break;
      }
      if (display.equals(comword)){
        System.out.println("Congrats! You win! The word was " + comword + ".");
        break;
      }
  }
}
}