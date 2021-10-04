import java.util.*;

public class HashSetHackerrank
{
    public static String getOut(int numberOfMatches, String squads, int squad1, int squad2)
    {
        String[] squadArr = squads.split("#");
        List<Set<String>> squadSet = new ArrayList<>();
        for (String string : squadArr) {    
            Set<String> set = new HashSet<String>(Arrays.asList(string.split(" ")));
            squadSet.add(set);
        }
        Iterator<Set<String>> it = squadSet.iterator();
        Set<String> intersection = new HashSet<String>(it.next());
        while (it.hasNext()) {
            intersection.retainAll(it.next());
        }
        Set<String> diff = new HashSet<>(squadSet.get(squad2 - 1));
        diff.removeAll(squadSet.get(squad1 - 1));
        StringBuilder sbr = new StringBuilder();
        String sep = "";
        for (String str : intersection) {
            sbr.append(sep).append(str);
            sep = " ";
        }
        sbr.append(", ");
        for (String str : diff) {
            sbr.append(str).append(" ");
        }
        return sbr.toString();
    }
    public static void main(String[] args){
        String squads = "Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Paciencia Jota Daniel Patrício Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego#Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício Daniel Patrício Nelson Pepe Mario Pereira Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo";
        System.out.println(HashSetHackerrank.getOut(4, squads, 2, 4));
    }
}

