package org.o7planning.factorial;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class BigNumberCache {
	private static LoadingCache<Long, BigNumber> cache 
		= CacheBuilder.newBuilder()
		.maximumSize(100) //set size
		.expireAfterWrite(20, TimeUnit.SECONDS) //set time expire
		.build(
				new CacheLoader<Long, BigNumber>() {
					@Override
					public BigNumber load(Long id) throws Exception {
						return getBigNumberById(id);
					}
		        }
		);
	
	public static LoadingCache<Long, BigNumber> getLoadingCache() {
		return BigNumberCache.cache;
	}
	
	public static BigNumber getBigNumberById(long id){
		BigNumber bigNumber = new BigNumber(id);
		return bigNumber;
	}
}

