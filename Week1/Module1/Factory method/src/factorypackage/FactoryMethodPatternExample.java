package factorypackage;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Create factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create documents using factories
        Document wordDocument = wordFactory.createDocument();
        Document pdfDocument = pdfFactory.createDocument();
        Document excelDocument = excelFactory.createDocument();

        // Use the documents
        wordDocument.open();
        wordDocument.save();
        wordDocument.close();

        pdfDocument.open();
        pdfDocument.save();
        pdfDocument.close();

        excelDocument.open();
        excelDocument.save();
        excelDocument.close();
    }
}
