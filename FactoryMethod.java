import java.util.ArrayList;
import java.util.List;

public class FactoryMethod {
    // entry into application.

    public static void main(String[] args) {
        // call Factory Method
        Document[] documents = new Document[2];
        
        documents[0] = new Resume();
        documents[1] = new Report();

        // display document pages
        for (Document document : documents) {
            System.out.println("\n" + document.getClass().getSimpleName() + "--");
            for (Page page : document.getPages()) {
                System.out.println(" " + page.getClass().getSimpleName());
            }
        }
        
        // wait for input
        System.out.println("\nPress Enter to exit...");
        try {
            System.in.read();
        } catch (Exception e) {
            // dont do anything for exception
        }
    }
}


// The Page abstract class

abstract class Page {
}

// extended page classes
class SkillsPage extends Page {
}
 
class EducationPage extends Page {
}

class ExperiencePage extends Page {
}

class IntroductionPage extends Page {
}

class ResultsPage extends Page {
}

class ConclusionPage extends Page {
}

class SummaryPage extends Page {
}

class BibliographyPage extends Page {
}

abstract class Document {
    private List<Page> pages = new ArrayList<>();
    
    // Constructor calls abstract document Factory method
    public Document() {
        this.createPages();
    }
    
    public List<Page> getPages() {
        return pages;
    }
    
    public abstract void createPages();
}

// extension of the document class
class Resume extends Document {

    @Override
    public void createPages() {
        getPages().add(new SkillsPage());
        getPages().add(new EducationPage());
        getPages().add(new ExperiencePage());
    }
}

// extension of the document class
class Report extends Document {

    @Override
    public void createPages() {
        getPages().add(new IntroductionPage());
        getPages().add(new ResultsPage());
        getPages().add(new ConclusionPage());
        getPages().add(new SummaryPage());
        getPages().add(new BibliographyPage());
    }
}