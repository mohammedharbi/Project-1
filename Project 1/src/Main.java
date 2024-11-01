import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isRounds = false;
        int rounds=0;
        System.out.println("Welcome to tic tac toe game. ");
        System.out.println("1. Play one round.\n" +
                "2. Play two rounds.\n" +
                "Please enter a number to choose:");
        while (!isRounds){
            int roundschoice = input.nextInt();
            if(roundschoice >2 || roundschoice <1){
                System.out.println("Please re-enter a number between(1 or 2).");
            }else isRounds=true;
            if (roundschoice == 1){rounds = 1;}
            if (roundschoice == 2){rounds = 3;}
        }
        System.out.println("You will be 'X'  and the Computer will be 'O'.");
        Character [][] ttt_board = {{'1', '2' ,'3'}, {'4', '5', '6'} ,{'7', '8', '9'}};
        System.out.println("_____________");
        System.out.println("| "+ttt_board[0][0]+" | "+ttt_board[0][1]+" | "+ttt_board[0][2]+" |\n" +
                "| "+ttt_board[1][0]+" | "+ttt_board[1][1]+" | "+ttt_board[1][2]+" |\n" +
                "| "+ttt_board[2][0]+" | "+ttt_board[2][1]+" | "+ttt_board[2][2]+" |\n" +
                "_____________");

        int playerwinscounter = 0;
        int computerwinscounter = 0;

        for (int i = 1; i <= rounds; i++) {
        while (!isWin(ttt_board)) {
            playerChoice(ttt_board);
            isWin(ttt_board);
            computerChoice(ttt_board);
            isWin(ttt_board);
            System.out.println("_____________");
            System.out.println("| "+ttt_board[0][0]+" | "+ttt_board[0][1]+" | "+ttt_board[0][2]+" |\n" +
                    "| "+ttt_board[1][0]+" | "+ttt_board[1][1]+" | "+ttt_board[1][2]+" |\n" +
                    "| "+ttt_board[2][0]+" | "+ttt_board[2][1]+" | "+ttt_board[2][2]+" |\n" +
                    "_____________");
        }
            if ((Winner(ttt_board).charAt(0) == 'P')){ playerwinscounter++;
            } else if ((Winner(ttt_board).charAt(0) == 'C')) {
                computerwinscounter++;
            }
            if (rounds == 3) {
                if (Winner(ttt_board).charAt(0) == 'T') {
                        System.out.println(i + " Round : it's a tie !!");
                    } else {
                        System.out.println(i + " Round winner is " + Winner(ttt_board) + ".");
                        Winner(ttt_board);
                    }

                if (playerwinscounter == 2 || computerwinscounter == 2) {
                    i++;
                } else if(i == 3 && (Winner(ttt_board).charAt(0)== 'T')){i++;}
                else{
                    ttt_board = new Character[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

                    System.out.println("_____________");
                    System.out.println("| " + ttt_board[0][0] + " | " + ttt_board[0][1] + " | " + ttt_board[0][2] + " |\n" +
                            "| " + ttt_board[1][0] + " | " + ttt_board[1][1] + " | " + ttt_board[1][2] + " |\n" +
                            "| " + ttt_board[2][0] + " | " + ttt_board[2][1] + " | " + ttt_board[2][2] + " |\n" +
                            "_____________");
                }
            }
        }


        if (rounds == 1){
            if (playerwinscounter > computerwinscounter){
                System.out.println("The winner is Player !!");
            } else if (computerwinscounter > playerwinscounter) {
                System.out.println("The winner is Computer !!");
            }else System.out.println("It's a a Tie");
        }
        if (rounds == 3){
        if (playerwinscounter > computerwinscounter){
            System.out.println("The winner for all rounds is Player !!");
        } else if (computerwinscounter > playerwinscounter) {
            System.out.println("The winner for all rounds is Computer !!");
        }else System.out.println("It's a Tie");
        }
    }

    public static boolean isWin(Character [][]a){
        boolean winner = false;
        if (a[0][0] == 'X' && a[0][1] == 'X' && a[0][2] == 'X' || a[0][0] == 'X' && a[1][0] == 'X' && a[2][0] == 'X'){
            winner = true;
        } else if(a[1][0] == 'X' && a[1][1] == 'X' && a[1][2] == 'X' || a[0][1] == 'X' && a[1][1] == 'X' && a[2][1] == 'X'){
            winner = true;
        } else if (a[2][0] == 'X' && a[2][1] == 'X' && a[2][2] == 'X' || a[0][2] == 'X' && a[1][2] == 'X' && a[2][2] == 'X'){
            winner = true;
        } else if (a[0][0] == 'X' && a[1][1] == 'X' && a[2][2] == 'X'){
            winner = true;
        } else if (a[0][2] == 'X' && a[1][1] == 'X' && a[2][0] == 'X'){
            winner = true;
        }else if (a[0][0] == 'O' && a[0][1] == 'O' && a[0][2] == 'O' || a[0][0] == 'O' && a[1][0] == 'O' && a[2][0] == 'O'){
            winner = true;
        } else if(a[1][0] == 'O' && a[1][1] == 'O' && a[1][2] == 'O' || a[0][1] == 'O' && a[1][1] == 'O' && a[2][1] == 'O'){
            winner = true;
        } else if (a[2][0] == 'O' && a[2][1] == 'O' && a[2][2] == 'O' || a[0][2] == 'O' && a[1][2] == 'O' && a[2][2] == 'O'){
            winner = true;
        } else if (a[0][0] == 'O' && a[1][1] == 'O' && a[2][2] == 'O'){
            winner = true;
        } else if (a[0][2] == 'O' && a[1][1] == 'O' && a[2][0] == 'O'){
            winner = true;
        }else if (a[0][0] !='1'&& a[0][1] != '2' && a[0][2] !='3' && a[1][0] !='4'&& a[1][1] != '5' && a[1][2] !='6'&& a[2][0] !='7'&& a[2][1] != '8' && a[2][2] !='9'){
            winner = true;
        }
        return winner;
    }
    public static String Winner(Character [][]a){
        String winner = "";
        if (a[0][0] == 'X' && a[0][1] == 'X' && a[0][2] == 'X' || a[0][0] == 'X' && a[1][0] == 'X' && a[2][0] == 'X'){
            winner="Player !!!";
        } else if(a[1][0] == 'X' && a[1][1] == 'X' && a[1][2] == 'X' || a[0][1] == 'X' && a[1][1] == 'X' && a[2][1] == 'X'){
            winner="Player !!!";
        } else if (a[2][0] == 'X' && a[2][1] == 'X' && a[2][2] == 'X' || a[0][2] == 'X' && a[1][2] == 'X' && a[2][2] == 'X'){
            winner="Player !!!";
        } else if (a[0][0] == 'X' && a[1][1] == 'X' && a[2][2] == 'X'){
            winner="Player !!!";
        } else if (a[0][2] == 'X' && a[1][1] == 'X' && a[2][0] == 'X'){
            winner="Player !!!";
        }else if (a[0][0] == 'O' && a[0][1] == 'O' && a[0][2] == 'O' || a[0][0] == 'O' && a[1][0] == 'O' && a[2][0] == 'O'){
            winner="Computer !!!";
        } else if(a[1][0] == 'O' && a[1][1] == 'O' && a[1][2] == 'O' || a[0][1] == 'O' && a[1][1] == 'O' && a[2][1] == 'O'){
            winner="Computer !!!";
        } else if (a[2][0] == 'O' && a[2][1] == 'O' && a[2][2] == 'O' || a[0][2] == 'O' && a[1][2] == 'O' && a[2][2] == 'O'){
            winner="Computer !!!";
        } else if (a[0][0] == 'O' && a[1][1] == 'O' && a[2][2] == 'O'){
            winner="Computer !!!";
        } else if (a[0][2] == 'O' && a[1][1] == 'O' && a[2][0] == 'O'){
            winner="Computer !!!";
        }else if (a[0][0] !='1'&& a[0][1] != '2' && a[0][2] !='3' && a[1][0] !='4'&& a[1][1] != '5' && a[1][2] !='6'&& a[2][0] !='7'&& a[2][1] != '8' && a[2][2] !='9'){
            winner="Tie !!!";
        }
        return winner;
    }

    public static Character[][] playerChoice(Character [][]a){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a new number to position(Between 1 - 9): ");
        int player_cohice = input.nextInt();
        if (player_cohice > 9 || player_cohice < 1){playerChoice(a);}
        switch (player_cohice){
            case 1:
                if (a[0][0] == '1'){
                  a[0][0] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                   playerChoice(a);
                 }
                break;
            case 2:
                if (a[0][1] == '2'){
                    a[0][1] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                    playerChoice(a);
                }
                break;
            case 3:
                if (a[0][2] == '3'){
                    a[0][2] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                    playerChoice(a);
                }
                break;
            case 4:
                if (a[1][0] == '4'){
                    a[1][0] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                    playerChoice(a);
                }
                break;
            case 5:
                if (a[1][1] == '5'){
                    a[1][1] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                    playerChoice(a);
                }
                break;
            case 6:
                if (a[1][2] == '6'){
                    a[1][2] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                    playerChoice(a);
                }
                break;
            case 7:
                if (a[2][0] == '7'){
                    a[2][0] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                    playerChoice(a);
                }
                break;
            case 8:
                if (a[2][1] == '8'){
                    a[2][1] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                    playerChoice(a);
                }
                break;
            case 9:
                if (a[2][2] == '9'){
                    a[2][2] = 'X';}else {System.out.println("Please enter another number it's already taken: ");
                    playerChoice(a);
                }
                break;
        }
        return  a;
    }

    public static Character[][] computerChoice(Character [][]a){

        Random rand = new Random();
        if (a[0][0] !='1'&& a[0][1] != '2' && a[0][2] !='3' && a[1][0] !='4'&& a[1][1] != '5' && a[1][2] !='6'&& a[2][0] !='7'&& a[2][1] != '8' && a[2][2] !='9'){
            System.out.println("Computer: Oh noo !!");
            return a;
        }
        int copmuter_choice = rand.nextInt(1,10);


        switch (copmuter_choice){
            case 1:
                if (a[0][0] == '1'){
                    a[0][0] = 'O';}else {
                    computerChoice(a);
                }
                break;
            case 2:
                if (a[0][1] == '2'){
                    a[0][1] = 'O';}else {
                    computerChoice(a);
                }
                break;
            case 3:
                if (a[0][2] == '3'){
                    a[0][2] = 'O';}else {
                    computerChoice(a);
                }
                break;
            case 4:
                if (a[1][0] == '4'){
                    a[1][0] = 'O';}else {
                    computerChoice(a);
                }
                break;
            case 5:
                if (a[1][1] == '5'){
                    a[1][1] = 'O';}else {
                    computerChoice(a);
                }
                break;
            case 6:
                if (a[1][2] == '6'){
                    a[1][2] = 'O';}else {
                    computerChoice(a);
                }
                break;
            case 7:
                if (a[2][0] == '7'){
                    a[2][0] = 'O';}else {
                    computerChoice(a);
                }
                break;
            case 8:
                if (a[2][1] == '8'){
                    a[2][1] = 'O';}else {
                    computerChoice(a);
                }
                break;
            case 9:
                if (a[2][2] == '9'){
                    a[2][2] = 'O';}else {
                    computerChoice(a);
                }
                break;
        }
        return  a;
    }

}