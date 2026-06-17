public abstract class DocumentFactory {

    public abstract Document createDocument();

    public void processNewDocument() {
        Document doc = createDocument();
        System.out.println(" System initializing new document workspace ");
        doc.open();
    }
}