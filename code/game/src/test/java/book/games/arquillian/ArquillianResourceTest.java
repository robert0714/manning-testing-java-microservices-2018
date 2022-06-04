package book.games.arquillian;

import book.games.entity.SearchResult;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// tag::test[]
@RunWith(Arquillian.class)
public class ArquillianResourceTest extends ArquillianAbstractTest
{ // <1>

    // <2>
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return createBaseDeployment(ArquillianResourceTest.class
                .getName());
    }

    @Test
    @RunAsClient // <3>
    public void testSearch(@ArquillianResource final URL url)
            throws Exception { // <4>
        // <5>
        final Client client = ClientBuilder.newBuilder().build();
        
        String uri = url.toExternalForm()
                + "?query=The Legend of Zelda: Breath of the Wild";
        System.out.println(uri);
        final WebTarget target = client.target(uri);

        // <6>
        final Future<Response> futureResponse = target.request()
                .async().get();
        final Response response = futureResponse.get(5, TimeUnit
                .SECONDS);
        final int statusCode = response.getStatus();
		Assert.assertEquals(200, statusCode);
		System.out.println(statusCode);
		
		
		// <7>
		
//        String value = response.readEntity(String.class);
//        System.out.println(value);
        //[{"id":7346,"name":"The Legend of Zelda: Breath of the Wild"}]
		
        
//        final List<SearchResult> results = response.readEntity(List.class);
//		final SearchResult[] array = response.readEntity(SearchResult[].class);
		
        final List<SearchResult> results = response.readEntity(new GenericType<List<SearchResult>>() { });

        Assert.assertEquals("Unexpected title", "The Legend of Zelda: Breath of the Wild",
        		results.get(0).getName());
    }
}
// end::test[]