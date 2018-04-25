package com.ccy.ocr;

/**
 * Created by 文江 on 2018/4/24.
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
}
