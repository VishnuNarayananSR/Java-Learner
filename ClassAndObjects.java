//author shagun

class Register {
    private static Register register = null;

    public static register getInstance() {
        if (register == null) {
            register = new register();
        }
        return register;
    }

    public String getTotalBill(Map<String, Integer> itemDetails) {
        double totalBill = 0.0;
        Iterator<Map.entry<String, Integer>> itr = itemDetails.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            if (entry.getKey().equals("apple")) {
                totalBill += entry.getValue() * 2.0;
            } else if (entry.getKey().equals("orange")) {
                totalBill += entry.getValue() * 1.5;
            } else if (entry.getKey().equals("mango")) {
                totalBill += entry.getValue() * 1.2;
            } else if (entry.getKey().equals("grape")) {
                totalBill += entry.getValue() * 1.0;
            }
        }
        String s = Double.toString(totalBill);
        return s;
    }
}
