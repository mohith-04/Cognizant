public class Main {
    public static void main(String[] args) {
        System.out.println("Document Management System \n");

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document myWordDoc = wordFactory.createDocument();
        myWordDoc.open();
        myWordDoc.save();
        
        System.out.println(); 

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.processNewDocument();
        
        System.out.println();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document myPdfDoc = pdfFactory.createDocument();
        myPdfDoc.open();
        myPdfDoc.close();
    }
}