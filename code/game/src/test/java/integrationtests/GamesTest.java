package integrationtests;

//import book.games.Main;
import book.games.boundary.Games;
import book.games.control.GamesService;
import book.games.entity.Game;
import book.games.entity.ReleaseDate;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith; 
import javax.ejb.EJB;
import javax.inject.Inject; 

import org.jboss.shrinkwrap.api.asset.EmptyAsset;
 

@RunWith(Arquillian.class)
public class GamesTest {

    @Deployment
    public static Archive<?>  createDeployment() throws Exception {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addClasses(Games.class, Game.class, ReleaseDate.class )
				.addAsWebInfResource(new ClassLoaderAsset("test-persistence.xml", GamesTest.class.getClassLoader()),
						"classes/META-INF/persistence.xml")
				.addPackage(Games.class.getPackage())
				.addPackage(GamesService.class.getPackage())
				.addPackage(ReleaseDate.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    


    @EJB
    Games games;
     

    @Test
    public void test() {
        System.out.println(games); 
    }

}
