public class App {

    interface Document {
        void open();
    }

    static class WordDocument implements Document {
        public void open() {
            System.out.println("Word Document Created");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("PDF Document Created");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Excel Document Created");
        }
    }

    static abstract class DocumentFactory {
        abstract Document createDocument();
    }

    static class WordDocumentFactory extends DocumentFactory {
        Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        Document createDocument() {
            return new ExcelDocument();
        }
    }

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        word.open();
        pdf.open();
        excel.open();
    }
}