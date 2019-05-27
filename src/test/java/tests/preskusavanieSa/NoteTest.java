package pages.preskusavamSa;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import models.Note;
import org.junit.Before;
import org.junit.Test;
import pages.NotePage;

import java.sql.Timestamp;


public class NoteTest extends TestBase {
    private NotePage notePage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "/odkazovac.php");
        notePage = new NotePage(driver);
    }

    @Test
    public void itShouldAddNote() throws InterruptedException {
        //vytvorim si casovu peciatku pre unikatnost title
        Fairy fairy = Fairy.create();
        Person fakePerson = fairy.person();
        //ulozim si hodnoty do premennych
        String title = generateUniqueTitle();
        String author = "Anton";
        String message = "toto je velmi dlhy a zmysluplny odkaz";

       Note noteToAdd = new Note (title,author,message);
       notePage.enterNoteData (noteToAdd);
       notePage.submitNewNote();
       notePage.checkNoteInList(title);
       notePage.getLastNoteFromList().click();


        //overim detail zaznamu
        Thread.sleep(1000);
        notePage.checkNoteDetail(title, author, message);
    }

    private String generateUniqueTitle() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "Title " + timestamp.getTime();
    }
}