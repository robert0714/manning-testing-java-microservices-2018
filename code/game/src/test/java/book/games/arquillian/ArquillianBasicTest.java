// tag::test[]
package book.games.arquillian;

import book.games.boundary.Games;
import book.games.boundary.IgdbGateway;
import book.games.control.GamesService;
import book.games.entity.Game;
import book.games.entity.ReleaseDate;
import book.games.entity.SearchResult;
import integrationtests.GamesTest;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// <1>
@RunWith(Arquillian.class)
public class ArquillianBasicTest {

    // <2>
    @Deployment
    public static WebArchive createDeployment() {

        // <3>
        //return ShrinkWrap.create(JavaArchive.class
        //return ShrinkWrap.create(EnterpriseArchive.class
    	return ShrinkWrap.create(WebArchive.class, 
    			ArquillianBasicTest.class.getName() + ".war")
				.addClasses(Games.class, Game.class, ReleaseDate.class )
				.addAsWebInfResource(new ClassLoaderAsset("test-persistence.xml", GamesTest.class.getClassLoader()),
						"classes/META-INF/persistence.xml")
				.addPackage(Games.class.getPackage())
				.addPackage(GamesService.class.getPackage())
				.addPackage(ReleaseDate.class.getPackage())
				.addAsResource("META-INF/persistence.xml") // <4>
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml"); // <5>
    }

    // <6>
    @Inject
    private GamesService service;

    // <7>
    @EJB
    private Games games;

    // <8>
    @PersistenceContext
    private EntityManager em;

    // <9>
    @Test
    public void test() {
        // <10>
        Assert.assertNotNull(this.service);
        Assert.assertNotNull(this.games);
        Assert.assertNotNull(this.em);
    }
}
//end::test[]
