import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class gameInterfaceTest {

    @Before
    public void beforeEach(){
        //gameInterface GameInterface = gameInterface.get();
    }

    @Test
    public void testLoadImages(){
        //
    }

    @Test
    public void testAddPieceToBoard(){
        int col = 1;
        int row = 1;
        char color = 'b';

        gameInterface.get().addPieceToBoard(col,row,color);


    }

}
