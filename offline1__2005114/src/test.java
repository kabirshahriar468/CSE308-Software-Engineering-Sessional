import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        StringTokenizer tokens = new StringTokenizer(input);
        ArrayList<String> commands = new ArrayList<String>();

        while (tokens.hasMoreTokens())
        {
            commands.add(tokens.nextToken());
        }
        for(String s:commands){
            System.out.println(s);
        }
    }
}
