public class RedisPersistenceTest {
	@Rule
	public RedisRule redisRule = new RedisRule(
			RemoteRedisConfigurationBuilder.newRemoteRedisConfiguration()
			.host("192.168.1.1")
			.build());

	@Test
	@UsingDataSet(locations = "initialData.json")
	public void shouldGetData() {
	}
}