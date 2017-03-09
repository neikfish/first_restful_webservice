package org.o7planning.factorial;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.common.cache.LoadingCache;

@Path("/calculator")
public class Factorial {
	
	@Path("{number}")
	@GET
	@Produces("application/json")
	public String getFactorial(@PathParam("number") String num){
		
		long start = System.currentTimeMillis();
		
		long l = Long.valueOf(num);
		BigNumber ans = null;
		
		try {
			ans = Factorial.getBigNumberUsingCache(l);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		
		return "{" //
	               + "'number': '" + num + "'," //
	               + "'factorial': '" + ans.getNumStr() + "'" //
	               + "}";
		
		
	}
	
	public static BigNumber getBigNumberUsingCache(long id) throws ExecutionException {
		LoadingCache<Long, BigNumber> cache = BigNumberCache.getLoadingCache();
		return cache.get(id);
	}
}
