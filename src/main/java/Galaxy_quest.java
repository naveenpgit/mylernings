import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Galaxy_quest {
    private HashMap<String, Integer> symbol = new HashMap<String, Integer>();
    private HashMap<String, String> intergalactic2arabic = new HashMap<String, String>();
    private HashMap<String, Double> commodity = new HashMap<String, Double>();


    private int decimal, qty, result;

    private String key, val, comm, _a, _b, credit;

    private double amount, rate;

    //method to insert symbols into Hashmap
    private void insertSymbols() {
        symbol.put("I", 1);
        symbol.put("V", 5);
        symbol.put("X", 10);
        symbol.put("L", 50);
        symbol.put("C", 100);
        symbol.put("D", 500);
        symbol.put("M", 1000);
    }

    private void processInputMessages(String msg) {

        String[] text = msg.split(" ");
        String[] newline = msg.split("\n");
        int words = text.length;
        int nl = newline.length;

        //Processing Value of Commodity
        if (words == 3 && (text[1].equalsIgnoreCase("is"))) {
            try {
                key = text[0];
                val = text[2];
                for (int i = 0; i < nl; i++) {
                    intergalactic2arabic.put(key, val);
                }
            } catch (Exception e) {
                System.out.println("I have no idea what you are talking about.");
            }
        }

        //Processing Rate of Commodity
        if (words > 3 && (text[words - 1].equalsIgnoreCase("credits"))) {
            try {

                boolean a = intergalactic2arabic.toString().contains(text[0]);
                boolean b = intergalactic2arabic.toString().contains(text[1]);

                _a = intergalactic2arabic.get(text[0]);
                _b = intergalactic2arabic.get(text[1]);

                if (a && b) {


                    if ((_b.equals("V") || _b.equals("X") && _a.equals("I")) || (_b.equals("L") || _b.equals("C") && _a.equals("X")) || (_b.equals("D") || _b.equals("M") && _a.equals("C"))) {

                        qty = symbol.get(intergalactic2arabic.get(text[1])) - symbol.get(intergalactic2arabic.get(text[0]));
                        comm = text[2];
                        amount = Double.parseDouble(text[words - 2]);
                        rate = amount / qty;
                        commodity.put(comm, rate);
                    } else {
                        qty = symbol.get(intergalactic2arabic.get(text[0])) + symbol.get(intergalactic2arabic.get(text[1]));
                        comm = text[2];
                        amount = Double.parseDouble(text[words - 2]);
                        rate = amount / qty;
                        commodity.put(comm, rate);
                    }

                }

            } catch (Exception e) {
                System.out.println("I have no idea what you are talking about.");
            }

        }

        if (text[words - 1].equals("?")) {
            try {
                int commcredit = 0;
                Double commrate = 0.0;
                result = 0;

                for (int i = 0; i < words; i++) {
                    if (text[i].equalsIgnoreCase("credits")) {
                        if (commodity.toString().contains(text[words - 2])) {
                            commrate = commodity.get(text[words - 2]);
                        }

                        if (intergalactic2arabic.toString().contains(text[words - 4]) && intergalactic2arabic.toString().contains(text[words - 3])) {

                            if (symbol.get(intergalactic2arabic.get(text[words - 4])) < symbol.get(intergalactic2arabic.get(text[words - 3])))
                                commcredit = -symbol.get(intergalactic2arabic.get(text[words - 4])) + symbol.get(intergalactic2arabic.get(text[words - 3]));
                            System.out.println(text[words - 4] + " " + text[words - 3] + " " + text[words - 2] + " is " + commcredit * commrate + " credits");
                        }
                    } else if (text[i].equalsIgnoreCase("much")) {
                        if (intergalactic2arabic.toString().contains(text[words - 5]) && intergalactic2arabic.toString().contains(text[words - 4]) && intergalactic2arabic.toString().contains(text[words - 3]) && intergalactic2arabic.toString().contains(text[words - 2])) {

                            if (symbol.get(intergalactic2arabic.get(text[words - 5])) < symbol.get(intergalactic2arabic.get(text[words - 4])))
                                result = symbol.get(intergalactic2arabic.get(text[words - 4])) - symbol.get(intergalactic2arabic.get(text[words - 5])) + symbol.get(intergalactic2arabic.get(text[words - 3])) + symbol.get(intergalactic2arabic.get(text[words - 2]));
                            System.out.println(text[words - 5] + " " + text[words - 4] + " " + text[words - 3] + " " + text[words - 2] + " is " + result);
                        } else {
                            System.out.println("I have no idea what you are talking about.");
                        }
                    }

                }

            } catch (Exception e) {
                System.out.println("I have no idea what you are talking about.");
            }


        }


    }

    public static void main(String args[]) throws Exception {
        Galaxy_quest gq = new Galaxy_quest();
        gq.insertSymbols();

        String inputFile = args[0];

        try {

            FileReader file = new FileReader(inputFile);
            BufferedReader reader = new BufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null) {
                gq.processInputMessages(line);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
