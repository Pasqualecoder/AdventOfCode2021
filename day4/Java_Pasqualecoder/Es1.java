import java.util.LinkedList;

public class Es1 {
    public static void main(String[] args) {
        boolean readFromSample = false;
        String filePath = readFromSample ? "sample.txt" : "numberDay4.txt";

        ExtractedNumbers ex = new ExtractedNumbers(ExtractedNumbers.readExtractedNumbers(filePath));
        LinkedList<Table> tables = Table.readTables(filePath);

        int indexExt = 0, winTable = 0;
        boolean quit = false;
        for (int i = 0; i < ex.extractedNumbers.size() && !quit ; i++) {
            for (int j = 0; j < tables.size(); j++) {
                tables.get(j).signNumber(ex.extractedNumbers.get(i));
                if (tables.get(j).checkTable()) {
                    indexExt = i;
                    winTable = j;
                    quit = true;
                    break;
                }
            }
        }

        int sumUnsigned = tables.get(winTable).sumUnsigned();
        int result = sumUnsigned * ex.extractedNumbers.get(indexExt);
        System.out.println(result);
    }

}
