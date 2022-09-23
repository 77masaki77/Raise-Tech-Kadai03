package kadai03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> beerMap = new HashMap<>();
        beerMap.put("キリン", null);
        beerMap.put("アサヒ", null);
        beerMap.put("サッポロ", null);

        System.out.println("＜ビールメーカーと銘柄のリスト作成＞");
        System.out.println("以下３社のお好きな銘柄を入力願います。");

        for (String key : beerMap.keySet()) {
            System.out.print(key + "といえば : ");
            String commandLine = new Scanner(System.in).nextLine();
            try {
                if (commandLine.isBlank()) {
                    //コード量の削減のため、メソッド化を中止
                    throw new Exception("スペースか、何も入力がありません。未回答とします。");
                }
            } catch (Exception e) {
                System.out.println(e);
                commandLine = "未回答";
            }
            beerMap.replace(key, commandLine);
        }

        //Mapの要素を表示
        System.out.printf("%n*ビールメーカー、銘柄リストの表示*%n");
        System.out.println("-------------------------------");
        System.out.println("key 　 : value");
        System.out.println("-------------------------------");

        //Stream APIの予習のため、コード置き換え実施
        //for (String key : beerMap.keySet()) {
        //    System.out.printf("%-4s : %s%n", key, beerMap.get(key));
        //}
        beerMap.entrySet().stream().forEach(value -> System.out.println(value.getKey() + " : " + value.getValue()));

        System.out.println("-------------------------------");
    }


}
