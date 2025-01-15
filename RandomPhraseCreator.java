import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RandomPhraseCreator {
    public static void main(String[] args) {
        float[] nums = new float[3];
        nums[1]=(float)0.9;

        System.out.println("Hello and welcome!");
//        System.out.println("Hello and welcome!");

//        dateTimeTut();

        RandomPhraseGenerate();
    }


    public static void RandomPhraseGenerate() {
            String[] var1 = new String[]{"SOT 2025 24/7", "multi-Tier", "30,000 foot", "B-to-B", "win-win", "front-end", "web-based", "pervasive", "smart", "six-sigma", "critical-path", "dynamic"};
            String[] var2 = new String[]{"SOT 2025 empowered", "sticky", "value-added", "oriented", "centric", "distributed", "aligned", "shared", "cooperative", "accelerated"};
            String[] var3 = new String[]{"process", "tipping-point", "solution", "architecture", "core competency", "strategy", "mindshare", "portal", "space", "vision", "paradigm", "mission"};
            int var4 = var1.length;
            int var5 = var2.length;
            int var6 = var3.length;
            int var7 = (int)(Math.random() * (double)var4);
            System.out.println("Selecting "+ (var7+1) +"th item from 1st list of length "+ var4);
            int var8 = (int)(Math.random() * (double)var5);
            System.out.println("Selecting "+ (var8+1) + "th item from 1st list of length "+ var5);
            int var9 = (int)(Math.random() * (double)var6);
            System.out.println("Selecting "+ (var9+1) + "th item from 1st list of length "+ var6);

            String var10 = var1[var7] + " " + var2[var8] + " " + var3[var9];
            System.out.println("The random phrase is ======== " + var10);
    }

    private static void dateTimeTut() {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        DateTimeFormatter dF = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(today.format(dF));

    }
}