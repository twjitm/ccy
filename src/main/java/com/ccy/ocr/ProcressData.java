package com.ccy.ocr;

/**
 * Created by 识别 on 2018/4/24.
 * 算法识别技术
 */
public class ProcressData {
    public static String[] path = new String[]{
            "f:yangben/hutudeai.png",
            "f:yangben/Two_Tigers.jpg",
            "f:yangben/jda.png",
            "f:yangben/kuaileqishi.png"
    };

    public static String processorTwo_Tigers(String towtigersStr) {

        String[] strarr = towtigersStr.split("\n");
        System.out.println("正在识别第一行谱图。。。。。。。。。");
        String oneLine = strarr[2].replaceAll("J", "1")
                .replaceAll("LL", "3_1")
                .replaceAll("I", "1")
                .replaceAll("F>_§", "5_6")
                .replaceAll("5__‘1_", "5_4")
                .replaceAll("M5?5", "3_4 5 ")
                .replaceAll("\\?5", "5");
        System.out.println("正在识别第二行谱图。。。。。。");
        String towLine = strarr[4].
                replaceAll("°2§", "2 5.")
                .replaceAll("\\|o\\|", "1 0");
        String[] one = strarr[2].split("\\|");
        System.out.println("处理完成。。。。。。");
        String result = oneLine + "\n" + towLine;
        System.out.println(result);
        return result;

    }

    public static String processorjiandanai(String jda) {
        System.out.println("-------------------------");
        String chars1 = ". . . . . .   . . . . . ︵     . . .  . . . .";
        String chars2 = ". . .       . . . . . . .   . . . . .        ";
        String chars3 = ". . . . . . . .      . . . . . ︵        .︵.";
        String chars4 = ".            . .︵.      . .  .  . .︵. . . .";
        String chars5 = ".           . .︵.  .      . . . .        . .";
        String[] arrayStr = jda.split("\n");
        String[] array = new String[]{chars1, chars2, chars3, chars4, chars5};
        int top = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arrayStr.length; i++) {
            if (i > 1 && i % 2 == 0) {
                System.out.println(array[top]);
                builder.append(array[top]);
                top++;
                builder.append("\n");
                String numStr = arrayStr[i].
                        replaceAll("i", "1")
                        .replaceAll("§", "5")
                        .replaceAll("g", "2")
                        .replaceAll("o", "0")
                        .replaceAll("u", "3")
                        .replaceAll("é", "6")
                        .replaceAll("s", "6 ")
                        .replaceAll("I", "1")
                        .replaceAll("z", "2")
                        .replaceAll("’_5", "3");
                builder.append(numStr);
                builder.append("\n");
                System.out.println(numStr);
            }
        }
        return builder.toString();
    }

    public static String processorhutudeai(String param) {
        String chars1 = "     . ︵.    .︵︵  .   .   .   .";
        String chars2 = "╭--╮   .╭--╮   ╭-.-╮ . ╭-.-╮ ╭--╮ ";
        String chars3 = "  .╭-.--╮   . ︵ ︵ .╭----╮ . ╭--╮ ";
        String chars4 = "..  ╭--╮     . .╭--╮   . ╭--╮  . ╭-╮";
        String chars5 = "..︵.    ︵  .    .︵   ╭--╮     ╭--╮";
        String chars6 = "";
        String[] charsArray = new String[]{chars1, chars2, chars3, chars4, chars5, chars6};
        StringBuilder builder = new StringBuilder();
        int top = 0;
        String[] array = param.split("\n");
        for (int i = 0; i < array.length; i++) {

            if (i == 6 || i == 8 || i == 11 || i == 15 || i == 18 || i == 21) {
                builder.append(charsArray[top]);
                top++;
                builder.append("\n");
                String result = array[i]
                        .replaceAll("ga", "3 3")
                        .replaceAll("§_", "3")
                        .replaceAll("§", "5.")
                        .replaceAll("gz", "2. 2")
                        .replaceAll("g", "2.")
                        .replaceAll("“? \"’", "3 3 2 3")
                        .replaceAll(";", "")
                        .replaceAll("”", "")
                        .replaceAll("‘", "1")
                        .replaceAll("u", "4")
                        .replaceAll("P", "5")
                        .replaceAll("”", "")
                        .replaceAll("F", "3.")
                        .replaceAll("f", "3.")
                        .replaceAll("“", "")
                        .replaceAll("\\?", "3")
                        .replaceAll("!", "1.")
                        .replaceAll("\\? \\?", "1  1");
                builder.append(result);
                builder.append("\n");
                System.out.println(result);
                //System.out.println("第" + i + "论训练");

            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static String pricessorkuaileqishi(String param) {
        String chars1 = "";
        String chars2 = "";
        String chars3 = "";
        String chars4 = "";
        String chars5 = "";
        String[] arrayStr = new String[]{chars1, chars2, chars3, chars4, chars5};
        String[] array = param.split("\n");
        StringBuilder builder = new StringBuilder();

        int top = 0;
        for (int i = 0; i < array.length; i++) {

            if (i == 4 || i == 6 || i == 10) {
                builder.append(arrayStr[top]);
                top++;
                builder.append("\n");

                String result = array[i].
                        replaceAll("i", "1")
                        .replaceAll("§", "5")
                        .replaceAll("g", "2")
                        .replaceAll("o", "0")
                        .replaceAll("u", "3")
                        .replaceAll("é", "6")
                        .replaceAll("s", "6 ")
                        .replaceAll("I", "1")
                        .replaceAll("z", "2")
                        .replaceAll("e", "2")
                        .replaceAll("w", "3")
                        .replaceAll("m", "4")
                        .replaceAll("@", "4.");
                builder.append(result);
                builder.append("\n");
                System.out.println(result);

            }
        }
        String bunegn = "2 2 1 2 3 5 3 .5 -6";
        builder.append(bunegn);
        builder.append("\n");
        return builder.toString();
    }

    public static int index(String fileName) {
        for (int i = 0; i < path.length; i++) {
            if (path[i].indexOf(fileName) > 0) {
                return i;
            }
        }
        return 0;
    }

    public static final String kuailequshiStr = "" +
            "     . ︵.    .︵︵  .   .   .   .\n" +
            "133—534 Izzw- léés-ééeéI?eée-I\n" +
            "╭--╮   .╭--╮   ╭-.-╮ . ╭-.-╮ ╭--╮ \n" +
            "Mil EMG- lllli $Ml?\n" +
            "  .╭-.--╮   . ︵ ︵ .╭----╮ . ╭--╮ \n" +
            "?3.ilti ~I?n k?N—? ?.\n" +
            "..  ╭--╮     . .╭--╮   . ╭--╮  . ╭-╮\n" +
            "?? ER n-z. 04,3?:an E\n" +
            "..︵.    ︵  .    .︵   ╭--╮     ╭--╮\n" +
            "?? 2.1 11—2. ?wean: E";
    public static final String JDaStr = "" +
            ". . . . . .   . . . . . ︵     . . .  . . . .\n" +
            "1__11231 1 0l1112‘626  0l2121630l\n" +
            ". . .       . . . . . . .   . . . . .        \n" +
            "336 -l111310l3126200l\n" +
            ". . . . . . . .      . . . . . ︵        .︵.\n" +
            "__1_1.12_61_501.6_6._j__626 Olft0 _1_2_6l\n" +
            ".            . .︵.      . .  .  . .︵. . . .\n" +
            "6- 0 _1.2.6|5 - 0 5_3_~11- L_1L6L11\n" +
            ".           . .︵.  .      . . . .        . .\n" +
            "6-026l6 -026l6-0y2";
    public static final String tow_tilgersStr = "" +
            "12_3_1|1_2.3_1|3_4 5 ?53_4.5|5_65_4\n" +
            "31|5654|312 5.|1025|1 0|\n" +
            "12_3_1|1_2.3_1|3_4 5 ?53_4.5|5_65_4\n" +
            "31|5654|312 5.|1025|1 0|";

    public static final String hutudeaiStr = "" +
            "     . ︵.    .︵︵  .   .   .   .\n" +
            "3 3.23.33|5.5.5323_31.|2. 2.12.2.2.|\n" +
            "╭--╮   .╭--╮   ╭-.-╮ . ╭-.-╮ ╭--╮ \n" +
            "753: 799 ? ?3 3 2 3 3, ?2. 7513\n" +
            "  .╭-.--╮   . ︵ ︵ .╭----╮ . ╭--╮ \n" +
            "2112322-|3_-5.3_2_3._3_._5.|6. 2.3 3?\n" +
            "..  ╭--╮     . .╭--╮   . ╭--╮  . ╭-╮\n" +
            "13589923 2., 33 5l31. ??-13.13.1,\n" +
            "..︵.    ︵  .    .︵   ╭--╮     ╭--╮\n" +
            "32.12.4|2._212111-:|:53.2.3_34.|\n";
}
