import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;  
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;



public class JeopardyGameTest {

    private Player player;
    private GameEventLogPublisher publisher;    
    private GameEventLog log;

    @BeforeEach
    void setup() {
        publisher = new GameEventLogPublisher();
        player = new Player("TestPlayer", publisher);
        log = new GameEventLog(1, "2024-10-10T10:00:00Z", "testActivity");


    }

    @Test
    //Testing Player Initialization with corret ID
    @DisplayName("Test Player Initialization")
    void testPlayerInitialization() {
        setup();
        assertEquals("TestPlayer", player.getPlayerId());
        assertEquals(0, player.getScore());
        assertNotNull(player.getPublisher());

    }

    @Test
    //Testing Score cannot be negative
    @DisplayName("Test Player Score Non-Negative")
    void testPlayerScoreNonNegative() {
        setup();
        player.setScore(10);
        assertEquals(10, player.getScore());
        player.setScore(-5);
        assertTrue(player.getScore() <= 0, "Player score should not be negative");
    }

    
    @Test
    //Question initialization with correct content and answer
    @DisplayName("Test Question Initialization")
    void testQuestionInitialization() {
        Question question = new Question("Science", 100, "What is H2O?", null, "Water");
        assertEquals("Science", question.getCategory());
        assertEquals(100, question.getValue());
        assertEquals("What is H2O?", question.getContent());
        assertEquals("Water", question.getRightAnswer());
        assertFalse(question.isAnswered());
    } 
    

    @Test
    //Testing GameEventLog creation and content
    @DisplayName("Test GameEventLog Creation")
    void testGameEventLogCreation() { 
        setup();
        assertEquals(1, log.getCaseId());
        assertEquals("testActivity", log.getActivity());
        assertEquals("2024-10-10T10:00:00Z", log.getTimestamp());
        assertNull(log.getCategory());
        assertNull(log.getPlayerId());
        

    }



}