package fairy.dataconcealer.concealer;

class XEncoder implements Encoder {

    private int numberOfX;
    private String xString;

    XEncoder(int numberOfX) {
        this.setNumberOfX(numberOfX);
    }

    @Override
    public String encode(String strToFix) {
        return xString;
    }

    public int getNumberOfX() {
        return numberOfX;
    }

    void setNumberOfX(int numberOfX) {
        this.numberOfX = numberOfX;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfX; i++) {
            sb.append("X");
        }
        xString = sb.toString();
    }
}
