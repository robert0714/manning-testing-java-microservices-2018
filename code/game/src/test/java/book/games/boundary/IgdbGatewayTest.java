package book.games.boundary;

import book.games.entity.Game;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import javax.json.JsonArray;
import javax.json.JsonValue;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.anyUrl;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.Assert.assertTrue;

public class IgdbGatewayTest {

    private static IgdbGateway gateway = new IgdbGateway();
    @Before
    public void before() {
        // <1>
        stubFor(get(anyUrl()) 
                .willReturn(aResponse().withStatus(200).withHeader
                        ("Content-Type", "application/json")
                        .withBody("[{\"id\":7346,\"name\":\"The " +
                                "Legend of Zelda: Breath of the " +
                                "Wild\"}]")));
    }

    // <2>
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8071);
    
    @BeforeClass
    public static void beforeClass() {
        gateway.postConstruct();
    }

    @AfterClass
    public static void afterClass() {
        gateway.postConstruct();
    }

    @Test
    public void searchGameById() throws Exception {
        JsonArray json = gateway.searchGameById(7346);
        Game game = Game.fromJson(json);
        assertTrue(game.getTitle().contains("The Legend of Zelda: "
                + "Breath of the Wild"));
    }

    @Test
    public void searchGames() throws Exception {
        JsonArray games = gateway.searchGames("Zelda");
        boolean found = false;
        for (final JsonValue game : games) {
            if (game.toString().contains("7346")) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }

}