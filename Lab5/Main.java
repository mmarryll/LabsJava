import java.io.IOException;
import java.nio.file.Files ;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)
    {
        Path path = Path.of("in.txt");
        List<Integer> maxsz = new ArrayList<>();
        List<String> res = new ArrayList<>();
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        List<String> list = null;
        int maxsz_ = 0;
        try {
            list = Files.readAllLines(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String str : list)
        {
            Matcher matcher = pattern.matcher(str);
            int max = 0;
            while(matcher.find()){
                int length = matcher.group().length();
                if (length > max){
                    max = length;
                }
            }
            maxsz.add(max);
        }
        for (Integer i : maxsz){
            if (i > maxsz_){
                maxsz_ = i;
            }
        }
        for (int i = 0; i < maxsz.size(); i++){
            if (maxsz.get(i) == maxsz_){
                res.add(list.get(i));
            }
        }
        for (int i = 0; i < res.size() && i < 10; i++){
            System.out.println(res.get(i));
        }
    }
}
